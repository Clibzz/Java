
/**
 * class Meal - a meal at the wedding
 *
 * @author Chris Klunder
 * @version 07-07-2022
 */
public class Meal
{
    //Fields
    private String name;
    private int price; // in euro's
    
    //Constructor
    public Meal(String name, int price)
    {
        this.name = name;
        this.price = price;
    }
    
    //Methods
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    public int getPrice()
    {
        return this.price;
    }
}
