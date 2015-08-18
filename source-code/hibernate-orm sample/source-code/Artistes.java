//Author: Jordan Micah Bennett
import javax.persistence.*;

@Entity
@Table(name = "artistes")
public class Artistes
{
    @Id @GeneratedValue
    @Column(name = "id")
    int id;
    
    @Column(name = "alias")
    String alias;    
    
    @Column(name = "balance")
    double balance;
    
    @Column(name = "owedBalance")
    double owedBalance;   
    
    @Column(name = "joinDate")
    String joinDate;  
    
    public Artistes ( )
    {
    }
    
    //methods
        //accessors
        public int getId ( )
        {
            return id;
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
        //mutators
        public void setId ( int value )
        {
            id = value;
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
        public void setDate ( String value )
        {
            joinDate = value;
        }   
}
