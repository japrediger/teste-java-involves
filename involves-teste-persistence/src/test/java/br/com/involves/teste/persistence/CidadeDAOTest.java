package br.com.involves.teste.persistence;

import java.io.FileInputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.involves.teste.persistence.beans.Cidade;
import br.com.involves.teste.persistence.beans.CidadeColumn;
import br.com.involves.teste.persistence.connection.csv.ConnectionCsvFactory;
import br.com.involves.teste.persistence.dao.CidadeDAO;
import br.com.involves.teste.persistence.dao.impl.CidadeCsvDAOImpl;

public class CidadeDAOTest {

	private CidadeDAO cidadeDAO = new CidadeCsvDAOImpl();
	private Integer sizeFile = 63;
	
	@Before
	public void loadFileCsv() {
		
		Collection<Cidade> collection = new HashSet<Cidade>();
		FileInputStream input = null;
		Scanner scan = null;
		try {
			input = new FileInputStream( "src/main/resources/cidades_test.csv" );
			scan = new Scanner( input );
			
			// le o cabeçalho
			scan.nextLine();
			while(scan.hasNext()) {
				String[] cidade = scan.nextLine().split("\\,");
				Cidade cid = new Cidade();
				cid.setIbgeId(cidade[0].trim());
				cid.setUf(cidade[1].trim());
				cid.setName(cidade[2].trim());
				cid.setCapital(cidade[3].trim().isEmpty()?"false":cidade[3].trim());
				cid.setLongitude(cidade[4].trim());
				cid.setLatitude(cidade[5].trim());
				cid.setNoAssents(cidade[6].trim());
				cid.setAlternativeNames(cidade[7].trim());
				cid.setMicroregion(cidade[8].trim());
				cid.setMesoregion(cidade[9].trim());
				collection.add(cid);	
			}
			
			ConnectionCsvFactory.setCollectionCsv(collection);
			
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		finally {
			try {
				scan.close();
			}
			catch(Exception e){}
			try {
				input.close();
			}
			catch(Exception e){}
		}
		
	}
	
	@Test
	public void countAllTest() {
		Assert.assertEquals(sizeFile, cidadeDAO.countAll());
	}
	
	@Test
	public void countDistinctColumnTest() {
		Assert.assertEquals(new Integer(7), cidadeDAO.countDistinctColumn(CidadeColumn.UF));
	}
	
	@Test
	public void filterByColumnValueUf() {
		Collection<Cidade> collectionReturn = cidadeDAO.filterByColumnValue(CidadeColumn.UF, "SC");
		Assert.assertEquals(17, collectionReturn.size());
	}
	
	@Test
	public void filterByColumnValueMesoregion() {
		Collection<Cidade> collectionReturn = cidadeDAO.filterByColumnValue(CidadeColumn.MESOREGION, "Leste Rondoniense");
		Assert.assertEquals(7, collectionReturn.size());
	}
	
}
