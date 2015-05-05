package br.com.mvabiguzzi.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.mvabiguzzi.notasfiscais.dao.NotaFiscalDao;
import br.com.mvabiguzzi.notasfiscais.modelo.NotaFiscal;

public class DataModelNotasFiscais extends LazyDataModel<NotaFiscal> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject private NotaFiscalDao nfDao;
	
	@PostConstruct
	private void inicializaTotal() {
		this.setRowCount(nfDao.contaTodos());
	}
	
	@Override
	public List<NotaFiscal> load(int inicio, int quantidade, String campoOrdenacao, SortOrder sentidoOrdenacao, Map<String,Object> filtros) {
		return nfDao.listaTodosPaginada(inicio, quantidade);
	}
	
}
