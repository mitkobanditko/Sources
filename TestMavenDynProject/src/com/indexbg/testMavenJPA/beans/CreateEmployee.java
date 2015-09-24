package com.indexbg.testMavenJPA.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.indexbg.testMavenJPA.db.Employee;
import com.indexbg.testMavenJPA.jpa.JPAManager;

public class CreateEmployee {

	public static void main(String[] args) {
		
		EntityManager entityManager =  JPAManager.getEntityManager();
		
		/*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "testMavenDynProject" ); 
		EntityManager entityManager = emfactory. createEntityManager( );*/
		entityManager.getTransaction().begin();
		Employee emp = new Employee();
		System.out.println(emp.getName());
		emp.setId(7L);
		emp.setName("NOVOTO IME 7 !!!!");
		entityManager.persist(emp);
		entityManager.getTransaction().commit();
		Employee emp2 = entityManager.find(Employee.class, 1L);
		System.out.println("Employee with ID:" + emp2.getId() + " and name: " + emp2.getName());
		entityManager.close();
	}

}
