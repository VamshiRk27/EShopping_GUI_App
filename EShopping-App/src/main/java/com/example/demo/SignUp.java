package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.sql.SQLException;

public class SignUp {
    public static Font globalFontBold=Font.font("Times New Roman", FontWeight.BOLD,20);
    public static Font globalFont=Font.font("Times New Roman",20);
    public static final int width= MainPage.width,height= MainPage.height,headerBar= MainPage.headerBar;
    static GridPane signUpPage(){
        // Font myFont=Font.font("Times New Roman", FontPosture.ITALIC.ordinal()); // Check later
        Label emailLabel=new Label("Email");
        Label firstNameLabel=new Label("First Name");
        Label lastNameLabel=new Label("Last Name");
        Label mobileNumber=new Label("Mobile Number");
        Label passwordLabel=new Label("Password");
        Label addressLabel=new Label("Address");

        emailLabel.setFont(globalFontBold);
        emailLabel.setTextFill(Color.BLACK);
        firstNameLabel.setFont(globalFontBold);
        firstNameLabel.setTextFill(Color.BLACK);
        lastNameLabel.setFont(globalFontBold);
        lastNameLabel.setTextFill(Color.BLACK);
        mobileNumber.setFont(globalFontBold);
        mobileNumber.setTextFill(Color.BLACK);
        passwordLabel.setFont(globalFontBold);
        passwordLabel.setTextFill(Color.BLACK);
        addressLabel.setFont(globalFontBold);
        addressLabel.setTextFill(Color.BLACK);

        Label Welcome=new Label();
        Welcome.setText("Welcome To SignUp Page\nPlease fill the details");
        Welcome.setStyle("-fx-font-weight: bold;");
        Welcome.setFont(Font.font("Times New Roman", FontPosture.ITALIC,25));
        Welcome.setTranslateX(-75);
        Welcome.setTranslateY(-100);
        Welcome.setTextFill(Color.BLACK);
        Welcome.setAlignment(Pos.TOP_CENTER); // check this
        GridPane.setHalignment(Welcome, Pos.TOP_CENTER.getHpos());
        //set font color in signup page

        TextField emailTextField=new TextField();
        TextField firstNameField=new TextField();
        TextField lastNameField=new TextField();
        TextField mobileNumberField=new TextField();
        PasswordField passwordField=new PasswordField();
        TextField addressField=new TextField();

        emailTextField.setFont(globalFont);
        firstNameField.setFont(globalFont);
        lastNameField.setFont(globalFont);
        mobileNumberField.setFont(globalFont);
        passwordField.setFont(globalFont);
        addressField.setFont(globalFont);

        Label newMessage=new Label();
        Button back=new Button("Back");
        Button signUpButton=new Button("Submit");

        newMessage.setFont(globalFont);
        back.setFont(globalFont);
        signUpButton.setFont(globalFont);


        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email=emailTextField.getText().toLowerCase();
                String firstName=firstNameField.getText();
                String lastName=lastNameField.getText();
                String mobileNumber=mobileNumberField.getText();
                String password=passwordField.getText();
                String address=addressField.getText();
                Boolean signUpStatus= null;

                Dialog<String> dialog = new Dialog<String>();//Creating a dialog
                dialog.setTitle("SignUp Status");//Setting the title
                ButtonType ok= new ButtonType("Ok");
                dialog.getDialogPane().getButtonTypes().add(ok);//Adding buttons to the dialog pane

                try {
                    signUpStatus = customerSignUp(email,firstName,lastName,mobileNumber,password,address);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(signUpStatus==true){
                    dialog.setContentText("Sign Up Successful");//Setting the content of the dialog
                    dialog.showAndWait();
                    MainPage.bodyPane.getChildren().clear();
                    MainPage.bodyPane.getChildren().addAll(MainPage.emptyPane(), MainPage.welcomeInfo());
                }
                else{
                    dialog.setContentText("Sign Up Failed");//Setting the content of the dialog
                    dialog.showAndWait();
                    //Try once dialog show & close
                }
            }
        });

        GridPane gridPane=new GridPane();
        gridPane.setStyle("-fx-background-color: #5579C6");
        gridPane.setVgap(7.5);
        gridPane.setHgap(7.5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMinSize(width,height+headerBar);
        gridPane.add(Welcome,1,1);
        gridPane.add(emailLabel,0,1);
        gridPane.add(emailTextField,1,1);
        gridPane.add(firstNameLabel,0,2);
        gridPane.add(firstNameField,1,2);
        gridPane.add(lastNameLabel,0,3);
        gridPane.add(lastNameField,1,3);
        gridPane.add(mobileNumber,0,4);
        gridPane.add(mobileNumberField,1,4);
        gridPane.add(passwordLabel,0,5);
        gridPane.add(passwordField,1,5);
        gridPane.add(addressLabel,0,6);
        gridPane.add(addressField,1,6);
        gridPane.add(signUpButton,1,7);
        gridPane.add(back,0,7);
        gridPane.add(newMessage,1,8);


        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainPage.bodyPane.getChildren().clear();
                MainPage.bodyPane.getChildren().addAll(MainPage.customerLoginPage(), MainPage.welcomeInfo());
            }
        });
        return gridPane;
    }
    public static boolean customerSignUp(String emailId, String firstName, String lastName, String mobileNumber, String password, String address) throws SQLException {
        DatabaseConnection dbConn = new DatabaseConnection();
        String query=String.format("INSERT INTO Customer(email,first_name,last_name,mobile_number,password,address)VALUES('%s','%s','%s','%s','%s','%s')",emailId,firstName,lastName,mobileNumber,password,address);
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
}
