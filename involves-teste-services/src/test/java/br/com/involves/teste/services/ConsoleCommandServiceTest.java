package br.com.involves.teste.services;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.teste.services.exception.ConsoleCommandException;
import br.com.involves.teste.services.exception.MessageCommand;
import br.com.involves.teste.services.impl.ConsoleCommandServiceImpl;

public class ConsoleCommandServiceTest {

	private ConsoleCommandService consoleCommandService = new ConsoleCommandServiceImpl();
	
	@Test
	public void validateCommandCountAll() {
		
		try {
			String command = "count *";
			ConsoleCommandType commandType = consoleCommandService.validateConsoleCommand(command);
			Assert.assertEquals(ConsoleCommandType.COUNT_ALL, commandType);
		}
		catch(ConsoleCommandException e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void validateCommandDistinctCountPropertie() {
		
		try {
			String command = "count distinct uf";
			ConsoleCommandType commandType = consoleCommandService.validateConsoleCommand(command);
			Assert.assertEquals(ConsoleCommandType.COUNT_DISTINCT_COLUMN, commandType);
		}
		catch(ConsoleCommandException e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void validateCommandFilter() {
		
		try {
			String command = "filter capital rs";
			ConsoleCommandType commandType = consoleCommandService.validateConsoleCommand(command);
			Assert.assertEquals(ConsoleCommandType.FILTER_COLUMN, commandType);
		}
		catch(ConsoleCommandException e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void validateCommandEmpty() {
		
		try {
			String command = "  ";
			consoleCommandService.validateConsoleCommand(command);
		}
		catch(ConsoleCommandException e) {
			Assert.assertEquals(MessageCommand.COMMAND_EMPTY.getValue(), e.getMessage());
		}
		
	}
	
	@Test
	public void validateCommandInvalid() {
		
		try {
			String command = "count * uf";
			consoleCommandService.validateConsoleCommand(command);
		}
		catch(ConsoleCommandException e) {
			Assert.assertEquals(MessageCommand.COMMAND_INVALID.getValue(), e.getMessage());
		}
		
	}
	
	@Test
	public void validatePropertieInvalid() {
		
		try {
			String command = "count distinct estado";
			consoleCommandService.validateConsoleCommand(command);
		}
		catch(ConsoleCommandException e) {
			Assert.assertEquals(MessageCommand.PROPERTIE_INVALID.getValue(), e.getMessage());
		}
		
	}
	
}
