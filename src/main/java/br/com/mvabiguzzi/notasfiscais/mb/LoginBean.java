package br.com.mvabiguzzi.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.mvabiguzzi.notasfiscais.dao.UsuarioDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Usuario;

@ManagedBean
public class LoginBean {
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void efetuaLogin() {
		UsuarioDao uDao = new UsuarioDao();
		
		boolean loginValido = uDao.existe(this.usuario);
		
		System.out.println("O Login era valido? "+loginValido);
	}
}
