package br.com.mvabiguzzi.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;

import br.com.mvabiguzzi.notasfiscais.dao.ProdutoDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Produto;
import br.com.mvabiguzzi.notasfiscais.tx.Transactional;
import br.com.mvabiguzzi.notasfiscais.util.ViewModel;

@ViewModel
public class ProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoDao produtoDao;
	/*@Inject
	private Dao<Produto> dao;*/
	private Produto produto = new Produto();
	private List<Produto> produtos;
	@Inject
	private LazyDataModel<Produto> dataModelProdutos;
	
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
	
	public LazyDataModel<Produto> getDataModelProdutos() {
		return dataModelProdutos;
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
		System.out.println("Removendo produto "+produto.getNome());
		produtoDao.remove(produto);
		this.produtos = produtoDao.listaTodos();
	}
	
}