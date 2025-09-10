package org.example;


import DBFactoryclass.Dbfactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManyToMany {
     static Connection con;

    public static void main(String []args){
        try{
            con=Dbfactory.getconnection();
            String query=String.format("select s.name as student , c.course_name as course from students s join enrollment e on s.student_id=e.student_id join course c on e.course_id=c.course_id");
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(query);
            while(res.next()){
                System.out.print(res.getString("student")+" ");
                System.out.println(res.getString("course"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
