package lib;

import java.sql.*;

public class Main {
    public static final String url = "jdbc:mysql://localhost:3306/books";
    public static final String user = "root";
    public static final String password = "password";
    
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    
    public static void connect(String query){
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
             // getting Statement object to execute query
            stmt = con.createStatement();
             // executing SELECT query
            rs = stmt.executeQuery(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }
    
    public static void main (String []args){
        Library l = new Library();
        Window w = new Window();
        
            
           
     

           
              
    }
}
