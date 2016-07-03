
package lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static lib.Window.*;
import lib.Main.*;
import static lib.Main.con;
import static lib.Main.password;
import static lib.Main.stmt;
import static lib.Main.url;
import static lib.Main.user;


public class Listener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()== show){
                                  
            String query = "select name, author, size, cost from books.lib;";
            try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
             // getting Statement object to execute query
            stmt = con.createStatement();
                // executing SELECT query
            ResultSet rs = stmt.executeQuery(query);
            String res = "";
            while(rs.next() == true){
                res += "Name: "+rs.getString(1)+" Author: "+rs.getString(2)+" Size: "+rs.getInt(3)+"Cost: "+rs.getInt(4)+"\n";
                            }
            JOptionPane.showMessageDialog(null, res);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }
        if (ae.getSource() == add){
            String name=JOptionPane.showInputDialog(null, "Input name of new book", "Name", JOptionPane.QUESTION_MESSAGE);
            String author = JOptionPane.showInputDialog(null, "Input author of new book", "Author", JOptionPane.QUESTION_MESSAGE);
            int size =Integer.parseInt(JOptionPane.showInputDialog(null, "Input size of new book", "Size", JOptionPane.QUESTION_MESSAGE));
            int cost = Integer.parseInt(JOptionPane.showInputDialog(null, "Input cost of new book", "Cost", JOptionPane.QUESTION_MESSAGE));
                        
            String query = "insert into lib (name, author, size, cost) values ('"+name+"', '"+author+"', '"+size+"', '"+cost+"');";
            try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
             // getting Statement object to execute query
            stmt = con.createStatement();
                // executing SELECT query
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Done");
                          }
            catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }
        if (ae.getSource() == delete){
            String name=JOptionPane.showInputDialog(null, "Input name of book you want to delete", "Name", JOptionPane.QUESTION_MESSAGE);
            String author = JOptionPane.showInputDialog(null, "Input author of book you want to delete", "Author", JOptionPane.QUESTION_MESSAGE);
                    
                       
            String query = "delete  from lib where name = '"+name+"' and author = '"+author+"';";
            try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
             // getting Statement object to execute query
            stmt = con.createStatement();
                // executing SELECT query
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Done");
                          }
            catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        }
        if (ae.getSource() == find){
            String name=JOptionPane.showInputDialog(null, "Input name of book you want to find", "Name", JOptionPane.QUESTION_MESSAGE);
            String query = "select name, size, cost from books.lib;";
            try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
             // getting Statement object to execute query
            stmt = con.createStatement();
                // executing SELECT query
            ResultSet rs = stmt.executeQuery(query);
            Library res = new Library();
            while(rs.next() == true){
                res.add(new Book (rs.getString(1), rs.getInt(2), rs.getInt(3)));                
                }
            Book tofind = res.findByName(name);
            JOptionPane.showMessageDialog(null, "Name: "+tofind.getName()+", Size: "+tofind.getSize()+", Cost: "+tofind.getCost());
                        
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }
        if (ae.getSource()== sort){
             String query = "select name, size, cost from books.lib;";
            try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
             // getting Statement object to execute query
            stmt = con.createStatement();
                // executing SELECT query
            ResultSet rs = stmt.executeQuery(query);
            Library res = new Library();
            while(rs.next() == true){
                res.add(new Book (rs.getString(1), rs.getInt(2), rs.getInt(3)));                
                }
            res.sortByName();
            String s = res.show();
            
            JOptionPane.showMessageDialog(null, s);
                        
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        }
        if (ae.getSource() == changeCost){
            String name=JOptionPane.showInputDialog(null, "Input name of book you want to change", "Name", JOptionPane.QUESTION_MESSAGE);
            int newCost = Integer.parseInt(JOptionPane.showInputDialog(null, "Input new cost", "Cost",JOptionPane.QUESTION_MESSAGE));
            String query = "update lib set cost = "+newCost+" where name = '"+name+"';";
            try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
             // getting Statement object to execute query
            stmt = con.createStatement();
                // executing SELECT query
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Done");
                        
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        }
        }
        }
            
        
        
    
    

