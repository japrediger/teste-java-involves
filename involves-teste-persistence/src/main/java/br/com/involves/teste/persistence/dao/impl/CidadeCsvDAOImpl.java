package br.com.involves.teste.persistence.dao.impl;

import java.util.Collection;
import java.util.HashSet;

import br.com.involves.teste.persistence.beans.Cidade;
import br.com.involves.teste.persistence.beans.CidadeColumn;
import br.com.involves.teste.persistence.connection.csv.ConnectionCsvFactory;
import br.com.involves.teste.persistence.dao.CidadeDAO;
import br.com.involves.teste.persistence.filters.Filter;
import br.com.involves.teste.persistence.filters.FilterUtils;

public class CidadeCsvDAOImpl implements CidadeDAO {

	public Integer countAll() {
		return ConnectionCsvFactory.getCollectionCsv().size();
	}

	@SuppressWarnings("unchecked")
	public Collection<Cidade> filterByColumnValue(CidadeColumn column, final String value) {
		
		Collection<Cidade> collectionFilter = null;
		
		if(column == CidadeColumn.IBGE_ID) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getIbgeId().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.NAME) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getName().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.UF) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getUf().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.NAME) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getName().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.CAPITAL) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getCapital().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.LONGITUDE) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getLongitude().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.LATITUDE) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getLatitude().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.NO_ACCENTS) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getNoAssents().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.ALTERNATIVE_NAMES) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getAlternativeNames().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.MICROREGION) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getMicroregion().equals(value);
				}
			});
			
		}
		else if(column == CidadeColumn.MESOREGION) {
			
			collectionFilter = FilterUtils.filter(ConnectionCsvFactory.getCollectionCsv(), new Filter<Cidade>() {
				public Boolean accept(Cidade obj) {
					return obj.getMesoregion().equals(value);
				}
			});
			
		}
		
		
		return collectionFilter;
		
	}

	public Integer countDistinctColumn(CidadeColumn column) {
		
		// Verifica o filtro
		if(CidadeColumn.IBGE_ID == column) {
			return countDistinctIbgeId();
		}
		else if(CidadeColumn.UF == column) {
			return countDistinctUf();
		}
		else if(CidadeColumn.NAME == column) {
			return countDistinctName();
		}
		else if(CidadeColumn.CAPITAL == column) {
			return countDistinctCapital();
		}
		else if(CidadeColumn.LONGITUDE == column) {
			return countDistinctLong();
		}
		else if(CidadeColumn.LATITUDE == column) {
			return countDistinctLat();
		}
		else if(CidadeColumn.NO_ACCENTS == column) {
			return countDistinctNoAssents();
		}
		else if(CidadeColumn.ALTERNATIVE_NAMES == column) {
			return countDistinctAlternativeNames();
		}
		else if(CidadeColumn.MICROREGION == column) {
			return countDistinctMicroregion();
		}
		else if(CidadeColumn.MESOREGION == column) {
			return countDistinctMesoregion();
		}
		else {
			return 0;
		}
		
	}

	private Integer countDistinctIbgeId() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getIbgeId())) {
				collectionDistinct.add(cid.getIbgeId());
			}
		}
		
		return collectionDistinct.size();
	}
	
	
	private Integer countDistinctUf() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getUf())) {
				collectionDistinct.add(cid.getUf());
			}
		}
		
		return collectionDistinct.size();
	}

	
	private Integer countDistinctCapital() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getCapital())) {
				collectionDistinct.add(cid.getCapital());
			}
		}
		
		return collectionDistinct.size();
	}

	
	private Integer countDistinctLong() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getLongitude())) {
				collectionDistinct.add(cid.getLongitude());
			}
		}
		
		return collectionDistinct.size();
	}

	
	private Integer countDistinctLat() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getLatitude())) {
				collectionDistinct.add(cid.getLatitude());
			}
		}
		
		return collectionDistinct.size();
	}

	
	private Integer countDistinctNoAssents() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getNoAssents())) {
				collectionDistinct.add(cid.getNoAssents());
			}
		}
		
		return collectionDistinct.size();
	}

	
	private Integer countDistinctAlternativeNames() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getAlternativeNames())) {
				collectionDistinct.add(cid.getAlternativeNames());
			}
		}
		
		return collectionDistinct.size();
	}

	
	private Integer countDistinctMicroregion() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getMicroregion())) {
				collectionDistinct.add(cid.getMicroregion());
			}
		}
		
		return collectionDistinct.size();
	}
	
	
	private Integer countDistinctName() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getName())) {
				collectionDistinct.add(cid.getName());
			}
		}
		
		return collectionDistinct.size();
	}

	
	private Integer countDistinctMesoregion() {
		Collection<String> collectionDistinct = new HashSet<String>();
		
		for(Cidade cid : ConnectionCsvFactory.getCollectionCsv()) {
			if(!collectionDistinct.contains(cid.getMesoregion())) {
				collectionDistinct.add(cid.getMesoregion());
			}
		}
		
		return collectionDistinct.size();
	}
	
	

}
