package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Klient;
import model.Laptop;
import model.Naprawa;
import model.Notatka;
import model.StatusNaprawy;
import model.TypNaprawy;

public class NaprawyController{

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
	private Button nowaNaprawaBtn;

	@FXML
	private Button szukajNaprawyBtn;

	@FXML
	private Button szukajKlientaBtn;

	@FXML
	private Button szukajSprzetuBtn;

	@FXML
	private Button szukajPoIdBtn;

	@FXML
	private TextField szukajPoIdTF;

	@FXML
	private TextArea notatkiTA;

	@FXML
	private void dodajKlienta(ActionEvent event) throws IOException {
		mainApp.showDodawanieKlientaView();
	}

	@FXML
	private void szukajKlienta(ActionEvent event) throws IOException {
		mainApp.showKlienciView();
	}

	@FXML
	private void szukajSprzetu(ActionEvent event) throws IOException {
		mainApp.showSprzetView();
	}

	@FXML
	private void szukajNaprawyPoId(ActionEvent event) throws IOException {
		naprawa = naprawaDaoImpl.findById(Long.parseLong(szukajPoIdTF.getText()));
		mainApp.setNaprawa(naprawa);
		mainApp.showSzczegolyNaprawyView();
	}

	@FXML
	private void initData() {
		daoCon = mainApp.getDaoCon();
		naprawa = mainApp.getNaprawa();
		naprawaDaoImpl = mainApp.getNaprawaDaoImpl();
		notatka = mainApp.getNotatka();
		notatkaDaoImpl = mainApp.getNotatkaDaoImpl();
		List<Notatka> listaNotatek = notatkaDaoImpl.findAll();
		for(Notatka temp:listaNotatek){
			notatkiTA.appendText(temp.getTrescNotatki() + "\n");
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		initData();
	}

}
