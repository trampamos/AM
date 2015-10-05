package br.com.fiap.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoBO {


	private List<Servico> lista;
	
	
	public List<Servico> listar(){

		lista = new ArrayList<Servico>();
		try{

			//
			//Abre a conexao com o SGBDR
			//
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "OPS$RM71552", "fiap");

			PreparedStatement servicoLista = conn.prepareStatement("select * from HRL_SERVICO");
			ResultSet rst = servicoLista.executeQuery();
			while (rst.next()) {
				Servico servico = new Servico();

				servico.setCdSevico(rst.getInt("CD_SERVICO"));
				servico.setDsServico(rst.getString("DS_SERVICO"));
				
				lista.add(servico);
			}

			conn.close();
			
		}
		catch (SQLException e) {

			e.printStackTrace();

		}
		return lista;
	}
	
	
	

}

