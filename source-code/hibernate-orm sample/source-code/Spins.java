//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "spins")
public class Spins
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "userId")
    int userId;    
    
    @Column(name = "date")
    String date;
    
    @Column(name = "songId")
    int songId;   
    
    @Column(name = "artisteId")
    int artisteId;  
    
    
    public Spins ( )
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
        public String getDate ( )
        {
            return date;
        }
        public int getSongId ( )
        {
            return songId;
        } 
        public int getArtisteId ( )
        {
            return artisteId;
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
        public void setDate ( String value )
        {
            date = value;
        }
        public void setSongId ( int value )
        {
            songId = value;
        } 
        public void setArtisteId ( int value )
        {
            artisteId = value;
        }
}
