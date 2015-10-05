package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "HRL_PRESTADOR")
@PrimaryKeyJoinColumn(name = "cd_prestador")

@NamedStoredProcedureQuery(name = "endereco", procedureName = "HRL_PROC_ENDERECO", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CEP", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_TP_LOGRADOURO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NM_LOGRADOURO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NM_BAIRRO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NM_CIDADE", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NM_SIGLA", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_CD_LOG", type = Integer.class)})
		


public class PrestadorEntity extends PessoaEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cd_logradouro")
	private int codigoLogradouro;
	
	@Column(name = "nr_residencia", nullable = false)
	private String numero;

	@Column(name = "ds_complemento", nullable = true, length = 20)
	private String complemento;
	
	@Column(name = "cd_servico")
	private int codigoServico;
	
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy = "prestador")
	private List<ComentarioEntity> comentarios;
	
	
	
	public int getCodigoLogradouro() {
		return codigoLogradouro;
	}

	public void setCodigoLogradouro(int codigoLogradouro) {
		this.codigoLogradouro = codigoLogradouro;
	}

	public List<ComentarioEntity> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioEntity> comentarios) {
		this.comentarios = comentarios;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero(){
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(int codigoServico) {
		this.codigoServico = codigoServico;
	}



	
	
}
