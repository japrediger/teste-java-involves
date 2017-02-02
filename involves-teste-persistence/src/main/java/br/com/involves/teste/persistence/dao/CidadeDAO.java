package br.com.involves.teste.persistence.dao;

import java.util.Collection;

import br.com.involves.teste.persistence.beans.Cidade;
import br.com.involves.teste.persistence.beans.CidadeColumn;

public interface CidadeDAO {

	/**
	 * Retorna a quantidade total de registros
	 * 
	 * @return
	 */
	public Integer countAll();
	
	/**
	 * Retorna a quantidade de registros distintos para determinada coluna
	 * 
	 * @param column
	 * @return
	 */
	public Integer countDistinctColumn(CidadeColumn column);
	
	/**
	 * Retorna todos os registros conforme o filtro e o valor passado
	 * 
	 * @param column
	 * @return
	 */
	public Collection<Cidade> filterByColumnValue(CidadeColumn column, String value);
	
	
}
