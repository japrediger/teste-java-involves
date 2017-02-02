package br.com.involves.teste.services;


public interface CidadeService {

	/**
	 * Retorna a quantidade total de registros
	 * 
	 * @return
	 */
	public Integer countAll();
	
	/**
	 * Retorna o total de valores distintos conforme a propriedade passada
	 * 
	 * @return
	 */
	public Integer countDistinctColumn(String consoleCommand);
	
	/**
	 * Retorna os valores conforme filtro aplicado 
	 * 
	 * @param consoleCommand
	 * @return
	 */
	public StringBuilder filterByColumnValue(String consoleCommand);
	
}
