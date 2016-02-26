package presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import util.Utilities;
import configuration.Configuration;
import business.EstadiaService;
import business.HospedeService;
import business.IEstadiaService;
import business.IHospedeService;
import business.AlojamentoService;
import business.IAlojamentoService;
import business.IParqueService;
import business.IQueryService;
import business.QueryService;
import business.ParqueService;
import business.ServiceException;
import model.Alojamento;
import model.Bungalow;
import model.Estadia;
import model.Hospede;
import model.Parque;
import model.Roulote;
import model.Tenda;




public class Actions {
	private IParqueService parqueService;
	private IAlojamentoService alojamentoService;
	private IHospedeService hospedeService;
	private IQueryService queryService;
	private IEstadiaService estadiaService;
		
	//public IParqueService getParqueService(){return parqueService;}
	//public void setParqueService(IParqueService parqueService){ this.parqueService = parqueService;}
	
	public Actions(){
		/* add services */
		parqueService = new ParqueService();
		alojamentoService = new AlojamentoService();
		hospedeService = new HospedeService();
		queryService = new QueryService();
		estadiaService = new EstadiaService();
	}
	
	/*Menu actions menu methods*/
	
	/*Option 0*/
	public void Quit(Scanner input, Console console) 
	{
		Boolean exit = Utilities.YesOrNoQuestion(input, "Are you sure?");
		if(exit) 
		{
			System.out.println("Thank you for using the program! Bye!");
			console.Terminate();
		}
	}
	
	/*Option 1*/
	public void About(Scanner input, Console console) 
	{
		configuration.Configuration.AboutConfiguration about = Configuration.getInstance().About;
		
		System.out.println("");
		System.out.println(about.SchoolName);
		System.out.println(about.DepartmentName);
		System.out.println(about.GroupNumber + "# Group number of " + about.Curse);
		System.out.println("");
	}

	/*Option 2*/
	public void ListParques(Scanner input, Console console) throws ServiceException
	{
		System.out.println("\nLista de Parques.");
		
		List<Parque> curses = parqueService.getAll();
		Iterator<Parque> it = curses.iterator();

		if(!it.hasNext()){
			System.out.println("Nenhum parque!");
		}
		else
		{
			Utilities.PrintTableHeaderForParque();
			while (it.hasNext()) 
			{
				Utilities.PrintParque(it.next());
			}
		}
		System.out.println("");
	}	
	
	
	public void ListAlojamentos(Scanner input, Console console) throws ServiceException{
		System.out.println("\nLista de Alojamentos.");

		List<Alojamento> curses = alojamentoService.getAll();
		Iterator<Alojamento> it = curses.iterator();

		if(!it.hasNext()){
			System.out.println("Nenhum Alojamnto!");
		}
		else
		{
			Utilities.PrintTableHeaderForAlojamento();
			while (it.hasNext()) 
			{
				Utilities.PrintAlojamento(it.next());
			}
		}
		System.out.println("");
	}

	/*adicionar novo alojamento, todos os parametros são obrigatorios*/
	public void NovoAlojamento(Scanner input, Console console) throws ServiceException
	{		
		String tipo = "";
		Alojamento alojamento = null;
		while ( ! (tipo.equals("B") || tipo.equals("R") || tipo.equals("T") ) ) {
			tipo = Utilities.GetString(input, "Tipo de Alojamento(B-Bungalow | R - Roulote | T - Tenda)? ");
			if ( tipo.equals("B") ) {
				Bungalow tmp = new Bungalow();
				tmp.topologia = Utilities.GetString(input, "Topoloia(T0|T1|T2|T3)? "); 
				alojamento = tmp;
			}
			else 
				if ( tipo.equals("T") ) {
					Tenda tmp = new Tenda();
					tmp.area = Utilities.GetInt(input, "Area(m2)? ","Valor em M2"); 
					alojamento = tmp;
				}
				else 
					if ( tipo.equals("R") ) {
						Roulote tmp = new Roulote();
						alojamento = tmp;
					}
		}
		alojamento.tipo = tipo;
		alojamento.parque = Utilities.GetString(input, "Parque? ");
		alojamento.localizacao = Utilities.GetString(input, "Localização? ");
		alojamento.descricao = Utilities.GetString(input, "Descrição? ");
		alojamento.preco = Utilities.GetFloat(input, "Preço? ", "Introduzir preço em Euros");
		System.out.println("Alojamento inserido com id: " + alojamentoService.insert(alojamento));
	}
	
