package br.com.fiap.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import br.com.fiap.dao.PrestadorDAO;
import br.com.fiap.dao.impl.PrestadorDAOImpl;
import br.com.fiap.entity.ComentarioEntity;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.PrestadorEntity;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

@ManagedBean
@SessionScoped
public class BuscaCepBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7467633681892952509L;
	private PrestadorEntity prestador;
	private PrestadorDAO dao;
	
	private Endereco endereco;
	
	private String cep;
	
	private EntityManager em;
	
	private int cd;
	
	

	@PostConstruct
	private void init() {
		// Inicializa o DAO
		em = EMFactorySingleton.getInstance()
				.createEntityManager();

		dao = new PrestadorDAOImpl(em);
		prestador=new PrestadorEntity();
		prestador.setComentarios(new ArrayList<ComentarioEntity>());
		prestador.setCodigoLogradouro(cd);
		endereco = new Endereco();

	}

	// Clique do botão cadastrar
	public void cadastrar() {
		FacesMessage msg;
		try {
			prestador.setCodigoLogradouro(cd);
			dao.insert(prestador);
			msg = new FacesMessage("Cadastrado!");
			prestador = new PrestadorEntity(); // Limpa o formulário
			prestador.setComentarios(new ArrayList<ComentarioEntity>());

		} catch (DBCommitException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro..");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	

	public void buscar() {
		
		
		
		try {
			String tp = "";
			String log= "";
			String bairro= "";
			String cidade= "";
			String sigla= "";
			
			StoredProcedureQuery query2 = em.createNamedStoredProcedureQuery("endereco");
			query2.setParameter("P_CEP", cep);
			query2.execute();
			
			tp = (String) query2.getOutputParameterValue("P_TP_LOGRADOURO");
			log = (String) query2.getOutputParameterValue("P_NM_LOGRADOURO");
			bairro = (String) query2.getOutputParameterValue("P_NM_BAIRRO");
			cidade = (String) query2.getOutputParameterValue("P_NM_CIDADE");
			sigla = (String) query2.getOutputParameterValue("P_NM_SIGLA");
			cd = (Integer) query2.getOutputParameterValue("P_CD_LOG");
			
			
			endereco.setTipoLogradouro(tp);
			endereco.setLogradouro(log);
			endereco.setBairro(bairro);
			endereco.setCidade(cidade);
			endereco.setSigla(sigla);
			endereco.setCd(cd);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public PrestadorEntity getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorEntity prestador) {
		this.prestador = prestador;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

}
