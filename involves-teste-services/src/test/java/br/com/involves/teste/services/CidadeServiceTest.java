package br.com.involves.teste.services;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.involves.teste.persistence.beans.Cidade;
import br.com.involves.teste.persistence.beans.CidadeColumn;
import br.com.involves.teste.persistence.dao.CidadeDAO;
import br.com.involves.teste.services.impl.CidadeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CidadeServiceTest {

	private CidadeServiceImpl cidadeService;
	
	@Mock
	private CidadeDAO cidadeDAO;
	
	@Before
    public void init(){
        cidadeService = new CidadeServiceImpl();
        cidadeService.setDao(cidadeDAO);
    }
	
	@Test
	public void countALL() {
		
		Integer countValueExpected = 10;
		Mockito.when(cidadeDAO.countAll()).thenReturn(countValueExpected);
		Assert.assertEquals(countValueExpected, cidadeService.countAll());
			
	}
	
	@Test
	public void countDistincColumn() {
		
		Integer countValueExpected = 5;
		Mockito.when(cidadeDAO.countDistinctColumn(CidadeColumn.IBGE_ID)).thenReturn(countValueExpected);
		Integer countValue = cidadeService.countDistinctColumn("count distinct "+CidadeColumn.IBGE_ID.getValue());
		Assert.assertEquals(countValueExpected, countValue);
		
	}
	
	
	@Test
	public void filterByColumnValue() {
	
		Collection<Cidade> collectionExpected = new HashSet<Cidade>();
		Cidade cidade = new Cidade();
		cidade.setIbgeId("1505106");
		cidade.setUf("PA");
		cidade.setAlternativeNames("Alta Floresta D'Oeste");
		cidade.setCapital("true");
		cidade.setLatitude("-63.033269278");
		cidade.setLongitude("-13.4997634597");
		cidade.setMesoregion("Leste Rondoniense");
		cidade.setMicroregion("Colorado do Oeste");
		cidade.setName("Ariquemes");
		cidade.setNoAssents("Vilhena");
		collectionExpected.add(cidade);
		
		Mockito.when(cidadeDAO.filterByColumnValue(CidadeColumn.UF, cidade.getUf())).thenReturn(collectionExpected);
		Assert.assertNotNull( cidadeService.filterByColumnValue("filter uf "+cidade.getUf()) );
		
	}
	
}
