package sample;

import java.sql.*;

public class Sql {
    public static void main(String args[]){
            Connection con=null;

            try{
                System.out.println("Successfully connected to MySQL server...");
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Successfully connected to MySQL server...");
                con = DriverManager.getConnection("jdbc:mysql://localhost:8080/javaapplication","root","");
                if(!(con.isClosed()))
                    System.out.println("Successfully connected to MySQL server...");
            }
             catch (Exception e) {
                 e.printStackTrace();
             }finally{
                try{
                    if(con != null)
                        con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }}}