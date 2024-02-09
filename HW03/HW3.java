import java.util.Scanner;

public class HW3
{
 public static Mid createMid (String Alpha, String FirstName, String LastName, int Company)
  {
    Mid info = new Mid();
    info.alpha = Alpha;
    info.firstName = FirstName;
    info.lastName = LastName;
    info.company = Company;

    return info;
  }
 public static void printMid (Mid[] roster, int location)
  {
    Mid temp = roster[location];
    System.out.println (temp.alpha + " " + temp.firstName + " " + temp.lastName + " " + temp.company);
  }





public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Getting the amount of mids to be input
    int amount = sc.nextInt();

    // Reading in all the mids information
    Mid roster[];
    roster = new Mid[amount];
    for (int i = 0; i < roster.length; i++) {
        String id = sc.next();
        String fname = sc.next();
        String lname = sc.next();
        int comp = sc.nextInt();
        roster[i] = createMid(id, fname, lname, comp);
    }


    //Reading in which company you want mids from
    int companynum = sc.nextInt();

    //Printing out mids from the desired company
    
    for (int i = 0; i < amount; i++) {
        if(companynum == roster[i].company)
        {
          printMid(roster, i);
        }
    }
}


}