package JDBC_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LoginValidiation {
    public Connection connct_to_db(String dbname,String user,String pass){
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if(conn!=null){
                System.out.println("Connection Established");
            }
            else {
                System.out.println("Connection Failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    public void create_table(Connection conn,String table_name){
        Statement statement;
        try{
            String query=String.format("CREATE TABLE %s (userid SERIAL , username varchar(20), password varchar(10),primary key(userid));",table_name);
            statement=conn.createStatement();
            statement.execute(query);
            System.out.println("Created User table");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void insert(Connection conn,String tname,String username,String pass){
        Statement statement;
        try{
            String query=String.format( "INSERT INTO %s (username, password) VALUES ('%s', '%s');", tname, username, pass);
            statement=conn.createStatement();
            statement.execute(query);
            System.out.println("Registered Successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
