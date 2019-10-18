package br.edu.unifei.ecoe18.supernatural.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FonteDados {

private static EntityManagerFactory emf =
Persistence.
createEntityManagerFactory("supernaturalPU");

public static EntityManager createManager() {
	return emf.createEntityManager();
}


}