	/* Colocado ON DELETE CASCADE nas tabelas que referenciam alojamento */
	public void RemoveAlojamento(Scanner input, Console console) throws ServiceException
	{
		System.out.print("<Parque> <Id do Alojamento>: ");
		if(input.hasNext()){
			if(alojamentoService.removeByPk(input.next(), input.nextInt()))
				System.out.println("Alojamento removido com sucesso!");
		}
	}	
	
	
	/**/
	public void ActualizarPrecoAlojamento(Scanner input, Console console) throws ServiceException
	{
		System.out.print("<Parque> <Id Aloj> <Preço>: ");
		Alojamento alojamento = alojamentoService.getByPk(input.next(), input.nextInt());
		alojamento.preco = input.nextFloat();		
		if(alojamentoService.updatePreco(alojamento))
			System.out.println("Alojamento actualizado com sucesso!");
	}
	
	/*Option 3*/
	public void CriarExtraAlojamento(Scanner input, Console console) throws ServiceException
	{
		System.out.print("<Parque> <Id Aloj> <ID Extra>: ");
		Alojamento alojamento = alojamentoService.getByPk(input.next(), input.nextInt());		
		if(alojamentoService.insereExtra(alojamento, input.nextInt()))
			System.out.println("Alojamento actualizado com sucesso!");
	}
	
	/*Option 3*/
	public void FazerReservaHospedeNovo(Scanner input, Console console) throws ServiceException
	{
		System.out.println("Criar Hospede Novo:");
		System.out.print("<NIF>|<BI>|<Passaporte>|<Nome>|<Morada>: ");
		Hospede hospede = new Hospede();
		Estadia estadia = new Estadia();
			String line = input.nextLine();
			hospede.nif = Integer.parseInt(line.split("\\|")[0]);
			hospede.bi = Integer.parseInt(line.split("\\|")[1]);
			hospede.passaporte = line.split("\\|")[2];
			hospede.nome = line.split("\\|")[3];
			hospede.morada = line.split("\\|")[4];	
			int id = hospedeService.insert(hospede);
			System.out.println("Hospede inserido na BD");
			System.out.println("Efectuar Reserva:");
			estadia.hospede = hospede.nif;
			estadia.dtentrada = Utilities.GetDate(input, "Data de Entrada(AAAA-MM-DD)? ");
			estadia.dtsaida = Utilities.GetDate(input, "Data de Saída(AAAA-MM-DD)? ");
			if ( Utilities.YesOrNoQuestion(input, "Sinal (Y/N)?") ) {
				   estadia.sinal = Utilities.GetFloat(input, "Valor? ", "Introduzir valor em Euros");
					estadia.tipo = "Res";
				}
			else {
				estadia.sinal = 0;
				estadia.tipo = "Est";
			}
			estadia.id = estadiaService.insert(estadia);
			System.out.println("Estadia inserida com id: "+id);

			System.out.println("Inserir Alojamentos:");
			String parque = Utilities.GetString(input, "Parque: " );
			boolean aloj = false;
			do {
				int idAloj = Utilities.GetInt(input, "ID Alojamento: ", "ID tem de ser um Numero Inteiro!");
				Alojamento alojamento = alojamentoService.getByPk(parque, idAloj);
				if ( alojamentoService.disponibilidade(alojamento, estadia.dtentrada, estadia.dtsaida)) {
					if ( estadiaService.insertAlojamento(estadia,alojamento) )
						aloj = true;
						System.out.println("Alojamento iinserido na estadia!");
				}
				else System.out.println("Alojamento não disponivel para as datas indicadas!");	
			}
			while ( aloj == false || Utilities.YesOrNoQuestion(input, "Inserir outro Alojamento?") );
			System.out.println("Reserva efectuada!");	

	}
	
	/*Option 9*/
	public void ValorAlojamento(Scanner input, Console console) throws ServiceException
	{		
		System.out.print("<NIF> <Data>: ");
		if(input.hasNext()){
			System.out.println( "Total: " + queryService.getCustoTotalAlojamento(input.nextInt(), java.sql.Date.valueOf(input.next()) ));
		}
	}
	
}
