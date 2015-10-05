package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * EntityManagerFactorySingleton classe para gerenciar
 * a única instância de EntityManagerFactory
 * @author Thiago
 */
public class EMFactorySingleton {
	
	private static EntityManagerFactory factory;
	
	private EMFactorySingleton() { }
	
	public static EntityManagerFactory getInstance(){
		if (factory == null){
			factory = 
		Persistence
		.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return factory;
	}
}






