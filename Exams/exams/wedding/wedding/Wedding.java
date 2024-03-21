import java.util.ArrayList;
import java.util.Iterator;

/**
 * class Wedding - the wedding
 *
 * @author Chris Klunder
 * @version 07-07-2022
 */
public class Wedding
{
    //Fields
    private double costs;
    private ArrayList<Guest> bridespair;
    private ArrayList<Guest> guests;
    private ArrayList<Meal> meals;
    private Band band;
    
    //Constructor
    public Wedding()
    {
        this.bridespair = new ArrayList<>();
        this.guests = new ArrayList<>();
        this.meals = new ArrayList<>();
    }
    
    //Methods
    public double getMealCosts()
    {
        //Loop through meals & get the total meal costs
        for(int index = 0; index < meals.size(); index++)
        {
            //Add the price of the meal to the previous costs (unfinished)
            this.costs += costs; //Wasn't able to get the meal price, so did this instead
        }
        
        //Check if meals.size > 120 for the discount
        if(meals.size() > 120)
        {
            this.costs = costs * 0.9;
            return this.costs;
        }
        else
        {
            return this.costs;
        }
    }
    
    public ArrayList removePersonsWithMoreThanFiveMeals()
    {
        Iterator<Guest> gIt = guests.iterator();
        while(gIt.hasNext())
        {
            Guest g = gIt.next();
            //Check if a guest has had more than five meals
            if(guests.get(meals.size()).meals.size() < 6)
            {
                gIt.remove();
            }
            //If noone has had more than 5 meals, return null
            else
            {
                return null;
            }
        }
        return this.guests;
    }
    
    public double getTotalCosts()
    {
        Iterator<Meal> mIt = meals.iterator();
        for(int index = 0; index < meals.size(); index++)
        {
            while(mIt.hasNext())
            {
                Meal m = mIt.next();
                //Add the costs of next meal to current costs (unfinished)
                this.costs += costs; //Wasn't able to get the meal price, so did this instead
                mIt.remove();
            }
        }
        return this.costs;
    }
    
    public double getTotalCostsWithBand()
    {
        //Add band costs to other costs
        this.costs = costs + band.fee;
        return this.costs;
    }
    
    public void addBridespair(Guest guest)
    {
        if(bridespair.size() < 2)
        {
            this.bridespair.add(guest);
        }
    }
    
    public ArrayList getBridespair()
    {
        return this.bridespair;
    }
    
    public void addGuests(Guest guest)
    {
        this.guests.add(guest);
    }
    
    public ArrayList getGuests()
    {
        return this.guests;
    }
    
    public void addMeals(Meal meal)
    {
        this.meals.add(meal);
    }
    
    public ArrayList getMeals()
    {
        return this.meals;
    }
    
    public void setBand(Band band)
    {
        this.band = band;
    }
    
    public Band getBand()
    {
        return this.band;
    }
}
