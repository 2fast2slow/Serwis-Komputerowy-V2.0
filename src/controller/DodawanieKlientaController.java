package controller;

import java.io.IOException;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import app.MainApp;
import dao.DaoCon;
import dao.KlientDaoImpl;
import dao.LaptopDaoImpl;
import dao.NaprawaDaoImpl;
import dao.NotatkaDaoImpl;
import dao.StatusNaprawyDaoImpl;
import dao.TypNaprawyDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Klient;
import model.Laptop;
import model.Naprawa;
import model.Notatka;
import model.StatusNaprawy;
import model.TypNaprawy;

public class DodawanieKlientaController {

	private DaoCon daoCon;
	private Klient klient;
	private Laptop laptop;
	private Naprawa naprawa;
	private Notatka notatka;
	private StatusNaprawy statusNaprawy;
	private TypNaprawy typNaprawy;

	private KlientDaoImpl klientDaoImpl;
	private LaptopDaoImpl laptopDaoImpl;
	private NaprawaDaoImpl naprawaDaoImpl;
	private NotatkaDaoImpl notatkaDaoImpl;
	private StatusNaprawyDaoImpl statusNaprawyDaoImpl;
	private TypNaprawyDaoImpl typNaprawyDaoImpl;

	private HashMap<String, String> klientHashMap;
	private HashMap<String, String> laptopHashMap;
	private HashMap<String, String> naprawaHashMap;
	private HashMap<String, String> notatkaHashMap;
	private HashMap<String, String> statusHashMap;
	private HashMap<String, String> typHashMap;

	private MainApp mainApp;

	@FXML
	private Button dalejButton;

	@FXML
	private TextField imieTextField;
	@FXML
	private TextField nazwiskoTextField;
	@FXML
	private TextField firmaTextField;
	@FXML
	private TextField nipTextField;
	@FXML
	private TextField ulicaTextField;
	@FXML
	private TextField nrBudynkuTextField;
	@FXML
	private TextField nrLokaluTextField;
	@FXML
	private TextField miastoTextField;
	@FXML
	private TextField kodPocztowyTextField;
	@FXML
	private TextField emailTextField;
	@FXML
	private TextField telefonTextField;
	@FXML
	private TextField telefon2TextField;

	@FXML
	private void dodajKlienta(ActionEvent event) throws IOException {
		//System.out.println(klient.getImie());
		klient = new Klient();
		klient.setImie(imieTextField.getText());
		klient.setNazwisko(nazwiskoTextField.getText());
		klient.setFirma(firmaTextField.getText());
		klient.setNip(nipTextField.getText());
		klient.setUlica(ulicaTextField.getText());
		klient.setNumerDomu(nrBudynkuTextField.getText());
		klient.setNumerLokalu(nrLokaluTextField.getText());
		klient.setMiasto(miastoTextField.getText());
		klient.setKodPocztowy(kodPocztowyTextField.getText());
		klient.setEmail(emailTextField.getText());
		klient.setTelefon(telefonTextField.getText());
		klient.setTelefon2(telefon2TextField.getText());
		klientDaoImpl.persist(klient);
		mainApp.setKlient(klient);
		mainApp.showDodawanieSprzetuView();
	}

	@FXML
	private void initData() {
		//daoCon = mainApp.getDaoCon();
		//klient = mainApp.getKlient();
		//klientDaoImpl = mainApp.getKlientDaoImpl();

		//naprawa = mainApp.getNaprawa();
		//System.out.println(naprawa.getId());
		//naprawaDaoImpl = mainApp.getNaprawaDaoImpl();
		//notatka = mainApp.getNotatka();
		//notatkaDaoImpl = mainApp.getNotatkaDaoImpl();
		//System.out.println(notatka.getTrescNotatki().toString());


	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		daoCon = mainApp.getDaoCon();
		klient = mainApp.getKlient();

		laptop = mainApp.getLaptop();
		naprawa = mainApp.getNaprawa();

		klientDaoImpl = mainApp.getKlientDaoImpl();
		naprawaDaoImpl = mainApp.getNaprawaDaoImpl();
		laptopDaoImpl = mainApp.getLaptopDaoImpl();
		initData();
	}

}
