package br.com.mvabiguzzi.notasfiscais.mb;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.mvabiguzzi.notasfiscais.dao.UsuarioDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Usuario;

@Model
public class LoginBean {
	
	@Inject
	private UsuarioDao uDao;
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	private Event<Usuario> eventoLogin;
	
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public String efetuaLogin() {
		boolean loginValido = uDao.existe(this.usuario);
		
		System.out.println("O Login era valido? "+loginValido);
		
		if(loginValido) {
			usuarioLogado.logar(usuario);
			eventoLogin.fire(usuario);
			return "produto?faces-redirect=true";
		} else {
			usuarioLogado.deslogar();
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public String logout() {
		usuarioLogado.deslogar();
		
		return "login?faces-redirect=true";
	}
	
}
