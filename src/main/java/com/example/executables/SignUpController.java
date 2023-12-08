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

public class SignUpController {

    @FXML
    private TextField name_signup;

    @FXML
    private TextField email_signup;

    @FXML
    private TextField pass_signup;

    @FXML
    private TextField confirm_pass_signup;

    @FXML
    private Button login_button;

    @FXML
    private Button signup_button;

    @FXML
    private TextField gender_signup;

    @FXML
    protected void onHandleButtonLogin(){
        try{
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent loginRoot = loginLoader.load();


            Stage curStage = (Stage)login_button.getScene().getWindow();

            curStage.setScene(new Scene(loginRoot));
            curStage.setTitle("Login Page");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void onHandleButtonSignUp() {
        try{
            String username=name_signup.getText();
            String email=email_signup.getText();
            String password=pass_signup.getText();
            String confirm_pass=confirm_pass_signup.getText();
            String gender = gender_signup.getText();

            if(!username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirm_pass.isEmpty() && !gender.isEmpty()){  //Because gettext() give empty string so we use string functions
                db.AddData(username,email,password,confirm_pass,gender);

                try{
                    FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                    Parent loginRoot = loginLoader.load();


                    Stage curStage = (Stage)login_button.getScene().getWindow();

                    curStage.setScene(new Scene(loginRoot,730,750));
                    curStage.setTitle("Login Page");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                // Show an alert for incomplete data
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Incomplete Data");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all fields.");
                alert.showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
