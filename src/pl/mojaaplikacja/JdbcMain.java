package pl.mojaaplikacja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		final String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		
		final String dbPath = "jdbc:mysql://localhost:3306/world_x?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		Connection conn = DriverManager.getConnection(dbPath,"root", "Polska01");
		
		final String sqlQuery ="SELECT Name, Capital FROM country";
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		
		String countryName = null;
		String countryCapital = null;
		
		while (resultSet.next())
		{
			countryName = resultSet.getString("Name");
			countryCapital = resultSet.getString("Capital");
			System.out.println(countryName + " " + countryCapital);
		}
		
		if (statement!=null) 
		{
			statement.close();
		}
		
		if (resultSet!=null)
		{
			resultSet.close();
		}
		
		if (conn!=null)
		{
			conn.close();
		}
		
	}
}
