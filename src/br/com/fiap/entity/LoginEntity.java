package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HRL_LOGIN")
@SequenceGenerator(name = "seq_login", sequenceName = "SEQ_HRL_LOGIN", allocationSize = 1)
public class LoginEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_login")
	@Column(name = "cd_login")
	private int codigoLogin;
	
	@Column(name = "ds_login")
	private String login; 
	
	@Column(name ="ds_senha")
	private String senha;
	
	@OneToOne(mappedBy = "login")
	private PessoaEntity pessoa;
	

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public int getCodigoLogin() {
		return codigoLogin;
	}

	public void setCodigoLogin(int codigoLogin) {
		this.codigoLogin = codigoLogin;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

	

	
	
}
