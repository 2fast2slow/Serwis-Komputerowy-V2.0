package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.Laptop;

public class LaptopDaoImpl implements DaoInterface<Laptop, HashMap<String, String>, Long> {

	private EntityManager entityManager;

	public LaptopDaoImpl(DaoCon daoCon) {
		this.entityManager = daoCon.getEntityManager();
	}

	public void persist(Laptop entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		System.out.println("dodano sprzet");

	}

	public void update(Laptop entity) {
		Laptop entityToUpdate = this.findById((long) entity.getId());
		entityToUpdate.setNazwa(entity.getNazwa());
		entityToUpdate.setWartosc(entity.getWartosc());
		entityToUpdate.setNumerSeryjny(entity.getNumerSeryjny());
		entityToUpdate.setOpis(entity.getOpis());
		entityToUpdate.setDataGwarancji(entity.getDataGwarancji());
		entityToUpdate.setMagazyn(entity.getMagazyn());
		entityToUpdate.setPlytaGlowna(entity.getPlytaGlowna());
		entityToUpdate.setProcesor(entity.getProcesor());
		entityToUpdate.setIloscRam(entity.getIloscRam());
		entityToUpdate.setProducentRam(entity.getProducentRam());
		entityToUpdate.setTypRam(entity.getTypRam());
		entityToUpdate.setDyskTwardy(entity.getDyskTwardy());
		entityToUpdate.setKartaGraficzna(entity.getKartaGraficzna());
		entityToUpdate.setNaped(entity.getNaped());
		entityToUpdate.setBateria(entity.getBateria());
		entityToUpdate.setZasilacz(entity.getZasilacz());

		entityManager.merge(entityToUpdate);
	}

	public Laptop findById(Long id) {

		Laptop laptopTmp;
		entityManager.getTransaction().begin();
		laptopTmp = entityManager.find(Laptop.class, id);
		entityManager.getTransaction().commit();
		return laptopTmp;

	}

	public void delete(Laptop entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();

	}

	public List<Laptop> findAll() {
		List<Laptop> laptopy;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Laptop> criteriaQuery = criteriaBuilder.createQuery(Laptop.class);
		Root<Laptop> laptop = criteriaQuery.from(Laptop.class);
		criteriaQuery.select(laptop);
		TypedQuery<Laptop> query = entityManager.createQuery(criteriaQuery);
		laptopy = query.getResultList();

		return laptopy;
	}

	public List<Laptop> findByAtrybutes(HashMap<String, String> map) {

		HashMap<String, String> hashMap = map;
		List<Laptop> laptopy = null;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Laptop> criteriaQuery = criteriaBuilder.createQuery(Laptop.class);
		Root<Laptop> root = criteriaQuery.from(Laptop.class);
		criteriaQuery.select(root);

		List<Predicate> pred = new ArrayList<Predicate>();
		Predicate p = criteriaBuilder.conjunction();

		String columnName;
		String fieldValue;

		for (int i = 0; i < hashMap.size(); i++) {
			columnName = (String) (hashMap.keySet().toArray()[i]);
			fieldValue = "%" + (String) (hashMap.values().toArray()[i] + "%");
			if (!(fieldValue == "" || fieldValue == null || fieldValue.toString() == "0")) {
				p = criteriaBuilder.and(criteriaBuilder.like(root.<String> get(columnName), fieldValue));
				pred.add(p);
			}
		}

		criteriaQuery.where(pred.toArray(new Predicate[] {}));
		laptopy = this.entityManager.createQuery(criteriaQuery).getResultList();

		return laptopy;
	}

}
