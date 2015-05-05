package br.com.mvabiguzzi.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.mvabiguzzi.notasfiscais.dao.NotaFiscalDao;
import br.com.mvabiguzzi.notasfiscais.modelo.NotaFiscal;
import br.com.mvabiguzzi.notasfiscais.util.ViewModel;

@ViewModel
public class ListaNotaFiscalBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private NotaFiscalDao nfDao;
	
	private List<NotaFiscal> notasFiscais;

	public List<NotaFiscal> getNotasFiscais() {
		if(this.notasFiscais == null) {
			System.out.println("Carregando notas fiscais");
			this.notasFiscais = this.nfDao.listaTodos();
		}
		
		return this.notasFiscais;
	}
	
}
