package br.com.involves.teste.csv;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

import br.com.involves.teste.persistence.beans.Cidade;

public class FileCsvUtils {

	public Collection<Cidade> loadCsvFileCidade() throws Exception {
		
		Collection<Cidade> collection = new HashSet<Cidade>();
		
		Scanner scan = null;
		try {
			scan = new Scanner( ClassLoader.getSystemResourceAsStream("cidades.csv") );
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
			
			return collection;
			
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			try {
				scan.close();
			}
			catch(Exception e){}
		}
		
	}
	
}
