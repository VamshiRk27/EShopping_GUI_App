package com.example.demo;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductDetails {
    public static final int width=780,height=720,headerBar=50;
    public static TableView<Product> productTable; // Type of Table will be Product Class <Product>
    public static Pane getAllProducts(){
        TableColumn id=new TableColumn("Id"); // Column for I'd
        id.setCellValueFactory(new PropertyValueFactory<>("id")); // Column for id values of Product
        id.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of id column
        TableColumn category=new TableColumn("Category"); // Column for name
        category.setCellValueFactory(new PropertyValueFactory<>("category")); // Column for name values of Product
        category.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of name column
        TableColumn name=new TableColumn("Name"); // Column for name
        name.setCellValueFactory(new PropertyValueFactory<>("name")); // Column for name values of Product
        name.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of name column
        TableColumn price=new TableColumn("Price"); // Column for price
        price.setCellValueFactory(new PropertyValueFactory<>("price")); // Column for Price values of Product
        price.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of Price column
        TableColumn quantity=new TableColumn("Quantity"); // Column for name
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity")); // Column for name values of Product
        quantity.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of name column

        ObservableList<Product> products=Product.getAllProducts(); // Calls the method to fetch the Table Or List
        productTable=new TableView<>(); // Initialising the Product Table
        productTable.setItems(products);
        productTable.setMinSize(width,height-(2*headerBar));
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Resizes table columns to the defined size so that extra columns won't appear
        productTable.getColumns().addAll(id,category,name,price,quantity); // Adding the declared id,name,price columns to the Table

        Pane tablePane=new Pane();
        tablePane.setMinSize(width,height);
        tablePane.getChildren().add(productTable);
        return tablePane;
    }
    public static Pane getProductByName(String productName){
        TableColumn id=new TableColumn("Id"); // Column for I'd
        id.setCellValueFactory(new PropertyValueFactory<>("id")); // Column for id values of Product
        id.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of id column
        TableColumn category=new TableColumn("Category"); // Column for name
        category.setCellValueFactory(new PropertyValueFactory<>("category")); // Column for name values of Product
        category.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of name column
        TableColumn name=new TableColumn("Name"); // Column for name
        name.setCellValueFactory(new PropertyValueFactory<>("name")); // Column for name values of Product
        name.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of name column
        TableColumn price=new TableColumn("Price"); // Column for price
        price.setCellValueFactory(new PropertyValueFactory<>("price")); // Column for Price values of Product
        price.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of Price column
        TableColumn quantity=new TableColumn("Quantity"); // Column for name
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity")); // Column for name values of Product
        quantity.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of name column

        ObservableList<Product> products=Product.getProductByName(productName);
        productTable=new TableView<>();
        productTable.setItems(products);
        productTable.setMinSize(width,height-(2*headerBar));
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Resizes table columns to the defined size so that extra columns won't appear
        productTable.getColumns().addAll(id,category,name,price,quantity); // Adding the declared id,name,price columns to the Table

        Pane tablePane=new Pane();
        tablePane.setMinSize(width,height);
        tablePane.getChildren().add(productTable);

        return tablePane;
    }
    public static Product getSelectedProduct(){
        try{
            Product selectedProduct=productTable.getSelectionModel().getSelectedItem();
            return  selectedProduct;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
