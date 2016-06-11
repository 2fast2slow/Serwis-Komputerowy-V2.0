package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoCon {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void initialize() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("mydatabase");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public void closeSession() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
