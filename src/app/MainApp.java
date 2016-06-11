package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import controller.DodawanieKlientaController;
import controller.DodawanieNaprawyController;
import controller.DodawanieSprzetuController;
import controller.KlienciController;
import controller.LogowanieController;
import controller.NaprawyController;
import controller.SprzetController;
import controller.SzczegolyNaprawyController;
import controller.TopMenuController;
import dao.DaoCon;
import dao.KlientDaoImpl;
import dao.LaptopDaoImpl;
import dao.NaprawaDaoImpl;
import dao.NotatkaDaoImpl;
import dao.StatusNaprawyDaoImpl;
import dao.TypNaprawyDaoImpl;
//import controlers.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Klient;
import model.Laptop;
import model.MagazynSprzetu;
import model.Naprawa;
import model.Notatka;
import model.StatusNaprawy;
import model.TypNaprawy;

public class MainApp extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;

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


	//private ObservableList<Person> personData = FXCollections.observableArrayList();

	public MainApp(){

		klientHashMap = new HashMap<String, String>();
		laptopHashMap = new HashMap<String, String>();
		naprawaHashMap = new HashMap<String, String>();
		notatkaHashMap = new HashMap<String, String>();

		klientHashMap.put("imie", "");
		klientHashMap.put("nazwisko", "");
		klientHashMap.put("firma", "");
		klientHashMap.put("nip", "");
		klientHashMap.put("ulica", "");
		klientHashMap.put("numerDomu", "");
		klientHashMap.put("numerLokalu", "");
		klientHashMap.put("miasto", "");
		klientHashMap.put("kodPocztowy", "");
		klientHashMap.put("email", "");
		klientHashMap.put("telefon", "");
		klientHashMap.put("telefon2", "");

		laptopHashMap.put("nazwa", "");
		laptopHashMap.put("wartosc", "");
		laptopHashMap.put("numerSeryjny", "");
		laptopHashMap.put("opis", "");
		laptopHashMap.put("dataGwarancji", "");
		//laptopHashMap.put("magazyn", "");
		laptopHashMap.put("plytaGlowna", "");
		laptopHashMap.put("procesor", "");
		laptopHashMap.put("iloscRam", "");
		laptopHashMap.put("producentRam", "");
		laptopHashMap.put("typRam", "");
		laptopHashMap.put("dyskTwardy", "");
		laptopHashMap.put("kartaGraficzna", "");
		laptopHashMap.put("naped", "");
		laptopHashMap.put("bateria", "");
		laptopHashMap.put("zasilacz", "");

		naprawaHashMap.put("dataPrzyjecia", "");
		naprawaHashMap.put("przewidywanaDataNaprawy", "");
		naprawaHashMap.put("przewidywanyKoszt", "");
		naprawaHashMap.put("opisUszkodzenia", "");
		naprawaHashMap.put("komentarz", "");
		naprawaHashMap.put("cenaNaprawy", "");
		naprawaHashMap.put("Id_klienta_fk", "");
		naprawaHashMap.put("sprzet", "");
		naprawaHashMap.put("notatki", "");
		naprawaHashMap.put("statusNaprawy", "");
		naprawaHashMap.put("typNaprawy", "");

		notatkaHashMap.put("", "");
		notatkaHashMap.put("dataNotatki", "");
		notatkaHashMap.put("trescNotatki", "");

		//statusHashMap

		daoCon = new DaoCon();
		daoCon.initialize();

		TypNaprawy gwarancyjna = new TypNaprawy("Gwarancyjna");
		TypNaprawy pogwarancyjna = new TypNaprawy("Pogwarancyjna");
		TypNaprawy niegwarancyjna = new TypNaprawy("Niegwarancyjna");
		TypNaprawyDaoImpl typDao = new TypNaprawyDaoImpl(daoCon);
		typDao.persist(gwarancyjna);
		typDao.persist(niegwarancyjna);
		typDao.persist(pogwarancyjna);

		StatusNaprawy status1 = new StatusNaprawy("[Otwarta] Nowa naprawa");
		StatusNaprawy status2 = new StatusNaprawy("[Otwarta] Naprawa rozpoczêta");
		StatusNaprawy status3 = new StatusNaprawy("[Oczekuj¹ca] Serwis zewnêtrzny");
		StatusNaprawy status4 = new StatusNaprawy("[Oczekuj¹ca] Oczekuje na czêœci");
		StatusNaprawy status5 = new StatusNaprawy("[Zamkniêta] Naprawa niewykonana");
		StatusNaprawy status6 = new StatusNaprawy("[Zamkniêta] Naprawa wykonana");
		StatusNaprawyDaoImpl statusDao = new StatusNaprawyDaoImpl(daoCon);
		statusDao.persist(status1);
		statusDao.persist(status2);
		statusDao.persist(status3);
		statusDao.persist(status4);
		statusDao.persist(status5);
		statusDao.persist(status6);



		Klient klient = new Klient();
		klient.setImie("Kamil");
		klient.setNazwisko("Urbañski");
		klient.setTelefon("500-355-822");
		klient.setEmail("kamilur@wp.pl");
		klientDaoImpl = new KlientDaoImpl(daoCon);
		klientDaoImpl.persist(klient);

		laptop = new Laptop();
		laptop.setNazwa("Lenovo G70");
		laptop.setBateria("tak");
		laptop.setNumerSeryjny("XDS3245F");
		laptopDaoImpl = new LaptopDaoImpl(daoCon);
		laptopDaoImpl.persist(laptop);

		Notatka notatka1 = new Notatka();
		notatka1.setTrescNotatki("3Spad³ na ziemiê, nie w³¹cza siê");

		Notatka notatka2 = new Notatka();
		notatka2.setTrescNotatki("23Spad³ na ziemiê, nie w³¹cza siê");

		naprawaDaoImpl = new NaprawaDaoImpl(daoCon);
		Naprawa naprawa1 = new Naprawa();
		naprawa1.setOpisUszkodzenia("Dziecko polamalo obudowe");
		naprawa1.setKlient(klient);
		naprawa1.setSprzet(laptop);

		notatkaDaoImpl = new NotatkaDaoImpl(daoCon);
		//notatkaDaoImpl.persist(notatka1);
		List<Notatka> listaNotatek = new ArrayList<Notatka>();

		//naprawa1 =  naprawaDaoImpl.findById(1l);
		//System.out.println(naprawa1.toString());
		listaNotatek.add(notatka1);
		listaNotatek.add(notatka2);
		naprawa1.setNotatki(listaNotatek);
		naprawaDaoImpl.persist(naprawa1);
//		listaNotatek.add(notatka1);


		/*Date date = new Date();
		System.out.println(date.toString());*/
		notatka1.setTrescNotatki("nowa notatka");
		//notatkaDaoImpl.persist(notatka1);
/*		naprawaHashMap.put("opisUszkodzenia", "Dziecko polamalo obudowe");
		List<Naprawa> naprawy = naprawaDaoImpl.findByAtrybutes(naprawaHashMap);

		for(Naprawa temp:naprawy){
			System.out.println(temp.toString()+" cos jest");
			System.out.println(temp.getOpisUszkodzenia() + " ========= ");
		}*/


		//init data

	}

