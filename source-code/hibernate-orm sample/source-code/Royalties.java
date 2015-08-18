//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "royalties")
public class Royalties
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "songRate")
    double songRate;   
    
    @Column(name = "featureRate")
    double featureRate;  
        
    public Royalties ( )
    {
    }
    
    //methods
        //accessors
        public int getId ( )
        {
            return id;
        }
        public double getSongRate ( )
        {
            return songRate;
        }
        public double getFeatureRate ( )
        {
            return featureRate;
        }
      
        //mutators
        public void setId ( int value )
        {
            id = value;
        }
        public void setSongRate ( double value )
        {
            songRate = value;
        }
        public void setFeatureRate ( double value )
        {
            featureRate = value;
        }
}
