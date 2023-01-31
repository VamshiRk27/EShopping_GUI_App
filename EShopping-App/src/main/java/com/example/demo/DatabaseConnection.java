package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String databaseUrl="jdbc:mysql://Localhost:3306/eshopping-app";
    private final static String userName="root";
    private static final String password="9Dec2022@sql";
    public Statement getStatement(){
        Statement statement=null;
        Connection connection;
        try{
            connection= DriverManager.getConnection(databaseUrl,userName,password);
            statement= connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return statement;
    }
    public ResultSet getQueryTable(String query){
        Statement statement=getStatement();
        try{
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int executeUpdateQuery(String query) {
        Statement statement=getStatement();
        try{
            return statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public static boolean adminLogin(String email, String password) {
        String query = String.format("SELECT * FROM admin WHERE email='%s' AND password='%s'", email, password);
        try {
            DatabaseConnection conn = new DatabaseConnection();
            ResultSet rs = conn.getQueryTable(query);
            if (rs != null && rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
