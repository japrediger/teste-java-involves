package br.com.involves.teste.services.impl;

import br.com.involves.teste.persistence.beans.CidadeColumn;
import br.com.involves.teste.services.ConsoleCommandService;
import br.com.involves.teste.services.ConsoleCommandType;
import br.com.involves.teste.services.exception.ConsoleCommandException;
import br.com.involves.teste.services.exception.MessageCommand;

public class ConsoleCommandServiceImpl implements ConsoleCommandService {

	public ConsoleCommandType validateConsoleCommand(String command) throws ConsoleCommandException {
		
		if(command.trim().isEmpty()) {
			throw new ConsoleCommandException(MessageCommand.COMMAND_EMPTY);
		}
		
		if(command.trim().equals("count *")) {
			return ConsoleCommandType.COUNT_ALL;
		}
		else if(command.trim().contains("count distinct")) {
			
			// verifica se a coluna é valida
			String[] splitCommand = command.trim().split(" ");
			if(splitCommand.length == 3) {
				
				if( CidadeColumn.findByNome(splitCommand[2]) != null ) {
					return ConsoleCommandType.COUNT_DISTINCT_COLUMN;
				}
				else {
					throw new ConsoleCommandException(MessageCommand.PROPERTIE_INVALID);
				}
				
			}
			else {
				throw new ConsoleCommandException(MessageCommand.COMMAND_INVALID);
			}
			
		}
		else if(command.trim().contains("filter")) {
			
			// verifica se tem propriedade e valor
			String[] splitCommand = command.trim().split(" ");
			if(splitCommand.length == 3) {
				// verifica se a coluna é valida
				if( CidadeColumn.findByNome(splitCommand[1]) != null ) {
					return ConsoleCommandType.FILTER_COLUMN;
				}
				else {
					throw new ConsoleCommandException(MessageCommand.PROPERTIE_INVALID);
				}
				
			}
			else {
				throw new ConsoleCommandException(MessageCommand.COMMAND_INVALID);
			}
			
		}
		else {
			throw new ConsoleCommandException(MessageCommand.COMMAND_INVALID);
		}
		
		
	}

}
