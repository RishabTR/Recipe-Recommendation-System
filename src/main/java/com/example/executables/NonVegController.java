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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class NonVegController{

    @FXML
    private AnchorPane side_page;

    @FXML
    private Button homebutton;

    @FXML
    private Button homebutton1;

    @FXML
    private Button homebutton11;



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


    public List<CheckBox> selectedCheckboxes=new ArrayList<>();
    public List<Pane> panes = new ArrayList<>();
    @FXML
    void initialize() {
        // Initialize your Pane objects and add them to the list
        panes.add(pane1);
        panes.add(pane2);
        panes.add(pane3);
        panes.add(pane4);
        panes.add(pane5);
    }
    @FXML
    protected static List<CheckBox> handleCheckboxSelection() {
        selectedCheckboxes.clear();

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
            boxnames.add(nameofcheckbox);
        }
    }
    @FXML
    protected void OnClickProcess(){
        db test = new db();
        String username=LoginController.GetUserName();
        int userid= test.GetUserId(username);
        handleCheckboxSelection();
        toDisplay();
        try{
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("finalpage.fxml"));
            Parent loginRoot = loginLoader.load();
            Stage curStage = (Stage)process.getScene().getWindow();
            curStage.setScene(new Scene(loginRoot,730,750));
            curStage.setTitle("Final Page");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