/*	public ObservableList<Person> getPersonData(){
		return personData;
	}*/

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Service Application");

		showLogowanieView();
		//showNaprawyView();
		//showDodawanieKlientaView();
		//showDodawanieSprzetuView();
		//showDodawanieNaprawyView();
		//showKlienciView();
		//showSprzetView();
		//showSzczegolyNaprawyView();

	}

	public void showLogowanieView() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Logowanie.fxml"));
			rootLayout = (AnchorPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

			LogowanieController controler = loader.getController();
			controler.setMainApp(this);

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void showNaprawyView() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Naprawy.fxml"));
			VBox naprawyView = (VBox) loader.load();
			Scene scene = new Scene(naprawyView);
			primaryStage.setScene(scene);
			primaryStage.show();

			NaprawyController controler = loader.getController();
			controler.setMainApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void showDodawanieKlientaView() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/DodawanieKlienta.fxml"));
			VBox naprawyView = (VBox) loader.load();
			Scene scene = new Scene(naprawyView);
			primaryStage.setScene(scene);
			primaryStage.show();

			Klient klient = new Klient();

			DodawanieKlientaController controler = loader.getController();
			controler.setMainApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void showDodawanieSprzetuView() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/DodawanieSprzetu.fxml"));
			AnchorPane naprawyView = (AnchorPane) loader.load();
			Scene scene = new Scene(naprawyView);
			primaryStage.setScene(scene);
			primaryStage.show();

			DodawanieSprzetuController controler = loader.getController();
			controler.setMainApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void showDodawanieNaprawyView() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/DodawanieNaprawy.fxml"));
			VBox naprawyView = (VBox) loader.load();
			Scene scene = new Scene(naprawyView);
			primaryStage.setScene(scene);
			primaryStage.show();

			DodawanieNaprawyController controler = loader.getController();
			//controler.setMainApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void showKlienciView() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Klienci.fxml"));
			VBox naprawyView = (VBox) loader.load();
			Scene scene = new Scene(naprawyView);
			primaryStage.setScene(scene);
			primaryStage.show();

			KlienciController controler = loader.getController();
			//controler.setMainApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void showSprzetView() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Sprzet.fxml"));
			VBox naprawyView = (VBox) loader.load();
			Scene scene = new Scene(naprawyView);
			primaryStage.setScene(scene);
			primaryStage.show();

			SprzetController controler = loader.getController();
			//controler.setMainApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void showSzczegolyNaprawyView() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/SzczegolyNaprawy.fxml"));
			AnchorPane naprawyView = (AnchorPane) loader.load();
			Scene scene = new Scene(naprawyView);
			primaryStage.setScene(scene);
			primaryStage.show();

			SzczegolyNaprawyController controler = loader.getController();
			controler.setMainApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Klient getKlient() {
		return klient;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public Naprawa getNaprawa() {
		return naprawa;
	}

	public void setNaprawa(Naprawa naprawa) {
		this.naprawa = naprawa;
	}

	public Notatka getNotatka() {
		return notatka;
	}

	public StatusNaprawy getStatusNaprawy() {
		return statusNaprawy;
	}

	public TypNaprawy getTypNaprawy() {
		return typNaprawy;
	}

	public DaoCon getDaoCon() {
		return daoCon;
	}

	public KlientDaoImpl getKlientDaoImpl() {
		return klientDaoImpl;
	}

	public LaptopDaoImpl getLaptopDaoImpl() {
		return laptopDaoImpl;
	}

	public NaprawaDaoImpl getNaprawaDaoImpl() {
		return naprawaDaoImpl;
	}

	public NotatkaDaoImpl getNotatkaDaoImpl() {
		return notatkaDaoImpl;
	}

	public StatusNaprawyDaoImpl getStatusNaprawyDaoImpl() {
		return statusNaprawyDaoImpl;
	}

	public TypNaprawyDaoImpl getTypNaprawyDaoImpl() {
		return typNaprawyDaoImpl;
	}

	public HashMap<String, String> getKlientHashMap() {
		return klientHashMap;
	}

	public void setKlientHashMap(HashMap<String, String> klientHashMap) {
		this.klientHashMap = klientHashMap;
	}

	public HashMap<String, String> getLaptopHashMap() {
		return laptopHashMap;
	}

	public void setLaptopHashMap(HashMap<String, String> laptopHashMap) {
		this.laptopHashMap = laptopHashMap;
	}

	public HashMap<String, String> getNaprawaHashMap() {
		return naprawaHashMap;
	}

	public void setNaprawaHashMap(HashMap<String, String> naprawaHashMap) {
		this.naprawaHashMap = naprawaHashMap;
	}

	public HashMap<String, String> getNotatkaHashMap() {
		return notatkaHashMap;
	}

	public void setNotatkaHashMap(HashMap<String, String> notatkaHashMap) {
		this.notatkaHashMap = notatkaHashMap;
	}

	public HashMap<String, String> getStatusHashMap() {
		return statusHashMap;
	}

	public void setStatusHashMap(HashMap<String, String> statusHashMap) {
		this.statusHashMap = statusHashMap;
	}

	public HashMap<String, String> getTypHashMap() {
		return typHashMap;
	}

	public void setTypHashMap(HashMap<String, String> typHashMap) {
		this.typHashMap = typHashMap;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public void setNotatka(Notatka notatka) {
		this.notatka = notatka;
	}

	public void setStatusNaprawy(StatusNaprawy statusNaprawy) {
		this.statusNaprawy = statusNaprawy;
	}

	public void setTypNaprawy(TypNaprawy typNaprawy) {
		this.typNaprawy = typNaprawy;
	}
}