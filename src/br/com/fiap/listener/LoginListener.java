package br.com.fiap.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class LoginListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		FacesContext context = arg0.getFacesContext();
		
		//Recuperar a página que o usuário vai acessar
		String pagina = context.getViewRoot().getViewId();
		
		//Validar se o usuário está indo para a tela de 
		//cadastro de usuario
		if (pagina.contains("cadastro_cliente")) return;
		
		//Recuperar a sessão do usuário
		HttpSession sessao = (HttpSession) context
					.getExternalContext().getSession(false);
		
		//Verifica se o usuário possui sessão 
		if (sessao == null || sessao.getAttribute("user") == null ){
			//Redirecionar para o login
			NavigationHandler navegacao = context
						.getApplication().getNavigationHandler();
			navegacao.handleNavigation(context, null, "login");
		}
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
