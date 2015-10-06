package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.PrestadorEntity;

public interface PrestadorDAO extends DAO<PrestadorEntity,Integer>{
	
	List<PrestadorEntity> listaServico();


	
	
}








