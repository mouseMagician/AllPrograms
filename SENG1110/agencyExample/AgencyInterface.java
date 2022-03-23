import java.util.*;

public class AgencyInterface 
{ 
    private void run() 
    {
       Scanner console = new Scanner(System.in);
       Couple c = new Couple();
       int      age, end;
       String   name;
       
       do {
           System.out.println("first person: "); 
           System.out.print("name: "); 
           name = console.next(); 
           age = inputAge();
           c.addData(1,name,age);

           System.out.println("second person: "); 
           System.out.print("name: "); 
           name = console.next();
           age = inputAge();
           c.addData(2,name,age);

           System.out.println("********************");
           System.out.println(c.test());           
           System.out.println("********************");
           System.out.print("Quit? (0)yes (1)no: "); 
           end = console.nextInt();
           }
       while (end!=0);
    }
    public static void main(String[] args)
    {
           AgencyInterface agency = new AgencyInterface ();
           agency.run();
    }
    public int inputAge()
    {
        int age;
        Scanner console = new Scanner(System.in);
        
        System.out.print("age: ");
        age = console.nextInt();
        while (age < 18) {
            System.out.println("Please enter an age >= 18");
            age = console.nextInt();
        }
        return age;
    }

    }