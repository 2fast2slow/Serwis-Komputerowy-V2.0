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

import model.Laptop;



public class LaptopDaoTest {
	
	private List<Laptop> laptopy;
	
	@Rule
	public final ConnectionRule cr = new ConnectionRule();

	@Before
	public void init() {
		laptopy = generujLaptopy();
		for (Laptop laptop : laptopy) {
			cr.getLaptopDao().persist(laptop);
		}
		
	}
	
	@Test
	public void isConnectionOk() {
		assertTrue(cr.getEntMan() != null);
	}
	
	@Test
	public void isAllLaptopsAdded() {
		for (Laptop laptop : laptopy) {
			assertTrue(laptop.getId() > 0.0);
		}
	}
	
	@Test
	public void isAllLaptopsFound() {
		List<Laptop> lista = cr.getLaptopDao().findAll();
		for (Laptop laptop : lista) {
			System.out.println(laptop.getNazwa());
		}
		assertNotNull(lista);
		assertTrue(lista.size() >= 4);
	}
	
	@Test
	public void isLaptopsFoundById() {
		Laptop laptop = cr.getLaptopDao().findById(3L);
		Laptop laptop2 = cr.getLaptopDao().findById(2L);
		assertNotNull(laptop);
		assertNotNull(laptop2);
	}
	
	@Test
	public void findLaptopsByAtr() {
		HashMap<String, String> atrMap = new HashMap<String, String>();
		List<Laptop> foundLaptops = null;
		atrMap.put("nazwa", "ov");
		foundLaptops = cr.getLaptopDao().findByAtrybutes(atrMap);
		assertNotNull(foundLaptops);
		assertTrue(foundLaptops.size() >= 1);

		
	}
	
	@Test
	public void deleteLaptops() {
		for (Laptop laptop : laptopy) {
			cr.getLaptopDao().delete(laptop);
			assertNull(cr.getLaptopDao().findById((long)laptop.getId()));
		}
		
	}
	

	
	public List<Laptop> generujLaptopy() {
		List<Laptop> laptopy = new ArrayList<Laptop>();
		Laptop laptop1 = new Laptop();
		laptop1.setNazwa("Lenovo G50");
		laptop1.setZasilacz("nie");
		laptop1.setNumerSeryjny("XXSD435DF");
		
		Laptop laptop2 = new Laptop();
		laptop2.setNazwa("Lenovo G70");
		laptop2.setZasilacz("tak");
		laptop2.setNumerSeryjny("625562458");
		
		Laptop laptop3 = new Laptop();
		laptop3.setNazwa("Samsung R50");
		laptop3.setZasilacz("tak");
		laptop3.setNumerSeryjny("DDDDSAS536");
		
		
		Laptop laptop4 = new Laptop();
		laptop4.setNazwa("Dell Vostro 5459");
		laptop4.setZasilacz("nie");
		laptop4.setNumerSeryjny("FGH3234D");
		
		
		
		laptopy.add(laptop1);
		laptopy.add(laptop2);
		laptopy.add(laptop3);
		laptopy.add(laptop4);
		return laptopy;
	}
	
}
