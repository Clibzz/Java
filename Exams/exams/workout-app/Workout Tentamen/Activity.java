
/**
 * class Activity - An activity that can be added to a workout
 *
 * @author Chris Klunder
 * @version 01-07-2022
 */
public class Activity
{
    // Fields
    public String name;
    public int duration; // In seconds
    
    // Constructor
    public Activity(String name, int duration)
    {
        this.name = name;
        this.duration = duration;
    }
    
    // Getters & setters
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    
    public int getDuration()
    {
        return this.duration;
    }
}
