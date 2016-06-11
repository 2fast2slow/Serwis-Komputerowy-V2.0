package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import model.Klient;

public class ClientDaoTest {

	private List<Klient> klienci;

	@Rule
	public final ConnectionRule cr = new ConnectionRule();

	@Before
	public void init() {
		klienci = generujKlientów();
		for (Klient klient : klienci) {
			cr.getKlientDao().persist(klient);
		}

	}

	@Test
	public void isConnectionOk() {
		assertTrue(cr.getEntMan() != null);
	}

	@Test
	public void isAllClientsAdded() {
		for (Klient klient : klienci) {
			assertTrue(klient.getId() > 0.0);
		}
	}

	@Test
	public void isAllClientsFound() {
		List<Klient> lista = cr.getKlientDao().findAll();
		for (Klient klient : lista) {
			System.out.println(klient.getImie());
		}
		assertNotNull(lista);
		assertTrue(lista.size() >= 5);
	}

	@Test
	public void isClientFoundById() {
		Klient klient = cr.getKlientDao().findById(3L);
		Klient klient2 = cr.getKlientDao().findById(2L);
		assertNotNull(klient);
		assertNotNull(klient2);
	}

	@Test
	public void findClientsByAtr() {
		HashMap<String, String> atrMap = new HashMap<String, String>();
		List<Klient> foundClients = null;
		atrMap.put("nazwisko", "dr");
		foundClients = cr.getKlientDao().findByAtrybutes(atrMap);
		System.out.println(foundClients);
		assertNotNull(foundClients);
		assertTrue(foundClients.size() >= 1);

	}

	@Test
	public void deleteClients() {
		for (Klient klient : klienci) {
			cr.getKlientDao().delete(klient);
			assertNull(cr.getKlientDao().findById((long) klient.getId()));
		}

	}

	public List<Klient> generujKlientów() {
		List<Klient> klienci = new ArrayList<Klient>();
		Klient klient1 = new Klient();
		klient1.setImie("Kamil");
		klient1.setNazwisko("Urbañski");
		klient1.setTelefon("500-355-022");
		klient1.setMiasto("Nowy S¹cz");

		Klient klient2 = new Klient();
		klient2.setImie("Andrzej");
		klient2.setNazwisko("Dro¿d¿");
		klient2.setTelefon("625562458");
		klient2.setMiasto("Kraków");

		Klient klient3 = new Klient();
		klient3.setImie("Jan");
		klient3.setNazwisko("Kowalski");
		klient3.setTelefon("7777777");
		klient3.setMiasto("Katowice");

		Klient klient4 = new Klient();
		klient4.setImie("Jakub");
		klient4.setNazwisko("Nowak");
		klient4.setTelefon("656312645");
		klient4.setMiasto("Nowy S¹cz");

		Klient klient5 = new Klient();
		klient5.setImie("Janina");
		klient5.setNazwisko("Nowak");
		klient5.setTelefon("99999999");
		klient5.setMiasto("Gdynia");

		klienci.add(klient1);
		klienci.add(klient2);
		klienci.add(klient3);
		klienci.add(klient4);
		klienci.add(klient5);
		return klienci;
	}

}
