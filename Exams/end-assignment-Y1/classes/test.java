import java.util.ArrayList; 
import java.util.Scanner; 
import java.util.Collections; 
import java.util.Random; 
/** 
* class Test - Digitale toets 
* 
* @author Chris Klunder 
* @version 1 
*/ 
public class Test 
{ 
    private String code;
    private ArrayList<Question> questions;
     
    public Test(String code) 
    { 
        this.code = code;
        questions = new ArrayList<Question>(); 
        
        Collections.shuffle(questions, new Random()); 
    } 
     
    public void addQuestion(Question question) 
    { 
        this.questions.add(question); 
    } 
    
    public ArrayList<Question> getQuestions()
    {
        return this.questions;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    public String getCode()
    {
        return this.code;
    }
    
    public void takeTest() 
    { 
        Scanner scan = new Scanner(System.in); 
        double correctAnswered = 0; 
        if(questions.isEmpty())
        {
            System.out.println("Voeg eerst vragen toe om de toets te kunnen maken!" );
        }
        else
        {
            for(int question = 0; question < questions.size(); question++) 
            { 
                System.out.println(questions.get(question).getQuestion()); 
                int numOptions = questions.get(question).getOptions().size(); 

                for(int option = 0; option < numOptions; option++) 
                { 
                    System.out.println((option + 1) + ": "  
                    + questions.get(question).getOptions().get(option)); 
                } 
                
                int answer = scan.nextInt(); 
                ArrayList<String> choiceSet = questions.get(question).getOptions(); 
                String correctAnswer = questions.get(question).getAnswer(); 
                int correctAnswerIndex = choiceSet.indexOf(correctAnswer);
                
                if (answer == correctAnswerIndex + 1) 
                { 
                    correctAnswered++; 
                }  
            } 
            scan.close();
            double grade = correctAnswered / questions.size() * 100; 
            grade = Math.round(grade * 100.0) / 100.0;
            if (grade > 55.0) 
            { 
                System.out.println("Je score is " + grade +  
                "%.\nJe hebt de toets gehaald!"); 
            } 
            else 
            { 
                System.out.println("Je score is " + grade +  
                "%.\nJe hebt de toets niet gehaald!"); 
            }
        }
    }
}