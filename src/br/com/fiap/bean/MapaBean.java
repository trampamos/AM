package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@RequestScoped
public class MapaBean {

	//Marcações para o Mapa
	private MapModel marcacoes;
	
	private String endereco;
	
	@PostConstruct
	private void init(){
		marcacoes = new DefaultMapModel();
		LatLng posicao = new LatLng(-23.538694, -46.479888);
		marcacoes.addOverlay(new Marker(posicao,"Corintia"));
	}

	public MapModel getMarcacoes() {
		return marcacoes;
	}

	public void setMarcacoes(MapModel marcacoes) {
		this.marcacoes = marcacoes;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
