package DBFactoryclass;

import Connections.Connectiondata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbfactory {
    public static Connectiondata con=new Connectiondata();
    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
    }
}
