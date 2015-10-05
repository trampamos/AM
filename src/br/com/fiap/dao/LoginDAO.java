package br.com.fiap.dao;

import br.com.fiap.entity.LoginEntity;

public interface LoginDAO extends DAO<LoginEntity,String>{

	boolean validarLogin(String login, String senha);
	
}
