package com.example.executables;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HomeController{


    @FXML
    private Button help;
    @FXML
    private Button logout;
    @FXML
    private ImageView nonveg_click;

    @FXML
    private ImageView veg_click;

    @FXML
    boolean NonVeg_Clicked(){
        try{
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("NonVegIngredient.fxml"));
            Parent loginRoot = loginLoader.load();
            Stage curStage = (Stage)nonveg_click.getScene().getWindow();
            curStage.setScene(new Scene(loginRoot));
            curStage.setTitle("NonVeg Ingredients");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    @FXML
    void Veg_Clicked() {
        try{
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("VegIngredient.fxml"));
            Parent loginRoot = loginLoader.load();
            Stage curStage = (Stage)veg_click.getScene().getWindow();
            curStage.setScene(new Scene(loginRoot));
            curStage.setTitle("Veg Ingredients");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void OnClickLogout(){
        try{
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent loginRoot = loginLoader.load();
            Stage curStage = (Stage)logout.getScene().getWindow();
            curStage.setScene(new Scene(loginRoot,730,750));
            curStage.setTitle("Login Page");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void OnClickHelp(){
        try{
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("help.fxml"));
            Parent loginRoot = loginLoader.load();
            Stage curStage = (Stage)help.getScene().getWindow();
            curStage.setScene(new Scene(loginRoot,730,750));
            curStage.setTitle("Help Page");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
