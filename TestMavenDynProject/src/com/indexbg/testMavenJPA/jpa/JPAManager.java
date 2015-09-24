package com.indexbg.testMavenJPA.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAManager {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testMavenDynProject");
	private static final ThreadLocal<EntityManager> treadLocal = new ThreadLocal<EntityManager>();
	
	static{
		// setup shutdown hook to close EntityManagerFactory
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				treadLocal.remove();
				emf.close();				
			}
		}));
	}

	
	public synchronized static EntityManager getEntityManager(){
		EntityManager em = treadLocal.get();

        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
            treadLocal.set(em);
        }
        return em;
	}

}
