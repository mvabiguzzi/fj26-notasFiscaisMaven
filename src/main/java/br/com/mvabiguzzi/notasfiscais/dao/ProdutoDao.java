package br.com.mvabiguzzi.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.mvabiguzzi.notasfiscais.modelo.Produto;

public class ProdutoDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public ProdutoDao(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Produto produto) {
		//manager.getTransaction().begin();

		//persiste o objeto
		manager.persist(produto);
		
		//manager.getTransaction().commit();
	}


	public void remove(Produto produto) {
		//manager.getTransaction().begin();

		manager.remove(manager.merge(produto));

		//manager.getTransaction().commit();
	}

	public void atualiza(Produto produto) {
		//manager.getTransaction().begin();

		manager.merge(produto);
		
		//manager.getTransaction().commit();
	}

	public List<Produto> buscaPorNome(String nome) {
		String jpql = "select p from Produto p where "
				+ " lower(p.nome) like :nome order by p.nome";

		List<Produto> lista = manager.createQuery(jpql, Produto.class)
				.setParameter("nome", nome + "%").getResultList();
		
		return lista; 
	}

	public List<Produto> listaTodos() {
		CriteriaQuery<Produto> query = manager.getCriteriaBuilder().createQuery(Produto.class);
		query.select(query.from(Produto.class));
		
		List<Produto> lista = manager.createQuery(query).getResultList();
		
		return lista; 
	}
	
	public int contaTodos() {
		long result = (Long) manager.createQuery("select count(p) from Produto p").getSingleResult();
		
		return (int) result;
	}
	
	public List<Produto> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<Produto> query = manager.getCriteriaBuilder().createQuery(Produto.class);
		query.select(query.from(Produto.class));
		
		return manager.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}
	
	public Produto buscaPorId(Long id) {
		Produto produto = manager.find(Produto.class, id);
		
		return produto;
	}
}