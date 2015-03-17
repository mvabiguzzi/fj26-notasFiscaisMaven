package br.com.mvabiguzzi.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.mvabiguzzi.notasfiscais.dao.ProdutoDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;

	public Produto getProduto() {
		return this.produto;
	}
	
	public List<Produto> getProdutos() {
		if(this.produtos == null) {
			System.out.println("Carregando produtos...");
			this.produtos = new ProdutoDao().listaTodos();
		}
		
		return this.produtos;
	}
	
	public void grava() {
		ProdutoDao pDao = new ProdutoDao();
		pDao.adiciona(this.produto);
		this.produto = new Produto();
		this.produtos = pDao.listaTodos();
	}
	
	public void remove(Produto produto) {
		ProdutoDao pDao = new ProdutoDao();
		pDao.remove(produto);
		this.produtos = pDao.listaTodos();
	}
}
