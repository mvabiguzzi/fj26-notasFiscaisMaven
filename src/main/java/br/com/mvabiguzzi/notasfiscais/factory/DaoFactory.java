package br.com.mvabiguzzi.notasfiscais.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import br.com.mvabiguzzi.notasfiscais.dao.Dao;

public class DaoFactory {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Produces
	public Dao createDao(InjectionPoint injectionPoint) {
		ParameterizedType type = (ParameterizedType) injectionPoint.getType();
		Class classe = (Class) type.getActualTypeArguments()[0];
		
		return new Dao(classe);
	}
	
}