//author: Jordan Micah Bennett
package data.packages.UNICODE;

import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JPanel;

public class UNICODE_DatabaseManager
{
    //variables
    private UNICODE_ConfigurationManager configurationManager = null;
    private UNICODE_DatabaseLogicModule databaseLogicModule = null;
    private UNICODE_ConveniencePack conveniencePack = null;
	final private String INSERT_QUERY_REGEX_PATTERN = "(.*)(\\s)(.*)(\\s)(.*)(\\s)values(.*)", INSERT_QUERY_REGEX_OUTCOME_KEY = "$5";
	final private String DELETE_QUERY_REGEX_PATTERN = "(.*)(\\s)(.*)(\\s)(.*)(\\s)where(.*)", DELETE_QUERY_REGEX_OUTCOME_KEY = "$5";
	final private String UPDATE_QUERY_REGEX_PATTERN = "(.*)(\\s)(.*)(\\s)set(.*)", UPDATE_QUERY_REGEX_OUTCOME_KEY = "$3";
	final private String SELECT_QUERY_REGEX_PATTERN_I = "select(\\s)(.*)(\\s)from(\\s)(.*)(\\s)where(\\s)(.*)", SELECT_QUERY_REGEX_OUTCOME_KEY_I = "$5"; //constrained [includes where]
	final private String SELECT_QUERY_REGEX_PATTERN_II = "select(\\s)(.*)(\\s)from(\\s)(.*)", SELECT_QUERY_REGEX_OUTCOME_KEY_II = "$5"; //non-constrained [doesn't include where]
	final private String SELECT_QUERY_REGEX_PATTERN_III = "select(\\s)(.*)(\\s)from(\\s)(.*)(\\s)from(\\s)(.*)(\\s)where(\\s)(.*)", SELECT_QUERY_REGEX_OUTCOME_KEY_III = "$8"; //constrained [includes where] (nested select, inner from)
	final private String SELECT_QUERY_REGEX_PATTERN_IV = "select(\\s)(.*)(\\s)from(\\s)(.*)(\\s)from(\\s)(.*)(\\s)join(\\s)(\\w+)(\\s)(.*)", SELECT_QUERY_REGEX_OUTCOME_KEY_IV = "$8$9join$9$11"; //non-constrained (nested select, inner from) part a,
	                           
	private String QUERY_REGEX_PATTERN_STRING = "", QUERY_REGEX_REPLACEMENT_CONTROLLER_STRING = "";
	
    //constructor
    public UNICODE_DatabaseManager ( UNICODE_ConfigurationManager configurationManager )
    {
        //establish configurationManager ( database settings are loaded here )
        this.configurationManager = configurationManager;
        
        //establish database logic module
        this.databaseLogicModule = new UNICODE_DatabaseLogicModule ( configurationManager );
		
		//establish conveniencePack
		this.conveniencePack = new UNICODE_ConveniencePack ( );
    }
    
    
    public UNICODE_DatabaseLogicModule getDatabaseLogicModule ( )
    {
        return databaseLogicModule;
    }
    
