import java.util.*;
import java.io.*;

public class Proj01 {

    public static class classStruct {
        public String num;
        public String sect;
        public String times;
        public String room;
    }

    // Adding methods for Week functionality
    public static Week currentSchedule = new Week(); // Creating an instance of the Week class

    // Method to print the current schedule
    public static void printWeek() {
        currentSchedule.printGrid();
    }

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

    public static void printData(classStruct info) {
        System.out.println(info.num + " " + info.sect + " " + info.times + " " + info.room);
    }

    public static void main(String[] args) {
        String[] unorganizedData = get(args[0]);
        int len = unorganizedData.length / 4;
        classStruct[] info = new classStruct[len];
        for (int i = 0; i < len; i++) {
            info[i] = new classStruct();
        }
        classStruct[] sched = new classStruct[len];
        for (int i = 0; i < len; i++) {
            sched[i] = new classStruct();
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    info[i].num = unorganizedData[((i * 4) + j)];
                }
                if (j == 1) {
                    info[i].sect = unorganizedData[((i * 4) + j)];
                }
                if (j == 2) {
                    info[i].times = unorganizedData[((i * 4) + j)];
                }
                if (j == 3) {
                    info[i].room = unorganizedData[((i * 4) + j)];
                }
            }
        }
        int loop = 0;
        Scanner sc = new Scanner(System.in);
        int schedNum = 0;
        while (loop == 0) {
            System.out.print("> ");
            String cmd = sc.next();
            if (cmd.equals("sections")) {
                String section = sc.next();
                for (int i = 0; i < len; i++) {
                    if (info[i].num.equals(section)) {
                        printData(info[i]);
                    }
                }
            } else if (cmd.equals("man")) {
                for (int i = 0; i < len; i++) {
                    printData(info[i]);
                }
            } else if (cmd.equals("add")) {
                String cl = sc.next();
                String section = sc.next();
                int addedSucessfully = 0;
                for (int i = 0; i < len; i++) {
                    if (info[i].num.equals(cl)) {
                        if (info[i].sect.equals(section)) {
                            sched[schedNum] = info[i];
                            addedSucessfully++;
                            schedNum++;
                        }
                    }
                }
                if (addedSucessfully == 0) {
                    System.out.println("Error! Section not found!");
                }
            } else if (cmd.equals("show")) {
                for (int i = 0; i < schedNum; i++) {
                    printData(sched[i]);
                }
            } else if (cmd.equals("week")) {
                printWeek(); // Command to print the week grid
            } else if (cmd.equals("quit")) {
                loop = 1;
            } else {
                System.out.println("Unknown command: " + cmd);
            }
        }
    }
}
