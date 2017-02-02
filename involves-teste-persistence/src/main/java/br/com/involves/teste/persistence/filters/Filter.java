package br.com.involves.teste.persistence.filters;

public interface Filter<T> {
	
	public Boolean accept(T obj);

}
