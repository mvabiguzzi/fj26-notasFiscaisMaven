package br.com.mvabiguzzi.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.mvabiguzzi.notasfiscais.dao.UsuarioDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public String efetuaLogin() {
		UsuarioDao uDao = new UsuarioDao();
		
		boolean loginValido = uDao.existe(this.usuario);
		
		System.out.println("O Login era valido? "+loginValido);
		
		if(loginValido) {
			return "produto";
		} else {
			this.usuario = new Usuario();
			return "login";
		}
	}
}
