package fxmlUtils;

import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import fxmlUtils.DialogUtilis;
import fxmlUtils.FxmlUtils;

public class FxmlUtils {

	public static Pane fxmlLoader(String fxmlPath) {

		FXMLLoader loader = new FXMLLoader(FxmlUtils.class.getClass().getResource(fxmlPath));
		loader.setResources(getResourceBundle());
		try {
			return loader.load();
		} catch (Exception e) {
			DialogUtilis.errorDialogs(e.getMessage());
		}
		return null;
	}

	public static ResourceBundle getResourceBundle() {

		return ResourceBundle.getBundle("bundles.messages");

	}
}
