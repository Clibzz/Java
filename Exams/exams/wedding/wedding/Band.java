import java.util.ArrayList;

/**
 * class Band - the band that plays at the wedding
 *
 * @author Chris Klunder
 * @version 07-07-2022
 */
public class Band
{
    //Fields
    public double fee;
    private ArrayList<Guest> members;
    
    //Constructor
    public Band(double fee)
    {
        this.fee = fee;
        this.members = new ArrayList<>();
    }
    
    //Methods
    public void setFee(double fee)
    {
        this.fee = fee;
    }
    
    public double getFee()
    {
        return this.fee;
    }
    
    public void addMembers(Guest guest)
    {
        this.members.add(guest);
    }
    
    public ArrayList getMembers()
    {
        return this.members;
    }
}
