package br.com.mvabiguzzi.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mvabiguzzi.notasfiscais.dao.UsuarioDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Usuario;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDao uDao;
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public String efetuaLogin() {
		boolean loginValido = uDao.existe(this.usuario);
		
		System.out.println("O Login era valido? "+loginValido);
		
		if(loginValido) {
			return "produto?faces-redirect=true";
		} else {
			this.usuario = new Usuario();
			return "login";
		}
	}
	
}
