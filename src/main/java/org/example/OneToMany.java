package org.example;

import DBFactoryclass.Dbfactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OneToMany {
    static Connection con;
    public  static  void main(String []args){
        try{
            con= Dbfactory.getconnection();
            String query=String.format("select t.name as teacher, s.name as student from teacher t join student s on t.teacher_id=s.teacher_id");
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(query);
            while(res.next()){
                System.out.print(res.getString("teacher")+" ");
                System.out.println(res.getString("student"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
