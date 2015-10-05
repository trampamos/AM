package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HRL_TELEFONE")
@SequenceGenerator(name = "seq_telefone", sequenceName = "SEQ_HRL_TELEFONE", allocationSize = 1)
public class TelefoneEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3361454174741352496L;

	@Id
	@Column(name = "cd_telefone")
	private int codigoTelefone;
	
	@Column(name = "nr_ddd")
	private int ddd;
	
	@Column(name ="nr_telefone", nullable = false)
	private int numTelefone;

	@Column(name ="tp_telefone", length = 20)
	private String tipTelefone;

	public int getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(int codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(int numTelefone) {
		this.numTelefone = numTelefone;
	}

	public String getTipTelefone() {
		return tipTelefone;
	}

	public void setTipTelefone(String tipTelefone) {
		this.tipTelefone = tipTelefone;
	}
	
	
	

}
