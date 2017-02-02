package br.com.involves.teste.services.exception;

public enum MessageCommand {

	COMMAND_EMPTY("Comando nao informado"), 
	
	PROPERTIE_INVALID("Propriedade invalida"), 
	
	COMMAND_INVALID("Comando invalido"), 
	
	REGISTERS_EMPTY("Nenhum registro encontrado");
	
	String value;
	
	MessageCommand(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static MessageCommand findByNome(String value) {
        for (MessageCommand c : values()) {
            if (c.getValue().equals(value)) {
                return c;
            }
        }
        return null;
    }
	
}
