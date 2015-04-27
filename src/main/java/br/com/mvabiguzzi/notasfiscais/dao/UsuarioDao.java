package br.com.mvabiguzzi.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.mvabiguzzi.notasfiscais.modelo.Usuario;

public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@Inject
	private EntityManager manager;
	
	@Inject
	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public boolean existe(Usuario usuario) {
		
		Query query = manager.createQuery("select u from Usuario u where u.login = :pLogin and u.senha = :pSenha")
						.setParameter("pLogin", usuario.getLogin())
						.setParameter("pSenha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();

		return encontrado;
	}
	
	public List<Usuario> listaTodos() {
		CriteriaQuery<Usuario> query = manager.getCriteriaBuilder().createQuery(Usuario.class);
		query.select(query.from(Usuario.class));
		
		List<Usuario> lista = manager.createQuery(query).getResultList();
		
		return lista;
	}
	
	public void adiciona(Usuario usuario) {
		manager.getTransaction().begin();
		
		manager.persist(usuario);
		
		manager.getTransaction().commit();
	}
	
	public void atualiza(Usuario usuario) {
		manager.getTransaction().begin();
		
		manager.merge(usuario);
		
		manager.getTransaction().commit();
	}
	
	public void remove(Usuario usuario) {
		manager.getTransaction().begin();
		
		manager.remove(manager.merge(usuario));
		
		manager.getTransaction().commit();
	}
}