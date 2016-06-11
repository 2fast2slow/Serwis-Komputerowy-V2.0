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

import dao.DaoCon;
import model.Klient;

public class KlientDaoImpl implements DaoInterface<Klient, HashMap<String, String>, Long> {

	private EntityManager entityManager;

	public KlientDaoImpl(DaoCon daoCon) {
		this.entityManager = daoCon.getEntityManager();

	}

	public void persist(Klient entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		System.out.println("dodano klienta");

	}

	public void update(Klient entity) {
		Klient entityToUpdate = this.findById((long) entity.getId());
		entityToUpdate.setImie(entity.getImie());
		entityToUpdate.setNazwisko(entity.getNazwisko());
		entityToUpdate.setFirma(entity.getFirma());
		entityToUpdate.setNip(entity.getNip());
		entityToUpdate.setUlica(entity.getUlica());
		entityToUpdate.setNumerDomu(entity.getNumerDomu());
		entityToUpdate.setNumerLokalu(entity.getNumerLokalu());
		entityToUpdate.setMiasto(entity.getMiasto());
		entityToUpdate.setKodPocztowy(entity.getKodPocztowy());
		entityToUpdate.setEmail(entity.getEmail());
		entityToUpdate.setTelefon(entity.getTelefon());
		entityToUpdate.setTelefon2(entity.getTelefon2());

		entityManager.merge(entityToUpdate);
	}

	public Klient findById(Long id) {

		Klient klientTmp;
		entityManager.getTransaction().begin();
		klientTmp = entityManager.find(Klient.class, id);
		entityManager.getTransaction().commit();
		return klientTmp;

	}

	public void delete(Klient entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();

	}

	public List<Klient> findAll() {
		List<Klient> klienci;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Klient> criteriaQuery = criteriaBuilder.createQuery(Klient.class);
		Root<Klient> klient = criteriaQuery.from(Klient.class);
		criteriaQuery.select(klient);
		TypedQuery<Klient> query = entityManager.createQuery(criteriaQuery);
		klienci = query.getResultList();

		return klienci;
	}

	public List<Klient> findByAtrybutes(HashMap<String, String> map) {

		HashMap<String, String> hashMap = map;
		List<Klient> klienci = null;

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Klient> criteriaQuery = criteriaBuilder.createQuery(Klient.class);
		Root<Klient> root = criteriaQuery.from(Klient.class);
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
		klienci = this.entityManager.createQuery(criteriaQuery).getResultList();

		for (Klient temp : klienci) {
			System.out.println(temp.getImie() + " " + temp.getNazwisko() + " " + temp.getTelefon());
		}

		return klienci;
	}

}
