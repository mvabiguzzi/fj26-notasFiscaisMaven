package br.com.mvabiguzzi.notasfiscais.mb;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.mvabiguzzi.notasfiscais.dao.NotaFiscalDao;
import br.com.mvabiguzzi.notasfiscais.dao.ProdutoDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Item;
import br.com.mvabiguzzi.notasfiscais.modelo.NotaFiscal;
import br.com.mvabiguzzi.notasfiscais.modelo.Produto;
import br.com.mvabiguzzi.notasfiscais.tx.Transactional;
import br.com.mvabiguzzi.notasfiscais.util.ViewModel;

@ViewModel
public class NotaFiscalBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject private NotaFiscalDao notaFiscalDao;
	@Inject private ProdutoDao produtoDao;
	
	private NotaFiscal notaFiscal = new NotaFiscal();
	private Item item = new Item();
	private Long idProduto;
	
	@Transactional
	public void grava() {
		notaFiscalDao.adiciona(notaFiscal);
		
		notaFiscal = new NotaFiscal();
	}
	
	public void guardaItem() {
		Produto produto = produtoDao.buscaPorId(idProduto);
		
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		
		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		
		item = new Item();
	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	
}
