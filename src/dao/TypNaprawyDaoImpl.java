package dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.TypNaprawy;

public class TypNaprawyDaoImpl implements DaoInterface<TypNaprawy, HashMap<String, String>, Long> {

	private EntityManager entityManager;

	public TypNaprawyDaoImpl (DaoCon daoCon) {
		this.entityManager = daoCon.getEntityManager();
	}

	public void persist(TypNaprawy entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		System.out.println("dodano typ naprawy");
	}

	public void update(TypNaprawy entity) {
		// TODO Auto-generated method stub

	}

	public TypNaprawy findById(Long id) {
		TypNaprawy typ;
		entityManager.getTransaction().begin();
		typ = entityManager.find(TypNaprawy.class, id);
		entityManager.getTransaction().commit();
		return typ;
	}

	public void delete(TypNaprawy entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();

	}

	public List<TypNaprawy> findAll() {
		List<TypNaprawy> typyNapraw;
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TypNaprawy> criteriaQuery = criteriaBuilder.createQuery(TypNaprawy.class);
		Root<TypNaprawy> typ = criteriaQuery.from(TypNaprawy.class);
		criteriaQuery.select(typ);
		TypedQuery<TypNaprawy> query = entityManager.createQuery(criteriaQuery);
		typyNapraw = query.getResultList();
		
		return typyNapraw;
	}

	public List<TypNaprawy> findByAtrybutes(HashMap<String, String> map) {
	
		return null;
	}

}
