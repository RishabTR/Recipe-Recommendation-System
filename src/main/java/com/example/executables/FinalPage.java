package com.example.executables;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class FinalPage{
    @FXML
    private Button clicktosee;
    @FXML
    public Button home;
    @FXML
    public void ToSee() {
//        HomeController check=new HomeController();
//        if(check.Veg_Clicked()) {
//            List<CheckBox> selectedCheckboxes = VegController.handleCheckboxSelection();
//            StringBuilder labelText = new StringBuilder();
//            for (CheckBox checkbox : selectedCheckboxes) {
//                labelText.append(checkbox.getText()).append("\n");
//            }
//            clicktosee.setText(labelText.toString());
//        }
//        else{
//            List<CheckBox> selectedCheckboxes = NonVegController.handleCheckboxSelection();
//            StringBuilder labelText = new StringBuilder();
//            for (CheckBox checkbox : selectedCheckboxes) {
//                labelText.append(checkbox.getText()).append("\n");
//            }
//            clicktosee.setText(labelText.toString());
//        }
    }
    @FXML
    public void ButtonHome(){
        try {
            FXMLLoader loginLoader = new FXMLLoader(FinalPage.class.getResource("Home-view.fxml"));
            Parent loginRoot = loginLoader.load();
            Stage curStage = (Stage) home.getScene().getWindow();
            curStage.setScene(new Scene(loginRoot,730,750));
            curStage.setTitle("Home Page");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
