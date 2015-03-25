package br.com.mvabiguzzi.notasfiscais.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class NavigationHandlerFactory {
	@Inject
	private FacesContext context;
	
	@Produces @RequestScoped
	public NavigationHandler getNavidationHandler() {
		return context.getApplication().getNavigationHandler();
	}
	
}
