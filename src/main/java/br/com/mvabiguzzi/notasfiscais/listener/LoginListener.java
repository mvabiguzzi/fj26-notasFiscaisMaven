package br.com.mvabiguzzi.notasfiscais.listener;

import javax.enterprise.event.Observes;

import br.com.mvabiguzzi.notasfiscais.modelo.Usuario;

public class LoginListener {
	
	public void onLogin(@Observes Usuario usuario) {
		System.out.printf("Usuario %s se logou no sistema.", usuario.getLogin());
	}
	
}
