package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class DesignDataController {

	private MainController mainController;

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@FXML
	private HBox designData;

	public HBox getDesignData() {
		return designData;
	}

	@FXML
	private Label labelDaneProjektowe;

	@FXML
	private Label labelDlugoscSłupa;
	@FXML
	private Label labelSiłaPodłuzna;

	@FXML
	private Label labelStal;

	@FXML
	private Label labelSchematStatyczny;

	@FXML
	private Label labelWariant;

	@FXML
	private Label labelRozstawOsiowy;

	@FXML
	private Label labelPrzekroj;
	@FXML
	private Label labelPrzewiazki;
	@FXML
	private Label labelGrubosc;
	@FXML
	private Label labelIlosc;
	@FXML
	private Label labelDaneDoOblczen;
	@FXML
	private Label labelKlasaPrzekroju;
	@FXML
	private Label labelKlasaSrodnika;
	@FXML
	private Label labelKlasaStopek;

	public Label getLabelDaneProjektowe() {
		return labelDaneProjektowe;
	}

	public Label getLabelDlugoscSłupa() {
		return labelDlugoscSłupa;
	}

	public Label getLabelSiłaPodłuzna() {
		return labelSiłaPodłuzna;
	}

	public Label getLabelStal() {
		return labelStal;
	}

	public Label getLabelSchematStatyczny() {
		return labelSchematStatyczny;
	}

	public Label getLabelWariant() {
		return labelWariant;
	}

	public Label getLabelRozstawOsiowy() {
		return labelRozstawOsiowy;
	}

	public Label getLabelPrzekroj() {
		return labelPrzekroj;
	}

	public Label getLabelPrzewiazki() {
		return labelPrzewiazki;
	}

	public Label getLabelGrubosc() {
		return labelGrubosc;
	}

	public Label getLabelIlosc() {
		return labelIlosc;
	}

	public Label getLabelDaneDoOblczen() {
		return labelDaneDoOblczen;
	}

	public Label getLabelKlasaPrzekroju() {
		return labelKlasaPrzekroju;
	}

	public Label getLabelKlasaSrodnika() {
		return labelKlasaSrodnika;
	}

	public Label getLabelKlasaStopek() {
		return labelKlasaStopek;
	}

	@FXML
	private TextField textFieldLength;
	@FXML
	private TextField textFieldForce;
	@FXML
	private ChoiceBox<String> choice;
	@FXML
	private RadioButton staticOption1;
	@FXML
	private ToggleGroup staticGroup;
	@FXML
	private RadioButton staticOption2;
	@FXML
	private RadioButton staticOption3;
	@FXML
	private RadioButton staticOption4;
	@FXML
	private RadioButton sectionOption1;
	@FXML
	private ToggleGroup sectionGroup;
	@FXML
	private RadioButton sectionOption2;
	@FXML
	private RadioButton sectionOption3;
	@FXML
	private TextField textFieldSection;
	@FXML
	private TextField textFieldSpan;
	@FXML
	private TextField textFieldPlateWidth;
	@FXML
	private TextField textFFieldThickness;
	@FXML
	private TextField textFieldPlateHeight;
	@FXML
	private TextField textFieldAmount;
	@FXML
	private ChoiceBox<String> choice2;

	@FXML
	private TextField textFieldEpsilon;

	@FXML
	private TextField textFieldKlasaSrodnika;

	@FXML
	private TextField textFieldKlasaStopek;

	@FXML
	private TextArea textArea;

	@FXML
	private TextField textFieldYoung;

	@FXML
	private TextField textFieldFy;

	@FXML
	private TextField textFieldDlWyb;

	@FXML
	private TextField textFieldRozstaw;

	public TextField getTextFieldYoung() {
		return textFieldYoung;
	}

	public TextField getTextFieldFy() {
		return textFieldFy;
	}

	public TextField getTextFieldDlWyb() {
		return textFieldDlWyb;
	}

	public TextField getTextFieldRozstaw() {
		return textFieldRozstaw;
	}

	public TextField getTextFieldDlugosc() {
		return textFieldDlugosc;
	}

	@FXML
	private TextField textFieldDlugosc;

	public TextField getTextFieldEpsilon() {
		return textFieldEpsilon;
	}

	public TextField getTextFieldKlasaSrodnika() {
		return textFieldKlasaSrodnika;
	}

	public TextField getTextFieldKlasaStopek() {
		return textFieldKlasaStopek;
	}

	public TextArea getTextArea() {
		return textArea;
	}

	public TextField getTextFieldLength() {
		return textFieldLength;
	}

	public TextField getTextFieldForce() {
		return textFieldForce;
	}

	public ChoiceBox<String> getChoice() {
		return choice;
	}

	public ChoiceBox<String> getChoice2() {
		return choice2;
	}

	public RadioButton getStaticOption1() {
		return staticOption1;
	}

	public RadioButton getStaticOption2() {
		return staticOption2;
	}

	public RadioButton getStaticOption3() {
		return staticOption3;
	}

	public RadioButton getStaticOption4() {
		return staticOption4;
	}

	public RadioButton getSectionOption1() {
		return sectionOption1;
	}

	public RadioButton getSectionOption2() {
		return sectionOption2;
	}

	public RadioButton getSectionOption3() {
		return sectionOption3;
	}

	public TextField getTextFieldSection() {
		return textFieldSection;
	}

	public TextField getTextFieldSpan() {
		return textFieldSpan;
	}

	public TextField getTextFieldPlateWidth() {
		return textFieldPlateWidth;
	}

	public TextField getTextFFieldThickness() {
		return textFFieldThickness;
	}

	public TextField getTextFieldPlateHeight() {
		return textFieldPlateHeight;
	}

	public TextField getTextFieldAmount() {
		return textFieldAmount;
	}

	ObservableList<String> steelList = FXCollections.observableArrayList();
	ObservableList<String> sectionList = FXCollections.observableArrayList();

	@FXML
	public void initialize() {

		choiceBoxSteelLoadData();
	}

	public void choiceBoxSectionLoadData() {

		sectionList.removeAll(sectionList);

		if (getSectionOption3().isSelected()) {
			sectionList.add("IPE80");
			sectionList.add("IPE100");
			sectionList.add("IPE120");
			sectionList.add("IPE140");
			sectionList.add("IPE160");
			sectionList.add("IPE180");
			sectionList.add("IPE200");
			sectionList.add("IPE220");
			sectionList.add("IPE240");
			sectionList.add("IPE270");
			sectionList.add("IPE300");
			sectionList.add("IPE330");
			sectionList.add("IPE360");
			sectionList.add("IPE400");
			sectionList.add("IPE450");
			sectionList.add("IPE500");
			sectionList.add("IPE550");
			sectionList.add("IPE600");
		}

		else {
			sectionList.add("C40");
			sectionList.add("C50");
			sectionList.add("C65");
			sectionList.add("C80");
			sectionList.add("C100");
			sectionList.add("C120");
			sectionList.add("C140");
			sectionList.add("C160");
			sectionList.add("C180");
			sectionList.add("C200");
			sectionList.add("C220");
			sectionList.add("C240");
			sectionList.add("C260");
			sectionList.add("C280");
			sectionList.add("C300");
			sectionList.add("C320");
			sectionList.add("C350");
			sectionList.add("C380");
			sectionList.add("C400");
		}

		choice2.getItems().removeAll(choice2.getItems());
		choice2.getItems().addAll(sectionList);

	}

	public void updateSection() {
		choiceBoxSectionLoadData();

	}

	public void choiceBoxSteelLoadData() {

		steelList.removeAll(steelList);
		String a = "S235";
		String b = "S275";
		String c = "S355";
		steelList.addAll(a, b, c);
		choice.getItems().addAll(steelList);

	}

}
