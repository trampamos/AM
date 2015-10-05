package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HRL_PESSOA")
@SequenceGenerator(name = "seq_pessoa", sequenceName = "SEQ_HRL_PESSOA", allocationSize = 1)
@Inheritance(strategy=InheritanceType.JOINED)
public class PessoaEntity implements Serializable{
	
	/**
	 * @author Rubens
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_pessoa")
	@Column(name = "cd_pessoa")
	private int codigoPessoa;
	
	@Column(name = "nm_nome", nullable = true, length = 40)
	private String nome;
	
	@Column(name = "nm_sobrenome", nullable = true, length = 40)
	private String sobrenome;
	
	@Column(name = "ds_email", nullable = true,length = 100)
	private String email;


	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "cd_login")
	private LoginEntity login;
	
	public LoginEntity getLogin() {
		return login;
	}

	public void setLogin(LoginEntity login) {
		this.login = login;
	}
	
	
	public int getCodigo() {
		return codigoPessoa;
	}

	public void setCodigo(int codigo) {
		this.codigoPessoa = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
