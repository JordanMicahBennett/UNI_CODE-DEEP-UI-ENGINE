//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "subscriptionId")
    int subscriptionId;    
    
    @Column(name = "userId")
    int userId;
    
    @Column(name = "startDate")
    String startDate;   
    
    @Column(name = "endDate")
    String endDate;  
    
    public Accounts ( )
    {
    }
    
    //methods
        //accessors
        public int getId ( )
        {
            return id;
        }
        public int getSubscriptionId ( )
        {
            return subscriptionId;
        }
        public int getUserId ( )
        {
            return userId;
        }
        public String getStartDate ( )
        {
            return startDate;
        } 
        public String getEndDate ( )
        {
            return endDate;
        }        
        //mutators
        public void setId ( int value )
        {
            id = value;
        }
        public void setSubscriptionId ( int value )
        {
            subscriptionId = value;
        }
        public void setUserId ( int value )
        {
            userId = value;
        }
        public void setStartDate ( String value )
        {
            startDate = value;
        }
        public void setEndDate ( String value )
        {
            endDate = value;
        }   
}
