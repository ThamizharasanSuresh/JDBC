package JDBC_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    public Connection connect_to_db(String dbname,String user,String pass){
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if(conn!=null){
                System.out.println("Connection Established");
            }
            else{
                System.out.println("Connection failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }
    public void createtable(Connection conn,String table_name){
        Statement statement;
        try {
            String query="create table "+table_name+"(empid SERIAL ,name varchar(20),address varchar(200),primary key(empid));";
            statement=conn.createStatement();
            statement.execute(query);
            System.out.println("Table created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void insertrow(Connection conn, String table_name, String name, String address) {
        Statement statement;
        try {
            String query = String.format(
                    "INSERT INTO %s (name, address) VALUES ('%s', '%s');", table_name, name, address
            );
            statement = conn.createStatement();
            statement.execute(query);
            System.out.println("Inserted one row");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void read_data(Connection conn,String table_name){
        Statement statement;
        ResultSet res;
        try{
            String query=String.format("Select *from "+table_name);
            statement=conn.createStatement();
            res=statement.executeQuery(query);
            while (res.next()){
                System.out.print(res.getString("empid")+" ");
                System.out.print(res.getString("name")+" ");
                System.out.println(res.getString("address")+" ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void update(Connection conn,String table_name,String name,String address){
        Statement statement;
        ResultSet res;
        try {
            String query=String.format("UPDATE %s SET address = '%s' WHERE name = '%s'",table_name,address,name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Updated the Table");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void delete_by_id(Connection conn,String table_name,String id){
        Statement statement;
        try{
            String query=String.format("DELETE from %s WHERE empid = '%s'",table_name,id);
            statement=conn.createStatement();
            statement.execute(query);
            System.out.println("Deleted one row");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete_by_name(Connection conn,String table_name,String name){
        Statement statement;
        try{
            String query=String.format("DELETE from %s WHERE name = '%s'",table_name,name);
            statement=conn.createStatement();
            statement.execute(query);
            System.out.println("Deleted one row");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void search_by_name(Connection conn,String table_name,String name){
        Statement statement;
        ResultSet res;
        try{
            String query=String.format("select * from %s where name = '%s'",table_name,name);
            statement=conn.createStatement();
            res = statement.executeQuery(query);
            while (res.next()){
                System.out.print(res.getString("empid")+" ");
                System.out.print(res.getString("name")+" ");
                System.out.println(res.getString("address")+" ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void search_by_id(Connection conn,String table_name,String id){
        Statement statement;
        ResultSet res;
        try{
            String query=String.format("select * from %s where empid = '%s'",table_name,id);
            statement=conn.createStatement();
            res = statement.executeQuery(query);
            while (res.next()){
                System.out.print(res.getString("empid")+" ");
                System.out.print(res.getString("name")+" ");
                System.out.println(res.getString("address")+" ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }



}
