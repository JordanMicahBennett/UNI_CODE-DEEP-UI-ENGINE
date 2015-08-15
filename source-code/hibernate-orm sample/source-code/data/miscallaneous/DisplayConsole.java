import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DisplayConsole
{
    
    public static void main ( String [ ] args ) 
    {
         read ( "" );
    }

    public static SessionFactory getSessionFactory (  )
    {
        Configuration configuration = new Configuration (  ).configure (  );
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder (  )
                .applySettings ( configuration.getProperties (  ) );
        SessionFactory sessionFactory = configuration
                .buildSessionFactory ( builder.build (  ) );
        return sessionFactory;
    }

    public static Integer create ( Songs e )
    {
        Session session = getSessionFactory (  ).openSession (  );
        session.beginTransaction (  );
        session.save ( e );
        session.getTransaction (  ).commit (  );
        session.close (  );
        System.out.println ( "Successfully created " + e.toString (  ) );
        return e.getId (  );
    }

    public static List <Songs> read ( String queryString ) 
    {
        Session session = getSessionFactory (  ).openSession (  );
        @SuppressWarnings ( "unchecked" )
        List<Songs> songs = session.createSQLQuery ( queryString ).list (  );
            for ( int i = 0; i < songs.size  (   ); i ++  )
                System.out.println  (  songs.get  (  i  ).getName  (   )  );
        session.close (  );
        System.out.println ( "Found " + songs.size (  ) + " songs" );
        return songs;
    }

    public static void update ( Songs e )
    {
        Session session = getSessionFactory (  ).openSession (  );
        session.beginTransaction (  );
        Songs em =  ( Songs ) session.load ( Songs.class, e.getId (  ) );
        //em.setName ( e.getName (  ) );
        //em.setAge ( e.getAge (  ) );
        session.getTransaction (  ).commit (  );
        session.close (  );
        System.out.println ( "Successfully updated " + e.toString (  ) );
    }

    public static void delete ( Integer id )
    {
        Session session = getSessionFactory (  ).openSession (  );
        session.beginTransaction (  );
        Songs e = findByID ( id );
        session.delete ( e );
        session.getTransaction (  ).commit (  );
        session.close (  );
        System.out.println ( "Successfully deleted " + e.toString (  ) );

    }

    public static Songs findByID ( Integer id )
    {
        Session session = getSessionFactory (  ).openSession (  );
        Songs e =  ( Songs ) session.load ( Songs.class, id );
        session.close (  );
        return e;
    }
    
    public static void deleteAll (  ) 
    {
        Session session = getSessionFactory (  ).openSession (  );
        session.beginTransaction (  );
        Query query = session.createQuery ( "DELETE FROM Songs " );
        query.executeUpdate (  );
        session.getTransaction (  ).commit (  );
        session.close (  );
        System.out.println ( "Successfully deleted all employees." );
    }
}
