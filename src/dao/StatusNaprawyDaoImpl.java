package dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.StatusNaprawy;

public class StatusNaprawyDaoImpl implements DaoInterface<StatusNaprawy, HashMap<String, String>, Long> {

	private EntityManager entityManager;

	public StatusNaprawyDaoImpl (DaoCon daoCon) {
		this.entityManager = daoCon.getEntityManager();
	}

	public void persist(StatusNaprawy entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		System.out.println("dodano status naprawy");
	}

	public void update(StatusNaprawy entity) {
		// TODO Auto-generated method stub

	}

	public StatusNaprawy findById(Long id) {
		StatusNaprawy status;
		entityManager.getTransaction().begin();
		status = entityManager.find(StatusNaprawy.class, id);
		entityManager.getTransaction().commit();
		return status;
	}

	public void delete(StatusNaprawy entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();

	}

	public List<StatusNaprawy> findAll() {
		List<StatusNaprawy> statusyNapraw;
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StatusNaprawy> criteriaQuery = criteriaBuilder.createQuery(StatusNaprawy.class);
		Root<StatusNaprawy> status = criteriaQuery.from(StatusNaprawy.class);
		criteriaQuery.select(status);
		TypedQuery<StatusNaprawy> query = entityManager.createQuery(criteriaQuery);
		statusyNapraw = query.getResultList();
		
		return statusyNapraw;
	}

	public List<StatusNaprawy> findByAtrybutes(HashMap<String, String> map) {
		
		return null;
	}
	
	
	
}
