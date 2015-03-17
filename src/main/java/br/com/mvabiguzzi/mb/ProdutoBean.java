package br.com.mvabiguzzi.mb;

import javax.faces.bean.ManagedBean;

import br.com.mvabiguzzi.notasfiscais.dao.ProdutoDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}
	
	public void grava() {
		ProdutoDao pDao = new ProdutoDao();
		pDao.adiciona(produto);
		this.produto = new Produto();
	}
}
