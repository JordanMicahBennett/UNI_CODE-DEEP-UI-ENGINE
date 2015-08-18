//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "subscriptions")
public class Subscriptions
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "type")
    String type;    
    
    @Column(name = "maximumSpins")
    int maximumSpins;
    
    public Subscriptions ( )
    {
    }
    
    //methods
        //accessors
        public int getId ( )
        {
            return id;
        }
        public String getType ( )
        {
            return type;
        }
        public int getMaximumSpins ( )
        {
            return maximumSpins;
        }     
        //mutators
        public void setId ( int value )
        {
            id = value;
        }
        public void setType ( String value )
        {
            type = value;
        }
        public void setMaximumSpins ( int value )
        {
            maximumSpins = value;
        }
}
