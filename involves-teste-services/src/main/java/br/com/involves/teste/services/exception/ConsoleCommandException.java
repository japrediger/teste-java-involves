package br.com.involves.teste.services.exception;

public class ConsoleCommandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8399388556937313608L;

	public ConsoleCommandException(MessageCommand message) {
		super(message.getValue());
	}
	
}
