package br.com.involves.teste.persistence.beans;

public enum CidadeColumn {

	IBGE_ID("ibge_id"), 
	
	UF("uf"), 
	
	NAME("name"), 
	
	CAPITAL("capital"), 
	
	LONGITUDE("lon"), 
	
	LATITUDE("lat"),
	
	NO_ACCENTS("no_accents"), 
	
	ALTERNATIVE_NAMES("alternative_names"), 
	
	MICROREGION("microregion"), 
	
	MESOREGION("mesoregion");
	
	String value;
	
	CidadeColumn(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static CidadeColumn findByNome(String value) {
        for (CidadeColumn c : values()) {
            if (c.getValue().equals(value)) {
                return c;
            }
        }
        return null;
    }
	
}
