//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Songs
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "artisteId")
    int artisteId;   
    
    @Column(name = "duration")
    int duration;  
    
    @Column(name = "date")
    String date;
        
    public Songs ( )
    {
    }
    
    //methods
        //accessors
        public int getId ( )
        {
            return id;
        }
        public int getArtisteId ( )
        {
            return artisteId;
        }
        public int getDuration ( )
        {
            return duration;
        }
        public String getDate ( )
        {
            return date;
        } 
      
        //mutators
        public void setId ( int value )
        {
            id = value;
        }
        public void setArtisteId ( int value )
        {
            artisteId = value;
        }
        public void setDuration ( int value )
        {
            duration = value;
        }
        public void setDate ( String value )
        {
            date = value;
        }
}
