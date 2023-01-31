package com.example.demo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Optional;

public class Cart {
    static Pane bodyPane=new Pane();
    public static final int width=780,height=720,headerBar=50;
    public static TableView<Product> productTable;
    private static GridPane headerPane(){
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
        Button backButton=new Button("Back");
        backButton.setTranslateX(width/2+40); // Translates the Button in X direction
        backButton.setTranslateY(10+40);//Translates the Button in Y direction

        gridPane.add(searchText,0,0);
        gridPane.add(logoutButton,0,0);
        gridPane.add(backButton,0,0);
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

            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bodyPane.getChildren().clear();
                bodyPane.getChildren().addAll(CustomerHomePage.headerPane(),CustomerHomePage.bodyPane(),CustomerHomePage.footerBar());
            }
        });

        return gridPane;
    }
    private static Pane bodyPane(){
        Pane gridPane=new GridPane();
        gridPane.setMinSize(width,height-(headerBar));
        gridPane.setStyle("-fx-background-color: #D86C70");
        gridPane.setTranslateY(2*headerBar);
        gridPane.getChildren().addAll(cartProducts());

        return gridPane;
    }
    public static Pane cartProducts(){
        TableColumn id=new TableColumn("Id"); // Column for I'd
        id.setCellValueFactory(new PropertyValueFactory<>("id")); // Column for id values of Product
        id.setStyle( "-fx-alignment: CENTER;"); // sets the text alignment of id column
        TableColumn category=new TableColumn("Category"); // Column for name
        category.setCellValueFactory(new PropertyValueFactory<>("Category")); // Column for name values of Product
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

        ObservableList<Product> cartProducts=CustomerHomePage.cart; // Calls the method to fetch the Table Or List
        productTable=new TableView<>(); // Initialising the Product Table
        productTable.setItems(cartProducts);
        productTable.setMinSize(width,height-(2*headerBar));
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Resizes table columns to the defined size so that extra columns won't appear
        productTable.getColumns().addAll(id,category,name,price,quantity);
        Pane tablePane=new Pane();
        tablePane.setMinSize(width,height-(2*headerBar));
        tablePane.getChildren().add(productTable);

        return tablePane;

    }
    public static Pane Root(){
        Pane root =new Pane();
        root.setPrefSize(width,height);//Size of root pane which acts as base

        bodyPane.setMinSize(width,height-headerBar);
        bodyPane.getChildren().addAll(headerPane(),bodyPane());
        root.getChildren().addAll(bodyPane);
        return root;
    }
}
