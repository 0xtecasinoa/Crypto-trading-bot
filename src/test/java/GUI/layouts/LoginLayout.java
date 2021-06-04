package GUI.layouts;

import GUI.MainGUI;
import GUI.preferences.LocalProperties;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class LoginLayout {

    //components
    TextField loginUsername = new TextField();
    PasswordField loginPassword = new PasswordField();
    Button loginButton = new Button("Login");

    Label loginResponse = new Label("");

    TextField registerUsername = new TextField();
    PasswordField registerPassword = new PasswordField();
    PasswordField apiKey = new PasswordField();
    PasswordField apiSecret = new PasswordField();
    Button registerButton = new Button("Register");

    Label registerResponse = new Label("");

    public HBox loginSceneLayout() {

        //main HBox za login livo i reg desno
        HBox mainLayout = new HBox(40);

        //login layout
        //////////////////////////////////////////////
        VBox loginLayout = new VBox(20);
        loginLayout.setAlignment(Pos.CENTER);

        //input fields
        loginUsername.setPromptText("Please input your username");
        loginPassword.setPromptText("Please input your password");

        loginUsername.setMaxHeight(30);
        loginUsername.setMinHeight(30);
        loginUsername.setMinWidth(300);
        loginUsername.setMaxWidth(300);
        loginUsername.setPrefHeight(Region.USE_COMPUTED_SIZE);
        loginPassword.setMaxHeight(30);
        loginPassword.setMinHeight(30);
        loginPassword.setMinWidth(300);
        loginPassword.setMaxWidth(300);
        loginPassword.setPrefHeight(Region.USE_COMPUTED_SIZE);


        loginButton.setOnAction(e -> {
            //validation
            if (loginUsername.getText().isEmpty() || loginPassword.getText().isEmpty()) {
                loginResponse.setText("Username or password cannot be empty");
            } else {
                //test for prefs
                MainGUI.prop.setPropertyString("username", loginUsername.getText());
                MainGUI.prop.setPropertyString("password", loginPassword.getText());

                loginResponse.setText("");
                //TODO: check with db
                MainGUI.getWindow().setScene(MainGUI.HomeScreen);
            }
        });

        loginLayout.getChildren().addAll(loginUsername, loginPassword, loginResponse, loginButton);
        ///////////////////////////////////////////////////////////////////

        //reg layout
        //////////////////////////////////////////////////////////////////
        VBox registerLayout = new VBox(20);
        registerLayout.setAlignment(Pos.CENTER);

        //input fields
        registerUsername.setPromptText("Please input your username");
        registerPassword.setPromptText("Please input your password");
        apiKey.setPromptText("Please input your apiKey");
        apiSecret.setPromptText("Please input your apiSecret");

        registerUsername.setMaxHeight(30);
        registerUsername.setMinHeight(30);
        registerUsername.setMinWidth(300);
        registerUsername.setMaxWidth(300);
        registerUsername.setPrefHeight(Region.USE_COMPUTED_SIZE);
        registerPassword.setMaxHeight(30);
        registerPassword.setMinHeight(30);
        registerPassword.setMinWidth(300);
        registerPassword.setMaxWidth(300);
        registerPassword.setPrefHeight(Region.USE_COMPUTED_SIZE);
        apiKey.setMaxHeight(30);
        apiKey.setMinHeight(30);
        apiKey.setMinWidth(300);
        apiKey.setMaxWidth(300);
        apiKey.setPrefHeight(Region.USE_COMPUTED_SIZE);
        apiSecret.setMaxHeight(30);
        apiSecret.setMinHeight(30);
        apiSecret.setMinWidth(300);
        apiSecret.setMaxWidth(300);
        apiSecret.setPrefHeight(Region.USE_COMPUTED_SIZE);


        registerButton.setOnAction(e -> {
            //validation
            if (registerUsername.getText().isEmpty() || registerPassword.getText().isEmpty() || apiKey.getText().isEmpty() || apiSecret.getText().isEmpty()) {
                registerResponse.setText("Username, password, apiKey or apiSecret cannot be empty");
            } else {
                registerResponse.setText("");
                MainGUI.getWindow().setScene(MainGUI.HomeScreen);
            }

        });

        registerLayout.getChildren().addAll(registerUsername, registerPassword, apiKey, apiSecret, registerResponse, registerButton);
        /////////////////////////////////////////////////////////////////
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getChildren().addAll(new Separator(), loginLayout, new Separator(), registerLayout, new Separator());

        return mainLayout;
    }
}