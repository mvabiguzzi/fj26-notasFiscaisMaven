package br.com.mvabiguzzi.notasfiscais.mb;

import java.util.Locale;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Model
public class InternacionalizacaoBean {
	
	@Inject
	private FacesContext context;
	
	public void mudaPara(String idioma) {
		Locale locale = new Locale(idioma);
		context.getViewRoot().setLocale(locale); //altera o idioma para a pagina atual
		context.getApplication().setDefaultLocale(locale); //altera o idioma para a aplicação inteira
	}
	
}
