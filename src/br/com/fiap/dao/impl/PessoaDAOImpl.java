package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.entity.PessoaEntity;

public class PessoaDAOImpl extends DAOImpl<PessoaEntity, Integer> implements PessoaDAO{

	public PessoaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PessoaEntity> listar() {
		return em.createQuery("from Venda",PessoaEntity.class).getResultList();
	}

	@Override
	public long contarPorFormaPagamento(String forma) {
		return em.createQuery("select count(v) from Venda "
				+ "v where v.formaPagamento = :f",Long.class)
				.setParameter("f", forma)
				.getSingleResult();
	}

	@Override
	public long contarPorFormaPagamentoMes(String forma, int mes, int ano) {		
		return em.createQuery("select count(v) from Venda v "
				+ "where v.formaPagamento = :f and "
				+ "month(v.data) = :m and year(v.data) = :y",
				Long.class).setParameter("f", forma)
				.setParameter("m", mes)
				.setParameter("y", ano).getSingleResult();
	}

	@Override
	public List<String> buscarPorDescricao(String desc) {		
		return em.createQuery("select v.descricao from Venda v "
				+ "where upper(v.descricao) like upper(:d)",
				String.class)
				.setParameter("d", "%" + desc + "%")
				.getResultList();
	}

	
}
