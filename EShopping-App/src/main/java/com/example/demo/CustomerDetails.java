package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class CustomerDetails {
    public static final int width=780,height=720,headerBar=50;
    public static TableView<Customer> customerTable;
    public static Pane getAllCustomers(){
        TableColumn id=new TableColumn("Id"); // Column for I'd
        id.setCellValueFactory(new PropertyValueFactory<>("id")); // Column for id values of Product
        id.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of id column
        TableColumn name=new TableColumn("Name"); // Column for name
        name.setCellValueFactory(new PropertyValueFactory<>("name")); // Column for name values of Product
        name.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of name column
        TableColumn email=new TableColumn("Email"); // Column for name
        email.setCellValueFactory(new PropertyValueFactory<>("email")); // Column for name values of Product
        email.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of name column
        TableColumn mobile=new TableColumn("Mobile"); // Column for price
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile")); // Column for Price values of Product
        mobile.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of Price column
        TableColumn address=new TableColumn("Address"); // Column for name
        address.setCellValueFactory(new PropertyValueFactory<>("address")); // Column for name values of Product
        address.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of name column

        ObservableList<Customer> customers= Customer.getAllCustomers(); // Calls the method to fetch the Table Or List
        customerTable=new TableView<>(); // Initialising the Product Table
        customerTable.setItems(customers);
        customerTable.setMinSize(width-150,height-headerBar);
        customerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Resizes table columns to the defined size so that extra columns won't appear
        customerTable.getColumns().addAll(id,name,email,mobile,address); // Adding the declared id,name,price columns to the Table

        Pane tablePane=new Pane();
        tablePane.setMinSize(width-150,height-headerBar);
        tablePane.getChildren().add(customerTable);
        return tablePane;
    }
}
