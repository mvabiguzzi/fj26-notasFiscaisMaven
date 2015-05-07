package br.com.mvabiguzzi.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.mvabiguzzi.notasfiscais.dao.ProdutoDao;
import br.com.mvabiguzzi.notasfiscais.modelo.Produto;

public class DataModelProdutos extends LazyDataModel<Produto> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoDao produtoDao;
	
	@PostConstruct
	private void inicializaTotal() {
		this.setRowCount(produtoDao.contaTodos());
	}

	@Override
	public List<Produto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		return produtoDao.listaTodosPaginada(first, pageSize);
	}
}
