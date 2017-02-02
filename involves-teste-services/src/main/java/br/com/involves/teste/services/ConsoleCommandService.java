package br.com.involves.teste.services;

import br.com.involves.teste.services.exception.ConsoleCommandException;

public interface ConsoleCommandService {

	/**
	 * Realiza a validação do comando informado 
	 * 
	 * @param command
	 * @return
	 * @throws ConsoleCommandException
	 */
	public ConsoleCommandType validateConsoleCommand(String command) throws ConsoleCommandException;
	
}
