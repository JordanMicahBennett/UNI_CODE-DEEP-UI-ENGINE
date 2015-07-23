//author: Jordan Micah Bennett
package data.packages.UNICODE;

import java.util.ArrayList;
import data.packages.UNICODE.*;


public class UNICODE_DatabaseLogicModule 
{	
	//establish database connection module
    private UNICODE_ConfigurationManager configurationManager  = null;
	private UNICODE_DatabaseConnectionModule databaseConnectionModule = null;
	
	public UNICODE_DatabaseLogicModule ( UNICODE_ConfigurationManager configurationManager )
	{
		this.configurationManager = configurationManager;
		this.databaseConnectionModule = new UNICODE_DatabaseConnectionModule ( configurationManager );
	}
	
	public String [ ] [ ] getData ( String queryString ) 
	{
		String  [ ] [ ] returnValue;
		
		ArrayList < String [ ] > results = databaseConnectionModule.selectQuery ( queryString );
		
		int numRows = results.size ( );
		int numColumns = getCoreColumnCount ( queryString ); //this number is derived from the number of attributes midst data table table
				
		returnValue = new String [ numRows ] [ numColumns ];
				
		for ( int r = 0; r < numRows; r ++ )
		{
			for ( int c = 0; c < numColumns; c ++ )
			{
				returnValue [ r ] [ c ] = results.get ( r ) [ c ];
			}
		}
		
		return returnValue;
	}
	
	public int getCoreRowCount ( String queryString ) 
	{
		int returnValue = 0;
		
		ArrayList < String [ ] > results = databaseConnectionModule.selectQuery ( queryString );
		
		returnValue = results.size ( );
		
		return returnValue;
	}
	
	public int getCoreColumnCount ( String queryString  ) 
	{
		return databaseConnectionModule.getColumnCount ( queryString );
	}
	
	public UNICODE_DatabaseConnectionModule getDatabaseConnectionModule ( )
	{
		return databaseConnectionModule;
	}

}