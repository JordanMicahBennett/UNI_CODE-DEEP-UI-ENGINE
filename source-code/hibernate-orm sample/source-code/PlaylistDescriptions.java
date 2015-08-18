//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "playlistdescriptions")
public class PlaylistDescriptions
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "userId")
    int userId;   
    
    @Column(name = "name")
    String name;  
        
    public PlaylistDescriptions ( )
    {
    }
    
    //methods
        //accessors
        public int getId ( )
        {
            return id;
        }
        public int getUserId ( )
        {
            return userId;
        }
        public String getName ( )
        {
            return name;
        }
      
        //mutators
        public void setId ( int value )
        {
            id = value;
        }
        public void setUserId ( int value )
        {
            userId = value;
        }
        public void setName ( String value )
        {
            name = value;
        }
}
