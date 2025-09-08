package org.example;

import JDBC_CRUD.LoginValidiation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class User{
    String name;
    String pass;
    User(String name,String pass){
        this.name=name;
        this.pass=pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
public class Login {
    public static void main(String[]args){
        LoginValidiation lg=new LoginValidiation();
        Connection conn=lg.connct_to_db("Login","postgres","rolex");
        Scanner js=new Scanner(System.in);
        while (true){
            System.out.println("User Register and Login");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3.Exit");
            System.out.println("Enter the Choice");
            int ch=js.nextInt();
            switch (ch){
                case 1 ->{
                    js.nextLine();
                    System.out.println("Enter the Username");
                    String name = js.nextLine();
                    System.out.println("Enter  the Password");
                    String pass = js.nextLine();
                    lg.insert(conn, "Userdetails", name, pass);
                }

                case 2 -> {
                    js.nextLine();
                    System.out.println("Enter the Username");
                    String lname = js.nextLine();
                    System.out.println("Enter  the Password");
                    String lpass = js.nextLine();
                    String query = String.format("select * from userdetails where username = '%s'", lname);
                    Statement statement;
                    ResultSet res;
                    User user = null;
                    try {
                        statement = conn.createStatement();
                        res = statement.executeQuery(query);
                        while (res.next()) {
                            String tname = res.getString("username");
                            String tpass = res.getString("password");
                            user = new User(tname, tpass);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    if (lname.equals(user.getName())) {
                        if (lpass.equals(user.getPass())) {
                            System.out.println("View Profile");
                            System.out.println("Username : " + user.getName());
                            System.out.println("Password : " + user.getPass());
                        } else {
                            System.out.println("Password is Invalid!!");
                        }
                    } else {
                        System.out.println("User Not exists");
                    }
                }
                case 3 ->
                {
                    return;
                }
                default->{
                    System.out.println("Enter the Valid choice[1,2,3]");
                }
            }
        }
    }
}
