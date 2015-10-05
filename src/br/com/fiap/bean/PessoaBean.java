package br.com.fiap.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.entity.PessoaEntity;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class PessoaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7467633681892952509L;

	private PessoaEntity pessoa;

	private PessoaDAO dao;


	@PostConstruct
	private void init() {
		// Inicializa o DAO
		EntityManager em = EMFactorySingleton.getInstance()
				.createEntityManager();
		
		dao = new PessoaDAOImpl(em);
		pessoa = new PessoaEntity();

		// Busca as vendas no DB
		//lista = dao.listar();

	}

	// Clique do botão cadastrar
	public void cadastrar() {
		FacesMessage msg;
		try {
				dao.insert(pessoa);
				msg = new FacesMessage("Cadastrado!");
			//lista = dao.listar(); // Atualizar a tabela
			//pessoa = new PessoaEntity(); // Limpa o formulário
		} catch (DBCommitException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro..");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}



	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

}
