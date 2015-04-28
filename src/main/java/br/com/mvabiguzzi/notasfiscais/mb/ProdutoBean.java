package br.com.mvabiguzzi.notasfiscais.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mvabiguzzi.notasfiscais.dao.ProdutoDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Produto;

@Named @RequestScoped
public class ProdutoBean {
	
	@Inject ProdutoDao produtoDao;
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
	
	public void grava() {		
		if(this.produto.getId() == null) {
			produtoDao.adiciona(this.produto);
		} else {
			produtoDao.atualiza(this.produto);
		}
		
		this.produto = new Produto();
		this.produtos = produtoDao.listaTodos();
	}
	
	public void remove(Produto produto) {
		produtoDao.remove(produto);
		this.produtos = produtoDao.listaTodos();
	}
}