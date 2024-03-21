import java.util.ArrayList; 
import java.util.Collections; 
/** 
* class Question - Digitale toets 
* 
* @author Chris Klunder 
* @version 1 
*/
public class Question 
{ 
    private String question; 
    private ArrayList<String> options; 
    private String answer; 
    
    public Question(String question, String[] options, String answer) 
    { 
        this.question = question; 
        this.options = new ArrayList<String>(); 
        for(int i = 0; i < options.length; i++) 
        { 
            this.options.add(options[i]); 
        } 
        Collections.shuffle(this.options); 
        this.answer = answer; 
    } 
    
    public String getQuestion() 
    { 
        return question; 
    } 
    
    public ArrayList<String> getOptions() 
    { 
        return options; 
    } 
    
    public String getAnswer() 
    { 
        return answer; 
    } 
} 