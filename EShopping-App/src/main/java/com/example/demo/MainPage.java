package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.text.Font.font;

public class MainPage extends Application {
    static Pane bodyPane=new Pane(); //A Pane which acts as Base Layer for other interfaces which are displayed
    //A Function which returns an Empty GridPane for initial Interface
    static GridPane emptyPane(){
        GridPane pane=new GridPane();
        pane.setMinSize(width,height-130);
        pane.setAlignment(Pos.CENTER);
        pane.setTranslateY(height/2-170);
        pane.setStyle("-fx-background-color: #d9a5b3");
        return pane;
    }
    public static Font globalFont=new Font("Times New Roman",18);
    public static final int width=780,height=720,headerBar=50;
    public static GridPane welcomeInfo(){
        GridPane gridPane=new GridPane();//Creating/Initialising a new GridPane
        gridPane.setVgap(5);//Sets the Vertical Gap/Spacing
        gridPane.setMinSize(width,height/2-150);//Sets the Min Size of the GridPane
        gridPane.setAlignment(Pos.TOP_CENTER);//Sets the Alignment/Position of the GridPane
        gridPane.setStyle("-fx-background-color: #d9a5b3");//Sets the Background Color of the GridPane

        Label Welcome=new Label();//Initialising a new Label
        Welcome.setText("Welcome to\nCAB E-Shopping");//Setting the Text of the Label "Welcome"
        Welcome.setFont(font("Times New Roman",40));//Setting the Font of the Label "Welcome"
        Welcome.setTextFill(Color.BLACK); //Sets black color to Welcome label
        Welcome.setStyle("-fx-font-weight: bold;");//Sets the Font Weight of the Label "Welcome"
        Welcome.setAlignment(Pos.TOP_CENTER);//Sets the Alignment/Position of the Label "Welcome"


        Font initial=new Font("Times New Roman", 35);//Used for initial letters of word
        Font follow=new Font("Times New Roman", 25);//Used for following letters of word other than initial
        //Initial letters of word
        Text C= new Text("C");
        C.setFill(Color.BLACK);
        C.setFont(initial);

        Text A= new Text("A");
        A.setFill(Color.BLACK);
        A.setFont(initial);

        Text B= new Text("B");
        B.setFill(Color.BLACK);
        B.setFont(initial);

        //Following letters of word
        Text heck = new Text("heck ");
        heck.setFill(Color.BLACK);
        heck.setFont(follow);

        Text dd= new Text("dd ");
        dd.setFill(Color.BLACK);
        dd.setFont(follow);

        Text uy = new Text("uy ");
        uy.setFill(Color.BLACK);
        uy.setFont(follow);

        //Adding Words as a single Text
        TextFlow UpperCase = new TextFlow(C,heck,A,dd,B,uy);
        UpperCase.setStyle("-fx-font-weight: bold;");
        Text LowerCase= new Text("At your Benefit");
        LowerCase.setFill(Color.BLACK);
        LowerCase.setFont(font("Times New Roman", FontPosture.ITALIC, 17.5));
        LowerCase.setStyle("-fx-font-weight: bold;");
        LowerCase.setTranslateX(175);

        // A Label to display the text for login buttons
        Label login=new Label();
        login.setText("Click here to Login for:");
        login.setFont(font("Times New Roman",17));
        login.setTextFill(Color.BLACK); //Sets black color to login label
        login.setTranslateY(15);
        login.setTranslateX(-40);

        //Creating Buttons for different types of Login
        Button admin=new Button("Admin");
        Button customer=new Button("Customer");
        //Translating the Buttons in different axis positions for better interface
        admin.setTranslateY(12.5);
        customer.setTranslateY(12.5);
        admin.setTranslateX(130);
        customer.setTranslateX(130+75);

        // Actions for Login Buttons
        customer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bodyPane.getChildren().clear();
                bodyPane.getChildren().addAll(customerLoginPage(),welcomeInfo());
            }
        });
        admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bodyPane.getChildren().clear();
                bodyPane.getChildren().addAll(adminLoginPage(),welcomeInfo());
            }
        });

        //Adding all elements to the GridPane at different positions
        gridPane.add(Welcome,0,0);
        gridPane.add(UpperCase,0,1);
        gridPane.add(LowerCase,0,2);
        gridPane.add(login,0,3);
        gridPane.add(admin,0,3);
        gridPane.add(customer,0,3);

        //returning the gridPane
        return gridPane;
    }
    public static GridPane customerLoginPage(){
        GridPane gridPane=new GridPane();
        gridPane.setMinSize(width,height-130);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: #d9a5b3");
        gridPane.setTranslateY(height/2-170);


        Label customerLogin=new Label("Customer Login");
        customerLogin.setFont(new Font("Times New Roman",30));
        customerLogin.setStyle("-fx-font-weight: bold;");
        customerLogin.setTranslateY(-60);
        customerLogin.setAlignment(Pos.CENTER);

        Label emailLabel=new Label("Email");
        Label passwordLabel=new Label("Password");
        Label messageLabel=new Label();
        TextField emailTextField=new TextField();
        PasswordField passwordField=new PasswordField();
        Button loginButton=new Button("Login");

        emailLabel.setFont(globalFont);
        passwordLabel.setFont(globalFont);
        emailTextField.setFont(globalFont);
        passwordField.setFont(globalFont);
        loginButton.setFont(globalFont);

        Label noAccount=new Label();
        noAccount.setText("Dont have an account?\nClick here");
        noAccount.setStyle("-fx-font-weight: bold;");
        Button signUpNow=new Button("Sign Up");
        signUpNow.setFont(globalFont);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email=emailTextField.getText();
                String password=passwordField.getText();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Login Failed");
                alert.setTitle("Login Status");
                alert.setResizable(false);
                if (Customer.customerLogin(email,password)) {
                    bodyPane.getChildren().clear();
                    bodyPane.getChildren().addAll(CustomerHomePage.Root());
                }
                else{
                    alert.setContentText("Incorrect Email or Password");
                    alert.showAndWait();
                }
            }
        });

        signUpNow.setOnAction(actionEvent -> {
            bodyPane.getChildren().clear();
            bodyPane.getChildren().add(SignUp.signUpPage());
        });

        gridPane.add(customerLogin,1,0);
        gridPane.add(emailLabel,0,0);
        gridPane.add(emailTextField,1,0);
        gridPane.add(passwordLabel,0,1);
        gridPane.add(passwordField,1,1);
        gridPane.add(loginButton,1,2);
        gridPane.add(messageLabel,1,3);
        gridPane.add(noAccount,1,4);
        gridPane.add(signUpNow,1,5);

        return gridPane;
    }
    private static GridPane adminLoginPage() {
        GridPane gridPane=new GridPane();
        gridPane.setMinSize(width,height-130);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: #d9a5b3");
        gridPane.setTranslateY(height/2-170);


        Label adminLogin=new Label("Admin Login");
        adminLogin.setFont(new Font("Times New Roman",30));
        adminLogin.setStyle("-fx-font-weight: bold;");
        adminLogin.setTranslateY(-60);
        adminLogin.setAlignment(Pos.CENTER);

        Label emailLabel=new Label("Email");
        Label passwordLabel=new Label("Password");
        Label messageLabel=new Label();
        TextField emailTextField=new TextField();
        PasswordField passwordField=new PasswordField();
        Button loginButton=new Button("Login");

        emailLabel.setFont(globalFont);
        passwordLabel.setFont(globalFont);
        emailTextField.setFont(globalFont);
        passwordField.setFont(globalFont);
        loginButton.setFont(globalFont);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email=emailTextField.getText();
                String password=passwordField.getText();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Login Failed");
                alert.setTitle("Login Status");
                alert.setResizable(false);
                if(DatabaseConnection.adminLogin(email,password)) {
                    bodyPane.getChildren().clear();
                    bodyPane.getChildren().addAll(AdminPage.Root());
                }
                else{
                    alert.setContentText("Incorrect Email or Password");
                    alert.showAndWait();
                }
            }
        });

        gridPane.add(adminLogin,1,0);
        gridPane.add(emailLabel,0,0);
        gridPane.add(emailTextField,1,0);
        gridPane.add(passwordLabel,0,1);
        gridPane.add(passwordField,1,1);
        gridPane.add(loginButton,1,2);
        gridPane.add(messageLabel,1,3);

        return gridPane;
    }
    private Pane content(){
        Pane root =new Pane();
        root.setPrefSize(width,height+headerBar);//Size of root pane which acts as base
        root.setStyle("-fx-background-color: #F3CA20");
        bodyPane.setMinSize(width,height);
        bodyPane.getChildren().addAll(emptyPane(),welcomeInfo());
        root.getChildren().addAll(bodyPane);
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(content());
        stage.setTitle("E-Shopping");
        stage.setResizable(false);//Sets the stage to not resizable i.e fixed size
        stage.setScene(scene);
        stage.show();
    }
}