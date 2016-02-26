package presentation;

import java.lang.reflect.*;
import java.util.*;


public class Menu {
	public class MenuItem
	{
		public String description;
		public Method method;

		public MenuItem(String description, Method method)
		{
			this.description = description;
			this.method = method;
		}
	}
	
	public ArrayList<MenuItem> menuItems = null;
	
	@SuppressWarnings("rawtypes")
	public Menu() throws NoSuchMethodException 
	{
		menuItems = new ArrayList<MenuItem>();
		Class params[] = {Scanner.class, Console.class};
	
		/*Items do menu*/
		menuItems.add(new MenuItem("Quit", Actions.class.getDeclaredMethod("Quit", params)));
		menuItems.add(new MenuItem("About", Actions.class.getDeclaredMethod("About", params)));		

		//TODO
		// Insert more menu items to the menu. They must be implemented at CustomActions.java
		menuItems.add(new MenuItem("Listar Parques", Actions.class.getDeclaredMethod("ListParques", params)));
		menuItems.add(new MenuItem("Listar Alojamentos", Actions.class.getDeclaredMethod("ListAlojamentos", params)));
		menuItems.add(new MenuItem("Criar Alojamento", Actions.class.getDeclaredMethod("NovoAlojamento", params)));		
		menuItems.add(new MenuItem("Remover Alojamento", Actions.class.getDeclaredMethod("RemoveAlojamento", params)));
		menuItems.add(new MenuItem("Actualizar preço de Alojamento", Actions.class.getDeclaredMethod("ActualizarPrecoAlojamento", params)));
		menuItems.add(new MenuItem("Criar Extra em Alojamento", Actions.class.getDeclaredMethod("CriarExtraAlojamento", params)));
		menuItems.add(new MenuItem("Fazer Reserva (Hospede Novo)", Actions.class.getDeclaredMethod("FazerReservaHospedeNovo", params)));
		menuItems.add(new MenuItem("Valor Alojamento", Actions.class.getDeclaredMethod("ValorAlojamento", params)));
	}
}
