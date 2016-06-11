package test;

import javax.persistence.EntityManager;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import dao.DaoCon;
import dao.KlientDaoImpl;
import dao.LaptopDaoImpl;
import dao.NaprawaDaoImpl;

public class ConnectionRule implements MethodRule {
	private DaoCon daoCon;
	private EntityManager entMan;
	private KlientDaoImpl klientDao;
	private LaptopDaoImpl laptopDao;
	private NaprawaDaoImpl naprawaDao;

	public Statement apply(final Statement statement, FrameworkMethod method, Object test) {

		return new Statement() {

			@Override
			public void evaluate() throws Throwable {

				daoCon = new DaoCon();
				daoCon.initialize();
				entMan = daoCon.getEntityManager();
				klientDao = new KlientDaoImpl(daoCon);
				laptopDao = new LaptopDaoImpl(daoCon);
				naprawaDao = new NaprawaDaoImpl(daoCon);
				try {
				statement.evaluate();
				} finally {
					closeConnection();
				}
			}

		};
	}

	public synchronized LaptopDaoImpl getLaptopDao() {
		return laptopDao;
	}

	public synchronized NaprawaDaoImpl getNaprawaDao() {
		return naprawaDao;
	}

	public EntityManager getEntMan() {
		return entMan;
	}

	public synchronized KlientDaoImpl getKlientDao() {
		return klientDao;
	}

	public void closeConnection() {
		daoCon.closeSession();
	}

}
