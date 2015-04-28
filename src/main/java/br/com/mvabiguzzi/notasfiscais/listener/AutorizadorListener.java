package br.com.mvabiguzzi.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.mvabiguzzi.notasfiscais.mb.UsuarioLogadoBean;

public class AutorizadorListener implements PhaseListener {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	private FacesContext context;
	
	@Inject
	private NavigationHandler handler;

	@Override
	public void afterPhase(PhaseEvent event) {
		if("/login.xhtml".equals(context.getViewRoot().getViewId()) || "/index.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		if(!usuarioLogado.isLogado()) {
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
	}
	
	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
}
