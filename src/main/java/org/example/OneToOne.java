package org.example;

import DBFactoryclass.Dbfactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OneToOne {
    static Connection con;
    public static void main(String[]args){
        try{
            con=Dbfactory.getconnection();
            String query =String.format("select s.name as student, a.city as city , a.state as state from student s join address a on s.student_id = a.student_id");
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(query);
            while(res.next()){
                System.out.print(res.getString("student")+" ");
                System.out.print(res.getString("city")+" ");
                System.out.println(res.getString("state"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
