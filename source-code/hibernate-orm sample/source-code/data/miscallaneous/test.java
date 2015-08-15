import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;


public class test
{
    public static void main ( String [ ] arguments )
    {   
        try 
        {
            Class <?> _Class = Class.forName ( "Sharedplaylists" );
            Object _Object = _Class.newInstance ( );
    
            Method [ ] allMethods = _Class.getDeclaredMethods ( );
            
            Object [ ] parameters = { "fff", 0, 1, 2, 3 }; //constraint: alphabetic method listing. Thereafter, params shall be organized with rerspect to this alphabetic sorting.
            int iterator = 0;
            
            for ( Method eachMethod : allMethods ) 
            {
                String eachMethodName = eachMethod.getName ( );
                
                if ( eachMethodName.contains ( "set" ) ) //universal standard for mutator method prefix
                {
                    eachMethod.invoke ( _Object, parameters [ iterator ] );
                    System.out.println ( eachMethodName + " : " + parameters [ iterator ] );
                    iterator ++;
                }
            }
            
            System.out.println ( "\n\n" );
             
            //test print values to see if set was successful
            System.out.println ( ( Class.forName ( "Sharedplaylists" ).cast ( _Object ) ).getDate ( ) );
        }
        catch ( Exception error )
        {
        }
    }
}
