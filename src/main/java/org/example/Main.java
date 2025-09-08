package org.example;

import JDBC_CRUD.DbFunctions;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DbFunctions db=new DbFunctions();
        Connection conn=db.connect_to_db("tutdb","postgres","rolex");
       // db.createtable(conn,"employee");
      //db.insertrow(conn,"employee","JS","Africa");
        //db.read_data(conn,"employee") ;
        //db.update(conn,"employee","Arasan","America");
        db.delete_by_id(conn,"employee","3");
        //db.search_by_name(conn,"employee","JS");
        //db.search_by_id(conn,"employee","2");
        //db.delete_by_name(conn,"employee","JS");
    }
}