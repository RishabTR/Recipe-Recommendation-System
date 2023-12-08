package com.example.executables;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController{
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    @FXML
    private Button login_button;
    @FXML
    private Button signup_button;

    private static String UserName;

    @FXML
    protected void onHandleButtonSignup(){
        try{
            FXMLLoader signuploader=new FXMLLoader(getClass().getResource("signup.fxml"));
            Parent loginroot=signuploader.load();
            Stage curStage = (Stage)signup_button.getScene().getWindow();
            curStage.setScene(new Scene(loginroot,730,750));
            curStage.setTitle("Signup Page");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void onHandleButtonLogin() {
        try {
            String username = tf_username.getText();
            String password = tf_password.getText();
            if (username.isEmpty() && password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Incomplete Data");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all fields.");
                alert.showAndWait();
            } else {
                db test = new db();
                boolean check = test.CheckCredentials(username, password);
                if (check) {
                    try {
                        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Home-view.fxml"));
                        Parent loginRoot = loginLoader.load();


                        Stage curStage = (Stage) login_button.getScene().getWindow();

                        curStage.setScene(new Scene(loginRoot));
                        curStage.setTitle("Home Page");
                        UserName = username;

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Login");
                    alert.setHeaderText(null);
                    alert.setContentText("Signup First.");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String GetUserName(){
        return UserName;
    }
}
