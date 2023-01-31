package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.SQLException;
import java.util.Optional;

public class AdminPage {
    public static Font globalFontBold=Font.font("Times New Roman", FontWeight.BOLD,20);
    public static Font globalFont=Font.font("Times New Roman",20);
    static Pane bodyPane=new Pane();//BodyPane which acts as a base for all sections to be displayed on a single Pane
    static Pane content=new Pane();
    public static final int width=780,height=720,headerBar=50;
    private static GridPane headerBar(){
        GridPane gridPane=new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setMinSize(width,(2*headerBar));
        gridPane.setStyle("-fx-background-color: #5579C6");

        TextField searchText=new TextField();
        searchText.setTranslateY(12+25); // Translates the textField in Y direction
        Button searchButton=new Button("Search");
        searchButton.setTranslateY(12+25); // Translates the Button in Y direction
        Button logoutButton=new Button("Logout");
        logoutButton.setTranslateX(width/2+40); // Translates the Button in X direction
        logoutButton.setTranslateY(12+25);//Translates the Button in Y direction



        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("LogOut Confirmation");
                alert.setResizable(false);
                alert.setContentText("Are you sure to Log Out?");
                Optional<ButtonType> result = alert.showAndWait();
                ButtonType button = result.orElse(ButtonType.CANCEL);
                if (button == ButtonType.OK){
                    bodyPane.getChildren().clear();
                    bodyPane.getChildren().addAll(MainPage.emptyPane(), MainPage.welcomeInfo());
                }
                else if (button == ButtonType.NO) {
                    alert.close();
                }
            }
        });

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String productName=searchText.getText();
                GridPane gridPane=new GridPane();
                gridPane.setVgap(5);
                gridPane.setHgap(5);
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setMinSize(width,height-(2*headerBar));
                gridPane.setStyle("-fx-background-color: #D86C70");
                gridPane.setTranslateY(2*headerBar);
                gridPane.getChildren().addAll(ProductDetails.getProductByName(productName));

                bodyPane.getChildren().clear();
                bodyPane.getChildren().addAll(headerBar(),gridPane,footerBar());
            }
        });

        gridPane.add(searchText,0,0);
        gridPane.add(logoutButton,0,0);
        gridPane.add(searchButton,1,0);

        return gridPane;
    }
    private static GridPane optionsBar(){
        GridPane gridPane=new GridPane();
        gridPane.setVgap(15);
        gridPane.setHgap(15);
//        gridPane.setAlignment(Pos.LEFT);
        gridPane.setMinSize(150,height-headerBar);
        gridPane.setStyle("-fx-background-color: #76C4AE");

        Button customers=new Button("Customers");
        customers.setTranslateX(22.5);
        Button products=new Button("Products");
        products.setTranslateX(22.5);
        Button addProductsButton=new Button("Add Products");
        addProductsButton.setTranslateX(22.5);

        gridPane.add(customers,0,1);
        gridPane.add(products,0,2);
        gridPane.add(addProductsButton,0,3);

        customers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Pane gridPane=new Pane();
                gridPane.setMinSize(width-150,height-headerBar);
                gridPane.setTranslateX(150);
                gridPane.getChildren().add(CustomerDetails.getAllCustomers());

                content.getChildren().clear();
                content.getChildren().addAll(optionsBar(),gridPane);

                bodyPane.getChildren().clear();
                bodyPane.getChildren().addAll(content,headerBar());
            }
        });

        products.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GridPane gridPane=new GridPane();
                gridPane.setVgap(5);
                gridPane.setHgap(5);
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setMinSize(width,height-(2*headerBar));
                gridPane.setStyle("-fx-background-color: #D86C70");
                gridPane.setTranslateY(2*headerBar);
                gridPane.getChildren().addAll(ProductDetails.getAllProducts());
                bodyPane.getChildren().clear();
                bodyPane.getChildren().addAll(headerBar(),gridPane,footerBar());
            }
        });

        addProductsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                content.getChildren().clear();
                content.getChildren().addAll(optionsBar(),addProduct());

                bodyPane.getChildren().clear();
                bodyPane.getChildren().addAll(content,headerBar());
            }
        });

        return gridPane;
    }
    private static GridPane addProduct(){
        GridPane gridPane=new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMinSize(width-150,height-headerBar);
        gridPane.setTranslateX(150);
        gridPane.setStyle("-fx-background-color: #D86C70");

        ObservableList<String> options= FXCollections.observableArrayList();
        final ComboBox<String> comboBox=new ComboBox<>(options);//Another possibility is to create a combo box by using an empty constructor and call the setItems method on it, i.e., comboBox.setItems(options);
        comboBox.setEditable(false);
        comboBox.getItems().addAll("Electronics", "Sports", "Furniture", "Clothing");


        Label productName=new Label("Product Name");
        Label category=new Label("Category");
        Label quantity=new Label("Quantity");
        Label price=new Label("Price");
        Button addProductButton=new Button("Add Product");
        addProductButton.setFont(globalFont);

        productName.setFont(globalFontBold);
        category.setFont(globalFontBold);
        quantity.setFont(globalFontBold);
        price.setFont(globalFontBold);

        TextField productNameField=new TextField();
        TextField categoryField=new TextField();
        categoryField.setText(comboBox.getSelectionModel().selectedItemProperty().getValue());
        TextField quantityField=new TextField();
        TextField priceField=new TextField();


        productNameField.setFont(globalFont);
        categoryField.setFont(globalFont);
        quantityField.setFont(globalFont);
        priceField.setFont(globalFont);


        addProductButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String productName=productNameField.getText();
                String category=categoryField.getText();
//                int quantity= Integer.parseInt(quantityField.getText());
                int quantity= Integer.parseInt(String.valueOf(quantityField.getText()));
                Double price= Double.valueOf(String.valueOf(priceField.getText()));
                Boolean addStatus= null;

                try {
                    addStatus=productAddStatus(productName,category,price,quantity);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Product Status");
                alert.setResizable(false);
                if(addStatus==true){
                    alert.setContentText("Product added successfully");
                    alert.showAndWait();
                }
                else{
                    alert.setContentText("Product not added");
                    alert.showAndWait();
                }
            }
        });

        //Retrieves the category name and sets it as text for categoryField
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> value, String s, String t1) {
                categoryField.setText(t1);
            }
        });

        gridPane.add(productName,0,0);
        gridPane.add(productNameField,1,0);
        gridPane.add(comboBox,1,1);
        gridPane.add(category,0,2);
        gridPane.add(categoryField,1,2);
        gridPane.add(quantity,0,3);
        gridPane.add(quantityField,1,3);
        gridPane.add(price,0,4);
        gridPane.add(priceField,1,4);
        gridPane.add(addProductButton,0,5);

        return gridPane;
    }
    public static boolean productAddStatus(String productName, String category,double price,int quantity) throws SQLException {
        DatabaseConnection dbConn = new DatabaseConnection();
        String query=String.format("INSERT INTO product(name,category,price,quantity)VALUES('%s','%s','%s','%s')",productName,category,price,quantity);
        int statement=dbConn.executeUpdateQuery(query);
        try {
            if (statement>0) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    static GridPane footerBar() {
        Button backButton=new Button("Back");
        GridPane gridPane=new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(150);
        gridPane.add(backButton,0,0);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setTranslateY(height);
        gridPane.setMinSize(width,headerBar);
        gridPane.setStyle("-fx-background-color: #5579C6");

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        return gridPane;
    }
    private static GridPane contentPage(){
        GridPane gridPane=new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMinSize(width-150,height-headerBar);//150 is the width of optionsBar
        gridPane.setStyle("-fx-background-color: #D86C70");
        gridPane.setTranslateX(150);


        return gridPane;
    }
    public static Pane Root(){
        Pane root =new Pane();
        root.setPrefSize(width,height);//Size of root pane which acts as base

        content.setMinSize(width,height-headerBar);
        content.getChildren().addAll(optionsBar(),contentPage());
        content.setTranslateY(2*headerBar);

        bodyPane.setMinSize(width,height);
        bodyPane.getChildren().addAll(content,AdminPage.headerBar());
        root.getChildren().addAll(bodyPane);
        return root;
    }
}
