package br.com.mvabiguzzi.notasfiscais.mb;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.mvabiguzzi.notasfiscais.dao.Dao;
import br.com.mvabiguzzi.notasfiscais.dao.ProdutoDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Produto;
import br.com.mvabiguzzi.notasfiscais.tx.Transactional;

@Model
public class ProdutoBean {
	
	@Inject
	private ProdutoDao produtoDao;
	/*@Inject
	private Dao<Produto> dao;*/
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Produto getProduto() {
		return this.produto;
	}
	
	public List<Produto> getProdutos() {
		if(this.produtos == null) {
			System.out.println("Carregando produtos...");
			this.produtos = produtoDao.listaTodos();
		}
		
		return this.produtos;
	}
	
	@Transactional
	public void grava() {		
		if(this.produto.getId() == null) {
			produtoDao.adiciona(this.produto);
		} else {
			produtoDao.atualiza(this.produto);
		}
		
		this.produto = new Produto();
		this.produtos = produtoDao.listaTodos();
	}
	
	@Transactional
	public void remove(Produto produto) {
		produtoDao.remove(produto);
		this.produtos = produtoDao.listaTodos();
	}
}