package com.learning.TempConverterTool;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;  // These are Ids written in sceneBuilder.
	                            // It should be unique throughout the project.
	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField textField;

	@FXML
	public Button button;

	private static
	final String C_TO_F ="Celsius to Fahrenehit" ;
	private static final String F_TO_C ="Fahrenehit to Celsius";
	private boolean isC_TO_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// choice box event handler.
		choiceBox.getItems().addAll(C_TO_F, F_TO_C);
		choiceBox.setValue(C_TO_F);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{

		if (newValue.equals(C_TO_F))
			isC_TO_F = true;
		else
			isC_TO_F = false;

		});

		// Button event handler.
		button.setOnAction(event -> {
			convert();
		});


	}

	private void convert() {

		String input = textField.getText();// get text from textFeild.

		Float enteredTemperature = 0.0f;

		try{
			enteredTemperature = Float.parseFloat(input);
		}
		catch (Exception e){
			warnUser();
			return;
		}

		float newTemperature = 0.0f;


		if (isC_TO_F){
			newTemperature = (enteredTemperature * 9/5) + 32;
		}else {
			newTemperature = (enteredTemperature - 32) * 5/9;
		}

		display(newTemperature);

	}

	private void warnUser() {

		Alert alertDilogue = new Alert(Alert.AlertType.ERROR);

		alertDilogue.setTitle("Error Occured");
		alertDilogue.setHeaderText("Invalid Temperature Entered");
		alertDilogue.setContentText("Pleasr enter the valid temperature");
		alertDilogue.show();

	}

	private void display(float newTemperature) {

		String unit = isC_TO_F ? "F" : "C";
		//System.out.println("The new Temperature is :- " + newTemperature + unit);

		Alert alertDilogue = new Alert(Alert.AlertType.INFORMATION);

		alertDilogue.setTitle("Result");
		alertDilogue.setContentText("The new Temperature is : " + newTemperature + unit);
		alertDilogue.show();

	}
}
