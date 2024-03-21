import java.util.ArrayList; 
/** 
* class Student - Digitale toets 
* 
* @author Chris Klunder 
* @version 1 
*/ 
public class Student 
{ 
    private String name; 
    private int number; 
    private ArrayList<Test> tests; 

    public Student(String name, int number) 
    { 
        this.name = name; 
        this.number = number;
        this.tests = new ArrayList<>(); 
    } 
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setNumber(int number)
    {
        this.number = number;
    }
    
    public int getNumber()
    {
        return this.number;
    }
    
    public void addTest(Test test) 
    { 
        this.tests.add(test); 
    } 

    public ArrayList<Test> getTests() 
    { 
        return this.tests; 
    } 
}