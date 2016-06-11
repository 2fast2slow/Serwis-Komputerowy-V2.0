package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.MainApp;
import dao.DaoCon;
import dao.KlientDaoImpl;
import dao.LaptopDaoImpl;
import dao.NaprawaDaoImpl;
import dao.NotatkaDaoImpl;
import dao.StatusNaprawyDaoImpl;
import dao.TypNaprawyDaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Klient;
import model.Laptop;
import model.Naprawa;
import model.Notatka;
import model.StatusNaprawy;
import model.TypNaprawy;

public class SzczegolyNaprawyController{

	private Klient klient;
	private Laptop laptop;
	private Naprawa naprawa;
	private Notatka notatka;
	private StatusNaprawy statusNaprawy;
	private TypNaprawy typNaprawy;
	private MainApp mainApp;

	private DaoCon daoCon;

	private KlientDaoImpl klientDaoImpl;
	private LaptopDaoImpl laptopDaoImpl;
	private NaprawaDaoImpl naprawaDaoImpl;
	private NotatkaDaoImpl notatkaDaoImpl;
	private StatusNaprawyDaoImpl statusNaprawyDaoImpl;
	private TypNaprawyDaoImpl typNaprawyDaoImpl;

	@FXML
	private TextArea opisUszkodzeniaTF;

	@FXML
	private void initialize() {
		//System.out.println("sss kkkkkkkkkkkk");
		//System.out.println(naprawa.getOpisUszkodzenia());
		//opisUszkodzeniaTF.setText(naprawa.getOpisUszkodzenia().toString()); //naprawa.getOpisUszkodzenia().toString()
		//System.out.println(naprawa.getOpisUszkodzenia());
		//firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstName());
		//lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastName());;
	}

	private void init(){
		opisUszkodzeniaTF.setText(naprawa.getOpisUszkodzenia().toString());
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

		//System.out.println(naprawa.getOpisUszkodzenia().toString());
		init(); //naprawa.getOpisUszkodzenia().toString()

		//opisUszkodzeniaTF.setText(naprawa.getOpisUszkodzenia().toString()); //naprawa.getOpisUszkodzenia().toString()

		//personTable.setItems(mainApp.getPersonData());
	}


}
