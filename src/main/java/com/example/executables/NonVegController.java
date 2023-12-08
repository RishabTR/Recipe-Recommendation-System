package com.example.executables;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.CharConversionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class NonVegController{
    @FXML
    private Button home;
    @FXML
    private Button logout;
    @FXML
    private Button help;
    @FXML
    private Button process;
    @FXML
    public Pane pane1;
    @FXML
    public Pane pane2;
    @FXML
    public Pane pane3;
    @FXML
    public Pane pane4;
    @FXML
    public Pane pane5;

    db test = new db();
    String username=LoginController.GetUserName();
    int userid= test.GetUserId(username);


    public static List<CheckBox> selectedCheckboxes=new ArrayList<>();
    public static List<Pane> panes = new ArrayList<>();
    @FXML
    void initialize() {
        // Initialize your Pane objects and add them to the list
        panes.add(pane1);
        panes.add(pane2);
        panes.add(pane3);
        panes.add(pane4);
        panes.add(pane5);
        toClear();
    }
    @FXML
    protected void toClear(){
        for(Pane i:panes){
            for(Node node:i.getChildren()){
                if(node instanceof CheckBox){
                    CheckBox checkbox=(CheckBox) node;
                    checkbox.setSelected(false);
                }
            }
        }
    }
    @FXML
    protected static List<CheckBox> handleCheckboxSelection() {
        for(Pane i:panes){
            for (Node node : i.getChildren()) {
                if (node instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) node;
                    if (checkBox.isSelected()) {
                        selectedCheckboxes.add(checkBox);
                    }
                }
            }
        }
        return selectedCheckboxes;
    }
    public List<String> boxnames=new ArrayList<>();
    protected void toDisplay(){
        for(CheckBox iterator:selectedCheckboxes){
            String nameofcheckbox=iterator.getText();
            System.out.println(userid+" "+" "+username+" "+nameofcheckbox);
        }
    }
    @FXML
    protected void OnClickProcess(){
        handleCheckboxSelection();
        toDisplay();
        selectedCheckboxes.clear();

        try{
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("finalpage.fxml"));
            Parent loginRoot = loginLoader.load();
            Stage curStage = (Stage)process.getScene().getWindow();
            curStage.setScene(new Scene(loginRoot,730,750));
            curStage.setTitle("Final Page");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void OnClickHome(){
        try{
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Home-view.fxml"));
            Parent loginRoot = loginLoader.load();
            Stage curStage = (Stage)home.getScene().getWindow();
            curStage.setScene(new Scene(loginRoot,730,750));
            curStage.setTitle("Home Page");
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
            curStage.setTitle("Home Page");

        }catch (IOException e){
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
            curStage.setTitle("Home Page");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
