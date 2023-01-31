package com.example.demo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Product {
    private SimpleIntegerProperty id;//Declaring this value as static may lead to issue in retrieving id for product i.e, all products will have same id on list interface
    private SimpleStringProperty category;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty quantity;

    public int getId() {
        return id.get();
    }
    public String getCategory() {
        return category.get();
    }
    public String getName() {
        return name.get();
    }
    public int getQuantity() {
        return quantity.get();
    }
    public double getPrice() {
        return price.get();
    }

    public Product(int id, String category, String name,double price, int quantity) {
        this.id=new SimpleIntegerProperty(id);
        this.category =new SimpleStringProperty(category);
        this.name =new SimpleStringProperty(name);
        this.price =new SimpleDoubleProperty(price);
        this.quantity =new SimpleIntegerProperty(quantity);
    }
    public static ObservableList<Product> getAllProducts(){
        DatabaseConnection databaseConnection=new DatabaseConnection(); // Creating a new DataBase Connection
        ObservableList<Product> productsList= FXCollections.observableArrayList(); // An Observable ArrayList to Store all the Products Data
        String selectProducts="SELECT * FROM product"; // Query to retrieve the data
        try{
            ResultSet rs=databaseConnection.getQueryTable(selectProducts); // Fetches the data from DataBase
            while(rs.next()){ // Adds the required details of Product into list by creating a new Product item in the table
                productsList.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("category"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                        ));
                 //The Order for rs.get() methods should be same as arguments passed in Product() constructor
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productsList;
    }
    public static ObservableList<Product> getProductByName(String productName) {
        DatabaseConnection databaseConnection=new DatabaseConnection(); // Creating a new DataBase Connection
        ObservableList<Product> productsList= FXCollections.observableArrayList(); // An Observable ArrayList to Store all the Products Data
        String selectProducts=String.format("SELECT * FROM product WHERE lower(name) like '%%%s%%'",productName.toLowerCase());
        // Query to retrieve the data of Product from Search
        try{
            ResultSet rs=databaseConnection.getQueryTable(selectProducts); // Fetches the data from DataBase
            while(rs.next()) { // Adds the required details of Product into list by creating a new Product item in the table
                productsList.add(new Product(rs.getInt("product_id"),
                        rs.getString("category"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productsList;
    }
}
