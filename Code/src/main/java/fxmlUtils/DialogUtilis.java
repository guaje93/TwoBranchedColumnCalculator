package fxmlUtils;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

public class DialogUtilis {

	public static void errorDialogs(String error) {
		Alert errorAlert = new Alert(Alert.AlertType.ERROR);
		errorAlert.setTitle(FxmlUtils.getResourceBundle().getString("data.errorTitle"));
		errorAlert.setHeaderText(FxmlUtils.getResourceBundle().getString("data.errorHeader"));
		
		TextArea textArea = new TextArea(error);
		textArea.setEditable(false);
		errorAlert.getDialogPane().setContent(textArea);
		errorAlert.showAndWait();
		
	}
	
	public static void dialogAboutApplication() {

		Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
		informationAlert.setTitle(FxmlUtils.getResourceBundle().getString("about.title"));
		informationAlert.setHeaderText(FxmlUtils.getResourceBundle().getString("about.header"));
		informationAlert.setContentText(FxmlUtils.getResourceBundle().getString("about.content"));
		informationAlert.showAndWait();
	}

	public static Optional<ButtonType> confirmationDialog() {

		Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
		confirmationAlert.setTitle(FxmlUtils.getResourceBundle().getString("exit.title"));
		confirmationAlert.setHeaderText(FxmlUtils.getResourceBundle().getString("exit.header"));
		Optional<ButtonType> result = confirmationAlert.showAndWait();
		return result;
	}


}
