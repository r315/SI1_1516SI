package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	
	private static Date date = new Date();
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//conversão de data para string...
	public static String getDateTime(){
		return format.format(date.getTime());
	}
}