	//methods
		//accessors - these are wrapper(s), providing short-cuts to end classes
		public String [ ] getColumnNames ( String queryString )
		{
			return getDatabaseLogicModule ( ).getDatabaseConnectionModule ( ).getColumnNames ( queryString );
		}
		public UNICODE_Structure_ComplexTable getDefinedTable ( int tableRowHeight, final String tableBackgroundImageParentStream /*eg data/"*/, final String tableBackgroundImageStream /*eg image.png"*/, String alignment, String tableThumbStream, String tableTrackStream, Color tableBackgroundColour, JPanel destinationPanel, String queryString, Color defaultBackgroundColour, Color defaultForegroundColour, Color highlightedBackgroundColour, Color highlightedForegroundColour )
		{
			UNICODE_Structure_ComplexTable returnValue = null;
			
			//define instance
			returnValue = new UNICODE_Structure_ComplexTable ( destinationPanel );
			//setup table column headers
			returnValue.describeColumns ( getColumnNames ( queryString ) );
			//define colour scheme [ default(1)background, default(2)foreground, highlighted(3)background, highlighted(4)foreground ]                    
			returnValue.establishColourScheme ( defaultBackgroundColour, defaultForegroundColour, highlightedBackgroundColour, highlightedForegroundColour );
			//setup table body for updating
			returnValue.setup ( tableRowHeight, tableBackgroundImageParentStream, tableBackgroundImageStream, alignment, tableThumbStream, tableTrackStream, tableBackgroundColour  ); //BACKGROUND IMAGES ARE ENGINE INTERNAL, must be placed in data/packages/UNICODE/
			//populate OUTCOME table
			populateTable ( returnValue, queryString );
			
			return returnValue;
		}
		//derives select query string from select/update query. This is utilized to 'refresh' table based on last selectupdate(delete,insert,update) function.
		public String getSelectQueryAtQuery ( String queryString )
		{
			queryString = queryString.replaceAll ( "\\s+"," " );

			QUERY_REGEX_PATTERN_STRING = queryString.contains ( "insert" ) ? INSERT_QUERY_REGEX_PATTERN : queryString.contains ( "update" ) ? UPDATE_QUERY_REGEX_PATTERN : queryString.contains ( "delete" ) ? DELETE_QUERY_REGEX_PATTERN : queryString.contains ( "select" ) && queryString.toLowerCase( ).contains ( "where" ) ? SELECT_QUERY_REGEX_PATTERN_I : queryString.contains ( "select" ) && !queryString.toLowerCase( ).contains ( "where" ) ? SELECT_QUERY_REGEX_PATTERN_II : new UNICODE_ConveniencePack ( ).getRegexComponents ( SELECT_QUERY_REGEX_PATTERN_II, queryString, SELECT_QUERY_REGEX_OUTCOME_KEY_II ) == null ? SELECT_QUERY_REGEX_PATTERN_III : new UNICODE_ConveniencePack ( ).getRegexComponents ( SELECT_QUERY_REGEX_PATTERN_III, queryString, SELECT_QUERY_REGEX_OUTCOME_KEY_III ) == null ? SELECT_QUERY_REGEX_PATTERN_IV : "";

			QUERY_REGEX_REPLACEMENT_CONTROLLER_STRING = queryString.contains ( "insert" ) ? INSERT_QUERY_REGEX_OUTCOME_KEY : queryString.contains ( "update" ) ? UPDATE_QUERY_REGEX_OUTCOME_KEY : queryString.contains ( "delete" ) ? DELETE_QUERY_REGEX_OUTCOME_KEY : queryString.contains ( "select" ) && queryString.toLowerCase( ).contains ( "where" ) ? SELECT_QUERY_REGEX_OUTCOME_KEY_I : queryString.contains ( "select" ) && !queryString.toLowerCase( ).contains ( "where" ) ? SELECT_QUERY_REGEX_OUTCOME_KEY_II : new UNICODE_ConveniencePack ( ).getRegexComponents ( SELECT_QUERY_REGEX_PATTERN_II, queryString, SELECT_QUERY_REGEX_OUTCOME_KEY_II ) == null ? SELECT_QUERY_REGEX_OUTCOME_KEY_III : new UNICODE_ConveniencePack ( ).getRegexComponents ( SELECT_QUERY_REGEX_PATTERN_III, queryString, SELECT_QUERY_REGEX_OUTCOME_KEY_III ) == null ? SELECT_QUERY_REGEX_OUTCOME_KEY_IV : "";

	
			
			return "select * from " + conveniencePack.getRegexComponents ( QUERY_REGEX_PATTERN_STRING, queryString, QUERY_REGEX_REPLACEMENT_CONTROLLER_STRING );
		}
		//derives table name from update query - delete,update,insert. [Used because sql result set meta data -> 'getColumnName' is non-reliable]
		public String getTableName ( String queryString )
		{
			queryString = queryString.replaceAll ( "\\s+"," " );
			
			QUERY_REGEX_PATTERN_STRING = queryString.contains ( "insert" ) ? INSERT_QUERY_REGEX_PATTERN : queryString.contains ( "update" ) ? UPDATE_QUERY_REGEX_PATTERN : queryString.contains ( "delete" ) ? DELETE_QUERY_REGEX_PATTERN : queryString.contains ( "select" ) && queryString.toLowerCase( ).contains ( "where" ) ? SELECT_QUERY_REGEX_PATTERN_I : queryString.contains ( "select" ) && !queryString.toLowerCase( ).contains ( "where" ) ? SELECT_QUERY_REGEX_PATTERN_II : new UNICODE_ConveniencePack ( ).getRegexComponents ( SELECT_QUERY_REGEX_PATTERN_II, queryString, SELECT_QUERY_REGEX_OUTCOME_KEY_II ) == null ? SELECT_QUERY_REGEX_PATTERN_III : new UNICODE_ConveniencePack ( ).getRegexComponents ( SELECT_QUERY_REGEX_PATTERN_III, queryString, SELECT_QUERY_REGEX_OUTCOME_KEY_III ) == null ? SELECT_QUERY_REGEX_PATTERN_IV : "";

			QUERY_REGEX_REPLACEMENT_CONTROLLER_STRING = queryString.contains ( "insert" ) ? INSERT_QUERY_REGEX_OUTCOME_KEY : queryString.contains ( "update" ) ? UPDATE_QUERY_REGEX_OUTCOME_KEY : queryString.contains ( "delete" ) ? DELETE_QUERY_REGEX_OUTCOME_KEY : queryString.contains ( "select" ) && queryString.toLowerCase( ).contains ( "where" ) ? SELECT_QUERY_REGEX_OUTCOME_KEY_I : queryString.contains ( "select" ) && !queryString.toLowerCase( ).contains ( "where" ) ? SELECT_QUERY_REGEX_OUTCOME_KEY_II : new UNICODE_ConveniencePack ( ).getRegexComponents ( SELECT_QUERY_REGEX_PATTERN_II, queryString, SELECT_QUERY_REGEX_OUTCOME_KEY_II ) == null ? SELECT_QUERY_REGEX_OUTCOME_KEY_III : new UNICODE_ConveniencePack ( ).getRegexComponents ( SELECT_QUERY_REGEX_PATTERN_III, queryString, SELECT_QUERY_REGEX_OUTCOME_KEY_III ) == null ? SELECT_QUERY_REGEX_OUTCOME_KEY_IV : "";


			
			return "current table : " + conveniencePack.getRegexComponents ( QUERY_REGEX_PATTERN_STRING, queryString, QUERY_REGEX_REPLACEMENT_CONTROLLER_STRING );
		}
		public String getExecutionTime ( )
		{
			return "" + getDatabaseLogicModule ( ).getDatabaseConnectionModule ( ).getExecutionTime ( ) + " milliseconds";
		}
		//mutators
			//non-wrapper mutators
			public void populateTable ( UNICODE_Structure_ComplexTable complexTable, String queryString )
			{
				//compose object
				Object [ ] [ ] outcomeObject = getDatabaseLogicModule ( ).getData ( queryString );

				//populate table
				for ( int i = 0; i < getDatabaseLogicModule ( ).getCoreRowCount(  queryString ); i ++ )
				{
					complexTable.getTableModel ( ).addRow ( outcomeObject [ i ] );
					complexTable.incrementItemCount ( );
				}
			}
			//wrapper mutators - these are wrapper(s), providing short-cuts to end classes
			public void insertQuery ( String queryString )
			{
				getDatabaseLogicModule ( ).getDatabaseConnectionModule ( ).insertQuery ( queryString );
			}
			public void updateQuery ( String queryString )
			{
				getDatabaseLogicModule ( ).getDatabaseConnectionModule ( ).updateQuery ( queryString );
			}
}