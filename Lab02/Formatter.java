import java.util.Scanner;

public class Formatter
{

//  public static void writeInColumns (String[] sta, int cols)
//   {
    
//   }


public static void main(String[] args) {
    //Array holder for testing
    String sta[] = { "These", "are", "the", "times", "that", "try", "men's", "souls." }; 
    int staSize = sta.length;
    
    //Creating an array to list the sizes of each element in the inital array
    int size[] = new int [staSize];
    for ( int i = 0; i < staSize; i++)
    {
        size[i] = sta[i].length();
    }

    //Asking for the lenght of the collumn
    System.out.print("Enter the lenght of the cols you want: ");
    Scanner sc = new Scanner(System.in); 
    int cols = sc.nextInt();

    //Printing out the array in order of how many cols are desired
    int counter = 0;
    for ( int i = 0; i < staSize; i++)
    {
        if ( counter + size[i] <= cols)
        {
            System.out.print(sta[i]);
            counter = counter + size[i];
        }   
        else
        {
            System.out.println();
            System.out.print(sta[i]);
            counter = size[i];
        }


        if(counter == cols)
        {
            System.out.println();
            counter = 0;
        }
        else if(counter < cols)
        {
            System.out.print(" ");
            counter = counter + 1;
        }

        if( counter == cols)
        {
            System.out.println();
            counter = 0;
        }

        if(i + 1 == staSize)
        {
            System.out.println();
        }
    } 




   
}


}