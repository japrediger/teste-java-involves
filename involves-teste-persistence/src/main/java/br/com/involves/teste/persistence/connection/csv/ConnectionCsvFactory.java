package br.com.involves.teste.persistence.connection.csv;

import java.util.Collection;

import br.com.involves.teste.persistence.beans.Cidade;

public class ConnectionCsvFactory {

	private static Collection<Cidade> collectionCsv;

	public static Collection<Cidade> getCollectionCsv() {
		return collectionCsv;
	}

	public static void setCollectionCsv(Collection<Cidade> collectionCsv) {
		ConnectionCsvFactory.collectionCsv = collectionCsv;
	}
	
	
}
