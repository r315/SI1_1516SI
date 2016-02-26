package configuration;

import java.io.FileInputStream;
import java.util.Properties;

import datalayer.common.*;
import datalayer.sqlserver.*;

public class Configuration {

	public static final String configurationFileName = "configmysql.conf";

	public boolean ConfigurationLoadSucess = true;
	public String ConfigurationLoadDescription = "OK";

	public AboutConfiguration About;
	public DataBaseConfiguration Database;

	public class AboutConfiguration {
		public AboutConfiguration(Properties properties) {
			SchoolName = properties.getProperty("schoolName");
			DepartmentName = properties.getProperty("departmentName");
			GroupNumber = properties.getProperty("groupNumber");
			Curse = properties.getProperty("curse");
		}

		public String SchoolName;
		public String DepartmentName;
		public String GroupNumber;
		public String Curse;

	}	

	public class DataBaseConfiguration {
		public static final String DatabaseType_Key = "databaseType";
		public static final String DatabaseType_SQLSERVER = "sqlserver";
		public static final String DatabaseType_MYSQL = "mysql";
		public static final String DatabaseType_ORACLE = "oracle";

		public DataBaseConfiguration(Properties properties) {
			Server = properties.getProperty("server");
			Port = properties.getProperty("port");
			InstanceName = properties.getProperty("instanceName");
			Database = properties.getProperty("database");
			Username = properties.getProperty("username");
			Password = properties.getProperty("password");
			IntegratedSecurity = Boolean.parseBoolean(properties
					.getProperty("integratedSecurity"));
			databaseType = properties.getProperty(DatabaseType_Key);

			/* Setup ConnectionFactory */
			if (DatabaseType_SQLSERVER.equals(databaseType)) {
				BaseDAO.setConnectionFactory(SQLServerConnectionFactory.getInstance());
			}
			
			if(DatabaseType_MYSQL.equals(databaseType)){
				BaseDAO.setConnectionFactory(MySQLServerConnectionFactory.getInstance());
			}
			/* TODO: Support oracle */
		}

		public String Server;
		public String Port;
		public String InstanceName;
		public String Database;
		public String Username;
		public String Password;
		public boolean IntegratedSecurity;
		public String databaseType;

	}

	//garante uma so instancia???
	private static Configuration Instance = new Configuration();

	public static Configuration getInstance() {
		return Instance;
	}

	private Configuration() {
		try {

			Properties properties = new Properties();
			FileInputStream iFile = new FileInputStream("bin/"
					+ this.getClass().getPackage().getName().replace('.', '/')
					+ "/" + configurationFileName);
			properties.loadFromXML(iFile);
			
			Database = new DataBaseConfiguration(properties);
			About = new AboutConfiguration(properties);

			iFile.close();
		} catch (Exception exception) {
			ConfigurationLoadDescription = exception.getMessage();
			ConfigurationLoadSucess = false;
		}
	}
}