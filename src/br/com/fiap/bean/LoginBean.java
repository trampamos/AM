package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.LoginDAO;
import br.com.fiap.dao.impl.LoginDAOImpl;
import br.com.fiap.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String login;
	private String senha;
	private LoginDAO dao;
	
	@PostConstruct
	private void init(){
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new LoginDAOImpl(em);
	}
	
	public String logar(){
		if (dao.validarLogin(login, senha)){
			//Criar uma sessao para o usu�rio
			HttpSession sessao = (HttpSession) 
					FacesContext.getCurrentInstance()
								.getExternalContext().getSession(true);
			//Coloca uma informa��o na sess�o do usu�rio
			sessao.setAttribute("user", login);
			return "index";
		}else{
			FacesMessage msg = 
				new FacesMessage("Usu�rio e/ou senha inv�lidos");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "login";
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
