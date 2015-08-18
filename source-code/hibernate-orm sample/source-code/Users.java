//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "firstName")
    String firstName;    
    
    @Column(name = "lastName")
    String lastName;
    
    @Column(name = "alias")
    String alias;   
    
    @Column(name = "balance")
    double balance;  
    
    @Column(name = "owedBalance")
    double owedBalance;    
    
    @Column(name = "joinDate")
    String joinDate;
    
    @Column(name = "accountId")
    int accountId;   
    
    @Column(name = "playlistId")
    int playlistId; 
    
    
    public Users ( )
    {
    }
    
    //methods
        //accessors
        public int getId ( )
        {
            return id;
        }
        public String getFirstName ( )
        {
            return firstName;
        }
        public String getLastName ( )
        {
            return lastName;
        }
        public String getAlias ( )
        {
            return alias;
        } 
        public double getBalance ( )
        {
            return balance;
        }        
        public double getOwedBalance ( )
        {
            return owedBalance;
        }
        public String getJoinDate ( )
        {
            return joinDate;
        }
        public int getAccountId ( )
        {
            return accountId;
        } 
        public double getPlaylistId ( )
        {
            return playlistId;
        }        
        //mutators
        public void setId ( int value )
        {
            id = value;
        }
        public void setFirstName ( String value )
        {
            firstName = value;
        }
        public void setLastName ( String value )
        {
            lastName = value;
        }
        public void setAlias ( String value )
        {
            alias = value;
        } 
        public void setBalance ( double value )
        {
            balance = value;
        }        
        public void setOwedBalance ( double value )
        {
            owedBalance = value;
        }
        public void setJoinDate ( String value )
        {
            joinDate = value;
        }
        public void setAccountId ( int value )
        {
            accountId = value;
        } 
        public void setPlaylistId ( int value )
        {
            playlistId = value;
        }    
}
