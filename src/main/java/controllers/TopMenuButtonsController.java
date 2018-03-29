package controllers;

import java.util.Locale;

import calculations.Calculator_WYY;
import calculations.Calculator_WZZ;
import calculations.Calculator_plate;
import calculations.Calculator_sectionClass;
import data.Przewiazka;
import data.Section;
import data.Slup;
import data.Stal;
import database.DataBaseDirector;
import fxmlUtils.DialogUtilis;
import fxmlUtils.FxmlUtils;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TopMenuButtonsController {

	@FXML
	private ToggleGroup toggleButtons;

	@FXML
	private ToggleButton designDataButton;

	@FXML
	private ToggleButton buttonWymiarowanie;

	@FXML
	private Button calculationsButton;

	@FXML
	private ToggleButton buttonLanguageEng;

	@FXML
	private ToggleButton buttonLanguagePl;

	public Button getCalculationsButton() {
		return calculationsButton;
	}

	public ToggleButton getButtonWymiarowanie() {

		return buttonWymiarowanie;
	}

	public ToggleButton getDesignDataButton() {
		return designDataButton;
	}

	public ToggleButton getButtonLanguageEng() {
		return buttonLanguageEng;
	}

	public ToggleButton getButtonLanguagePl() {
		return buttonLanguagePl;
	}

	private MainController mainController;
	private DataBaseDirector director = new DataBaseDirector();
	private Calculator_sectionClass calculator_sectionClass = new Calculator_sectionClass();;
	private Calculator_WYY calculator_WYY = new Calculator_WYY();
	private Calculator_WZZ calculator_WZZ = new Calculator_WZZ();
	private Calculator_plate calculator_plate = new Calculator_plate();

	private Slup slup = new Slup();
	private Przewiazka przewiazka = new Przewiazka();
	private Stal stal = new Stal();

	private Section przekroj = new Section();

	String textAreaClass = FxmlUtils.getResourceBundle().getString("data.klasaText");
	
	@FXML
	public void calculating() {

		setDataToCalculations();
		doCalculations();
		setTextFields();
		getButtonWymiarowanie().setDisable(false);

		setTickImage(mainController.getCalculationsDataController().getTickImage1(), calculator_WYY.getWarunek1());
		setTickImage(mainController.getCalculationsDataController().getTickImage2(), calculator_WZZ.getWarunek_sz());
		setTickImage(mainController.getCalculationsDataController().getTickImage3(), calculator_plate.getWarunek_P1(),
				calculator_plate.getWarunek_P2());

	}

	@FXML
	public void designData() {

		getDesignDataButton().setSelected(true);
		getButtonWymiarowanie().setSelected(false);
		mainController.getDesignDataController().getDesignData().setVisible(true);
		mainController.getCalculationsDataController().getCalculationsData().setVisible(false);

	}

	@FXML
	public void wyboczenieYY() {

		getButtonWymiarowanie().setSelected(true);
		getDesignDataButton().setSelected(false);
		mainController.getDesignDataController().getDesignData().setVisible(false);
		mainController.getCalculationsDataController().getCalculationsData().setVisible(true);

	}

	@FXML
	public void setPolish() {
		getButtonLanguagePl().setSelected(true);
		getButtonLanguageEng().setSelected(false);
		Locale.setDefault(new Locale("pl"));

		setLanguage();

	}

	@FXML
	public void setEnglish() {
		getButtonLanguageEng().setSelected(true);
		getButtonLanguagePl().setSelected(false);
		Locale.setDefault(new Locale("eng"));

		setLanguage();
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public void setDataToCalculations() {

		try {
			// SLUP
			slup.setDlugosc(
					Double.parseDouble(mainController.getDesignDataController().getTextFieldLength().getText()));
			slup.setSila(Double.parseDouble(mainController.getDesignDataController().getTextFieldForce().getText()));
			slup.setRozstaw_galezi(
					Double.parseDouble(mainController.getDesignDataController().getTextFieldSpan().getText()));

			if (mainController.getDesignDataController().getStaticOption1().isSelected())
				slup.setDlugosc_wyboczeniowa(slup.getDlugosc() * 2.0);
			if (mainController.getDesignDataController().getStaticOption2().isSelected())
				slup.setDlugosc_wyboczeniowa(slup.getDlugosc() * 0.5);
			if (mainController.getDesignDataController().getStaticOption3().isSelected())
				slup.setDlugosc_wyboczeniowa(slup.getDlugosc() * 0.7);
			if (mainController.getDesignDataController().getStaticOption4().isSelected())
				slup.setDlugosc_wyboczeniowa(slup.getDlugosc() * 1.0);

			slup.setDlugosc_wyboczeniowa(Math.round(slup.getDlugosc_wyboczeniowa()*100)/100.00);
			// PRZEWIAZKA

			przewiazka.setGrubosc(
					Double.parseDouble(mainController.getDesignDataController().getTextFFieldThickness().getText()));
			przewiazka.setSzerokosc(
					Double.parseDouble(mainController.getDesignDataController().getTextFieldPlateWidth().getText()));
			przewiazka.setWysokosc(
					Double.parseDouble(mainController.getDesignDataController().getTextFieldPlateHeight().getText()));
			przewiazka.setIlosc_przewiazek(
					Double.parseDouble(mainController.getDesignDataController().getTextFieldAmount().getText()));
			przewiazka.setRozstaw_przewiazek(slup.getDlugosc() / przewiazka.getIlosc_przewiazek());

			// STAL

			String grPlastycznoscu = mainController.getDesignDataController().getChoice().getValue();
			if (grPlastycznoscu.equals("S235"))
				stal.setGranica_plastycznosci(235);
			if (grPlastycznoscu.equals("S275"))
				stal.setGranica_plastycznosci(275);
			if (grPlastycznoscu.equals("S355"))
				stal.setGranica_plastycznosci(355);

			// PRZEKRÓJ

			przekroj = director.insert(mainController.getDesignDataController().getChoice2().getValue());

		} catch (Exception e) {
			DialogUtilis.errorDialogs(FxmlUtils.getResourceBundle().getString("data.error"));
		}
	}

	public void doCalculations() {

		// KALKULATOR KLASY PRZEKROJU
		calculator_sectionClass.section_class(stal, przekroj);
		calculator_WYY.wyboczenie_y_y(przekroj, stal, slup);
		calculator_WZZ.wyboczenie_z_z(przekroj, stal, slup, przewiazka);
		calculator_plate.przewiazka(przekroj, stal, slup, przewiazka, calculator_WZZ);
	}

	public void setTextFields() {

		mainController.getDesignDataController().getTextFieldEpsilon()
				.setText(Double.toString((calculator_sectionClass.epsilon)));
		mainController.getDesignDataController().getTextFieldKlasaSrodnika()
				.setText(Double.toString((calculator_sectionClass.klasa_srodnika)));
		mainController.getDesignDataController().getTextFieldKlasaStopek()
				.setText(Double.toString((calculator_sectionClass.klasa_stopek)));
		mainController.getDesignDataController().getTextArea()
				.setText(textAreaClass + " "
						+ Double.toString((calculator_sectionClass.klasa_przekroju)));

		// WYPEŁNIENIE PÓL DANYCH

		mainController.getDesignDataController().getTextFieldDlugosc().setText(Double.toString((slup.getDlugosc())));
		mainController.getDesignDataController().getTextFieldDlWyb()
				.setText(Double.toString((slup.getDlugosc_wyboczeniowa())));
		mainController.getDesignDataController().getTextFieldRozstaw()
				.setText(Double.toString((slup.getRozstaw_galezi())));
		mainController.getDesignDataController().getTextFieldFy()
				.setText(Double.toString((stal.getGranica_plastycznosci())));
		mainController.getDesignDataController().getTextFieldYoung().setText(Double.toString((stal.getModul_younga())));

		// WYPEŁNIENIE PÓL W ZAKŁADCE WYMIAROWANIE WYBOCZENIE Y-Y
		mainController.getCalculationsDataController().getTextFieldNosnoscKrytyczna()
				.setText(Double.toString(calculator_WYY.getN_cr()));
		mainController.getCalculationsDataController().getTextFieldSmukloscWzgledna()
				.setText(Double.toString(calculator_WYY.getLambda()));
		mainController.getCalculationsDataController().getTextFieldWspolczynnikWyboczenia()
				.setText(Double.toString(calculator_WYY.getKsi()));
		mainController.getCalculationsDataController().getTextFieldNosnoscYY()
				.setText(Double.toString(calculator_WYY.getNbrd()));
		mainController.getCalculationsDataController().getTextFieldNosnoscWarunekYY()
				.setText(Double.toString(calculator_WYY.getWarunek1()));

		// WYPEŁNIENIE PÓL W ZAKŁADCE WYMIAROWANIE WYBOCZENIE Z-Z

		mainController.getCalculationsDataController().getTextFieldSztywnoscPostaciowa()
				.setText(Double.toString(calculator_WZZ.getSv()));
		mainController.getCalculationsDataController().getTextFieldSilaKrytyczna()
				.setText(Double.toString(calculator_WZZ.getNcrz()));
		mainController.getCalculationsDataController().getTextFieldSilaPodluzna()
				.setText(Double.toString(calculator_WZZ.getNchEd()));
		mainController.getCalculationsDataController().getTextFieldSilaPoprzeczna()
				.setText(Double.toString(calculator_WZZ.getVEd()));
		mainController.getCalculationsDataController().getTextFieldSilaPoprzeczaWPasie()
				.setText(Double.toString(calculator_WZZ.getVchEd()));
		mainController.getCalculationsDataController().getTextFieldMomentZginajacyWPasie()
				.setText(Double.toString(calculator_WZZ.getMchEd()));
		mainController.getCalculationsDataController().getTextFieldNosnoscPrzekrojuPrzyZginaniu()
				.setText(Double.toString(calculator_WZZ.getMc_z_ch_Rd()));
		mainController.getCalculationsDataController().getTextFieldWspolczynnikWyboczeniaZZ()
				.setText(Double.toString(calculator_WZZ.getKsi2()));
		mainController.getCalculationsDataController().getTextFieldNosnoscPrzekroju()
				.setText(Double.toString(calculator_WZZ.getVplzRd()));
		mainController.getCalculationsDataController().getTextFieldCmz()
				.setText(Double.toString(calculator_WZZ.getCmz()));
		mainController.getCalculationsDataController().getTextFieldKzz()
				.setText(Double.toString(calculator_WZZ.getKzz()));
		mainController.getCalculationsDataController().getTextFieldWarunekNosnosci()
				.setText(Double.toString(calculator_WZZ.getWarunek_sz()));

		// WYPEŁNIENIE PÓL W ZAKŁADCE WYMIAROWANIE PRZEWIAZKA

		mainController.getCalculationsDataController().getTextFieldSilaPoprzecznaPrzewiazka()
				.setText(Double.toString(calculator_plate.getV_BED()));
		mainController.getCalculationsDataController().getTextFieldMomentZginajacy()
				.setText(Double.toString(calculator_plate.getM_BED()));
		mainController.getCalculationsDataController().getTextFieldNosnoscPrzyScinaniu()
				.setText(Double.toString(calculator_plate.getV_PL_RD()));
		mainController.getCalculationsDataController().getTextFieldNosnoscPrzyZginaniu()
				.setText(Double.toString(calculator_plate.getM_CRD()));
		mainController.getCalculationsDataController().getTextFieldWarunekScinania()
				.setText(Double.toString(calculator_plate.getWarunek_P1()));
		mainController.getCalculationsDataController().getTextFieldWarunekZginania()
				.setText(Double.toString(calculator_plate.getWarunek_P2()));

	}

	public void setLanguage() {

		setButtonsLanguage(buttonWymiarowanie, "topMenu.results");
		setButtonsLanguage(calculationsButton, "topMenu.calculations");
		setButtonsLanguage(designDataButton, "topMenu.data");

		setLabelLanguage(mainController.getDesignDataController().getLabelDaneDoOblczen(), "data.daneDoObliczen");
		setLabelLanguage(mainController.getDesignDataController().getLabelDaneProjektowe(), "data.DaneProjektowe");
		setLabelLanguage(mainController.getDesignDataController().getLabelDlugoscSłupa(), "data.dlugoscSlupa");
		setLabelLanguage(mainController.getDesignDataController().getLabelGrubosc(), "data.grubosc");
		setLabelLanguage(mainController.getDesignDataController().getLabelIlosc(), "data.ilosc");
		setLabelLanguage(mainController.getDesignDataController().getLabelKlasaPrzekroju(), "data.klasaPrzekroju");
		setLabelLanguage(mainController.getDesignDataController().getLabelKlasaSrodnika(), "data.klasaSrodnika");
		setLabelLanguage(mainController.getDesignDataController().getLabelKlasaStopek(), "data.klasaStopek");
		setLabelLanguage(mainController.getDesignDataController().getLabelPrzekroj(), "data.przekroj");
		setLabelLanguage(mainController.getDesignDataController().getLabelPrzewiazki(), "data.Przewiazki");
		setLabelLanguage(mainController.getDesignDataController().getLabelRozstawOsiowy(), "data.rozstawOsiowy");
		setLabelLanguage(mainController.getDesignDataController().getLabelSchematStatyczny(), "data.schematStatyczny");
		setLabelLanguage(mainController.getDesignDataController().getLabelSiłaPodłuzna(), "data.silaPodluzna");
		setLabelLanguage(mainController.getDesignDataController().getLabelStal(), "data.stal");
		setLabelLanguage(mainController.getDesignDataController().getLabelWariant(), "data.wariant");

		setLabelLanguage(mainController.getCalculationsDataController().getLabelYYLambda(), "calculations.YYLambda");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelYYnosnosc(), "calculations.YYNosnosc");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelYYNosnoscKrytyczna(), "calculations.YYNosnoscKrytyczna");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelYYSmukloscWzgledna(), "calculations.YYSmukloscWzgledna");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelYYWarunek(), "calculations.YYWarunek");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelTitleYY(), "calculations.TitleYY");
	
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZLambda(), "calculations.ZZLambda");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZMomentZginajacy(), "calculations.ZZMomentZginajacy");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZNosnoscScinanie(), "calculations.ZZNosnoscScinanie");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZNosnoscZginanie(), "calculations.ZZNosnoscZginanie");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZSilaKrytyczna(), "calculations.ZZSilaKrytyczna");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZSilaPodluzna(), "calculations.ZZSilaPodluzna");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZSilaPoprzecznaPas(), "calculations.ZZSilaPoprzecznaPas");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZSilaPoprzecznaSlup(), "calculations.ZZSilaPoprzecznaSlup");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZSztywnosc(), "calculations.ZZSztywnosc");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelZZWarunkiNosnosci(), "calculations.ZZWarunkiNosnosci");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelTitleZZ(), "calculations.TitleZZ");

		setLabelLanguage(mainController.getCalculationsDataController().getLabelPlateMoment(), "calculations.PlateMoment");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelPlateNosnoscScinanie(), "calculations.PlateNosnoscScinanie");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelPlateNosnoscZginanie(), "calculations.PlateNosnoscZginanie");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelPlateSilaPoprzeczna(), "calculations.PlateSilaPoprzeczna");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelPlateWarunekScinanie(), "calculations.WarunekScinanie");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelPlateWarunekZginanie(), "calculations.TitleZZ");
		setLabelLanguage(mainController.getCalculationsDataController().getLabelTitlePlate(), "calculations.WarunekZginanie");
	
		textAreaClass = (FxmlUtils.getResourceBundle().getString("data.klasaText"));
		if(!mainController.getDesignDataController().getTextArea().getText().equals(""))
			setTextFields();
		
		mainController.getMenuAbout().setText(FxmlUtils.getResourceBundle().getString("menu.about"));
		mainController.getMenuAlwaysOnTop().setText(FxmlUtils.getResourceBundle().getString("menu.alwaysOnTop"));
		mainController.getMenuClose().setText(FxmlUtils.getResourceBundle().getString("menu.close"));
		mainController.getMenuEdit().setText(FxmlUtils.getResourceBundle().getString("menu.edit"));
		mainController.getMenuFile().setText(FxmlUtils.getResourceBundle().getString("menu.file"));
		mainController.getMenuHelp().setText(FxmlUtils.getResourceBundle().getString("menu.help"));
		

		}

	public void setButtonsLanguage(Button button, String bundle) {

		button.setText(FxmlUtils.getResourceBundle().getString(bundle));

	}

	public void setButtonsLanguage(ToggleButton button, String bundle) {

		button.setText(FxmlUtils.getResourceBundle().getString(bundle));

	}

	public void setLabelLanguage(Label label, String bundle) {

		label.setText(FxmlUtils.getResourceBundle().getString(bundle));

	}

	public void setTickImage(ImageView imageView, double warunek) {
		if (warunek <= 1)
			imageView.setImage(new Image("/pictures/tick1.jpg"));
		else
			imageView.setImage(new Image("/pictures/tick2.jpg"));
	}

	public void setTickImage(ImageView imageView, double warunek, double warunek1) {
		if (warunek <= 1 && warunek1 <= 1)
			imageView.setImage(new Image("/pictures/tick1.jpg"));
		else
			imageView.setImage(new Image("/pictures/tick2.jpg"));
	}
}
