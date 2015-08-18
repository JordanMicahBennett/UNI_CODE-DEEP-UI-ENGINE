//Author: Jordan Micah Bennett
import java.util.List;
import java.lang.reflect.Method;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SQLComposerDebugger
{
    //attributes
    private SQLComposer _SQLComposer = null;
    
    public SQLComposerDebugger ( SQLComposer _SQLComposer )
    {
         this._SQLComposer = _SQLComposer;
    }
 
    
    public void showAccessorMethodsAtInsert ( String className )
    {
        Session session = _SQLComposer.getSessionFactory ( ).openSession ( );
        System.out.println ( "__sql_composer_debugger__" );
        
        //Add new object
        try 
        {
            Class <?> _Class = Class.forName ( className );
            
            Method [ ] allMethods = _Class.getDeclaredMethods ( );
            
            int iterator = 0;
            
            for ( Method eachMethod : allMethods ) 
            {
                String eachMethodName = eachMethod.getName ( );
                
                if ( eachMethodName.contains ( "set" ) ) //universal standard for mutator method prefix
                {
                    System.out.println ( eachMethodName );
                    iterator ++;
                }
            }
        }
        catch ( Exception error )
        {
        }
 
        session.close ( );
    }
}