package br.com.mvabiguzzi.notasfiscais.mb;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.mvabiguzzi.notasfiscais.dao.UsuarioDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Usuario;
import br.com.mvabiguzzi.notasfiscais.tx.Transactional;

@Model
public class UsuarioBean {
	@Inject UsuarioDao usuarioDao;
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		if(usuarios == null) {
			System.out.println("Carregando usuários...");
			usuarios = usuarioDao.listaTodos();
		}
		
		return usuarios;
	}
	
	@Transactional
	public void grava() {
		if(usuario.getId() == null) {
			usuarioDao.adiciona(usuario);
		} else {
			usuarioDao.atualiza(usuario);
		}
		
		usuario = new Usuario();
		usuarios = usuarioDao.listaTodos();
	}
	
	@Transactional
	public void remove(Usuario usuario) {
		usuarioDao.remove(usuario);
		usuarios = usuarioDao.listaTodos();
	}
	
}
