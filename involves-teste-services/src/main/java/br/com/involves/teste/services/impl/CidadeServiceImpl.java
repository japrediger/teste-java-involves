package br.com.involves.teste.services.impl;

import java.util.Collection;

import br.com.involves.teste.persistence.beans.Cidade;
import br.com.involves.teste.persistence.beans.CidadeColumn;
import br.com.involves.teste.persistence.dao.CidadeDAO;
import br.com.involves.teste.persistence.dao.impl.CidadeCsvDAOImpl;
import br.com.involves.teste.services.CidadeService;
import br.com.involves.teste.services.exception.MessageCommand;

public class CidadeServiceImpl implements CidadeService {

	private CidadeDAO dao = new CidadeCsvDAOImpl();
	
	private static String LINE_DELIMITER = ",";
	private static String LINE_BREAK = "\n";
	
	public Integer countAll() {
		return dao.countAll();
	}

	
	public Integer countDistinctColumn(String consoleCommand) {
		
		// recupera a propriedade e o valor
		String[] propertieValue = consoleCommand.split(" ");
			
		CidadeColumn column = CidadeColumn.findByNome(propertieValue[2]);
		
		return dao.countDistinctColumn(column);
		
	}

	public StringBuilder filterByColumnValue(String consoleCommand) {
		
		// recupera a propriedade e o valor
		String[] propertieColumnValue = consoleCommand.split(" ");
			
		CidadeColumn column = CidadeColumn.findByNome(propertieColumnValue[1]);
		String value = propertieColumnValue[2];
		
		// Realiza o filtro
		Collection<Cidade> collectionCidade = dao.filterByColumnValue(column, value);
		
		if(collectionCidade!=null && collectionCidade.size()>0) {
			
			// Monta o retorno a ser apresentado
			StringBuilder strReturn = new StringBuilder();
			// monta o cabeçalho
			strReturn.append(CidadeColumn.IBGE_ID.getValue());
			strReturn.append(LINE_DELIMITER);
			strReturn.append(CidadeColumn.UF.getValue());
			strReturn.append(LINE_DELIMITER);
			strReturn.append(CidadeColumn.NAME.getValue());
			strReturn.append(LINE_DELIMITER);
			strReturn.append(CidadeColumn.CAPITAL.getValue());
			strReturn.append(LINE_DELIMITER);
			strReturn.append(CidadeColumn.LONGITUDE.getValue());
			strReturn.append(LINE_DELIMITER);
			strReturn.append(CidadeColumn.LATITUDE.getValue());
			strReturn.append(LINE_DELIMITER);
			strReturn.append(CidadeColumn.NO_ACCENTS.getValue());
			strReturn.append(LINE_DELIMITER);
			strReturn.append(CidadeColumn.ALTERNATIVE_NAMES.getValue());
			strReturn.append(LINE_DELIMITER);
			strReturn.append(CidadeColumn.MICROREGION.getValue());
			strReturn.append(LINE_DELIMITER);
			strReturn.append(CidadeColumn.MESOREGION.getValue());
			strReturn.append(LINE_BREAK);
			
			
			for(Cidade cidade : collectionCidade) {
				strReturn.append(cidade.getIbgeId());
				strReturn.append(LINE_DELIMITER);
				strReturn.append(cidade.getUf());
				strReturn.append(LINE_DELIMITER);
				strReturn.append(cidade.getName());
				strReturn.append(LINE_DELIMITER);
				strReturn.append(cidade.getCapital());
				strReturn.append(LINE_DELIMITER);
				strReturn.append(cidade.getLongitude());
				strReturn.append(LINE_DELIMITER);
				strReturn.append(cidade.getLatitude());
				strReturn.append(LINE_DELIMITER);
				strReturn.append(cidade.getNoAssents());
				strReturn.append(LINE_DELIMITER);
				strReturn.append(cidade.getAlternativeNames());
				strReturn.append(LINE_DELIMITER);
				strReturn.append(cidade.getMicroregion());
				strReturn.append(LINE_DELIMITER);
				strReturn.append(cidade.getMesoregion());
				strReturn.append(LINE_BREAK);
			}
			
			return strReturn;
		}
		else {
			// Monta o retorno a ser apresentado
			StringBuilder strReturn = new StringBuilder();
			strReturn.append(MessageCommand.REGISTERS_EMPTY.getValue());
			return strReturn;
		}
		
	}


	public void setDao(CidadeDAO dao) {
		this.dao = dao;
	}
	
	
}
