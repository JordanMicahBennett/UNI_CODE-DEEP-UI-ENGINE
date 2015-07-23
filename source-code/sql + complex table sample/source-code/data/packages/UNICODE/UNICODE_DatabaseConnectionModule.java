//author: Jordan Micah Bennett
package data.packages.UNICODE;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.concurrent.Callable;
import com.mysql.jdbc.CallableStatement;


import data.packages.UNICODE.*;


public class UNICODE_DatabaseConnectionModule 
{

	private java.sql.Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
	private ResultSetMetaData resultSetMetaData = null;

    private String url = "", user = "", password = "";
    private UNICODE_ConfigurationManager configurationManager  = null;
	
	//utilized to determine execution speed
	private Date executionCommenceDate, executionEndDate;
	private long executionTime;
    
   
	public UNICODE_DatabaseConnectionModule ( UNICODE_ConfigurationManager configurationManager )
	{
		this.configurationManager = configurationManager;
		
		url = configurationManager.getConnectionUrlFromFile ( );
		user = configurationManager.getConnectionUsernameFromFile ( );
		password = configurationManager.getConnectionPasswordFromFile ( ).equals ( "ignore" ) ? "" : configurationManager.getConnectionPasswordFromFile ( );

		
		try 
		{
			connection = DriverManager.getConnection ( url, user, password );
			
		} catch ( SQLException e ) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace ( );
		}	
	}
	
	
	 public java.sql.Connection getConnection ( )
	 {
		return connection;
	 }
	 
	public ArrayList < String [ ] > selectQuery ( String stringQuery )
	{
		
		//define speed attributes
			//commence
			executionCommenceDate = new Date ( );
			
		ArrayList < String [ ] > mainQuery = new ArrayList < String [ ] > ( ); 
		try 
		{       
			statement =  connection.createStatement ( );
            resultSet = statement.executeQuery ( stringQuery ); 
			resultSetMetaData = resultSet.getMetaData ( );
			
			 
            int columns = resultSet.getMetaData ( ).getColumnCount ( );

            while ( resultSet.next ( ) ) 
			{
            	
            	String [ ] subQuery = new String [ ( columns + 1 ) ];   //create an array of length 1 + that of the columns found
            	for ( int columnIndex = 0; columnIndex < columns; columnIndex++ )
            		subQuery [ columnIndex ] = resultSet.getString ( columnIndex + 1 );         //add a new column
            	
            	mainQuery.add ( subQuery );    //add a new row
            }

        } 
		catch ( SQLException exception )
        {
        	System.out.println ( exception );
        }
		finally
		{        	
        	try 
			{
				statement.close ( );
			} catch ( SQLException exception ) 
			{
				// TODO Auto-generated catch block
				exception.printStackTrace ( );
			}
        }
		

		//define speed attributes
			//end		
			executionEndDate = new Date ( );
			//compute speed
			executionTime = executionEndDate.getTime ( ) - executionCommenceDate.getTime ( );
		return mainQuery;
	}

	
	public int getColumnCount ( String stringQuery )
	{
		int returnValue = 0;
		//define speed attributes
			//commence
			executionCommenceDate = new Date ( );
		try 
		{       
			statement = connection.createStatement ( );
            resultSet  = statement.executeQuery ( stringQuery );  
            returnValue = resultSet.getMetaData ( ).getColumnCount ( );
        } 
		catch ( SQLException exception )
        {
        	System.out.println ( exception );
        }
		finally
		{        	
        	try 
			{
				statement.close ( );
			} catch ( SQLException exception ) 
			{
				// TODO Auto-generated catch block
				exception.printStackTrace ( );
			}
        }
		//define speed attributes
			//end		
			executionEndDate = new Date ( );
			//compute speed
			executionTime = executionEndDate.getTime ( ) - executionCommenceDate.getTime ( );
		return returnValue;
	}

	//support both delete and update
	public void updateQuery ( String stringQuery )
	{
		//define speed attributes
			//commence
			executionCommenceDate = new Date ( );
		try{
			statement =connection.createStatement ( );
			int result =statement.executeUpdate ( stringQuery );	
		}
		catch ( Exception exception )
		{
			//System.out.println ( exception );
		}
		finally
		{			
			try {
				statement.close ( );
			} catch ( SQLException exception ) 
			{
				// TODO Auto-generated catch block
				exception.printStackTrace ( );
			}
		}	
		//define speed attributes
			//end		
			executionEndDate = new Date ( );
			//compute speed
			executionTime = executionEndDate.getTime ( ) - executionCommenceDate.getTime ( );	
	}
	
	 
	public void insertQuery ( String stringQuery )
	{
		//define speed attributes
			//commence
			executionCommenceDate = new Date ( );
		try
		{
			statement  = connection.createStatement ( );
			statement.execute ( stringQuery );		
		}
		catch ( Exception exception )
		{
			System.out.println ( exception );
		}
		finally
		{			
			try 
			{
				statement.close ( );
			} catch ( SQLException exception ) 
			{
				// TODO Auto-generated catch block
				exception.printStackTrace ( );
			}
		}
		//define speed attributes
			//end		
			executionEndDate = new Date ( );
			//compute speed
			executionTime = executionEndDate.getTime ( ) - executionCommenceDate.getTime ( );
	}
	
	public ArrayList <String [ ] > insertQueryProcOUT ( String proc ) 
	{
		//define speed attributes
			//commence
			executionCommenceDate = new Date ( );
		ArrayList < String [ ] > mainQuery = new ArrayList < String [ ] > ( ); 
		try
		{
			statement =connection.createStatement ( );
			statement.execute ( "CALL "+proc );	
			resultSet =statement.getResultSet ( );
            int columns = resultSet.getMetaData ( ).getColumnCount ( );
            while ( resultSet.next ( ) )
            {
            	
            	String [ ] subQuery = new String [ ( columns+1 ) ] ;   //create an array of length 1 + that of the columns found
            	for ( int columnIndex = 0; columnIndex < columns; columnIndex++ ) 
            		subQuery [ columnIndex ] = resultSet.getString ( columnIndex + 1 );         //add a new column
            	
            	mainQuery.add ( subQuery );    //add a new row
            }
		}
		catch ( Exception exception ) 
		{
			System.out.println ( exception );
		}
		finally
		{			
			try 
			{
				statement.close ( );
			} 
			catch ( SQLException exception ) 
			{
				// TODO Auto-generated catch block
				exception.printStackTrace ( );
			}
		}	
		//define speed attributes
			//end		
			executionEndDate = new Date ( );
			//compute speed
			executionTime = executionEndDate.getTime ( ) - executionCommenceDate.getTime ( );
		return  mainQuery;
	}

	public String [ ] getColumnNames ( String stringQuery )
	{
		String [ ] returnValue = null;
		//define speed attributes
			//commence
			executionCommenceDate = new Date ( );
		try 
		{       
			statement = connection.createStatement ( );
            resultSet = statement.executeQuery ( stringQuery ); 
			

			if ( resultSet != null ) 
			{
				resultSetMetaData = resultSet.getMetaData ( );
				returnValue = new String [ resultSetMetaData.getColumnCount ( ) ];
				
				int i = 0;
				while ( i <= resultSetMetaData.getColumnCount ( ) ) 
				{
					i++;
					
					returnValue [ i - 1 ] = resultSetMetaData.getColumnName ( i ); //i - 1 is illogical, however, functional.
				}
			}
        } 
		catch ( Exception error )
		{
			
		}
		//define speed attributes
			//end		
			executionEndDate = new Date ( );
			//compute speed
			executionTime = executionEndDate.getTime ( ) - executionCommenceDate.getTime ( );
		return returnValue;
	}
	
	/*
		//define speed attributes
			//commence
			executionCommenceDate = new Date ( );
		//define speed attributes
			//end		
			executionEndDate = new Date ( );
			//compute speed
			executionTime = executionEndDate.getTime ( ) - executionCommenceDate.getTime ( );
		*/
	public long getExecutionTime ( )
	{
		return executionTime;
	}
}