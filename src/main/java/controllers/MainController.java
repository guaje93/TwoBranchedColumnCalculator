package controllers;

import fxmlUtils.DialogUtilis;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {

	@FXML
	private BorderPane borderPane;
	@FXML
	private TopMenuButtonsController topMenuButtonsController;
	@FXML
	private DesignDataController designDataController;
	@FXML
	private CalculationsDataController calculationsDataController;
	@FXML
	private Menu menuFile;
	@FXML
	private Menu menuEdit;
	@FXML
	private Menu menuHelp;
	@FXML
	private CheckMenuItem menuAlwaysOnTop;
	@FXML
	private MenuItem menuClose;
	@FXML
	private MenuItem menuAbout;

	public Menu getMenuFile() {
		return menuFile;
	}

	public Menu getMenuEdit() {
		return menuEdit;
	}

	public Menu getMenuHelp() {
		return menuHelp;
	}

	public CheckMenuItem getMenuAlwaysOnTop() {
		return menuAlwaysOnTop;
	}

	public MenuItem getMenuClose() {
		return menuClose;
	}

	public MenuItem getMenuAbout() {
		return menuAbout;
	}

	public DesignDataController getDesignDataController() {
		return designDataController;
	}

	public CalculationsDataController getCalculationsDataController() {
		return calculationsDataController;
	}

	@FXML
	private void initialize() {

		topMenuButtonsController.setMainController(this);
		designDataController.setMainController(this);
		calculationsDataController.setMainController(this);
		Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
		calculationsDataController.getCalculationsData().setVisible(false);
		topMenuButtonsController.getButtonWymiarowanie().setDisable(true);
		topMenuButtonsController.getDesignDataButton().setSelected(true);
		topMenuButtonsController.getButtonLanguagePl().setSelected(true);

	}

	@FXML
	public void closeApplication() {
		Platform.exit();
		System.exit(0);
	}

	@FXML
	public void setCaspian(ActionEvent actionEvent) {
		Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);

	}

	@FXML
	public void setModena(ActionEvent actionEvent) {
		Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);

	}

	@FXML
	public void setAlwaysOnTop(ActionEvent actionEvent) {
		Stage stage = (Stage) borderPane.getScene().getWindow();
		boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
		stage.setAlwaysOnTop(value);

	}

	@FXML
	public void about() {
		DialogUtilis.dialogAboutApplication();
	}

}
