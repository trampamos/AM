package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HRL_BADGE")
@SequenceGenerator(name = "seq_badge", sequenceName = "SEQ_HRL_BADGE", allocationSize = 1)
public class BadgeEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_badge")
	private int codigoBadge;
	
	@Column(name = "cd_prestador", nullable = false)
	private PrestadorEntity prestador;
	
	@Column(name = "ds_badge", nullable = false, length = 100)
	private String badge;

	public int getCodigoBadge() {
		return codigoBadge;
	}

	public void setCodigoBadge(int codigoBadge) {
		this.codigoBadge = codigoBadge;
	}

	

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public PrestadorEntity getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorEntity prestador) {
		this.prestador = prestador;
	}

	
	
}
