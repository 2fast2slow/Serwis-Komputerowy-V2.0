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

import model.Naprawa;

public class NaprawaDaoImpl implements DaoInterface<Naprawa, HashMap<String, String>, Long> {

	private EntityManager entityManager;

	public NaprawaDaoImpl(DaoCon daoCon) {
		this.entityManager = daoCon.getEntityManager();
	}

	public void persist(Naprawa entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		System.out.println("dodano naprawê");

	}

	public void update(Naprawa entity) {
		Naprawa entityToUpdate = this.findById((long) entity.getId());
		entityToUpdate.setDataPrzyjecia(entity.getDataPrzyjecia());
		entityToUpdate.setPrzewidywanyKoszt(entity.getPrzewidywanyKoszt());
		entityToUpdate.setOpisUszkodzenia(entity.getOpisUszkodzenia());
		entityToUpdate.setKomentarz(entity.getKomentarz());
		entityToUpdate.setCenaNaprawy(entity.getCenaNaprawy());
		entityToUpdate.setStatusNaprawy(entity.getStatusNaprawy());
		entityToUpdate.setTypNaprawy(entity.getTypNaprawy());

		entityManager.merge(entityToUpdate);

	}

	public Naprawa findById(Long id) {
		Naprawa naprawaTmp;
		entityManager.getTransaction().begin();
		naprawaTmp = entityManager.find(Naprawa.class, id);
		entityManager.getTransaction().commit();
		return naprawaTmp;
	}

	public void delete(Naprawa entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();

	}

	public List<Naprawa> findAll() {

		List<Naprawa> naprawy;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Naprawa> criteriaQuery = criteriaBuilder.createQuery(Naprawa.class);
		Root<Naprawa> naprawa = criteriaQuery.from(Naprawa.class);
		criteriaQuery.select(naprawa);
		TypedQuery<Naprawa> query = entityManager.createQuery(criteriaQuery);
		naprawy = query.getResultList();

		return naprawy;
	}

	public List<Naprawa> findByAtrybutes(HashMap<String, String> map) {

		HashMap<String, String> hashMap = map;
		List<Naprawa> naprawy = null;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Naprawa> criteriaQuery = criteriaBuilder.createQuery(Naprawa.class);
		Root<Naprawa> root = criteriaQuery.from(Naprawa.class);
		criteriaQuery.select(root);

		List<Predicate> pred = new ArrayList<Predicate>();
		Predicate p = criteriaBuilder.conjunction();

		String columnName;
		String fieldValue;

		for (int i = 0; i < hashMap.size(); i++) {
			columnName = (String) (hashMap.keySet().toArray()[i]);
			fieldValue = (String) (hashMap.values().toArray()[i]);
			if (!(fieldValue == "" || fieldValue == null || fieldValue.toString() == "0")) {
				fieldValue = "%" + (String) (hashMap.values().toArray()[i] + "%");
				p = criteriaBuilder.and(criteriaBuilder.like(root.<String> get(columnName), fieldValue));
				pred.add(p);
			}
		}

		criteriaQuery.where(pred.toArray(new Predicate[] {}));
		naprawy = this.entityManager.createQuery(criteriaQuery).getResultList();

		return naprawy;
	}

}
