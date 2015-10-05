package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.ClienteEntity;

public class ClienteDAOImpl extends DAOImpl<ClienteEntity, Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}


}
