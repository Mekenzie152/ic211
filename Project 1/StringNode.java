import java.util.*;
import java.io.*;

public class StringNode{

    public String data;
    public StringNode next; //next is automatically a pointer in Java 


    //this adds to the front of a linked list
    public static StringNode addToFront(String val, StringNode P) {
        StringNode temp = new StringNode();
        temp.data = val;
        temp.next = P;
        return temp;
    }

    //this gives the lenght of a linked list
    public static int length(StringNode P) {
        if (P == null) {
            return 0;
        } else {
            return 1 + length(P.next);
        }
    }

    //this turns a liked list into an array
    public static String[] listToArray(StringNode P) {
        int n = length(P);
        String[] newArray = new String[n];
        int pos = 0;
        for (StringNode X = P; X != null; X = X.next) {
            newArray[pos++] = X.data;
        }
        return newArray;
    }

    //this added to the back of a linked list
    public static StringNode addToBack(String val, StringNode P) {
        StringNode newNode = new StringNode();
        newNode.data = val;
        newNode.next = null;
        if (P.data == null) {
            P = newNode;
            return P;
        } else {
            StringNode temp = P;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            return P;
        }
    }

    //this reads in a file and turns the text in it into a string array
    public static String[] get(String fname) {
        StringNode words = new StringNode();
        Scanner zq = null;
        try {
            zq = new Scanner(new FileReader(fname));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (zq.hasNext()) {
            words = addToBack(zq.next(), words);
        }
        String[] ourArray = listToArray(words);
        return ourArray;
    }
}
