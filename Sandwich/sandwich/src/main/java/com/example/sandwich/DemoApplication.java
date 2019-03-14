package com.example.sandwich;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.sandwich.model.*;

import com.example.sandwich.workers.*;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws ClassNotFoundException {
		//SpringApplication.run(DemoApplication.class, args);
		Class.forName("org.sqlite.JDBC");

    	Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/alex/android/Sandwich-1/Sandwich/sandwich/src/main/resources/sandw.db");
      		Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			SandwichWorker s = new SandwichWorker();
			List<Sandwiches> s_arr = s.getSandwichByIngredient(connection, 1);
			for (int i = 0; i < 3; i++) {
				System.out.println(s_arr.get(i).getId());
				System.out.println(s_arr.get(i).getName());
				System.out.println(s_arr.get(i).getType());
				}

			AdminWorker adm = new AdminWorker();
			List<Admin> adm_arr = adm.getAllAdmins(connection);
			for (int i = 0; i < 1; i++){
				System.out.println(adm_arr.get(i).getAdm_id());
				System.out.println(adm_arr.get(i).getLogin());
				System.out.println(adm_arr.get(i).getPassword());
			}

			/*ResultSet rs = statement.executeQuery("select distinct Sandwiches.* from Sandwiches where id IN (Select Sandwiches_id from Composition where Ingredients_comp_id = 1)");
			//System.out.println(rs);
			while(rs.next())
      		{
        		// read the result set
        		System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
				System.out.println("type = " + rs.getString("type"));
				System.out.println("minutes = " + rs.getString("minutes"));
				System.out.println("comment = " + rs.getString("comment"));
				System.out.println("bread = " + rs.getString("bread"));
				
      		}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
    	{	
      		try
      		{
        		if(connection != null)
          			connection.close();
      		}
      		catch(SQLException e)
      		{
        		// connection close failed.
        		System.err.println(e);
      		}
    	}
		

	}

}

