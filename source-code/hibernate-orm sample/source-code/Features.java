//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "features")
public class Features
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "artisteId")
    int artisteId;   
    
    @Column(name = "subCount")
    int subCount;  
    
    @Column(name = "mainCount")
    int mainCount;
        
    public Features ( )
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
        public int getSubCount ( )
        {
            return subCount;
        }
        public int getMainCount ( )
        {
            return mainCount;
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
        public void setSubCount ( int value )
        {
            subCount = value;
        }
        public void setMainCount ( int value )
        {
            mainCount = value;
        }
}
