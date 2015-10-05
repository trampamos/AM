package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HRL_COMENTARIO")
@SequenceGenerator(name = "seq_comentario", sequenceName = "SEQ_HRL_COMENTARIO", allocationSize = 1)
public class ComentarioEntity implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seq_comentario", strategy=GenerationType.SEQUENCE)
	@Column(name = "cd_comentario")
	private int codigoComentario;
	
	@Column(name = "ds_comentario", nullable = false, length = 300)
	private String comentario;
	
	@Column(name = "DATA_REGISTRADA")
	@Temporal(TemporalType.DATE)
	private Calendar dataRegistrada;
	
	@Id
	@ManyToOne( cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="cd_cliente")
	private ClienteEntity cliente;
	
	@Id
	@ManyToOne( cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="cd_prestador")
	private PrestadorEntity prestador;

	
	
	public int getCodigoComentario() {
		return codigoComentario;
	}

	public void setCodigoComentario(int codigoComentario) {
		this.codigoComentario = codigoComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public Calendar getDataRegistrada() {
		return dataRegistrada;
	}

	public void setDataRegistrada(Calendar dataRegistrada) {
		this.dataRegistrada = dataRegistrada;
	}
	
	
	
	
}
