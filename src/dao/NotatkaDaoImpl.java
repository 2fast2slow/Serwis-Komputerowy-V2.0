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


import model.Notatka;


public class NotatkaDaoImpl implements DaoInterface<Notatka, HashMap<String, String>, Long> {

	private EntityManager entityManager;

	public NotatkaDaoImpl(DaoCon daoCon) {
		this.entityManager = daoCon.getEntityManager();
	}

	public void persist(Notatka entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		System.out.println("dodano notatke");

	}

	public void update(Notatka entity) {
		Notatka entityToUpdate = this.findById((long) entity.getId());
		entityToUpdate.setDataNotatki(entity.getDataNotatki());
		entityToUpdate.setTrescNotatki(entity.getTrescNotatki());
		entityManager.merge(entityToUpdate);

	}

	public Notatka findById(Long id) {
		Notatka notatkaTmp;
		entityManager.getTransaction().begin();
		notatkaTmp = entityManager.find(Notatka.class, id);
		entityManager.getTransaction().commit();
		return notatkaTmp;
	}

	public void delete(Notatka entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();

	}

	public List<Notatka> findAll() {

		List<Notatka> notatki;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Notatka> criteriaQuery = criteriaBuilder.createQuery(Notatka.class);
		Root<Notatka> notatka = criteriaQuery.from(Notatka.class);
		criteriaQuery.select(notatka);
		TypedQuery<Notatka> query = entityManager.createQuery(criteriaQuery);
		notatki = query.getResultList();

		for(Notatka temp:notatki){
			System.out.println(temp.getTrescNotatki() + "\n");
		}

		return notatki;
	}

	public List<Notatka> findByAtrybutes(HashMap<String, String> map) {

		HashMap<String, String> hashMap = map;
		List<Notatka> notatki = null;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Notatka> criteriaQuery = criteriaBuilder.createQuery(Notatka.class);
		Root<Notatka> root = criteriaQuery.from(Notatka.class);
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
		notatki = this.entityManager.createQuery(criteriaQuery).getResultList();

		return notatki;
	}

}