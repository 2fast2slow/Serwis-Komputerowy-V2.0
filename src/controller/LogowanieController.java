package controller;

import java.io.IOException;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogowanieController {

	private MainApp mainApp;

	@FXML
	private TextField loginTextField;

	@FXML
	private PasswordField hasloTextField;

	@FXML
	private Button zalogujButton;

	@FXML
	private void zaloguj(ActionEvent event) throws IOException {
		if (hasloTextField.getText().equalsIgnoreCase("tajnehaslo")) {
			mainApp.showNaprawyView();
		}
	}

	@FXML
	private void initialize() {
		// firstNameColumn.setCellValueFactory(cellData ->
		// cellData.getValue().getFirstName());
		// lastNameColumn.setCellValueFactory(cellData ->
		// cellData.getValue().getLastName());;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// personTable.setItems(mainApp.getPersonData());
	}

}
