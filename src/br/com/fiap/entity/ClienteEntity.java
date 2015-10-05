package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "HRL_CLIENTE")
@PrimaryKeyJoinColumn(name = "cd_cliente") 
public class ClienteEntity extends PessoaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*public ClienteEntity() {
		super();
	}*/
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy = "cliente")
	private List<ComentarioEntity> comentarios;

	
	public List<ComentarioEntity> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioEntity> comentarios) {
		this.comentarios = comentarios;
	}

	
}
