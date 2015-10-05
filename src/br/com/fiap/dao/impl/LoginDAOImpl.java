package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LoginDAO;
import br.com.fiap.entity.LoginEntity;

public class LoginDAOImpl extends DAOImpl<LoginEntity, String>
										implements LoginDAO{

	public LoginDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public boolean validarLogin(String login, String senha) {
		try{
			em.createQuery("from LoginEntity l where l.login = :login "
				+ " and l.senha = :senha").setParameter("login", login)
				.setParameter("senha", senha).getSingleResult();
			return true;
		}catch(Exception e){
			return false;
		}
	}


}