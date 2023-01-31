package com.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Customer {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private static SimpleStringProperty email;
    private SimpleStringProperty mobile;
    private SimpleStringProperty address;

    public int getId() {
        return id.get();
    }
    public String getName() {
        return name.get();
    }
    public static String getEmail() {
        return email.get();
    }
    public String getMobile() {
        return mobile.get();
    }
    public String getAddress() {
        return address.get();
    }

    public Customer(int id, String name, String email, String mobile, String address) {
        this.id = new SimpleIntegerProperty(id);
        this.name =new SimpleStringProperty(name);
        this.email =new SimpleStringProperty(email);
        this.mobile =new SimpleStringProperty(mobile);
        this.address =new SimpleStringProperty(address);
    }
    public static ObservableList<Customer> getAllCustomers(){
        DatabaseConnection databaseConnection=new DatabaseConnection(); // Creating a new DataBase Connection
        ObservableList<Customer> customersList= FXCollections.observableArrayList(); // An Observable ArrayList to Store all the Products Data
        String selectCustomers="SELECT * FROM customer"; // Query to retrieve the data
        try{
            ResultSet rs=databaseConnection.getQueryTable(selectCustomers); // Fetches the data from DataBase
            while(rs.next()){ // Adds the required details of Product into list by creating a new Product item in the table
                customersList.add(new Customer(rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("email"),
                        rs.getString("mobile_number"),
                        rs.getString("address")));
                //The Order for rs.get() methods should be same as arguments passed in Product() constructor
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customersList;
    }
    public static boolean customerLogin(String email, String password) {
        String query = String.format("SELECT * FROM customer WHERE email='%s' AND password='%s'", email, password);
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
