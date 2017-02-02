package br.com.involves.teste;

import java.util.Scanner;

import br.com.involves.teste.csv.FileCsvUtils;
import br.com.involves.teste.persistence.connection.csv.ConnectionCsvFactory;
import br.com.involves.teste.services.CidadeService;
import br.com.involves.teste.services.ConsoleCommandService;
import br.com.involves.teste.services.ConsoleCommandType;
import br.com.involves.teste.services.exception.ConsoleCommandException;
import br.com.involves.teste.services.exception.MessageCommand;
import br.com.involves.teste.services.impl.CidadeServiceImpl;
import br.com.involves.teste.services.impl.ConsoleCommandServiceImpl;


public class App 
{
	
	// serviços
	private ConsoleCommandService consoleCommandService = new ConsoleCommandServiceImpl();
	private CidadeService cidadeService = new CidadeServiceImpl();
	
    public static void main( String[] args )
    {
        
    	try {
    		// carrega o banco pelo arquivo
    		ConnectionCsvFactory.setCollectionCsv( new FileCsvUtils().loadCsvFileCidade() );
    		// Inicia o scan do console
        	App app = new App();
        	app.initScanConsole();
    	}
    	catch(Exception e) {
    		System.out.println("Erro ao carrega banco pelo arquivo. Erro:"+e.getMessage());
    		e.printStackTrace();
    		return;
    	}
    	
    }
    
    @SuppressWarnings("resource")
	public void initScanConsole() {
		
		// espera o comando
		while (Boolean.TRUE) {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Informe a consulta a ser feita:");
			String consoleCommand = scan.nextLine();
			
			// valida o comando informado
			try {
				ConsoleCommandType commandType = consoleCommandService.validateConsoleCommand(consoleCommand);
				if(ConsoleCommandType.COUNT_ALL == commandType) {
					System.out.println(cidadeService.countAll());
				}
				else if(ConsoleCommandType.COUNT_DISTINCT_COLUMN == commandType) {
					System.out.println(cidadeService.countDistinctColumn(consoleCommand));
				}
				else if(ConsoleCommandType.FILTER_COLUMN == commandType) {
					System.out.println(cidadeService.filterByColumnValue(consoleCommand));
				}
				else {
					System.out.println(MessageCommand.COMMAND_INVALID.getValue());
				}
				
			} catch (ConsoleCommandException e) {
				System.out.println("Erro ao processar comando. "+e.getMessage());
			}
			
		}
		
	}
    
    
}
