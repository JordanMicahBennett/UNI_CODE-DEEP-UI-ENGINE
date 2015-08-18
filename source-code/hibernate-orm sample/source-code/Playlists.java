//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "playlists")
public class Playlists
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "userId")
    int userId;   
    
    @Column(name = "songId")
    int songId;  
        
    public Playlists ( )
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
        public int getSongId ( )
        {
            return songId;
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
        public void setSongId ( int value )
        {
            songId = value;
        }
}
