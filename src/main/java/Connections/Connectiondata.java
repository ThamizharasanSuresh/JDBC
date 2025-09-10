package Connections;

public class Connectiondata {
    public String getUrl() {
        String url="jdbc:postgresql://localhost:5432/schooldb";
        return url;
    }

    public String getUser() {
        String user="postgres";
        return user;
    }

    public String getPass() {
        String pass="rolex";
        return pass;
    }
}
