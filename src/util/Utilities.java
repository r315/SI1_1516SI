package util;

import java.sql.Date;
import java.util.Scanner;

import model.Alojamento;
import model.Parque;


public class Utilities {
	public static int GetInt(Scanner input, String caption, String onErrorCaption)
	{
		int result;
		do {
			System.out.print(caption);
			if (input.hasNextInt()) 
			{
				result = input.nextInt();
				input.nextLine();
				
				return result;
			}
			else 
			{
				input.nextLine();
				System.out.println(onErrorCaption);
				System.out.println();
			}
		}
		while(true);
	}
	
	public static float GetFloat(Scanner input, String caption, String onErrorCaption)
	{
		float result;
		do {
			System.out.print(caption);
			if (input.hasNextFloat()) 
			{
				result = input.nextFloat();
				input.nextLine();
				
				return result;
			}
			else 
			{
				input.nextLine();
				System.out.println(onErrorCaption);
				System.out.println();
			}
		}
		while(true);
	}
	
	public static  Date GetDate(Scanner input, String caption)
	{
		System.out.print(caption);
		return java.sql.Date.valueOf(input.nextLine());
	}
	
	public static  String GetString(Scanner input, String caption)
	{
		System.out.print(caption);
		return input.nextLine();
	}
	
	public static  boolean AreYouSure(Scanner input)
	{
		return YesOrNoQuestion(input, "Are you sure");
	}
	
	public static  boolean YesOrNoQuestion(Scanner input, String questionCaption)
	{
		String question = null;
		while(true)
		{
			question = GetString(input, questionCaption + "[(Y)es/(N)o]:");
			if(question.toUpperCase().equals("Y"))
			{
				return true;
			} 
			else if (question.toUpperCase().equals("N"))
			{
				return false;
			}
		}
	}

	/*
	 * 0 no
	 * 1 yes
	 * -1 quit 
	 * */
	public static  int YesOrNoQuitQuestion(Scanner input, String questionCaption)
	{
		String question = null;
		while(true)
		{
			question = GetString(input, questionCaption + "[(Y)es/(N)o/(Q)uit]:");
			
			if(question.toUpperCase().equals("Y"))
			{
				return 1;
			}
			else if (question.toUpperCase().equals("N"))
			{
				return 0;
			}
			else if (question.toUpperCase().equals("Q"))
			{
				return -1;
			}
		}
	}
	
	
	/* Parque*/
	public static void PrintTableHeaderForParque()
	{
		System.out.printf("%-15s%-50s%-20s\n","Nome", "Morada", "Localização");
		System.out.println("*************************************************************************************");
	}	
	public static void PrintParque(Parque parque){
		String name = parque.nome.length()>15?parque.nome.substring(0, 14):parque.nome;
		String address = parque.morada.length()>50?parque.morada.substring(0, 49):parque.morada;
		String loc = parque.localizacao.length() > 20 ? parque.localizacao.substring(0,19):parque.localizacao;
		System.out.printf("%-15s%-50s%-20s\n",name, address,loc );
	}
	
	/* Alojamento*/
	public static void PrintTableHeaderForAlojamento()
	{
		System.out.printf("%-5s%-10s%-20s%-20s%-9s%-6s\n", "ID","Parque", "Localização", "Descrição","Preço","Tipo");
		System.out.println("**************************************************************************************");
	}	
	public static void PrintAlojamento(Alojamento alojamento){
		String parque = alojamento.parque.length()>10?alojamento.parque.substring(0, 9):alojamento.parque;
		String desc = alojamento.descricao.length()>20?alojamento.descricao.substring(0, 19):alojamento.descricao;
		String loc = alojamento.localizacao.length() > 20 ? alojamento.localizacao.substring(0,19):alojamento.localizacao;
		System.out.printf("%-5d%-10s%-20s%-20s%.2f\t%-6s\n",alojamento.id, parque,loc,desc,alojamento.preco,alojamento.tipo );
	}
	
	
	
	
	
	
	
}
