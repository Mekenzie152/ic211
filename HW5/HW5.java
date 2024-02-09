public class HW5
{

  //Method to capitalize the numbers for the song
  public static String capitalize(String str)   
  {  
    if (str == null || str.length() == 0) return str;  
    return str.substring(0, 1).toUpperCase() + str.substring(1);  
  }  


  public static void main(String[] args)
  {
    //Setting the length of the song as an it so it can be modifed in length if
    // needed
    int songLength = 99;

    //Creating a list of number written out in strings so it can be printed out
    // in words
    Countdown A = new Countdown(songLength,1);
    
    //Counter to hold the place of where we are in the song so approprate 
    //measures can be takes to print the right words
    int start = 0;

    //While loop to loop though all the lyrics needed for the song
    while(!A.done())
    {

        //The number in word form to be printed
        String temp = A.next();

        //The capitalized number
        String Ctemp = capitalize(temp);

        //If we are on the fist line print the number only two times
        if( start == 0)
        {
            System.out.println( Ctemp + " bottles of beer on the wall, " + 
                                temp + " bottles of beer.");
            System.out.print("Take one down and pass it around, ");
        }

        //To print all of the lyrics exept for the last ones
        else if (start != 0 && start != (songLength-1))
        {
            //Print out the number three times beczuse for most of the song 
            //each number is printed out three times
            for (int i = 0; i < 3; i++)
            {
                //when i == 0 --> the first time the number is printed
                //when i == 1 --> the second time the number is printed
                //when i == 2 --> the third time the number is printed

                //for the second print print the number capitalized otherwise 
                //print lowercase
                if( i == 1)
                {
                    System.out.print(Ctemp + " bottles of beer");
                }
                else if ( i == 0 || i == 2 )
                {
                System.out.print(temp + " bottles of beer");
                }

                //For all exept the third print, print the following lyrics on 
                //top of the previous lyrics
                if (i == 0 || i == 1 )
                {
                    System.out.print(" on the wall");
                }

                //The puncutation for all exept the second print use a period
                if( i == 0 || i == 2)
                {
                    System.out.println(".");
                }

                //the second print requires a print for puncutation
                if(i == 1)
                {
                    System.out.print(", ");
                }

                //print this out after the last time the number is called
                if( i == 2)
                {
                    System.out.print("Take one down and pass it around, ");
                }

                //after the first call print a new line to formatt the lyrics
                // properly
                if ( i == 0 )
                {
                    System.out.println();
                }
            }
        }

    //For the last line of the song lyrics print out a modfied version to fit 
    //the proper grammer needed 
    else if ( start == (songLength-1))
    {
        System.out.println(temp + " bottle of beer on the wall.");
        System.out.println();
        System.out.println(Ctemp + " bottle of beer on the wall, " + temp + 
                            " bottle of beer.");
        System.out.println("Take one down and pass it around, no more bottles" 
                            + " of beer on the wall.");
    }

    //Increment the coumter to be able to tell where we are on the song
    start++;

    }
  }

 
}