package br.com.mvabiguzzi.notasfiscais.factory;

import javax.enterprise.inject.Produces;

import br.com.mvabiguzzi.notasfiscais.util.EmailComercial;
import br.com.mvabiguzzi.notasfiscais.util.EmailFinanceiro;

public class EmailFactory {
	
	@Produces @EmailComercial
	private String emailComercial = "comercial@uberdist.com.br";
	@Produces @EmailFinanceiro
	private String emailFinanceiro = "financeiro@uberdist.com.br";
	
}
