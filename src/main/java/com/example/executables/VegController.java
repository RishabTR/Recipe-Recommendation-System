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


public class VegController{





    @FXML
    private AnchorPane side_page;

    @FXML
    private Button homebutton;

    @FXML
    private Button homebutton1;

    @FXML
    private Button homebutton11;

    @FXML
    private Pane pane6;
    @FXML
    private Pane pane7;
    @FXML
    private Pane pane8;
    @FXML
    private Pane pane9;
    @FXML
    private Pane pane10;

    @FXML
    private Button process;


    public List<CheckBox> selectedCheckboxes=new ArrayList<>();
    public List<Pane> panes = new ArrayList<>();
    @FXML
    void initialize() {
        panes.add(pane6);
        panes.add(pane7);
        panes.add(pane8);
        panes.add(pane9);
        panes.add(pane10);
    }
    @FXML
    protected void handleCheckboxSelection() {
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
        for (String i:boxnames){
            System.out.println(i+" ");
        }
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
