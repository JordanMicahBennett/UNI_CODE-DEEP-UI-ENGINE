//Author: Jordan Micah Bennett
import java.util.List;
import java.lang.reflect.Method;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SQLComposer
{
    //attributes
    
    //constructor
    public SQLComposer ( )
    {
         
    }
 
    //methods
        //accessors
        public SessionFactory getSessionFactory ( )
        {
            Configuration configuration = new Configuration ( ).configure ( );
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder ( ).applySettings ( configuration.getProperties ( ) );
            SessionFactory sessionFactory = configuration.buildSessionFactory ( builder.build ( ) );
            return sessionFactory;
        }
        
        public List <?> getSqlResultFromSelection ( String message, String queryString, int dataColumnIndex ) 
        {
            System.out.println ( message + ":\n" );
            
            Session session = getSessionFactory ( ).openSession ( );
            @SuppressWarnings ( "unchecked" )
       
            List <?> items = session.createSQLQuery ( queryString ).list ( ); 
            
            //return item as an Object if it is an Object instance ( LString ), otherwise return decimal double outcome.
            for ( int i = 0; i < items.size ( ); i ++ )
                System.out.println ( ! ( items.get ( i ) instanceof Double ) ? ( ( Object [ ] ) items.get ( i ) ) [ dataColumnIndex ] : items );
                    
            session.close ( );
            System.out.println ( "\nencountered " + items.size (  ) + " items\n\n\n\n" );
            
            return items;
        }
        //mutators
        public void insertItem ( String message, String className, Object [ ] parameters ) //constraint: alphabetic method listing. Thereafter, parameters shall be organized with respect to this alphabetic sorting.
        {
            System.out.println ( message + ":\n" );
            
            Session session = getSessionFactory ( ).openSession ( );
            session.beginTransaction ( );
            
            //Add new object
            try 
            {
                Class <?> _Class = Class.forName ( className );
                Object _Object = _Class.newInstance ( );
                
                Method [ ] allMethods = _Class.getDeclaredMethods ( );
                
                int iterator = 0;
                
                for ( Method eachMethod : allMethods ) 
                {
                    String eachMethodName = eachMethod.getName ( );
                    
                    if ( eachMethodName.contains ( "set" ) ) //universal standard for mutator method prefix
                    {
                        eachMethod.invoke ( _Object, parameters [ iterator ] );
                        iterator ++;
                    }
                }

                //Save the object in database
                session.save ( ( Class.forName ( className ).cast ( _Object ) ) );
                session.getTransaction ( ).commit ( );
            }
            catch ( Exception error )
            {
            }
            
            session.close ( );
        }
}