import java.util.*;
import java.io.*;

public class StringNode{

    public String data;
    public StringNode next; //next is automatically a pointer in Java 


    public static StringNode addToFront(String val, StringNode P) {
        StringNode temp = new StringNode();
        temp.data = val;
        temp.next = P;
        return temp;
    }

    public static int length(StringNode P) {
        if (P == null) {
            return 0;
        } else {
            return 1 + length(P.next);
        }
    }

    public static String[] listToArray(StringNode P) {
        int n = length(P);
        String[] newArray = new String[n];
        int pos = 0;
        for (StringNode X = P; X != null; X = X.next) {
            newArray[pos++] = X.data;
        }
        return newArray;
    }

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
