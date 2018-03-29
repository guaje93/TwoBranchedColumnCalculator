package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CalculationsDataController {

	@FXML
	private ScrollPane calculationsData;

	private MainController mainController;

	public ScrollPane getCalculationsData() {
		return calculationsData;
	}
	
	@FXML private Label labelTitleYY;
	@FXML private Label labelYYNosnoscKrytyczna;
	@FXML private Label labelYYSmukloscWzgledna;
	@FXML private Label labelYYLambda;
	@FXML private Label labelYYnosnosc;
	@FXML private Label labelYYWarunek;
	@FXML private Label labelTitleZZ;
	@FXML private Label labelZZSztywnosc;
	@FXML private Label labelZZSilaKrytyczna;
	@FXML private Label labelZZSilaPodluzna;
	@FXML private Label labelZZSilaPoprzecznaSlup;
	@FXML private Label labelZZSilaPoprzecznaPas;
	@FXML private Label labelZZMomentZginajacy;
	@FXML private Label labelZZNosnoscScinanie;
	@FXML private Label labelZZLambda;
	@FXML private Label labelZZNosnoscZginanie;
	@FXML private Label labelZZWarunkiNosnosci;
	@FXML private Label labelTitlePlate;
	@FXML private Label labelPlateSilaPoprzeczna;
	@FXML private Label labelPlateMoment;
	@FXML private Label labelPlateNosnoscScinanie;
	@FXML private Label labelPlateNosnoscZginanie;
	
	public Label getLabelTitleYY() {
		return labelTitleYY;
	}

	public Label getLabelYYNosnoscKrytyczna() {
		return labelYYNosnoscKrytyczna;
	}

	public Label getLabelYYSmukloscWzgledna() {
		return labelYYSmukloscWzgledna;
	}

	public Label getLabelYYLambda() {
		return labelYYLambda;
	}

	public Label getLabelYYnosnosc() {
		return labelYYnosnosc;
	}

	public Label getLabelYYWarunek() {
		return labelYYWarunek;
	}

	public Label getLabelTitleZZ() {
		return labelTitleZZ;
	}

	public Label getLabelZZSztywnosc() {
		return labelZZSztywnosc;
	}

	public Label getLabelZZSilaKrytyczna() {
		return labelZZSilaKrytyczna;
	}

	public Label getLabelZZSilaPodluzna() {
		return labelZZSilaPodluzna;
	}

	public Label getLabelZZSilaPoprzecznaSlup() {
		return labelZZSilaPoprzecznaSlup;
	}

	public Label getLabelZZSilaPoprzecznaPas() {
		return labelZZSilaPoprzecznaPas;
	}

	public Label getLabelZZMomentZginajacy() {
		return labelZZMomentZginajacy;
	}

	public Label getLabelZZNosnoscScinanie() {
		return labelZZNosnoscScinanie;
	}

	public Label getLabelZZLambda() {
		return labelZZLambda;
	}

	public Label getLabelZZNosnoscZginanie() {
		return labelZZNosnoscZginanie;
	}

	public Label getLabelZZWarunkiNosnosci() {
		return labelZZWarunkiNosnosci;
	}

	public Label getLabelTitlePlate() {
		return labelTitlePlate;
	}

	public Label getLabelPlateSilaPoprzeczna() {
		return labelPlateSilaPoprzeczna;
	}

	public Label getLabelPlateMoment() {
		return labelPlateMoment;
	}

	public Label getLabelPlateNosnoscScinanie() {
		return labelPlateNosnoscScinanie;
	}

	public Label getLabelPlateNosnoscZginanie() {
		return labelPlateNosnoscZginanie;
	}

	public Label getLabelPlateWarunekScinanie() {
		return labelPlateWarunekScinanie;
	}

	public Label getLabelPlateWarunekZginanie() {
		return labelPlateWarunekZginanie;
	}

	@FXML private Label labelPlateWarunekScinanie;	
	@FXML private Label labelPlateWarunekZginanie;



	@FXML
	private TextField textFieldNosnoscKrytyczna;

	@FXML
	private TextField textFieldSmukloscWzgledna;
	@FXML
	private TextField textFieldWspolczynnikWyboczenia;
	@FXML
	private TextField textFieldWspolczynnikWyboczeniaZZ;

	@FXML
	private TextField textFieldNosnoscYY;
	@FXML
	private TextField textFieldNosnoscWarunekYY;

	@FXML
	private TextField textFieldSztywnoscPostaciowa;

	@FXML
	private TextField textFieldSilaKrytyczna;

	@FXML
	private TextField textFieldSilaPodluzna;

	@FXML
	private TextField textFieldSilaPoprzeczna;

	@FXML
	private TextField textFieldSilaPoprzeczaWPasie;

	@FXML
	private TextField textFieldMomentZginajacyWPasie;

	@FXML
	private TextField textFieldNosnoscPrzekroju;

	@FXML
	private TextField textFieldKzz;

	@FXML
	private TextField textFieldNosnoscPrzekrojuPrzyZginaniu;

	@FXML
	private TextField textFieldCmz;

	@FXML
	private TextField textFieldWarunekNosnosci;

	@FXML
	private TextField textFieldSilaPoprzecznaPrzewiazka;

	@FXML
	private TextField textFieldMomentZginajacy;

	@FXML
	private TextField textFieldNosnoscPrzyScinaniu;

	@FXML
	private TextField textFieldNosnoscPrzyZginaniu;

	@FXML
	private TextField textFieldWarunekScinania;

	@FXML
	private TextField textFieldWarunekZginania;

	@FXML
	private ImageView tickImage1;

	@FXML
	private ImageView tickImage2;

	@FXML
	private ImageView tickImage3;
	
	public ImageView getTickImage1() {
		return tickImage1;
	}

	public ImageView getTickImage2() {
		return tickImage2;
	}

	public ImageView getTickImage3() {
		return tickImage3;
	}

	public TextField getTextFieldSilaPoprzecznaPrzewiazka() {
		return textFieldSilaPoprzecznaPrzewiazka;
	}
	
	public TextField getTextFieldMomentZginajacy() {
		return textFieldMomentZginajacy;
	}

	public TextField getTextFieldNosnoscPrzyScinaniu() {
		return textFieldNosnoscPrzyScinaniu;
	}

	public TextField getTextFieldNosnoscPrzyZginaniu() {
		return textFieldNosnoscPrzyZginaniu;
	}

	public TextField getTextFieldWarunekScinania() {
		return textFieldWarunekScinania;
	}

	public TextField getTextFieldWarunekZginania() {
		return textFieldWarunekZginania;
	}

	public TextField getTextFieldSztywnoscPostaciowa() {
		return textFieldSztywnoscPostaciowa;
	}

	public TextField getTextFieldSilaKrytyczna() {
		return textFieldSilaKrytyczna;
	}

	public TextField getTextFieldSilaPodluzna() {
		return textFieldSilaPodluzna;
	}

	public TextField getTextFieldSilaPoprzeczna() {
		return textFieldSilaPoprzeczna;
	}

	public TextField getTextFieldSilaPoprzeczaWPasie() {
		return textFieldSilaPoprzeczaWPasie;
	}

	public TextField getTextFieldMomentZginajacyWPasie() {
		return textFieldMomentZginajacyWPasie;
	}

	public TextField getTextFieldNosnoscPrzekroju() {
		return textFieldNosnoscPrzekroju;
	}

	public TextField getTextFieldKzz() {
		return textFieldKzz;
	}

	public TextField getTextFieldNosnoscPrzekrojuPrzyZginaniu() {
		return textFieldNosnoscPrzekrojuPrzyZginaniu;
	}

	public TextField getTextFieldCmz() {
		return textFieldCmz;
	}

	public TextField getTextFieldWspolczynnikWyboczeniaZZ() {
		return textFieldWspolczynnikWyboczeniaZZ;
	}

	public TextField getTextFieldWarunekNosnosci() {
		return textFieldWarunekNosnosci;
	}

	public TextField getTextFieldNosnoscKrytyczna() {
		return textFieldNosnoscKrytyczna;
	}

	public TextField getTextFieldSmukloscWzgledna() {
		return textFieldSmukloscWzgledna;
	}

	public TextField getTextFieldWspolczynnikWyboczenia() {
		return textFieldWspolczynnikWyboczenia;
	}

	public TextField getTextFieldNosnoscYY() {
		return textFieldNosnoscYY;
	}

	public TextField getTextFieldNosnoscWarunekYY() {
		return textFieldNosnoscWarunekYY;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

}
