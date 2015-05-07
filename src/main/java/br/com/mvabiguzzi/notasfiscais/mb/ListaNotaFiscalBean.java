package br.com.mvabiguzzi.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.chart.PieChartModel;

import br.com.mvabiguzzi.notasfiscais.dao.GraficoDao;
import br.com.mvabiguzzi.notasfiscais.modelo.NotaFiscal;
import br.com.mvabiguzzi.notasfiscais.modelo.QuantidadePorProduto;
import br.com.mvabiguzzi.notasfiscais.util.ViewModel;

@ViewModel
public class ListaNotaFiscalBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject private GraficoDao graficoDao;
	
	@Inject
	private LazyDataModel<NotaFiscal> dataModel;
	
	public PieChartModel getRelatorioQuantidadeVendidaProduto() {
		List<QuantidadePorProduto> lista = graficoDao.relatorioQuantidadePorProduto();
		
		PieChartModel model = new PieChartModel();
		
		for(QuantidadePorProduto qtde : lista) {
			model.set(qtde.getProduto().getNome(), qtde.getQuantidade());
			model.setTitle("Quantidade Vendida por Produto");
			model.setLegendPosition("w");
		}
		
		return model;
	}
	
	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}
	
}
