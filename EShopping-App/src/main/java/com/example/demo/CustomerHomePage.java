package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Optional;

public class CustomerHomePage {
    static Pane bodyPane=new Pane();
    public static final int width=780,height=720,headerBar=50;
    static ObservableList<Product> cart=FXCollections.observableArrayList();
    static GridPane headerPane(){
        GridPane gridPane=new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setMinSize(width,(2*headerBar));
        gridPane.setStyle("-fx-background-color: #5579C6");

        TextField searchText=new TextField();
        searchText.setTranslateY(24); // Translates the textField in Y direction
        Button searchButton=new Button("Search");
        searchButton.setTranslateY(24); // Translates the Button in Y direction
        Button logoutButton=new Button("Logout");
        logoutButton.setTranslateX(width/2+40); // Translates the Button in X direction
        logoutButton.setTranslateY(10);//Translates the Button in Y direction
        Button cartButton=new Button("Cart");
        cartButton.setTranslateX(width/2+40); // Translates the Button in X direction
        cartButton.setTranslateY(10+40);//Translates the Button in Y direction

        gridPane.add(searchText,0,0);
        gridPane.add(logoutButton,0,0);
        gridPane.add(cartButton,0,0);
        gridPane.add(searchButton,1,0);


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
                bodyPane.getChildren().addAll(headerPane(),gridPane,footerBar());
            }
        });

        cartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bodyPane.getChildren().clear();
                bodyPane.getChildren().addAll(Cart.Root());
            }
        });

        return gridPane;
    }
    static GridPane bodyPane(){
        GridPane gridPane=new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMinSize(width,height-(2*headerBar));
        gridPane.setStyle("-fx-background-color: #D86C70");
        gridPane.setTranslateY(2*headerBar);

        gridPane.getChildren().addAll(ProductDetails.getAllProducts());

        return gridPane;
    }
    static GridPane footerBar(){
        Button addToCartButton=new Button("Add to Cart");
        Button buyNowButton=new Button("Buy Now");

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Add Product to your cart");
        alert.setResizable(false);

        GridPane gridPane=new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(150);
        gridPane.add(addToCartButton,0,0);
        gridPane.add(buyNowButton,1,0);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setTranslateY(height);
        gridPane.setMinSize(width,headerBar);
        gridPane.setStyle("-fx-background-color: #5579C6");

        addToCartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product selectedProduct=ProductDetails.getSelectedProduct();
                alert.setContentText("Add Quantity: ");
                Optional<ButtonType> result = alert.showAndWait();
                ButtonType button = result.orElse(ButtonType.CANCEL);
                if (button == ButtonType.OK){
                    cart.add(selectedProduct);
                }
                else if (button == ButtonType.NO) {
                    alert.close();
                }
            }
        });


        return gridPane;

    }
    public static Pane Root(){
        Pane root =new Pane();
        root.setPrefSize(width,height);//Size of root pane which acts as base

        bodyPane.setMinSize(width,height-headerBar);
        bodyPane.getChildren().addAll(headerPane(),bodyPane(),footerBar());
        root.getChildren().addAll(bodyPane);
        return root;
    }
}
