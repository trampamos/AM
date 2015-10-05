package br.com.fiap.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.ClienteEntity;
import br.com.fiap.entity.ComentarioEntity;
import br.com.fiap.entity.LoginEntity;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7467633681892952509L;
	private ClienteEntity cliente;
	private LoginEntity login;
	private ClienteDAO dao;

	@PostConstruct
	private void init() {
		// Inicializa o DAO
		EntityManager em = EMFactorySingleton.getInstance()
				.createEntityManager();

		dao = new ClienteDAOImpl(em);
		login = new LoginEntity();
		cliente = new ClienteEntity();
		cliente.setComentarios(new ArrayList<ComentarioEntity>());

	}

	// Clique do botão cadastrar
	public void cadastrar() {
		FacesMessage msg;
		try {
			cliente.setLogin(login);
			dao.insert(cliente);
			msg = new FacesMessage("Cadastrado!");
			cliente = new ClienteEntity(); // Limpa o formulário
			login = new LoginEntity();
			cliente.setComentarios(new ArrayList<ComentarioEntity>());
			cliente.setLogin(login);

		} catch (DBCommitException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro..");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public LoginEntity getLogin() {
		return login;
	}

	public void setLogin(LoginEntity login) {
		this.login = login;
	}
	
	


}
