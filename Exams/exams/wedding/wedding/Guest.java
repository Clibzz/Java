import java.util.ArrayList;

/**
 * class Guest - a guest of the wedding
 *
 * @author Chris Klunder
 * @version 07-07-2022
 */
public class Guest
{
    //Fields
    private String name;
    public ArrayList<Meal> meals;
    
    //Constructor
    public Guest(String name)
    {
        this.name = name;
        this.meals = new ArrayList<>();
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
    
    public void addMeal(Meal meal)
    {
        //Check if the name of a meal equals a name of a meal from the wedding
        if(meals.equals("Test")) 
        //^ Wasn't able to access the meal names from the wedding, 
        //so I used test data instead 
        //and changed back some public into privates in other classes that were supposed to be used here
        {         
            this.meals.add(meal);
        }
    }
    
    public ArrayList getMeals()
    {
        return this.meals;
    }
}
