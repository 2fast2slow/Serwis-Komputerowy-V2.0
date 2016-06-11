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

public class DodawanieSprzetuController{

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
	private TextField nazwaTF;
	@FXML
	private TextField wartoscTF;
	@FXML
	private TextField snTF;
	@FXML
	private TextField bateriaTF;
	@FXML
	private TextField plytaTF;
	@FXML
	private TextField procesorTF;
	@FXML
	private TextField zasilaczTF;
	@FXML
	private TextField stanTF;
	@FXML
	private TextField inneTF;
	@FXML
	private TextField ramTF;
	@FXML
	private TextField gwarTF;

	@FXML
	private void dodajSprzet(ActionEvent event) throws IOException {
		laptop.setNazwa(nazwaTF.getText());
		laptop.setBateria(bateriaTF.getText());
		laptop.setPlytaGlowna(plytaTF.getText());
		laptop.setProcesor(procesorTF.getText());
		laptop.setZasilacz(zasilaczTF.getText());
		laptopDaoImpl.persist(laptop);
		mainApp.setLaptop(laptop);
	}




	@FXML
	private void initData() {
		daoCon = mainApp.getDaoCon();
		naprawa = mainApp.getNaprawa();

		laptop = new Laptop();
		laptopDaoImpl = mainApp.getLaptopDaoImpl();
		naprawaDaoImpl = mainApp.getNaprawaDaoImpl();
		notatka = mainApp.getNotatka();
		notatkaDaoImpl = mainApp.getNotatkaDaoImpl();
		List<Notatka> listaNotatek = notatkaDaoImpl.findAll();

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		initData();
	}

}
