package main;

import java.util.Locale;

import fxmlUtils.FxmlUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private static final String BORDER_PANE_FXML = "/fxml/borderPane.fxml";

	public static void main(String args[]) {
		Locale.setDefault(new Locale("pl"));
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_FXML);
		Scene scene = new Scene(borderPane);

		primaryStage.setScene(scene);
		primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("app.title"));
		primaryStage.show();
		primaryStage.setResizable(false);

	}

}
