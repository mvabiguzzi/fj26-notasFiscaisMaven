package br.com.mvabiguzzi.notasfiscais.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mvabiguzzi.notasfiscais.dao.UsuarioDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Usuario;

@Named @RequestScoped
public class LoginBean {
	
	@Inject
	private UsuarioDao uDao;
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public String efetuaLogin() {
		boolean loginValido = uDao.existe(this.usuario);
		
		System.out.println("O Login era valido? "+loginValido);
		
		if(loginValido) {
			usuarioLogado.logar(usuario);
			return "produto?faces-redirect=true";
		} else {
			usuarioLogado.deslogar();
			this.usuario = new Usuario();
			return "login";
		}
	}
	
}
