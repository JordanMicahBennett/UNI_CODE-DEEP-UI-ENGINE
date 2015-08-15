//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "sharedplaylists")
public class Sharedplaylists
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "sourceUserId")
    int sourceUserId;    
    
    @Column(name = "targetUserId")
    int targetUserId;
    
    @Column(name = "playlistId")
    int playlistId;   
    
    @Column(name = "date")
    String date;  
    
    public Sharedplaylists ( )
    {
    }
    
    //methods
        //accessors
        public int getId ( )
        {
            return id;
        }
        public int getSourceUserId ( )
        {
            return sourceUserId;
        }
        public int getTargetUserId ( )
        {
            return targetUserId;
        }
        public int getPlaylistId ( )
        {
            return playlistId;
        } 
        public String getDate ( )
        {
            return date;
        }        
        //muators
        public void setId ( int value )
        {
            id = value;
        }
        public void setSourceUserId ( int value )
        {
            sourceUserId = value;
        }
        public void setTargetUserId ( int value )
        {
            targetUserId = value;
        }
        public void setPlaylistId ( int value )
        {
            playlistId = value;
        }
        public void setDate ( String value )
        {
            date = value;
        }   
}
