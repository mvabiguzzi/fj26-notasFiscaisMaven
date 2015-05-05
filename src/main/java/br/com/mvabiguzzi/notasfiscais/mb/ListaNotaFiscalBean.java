package br.com.mvabiguzzi.notasfiscais.mb;

import java.io.Serializable;

import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;

import br.com.mvabiguzzi.notasfiscais.modelo.NotaFiscal;
import br.com.mvabiguzzi.notasfiscais.util.ViewModel;

@ViewModel
public class ListaNotaFiscalBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LazyDataModel<NotaFiscal> dataModel;

	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}
	
}
