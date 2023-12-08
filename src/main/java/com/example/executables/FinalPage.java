package com.example.executables;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.List;



public class FinalPage{
    @FXML
    private Button clicktosee;
    @FXML
    void ToSee() {
        List<CheckBox> selectedCheckboxes = NonVegController.handleCheckboxSelection();
        StringBuilder labelText = new StringBuilder();

        for (CheckBox checkbox : selectedCheckboxes) {
            labelText.append(checkbox.getText()).append("\n");
        }

        clicktosee.setText(labelText.toString());
    }

}
