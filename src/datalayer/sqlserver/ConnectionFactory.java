package datalayer.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import configuration.Configuration;
import configuration.Configuration.DataBaseConfiguration;


public abstract class ConnectionFactory {

	public abstract Connection getConnection() throws ClassNotFoundException,SQLException;

	public String GetConnectionString() {
		String url = "";
		DataBaseConfiguration database = Configuration.getInstance().Database;
		
		if(database.DatabaseType_SQLSERVER.equals(database.databaseType)){
			url = "jdbc:sqlserver://" + database.Server;		

			if (database.Port != null && database.Port.length() > 0) {
				url += ":" + database.Port + ";";
			} else {
				url += ";";
			}

			if (database.InstanceName != null && database.InstanceName.length() > 0) {
				url += "instanceName=" + database.InstanceName + ";";
			}

			if (database.Database != null && database.Database.length() > 0) {
				url += "databaseName=" + database.Database + ";";
			}
			if (database.IntegratedSecurity) {
				url += "integratedSecurity=true;";
			} else {
				url += "user=" + database.Username + ";password="
						+ database.Password + ";";
			}

		}
		
		//"jdbc:mysql://<server>/<database>?user=<username>&password=<password>"
		if(database.DatabaseType_MYSQL.equals(database.databaseType)){
			url = "jdbc:mysql://" + database.Server;			

			if (database.Port != null && database.Port.length() > 0) 
				url += ":" + database.Port;
			url += "/";

			if (database.Database != null && database.Database.length() > 0)
				url += database.Database + "?";
			url += "user=" + database.Username + "&password=" + database.Password;			

		}
		return url;
	}

}
