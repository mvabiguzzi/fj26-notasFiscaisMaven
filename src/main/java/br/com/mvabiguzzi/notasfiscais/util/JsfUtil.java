package br.com.mvabiguzzi.notasfiscais.util;

import java.util.ResourceBundle;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Model
public class JsfUtil {
	
	@Inject FacesContext context;
	
	public void addMessage(String key) {
		String bundleName = "br.com.mvabiguzzi.notasfiscais.mensagens.Resources";
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, context.getViewRoot().getLocale());
		String mensagem = bundle.getString(key);
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
	}
	
}
