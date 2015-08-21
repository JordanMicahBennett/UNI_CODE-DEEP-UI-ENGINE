import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SQLComposer
{
    public SQLComposer ( )
    {
         
    }
 
    
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
    
    public void insertItem ( String message, int sourseUserId, int targetUserId, int playlistId, String date )
    {
        System.out.println ( message + ":\n" );
        
        Session session = getSessionFactory ( ).openSession ( );

        //Add new Employee object
        Sharedplaylists _Sharedplaylists = new Sharedplaylists ( );
        _Sharedplaylists.setId ( 0 );
        _Sharedplaylists.setSourceUserId ( sourseUserId );
        _Sharedplaylists.setTargetUserId ( targetUserId );
        _Sharedplaylists.setPlaylistId ( playlistId );
        _Sharedplaylists.setDate ( date );
         
        //Save the employee in database
        session.save ( _Sharedplaylists );
 
        session.close ( );
    }
}