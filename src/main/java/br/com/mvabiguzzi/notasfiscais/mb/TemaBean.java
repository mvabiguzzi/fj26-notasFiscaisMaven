package br.com.mvabiguzzi.notasfiscais.mb;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named @SessionScoped
public class TemaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> temas;
	private String tema = "aristo";
	
	public TemaBean() {
		temas = new TreeMap<String, String> ();
		
		temas.put("Aristo", "aristo");
		temas.put("Cruze", "cruze");
	}

	public Map<String, String> getTemas() {
		return temas;
	}

	public void setTemas(Map<String, String> temas) {
		this.temas = temas;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
}
