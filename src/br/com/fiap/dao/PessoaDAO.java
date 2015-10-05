package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.PessoaEntity;

public interface PessoaDAO extends DAO<PessoaEntity,Integer>{

	List<PessoaEntity> listar();
	
	long contarPorFormaPagamento(String forma);
	
	long contarPorFormaPagamentoMes(String forma, int mes, int ano);
	
	//Método para o autocomplete
	List<String> buscarPorDescricao(String desc);
	
	
}








