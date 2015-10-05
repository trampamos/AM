package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PrestadorDAO;
import br.com.fiap.entity.PrestadorEntity;

public class PrestadorDAOImpl extends DAOImpl<PrestadorEntity, Integer> implements PrestadorDAO{

	public PrestadorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}


}
