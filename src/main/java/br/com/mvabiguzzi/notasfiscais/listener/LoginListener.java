package br.com.mvabiguzzi.notasfiscais.listener;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.mvabiguzzi.notasfiscais.modelo.Usuario;
import br.com.mvabiguzzi.notasfiscais.util.EmailComercial;
import br.com.mvabiguzzi.notasfiscais.util.EmailFinanceiro;

public class LoginListener {
	@Inject @EmailComercial
	private String emailComercial;
	@Inject @EmailFinanceiro
	private String emailFinanceiro;
	
	public void onLogin(@Observes Usuario usuario) {
		System.out.printf("Usuario %s se logou no sistema.", usuario.getLogin());
		
		System.out.println("Envio de email para o comercial: "+emailComercial);
		System.out.println("Envio de email para o financeiro: "+emailFinanceiro);
	}
	
}
