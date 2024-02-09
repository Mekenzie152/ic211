import java.util.*;
import java.io.*;


public class part2 {
//adding a string to the front of StringNode P
    //temp StringNode to make the front of P
    public static StringNode addToFront(String val, StringNode P){
        
        StringNode temp = new StringNode();
        temp.data = val;
        temp.next = P;
        return temp;

    }
    
    //recursive function to calculate the length of a linked list
    public static int length(StringNode P){
         
        if (P == null) {
            return 0;
        }
        else {
            return 1+length(P.next);

        }
    }

    //converts a linked list into an array
    public static String[] listToArray(StringNode P){
        //Returns an array that stores the data in P
        int n = length(P);
        String[] newArray = new String[n];
        int pos = 0; 
        //for loop makes each index of the array the corresponding string in P
        for (StringNode X = P; X!=null; X = X.next){
            newArray[pos++] = X.data;
            }

        return newArray;


    } 

    //add data to the back of a linked list
    public static StringNode addToBack(String val, StringNode P){
        //This function takes in a string and a StringNode and adds the new string to the back of the linked lsit 
        StringNode newNode = new StringNode();
        //newNode is a linked list with one element: just th enew string to be added 
        newNode.data = val;
        newNode.next = null;

        //if the linked list is empty, make the linked list equal to newNode
        if (P.data == null){
            P = newNode;
            return P;
        } else {
        StringNode temp = P;
           while(temp.next!=null){
               //iterate through the linked list until you reach the end 
            temp = temp.next;
           }
        temp.next = newNode;
        return P; 
        }
    }
        
    //a function that takes in a file and stores everything in that file as an array 
    public static String[] get (String fname){
        StringNode words = new StringNode();
        Scanner zq = null;
        try { zq = new Scanner(new FileReader(fname)); } 
        catch(IOException e) { e.printStackTrace(); System.exit(1); }
        
        while (zq.hasNext()){
            words = addToBack(zq.next(), words);
        }

        String[] ourArray = listToArray(words);
        return ourArray;
        }

    //prints the information relating to the section
    public static void printData( classStruct info)
    {
        System.out.println ( info.num + " " + info.sect + " " + info.times + " " + info.room);
    }
    
    public static void main(String[] args) 
    {
           
        String[] unorganizedData = get(args[0]);
        int len = unorganizedData.length/4;

        classStruct[] info = new classStruct[len];


        for ( int i = 0; i < len; i++)
        {
            info[i] = new classStruct();
        }


        for ( int i = 0; i < len; i++)
        {
            for ( int j = 0; j < 4; j++)
            {
                if (j == 0)
                    {info[i].num = unorganizedData[((i*4)+j)];}
                if (j == 1)
                    {info[i].sect = unorganizedData[((i*4)+j)];}
                if (j == 2)
                    {info[i].times = unorganizedData[((i*4)+j)];}
                if (j == 3)
                    {info[i].room = unorganizedData[((i*4)+j)];}
            }
        }

        int loop = 0;

        Scanner sc = new Scanner(System.in);
        while (loop == 0)
        {
            String cmd = sc.next();

            if (cmd.equals("sections"))
            {
                String section = sc.next();
                for ( int i = 0; i < len; i ++)
                {
                    if( info[i].num.equals(section))
                    {
                        printData(info[i]);
                    }
                }
            }
            else if (cmd.equals("quit"))
            {
                loop = 1;
            }
            else
            {
                System.out.println("Unknown command: " + cmd);
            }

        }
    }
}