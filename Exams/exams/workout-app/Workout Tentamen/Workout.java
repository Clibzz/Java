import java.util.ArrayList;
import java.util.Iterator;

/**
 * class Workout - A workout
 *
 * @author Chris Klunder
 * @version 01-07-2022
 */
public class Workout
{
    // Fields
    private String title;
    private double difficulty;
    private ArrayList<Activity> activities;
    private int startTime;
    private int nextStartTime;
    private int breakDuration;
    private int workoutDuration;
    
    
    // Constructor
    public Workout(String title, double difficulty)
    {
        this.title = title;
        // Check if the filled in difficulty is a legitimate difficulty, if not, set it to 1.0
        if(difficulty <= 5)
        {
            this.difficulty = difficulty;
        }
        else
        {
            this.difficulty = 1;  
        }
        this.activities = new ArrayList<>();
        this.breakDuration = 0;
        this.workoutDuration = 0;
    }
    
    // Methods
    // A method to get the total amount of break time from a workout in seconds
    public int getBreakDuration()
    {
        int index = 0;
        int activityAmount = activities.size();
        while(index < activityAmount)
        {
            this.breakDuration += 10;
            activityAmount --;
        }
        return this.breakDuration;
    }
    
    // Check duration of a workout
    public String checkWorkoutDuration()
    {
        if(workoutDuration <= 600)
        {
            return "This workout is under 10 minutes";
        }
        return "This workout is too long"; 
    }
    
    // Getters & setters and Getters & adders
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void setDifficulty(double difficulty)
    {
        // Check if the filled in difficulty is a legitimate difficulty, if not, set it to 1.0
        if(difficulty <= 5)
        {
            this.difficulty = difficulty;
        }
        else
        {
            this.difficulty = 1;
        }
    }
    
    public double getDifficulty()
    {
        return this.difficulty;
    }
    
    // Add an activity, calculate the nextStartTime and set the workoutDuration
    public void addActivity(Activity activity)
    {
        if(activities.isEmpty())
        {
            this.startTime = 0;
            this.nextStartTime = startTime + activity.duration;
        }
        else
        {
            // Calculate the nextStartTime by adding the duration & the breakDuration
            this.nextStartTime = nextStartTime + activity.duration + 10;
        }
        this.activities.add(activity);
        this.workoutDuration = workoutDuration + activity.duration;
        
    }
    
    public ArrayList getActivities()
    {
        return this.activities;
    }
    
    public int getWorkoutDuration()
    {
        return this.workoutDuration;
    }
}
