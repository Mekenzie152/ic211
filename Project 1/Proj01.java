import java.util.*;

public class Proj01 {

    public static void main(String[] args) {

        //Using the StringNode class organize the text file into 
        //an array
        String[] unorganizedData = StringNode.get(args[0]);

        //length of the arrays should be according to the data
        int len = unorganizedData.length / 4;

        //array to hold all of the class information
        classStruct[] info = new classStruct[len];
        for (int i = 0; i < len; i++) {
            info[i] = new classStruct();
        }

        //array to hold all of the classes the user added
        classStruct[] sched = new classStruct[len];
        for (int i = 0; i < len; i++) {
            sched[i] = new classStruct();
        }

        //initalazling the info array with the apportiatly data 
        //organized
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    //class number
                    info[i].num = unorganizedData[((i * 4) + j)];
                }
                if (j == 1) {
                    //class section
                    info[i].sect = unorganizedData[((i * 4) + j)];    
                }
                if (j == 2) {
                    //class meeting times
                    info[i].times = unorganizedData[((i * 4) + j)];
                }
                if (j == 3) {
                    //the room the class is in
                    info[i].room = unorganizedData[((i * 4) + j)];
                }
            }
        }

        //condition for the while loop to keep looping
        int loop = 0;
        Scanner sc = new Scanner(System.in);
        
        //tracker of the current amount of classes taking
        int schedNum = 0;

        //initalizer to be able to print out the weeks
        Week currentWeek = new Week();


        while (loop == 0) {
            System.out.print("> ");
            String cmd = sc.next();

            //this command prints out all the sections of a given 
            //class
            if (cmd.equals("sections")) {
                String section = sc.next();
                for (int i = 0; i < len; i++) {
                    if (info[i].num.equals(section)) {
                        info[i].printData();
                    }
                }

            //this command works like the linux man and serves to 
            //work as a way to veiw all of the classes in a 
            //text file
            } else if (cmd.equals("man")) {
                for (int i = 0; i < len; i++) {
                    info[i].printData();
                }

            //this command add a class to the users schedual 
            } else if (cmd.equals("add")) {
                //read in the class
                String cl = sc.next();

                //read in the section for the class
                String section = sc.next();

                //tester to see if the class was actually added
                int addedSucessfully = 0;

                //loop to add the class acording to the database
                for (int i = 0; i < len; i++) {
                    if (info[i].num.equals(cl)) {
                        if (info[i].sect.equals(section)) {
                            sched[schedNum] = info[i];
                            addedSucessfully++;
                            schedNum++;
                        }
                    }
                }

                //what to do if the class was not able to be added 
                //to the users schedual
                if (addedSucessfully == 0) {
                    System.out.println("Error! Section not found!");
                }

                //this will show all of the classes in the users 
                //schedual
            } else if (cmd.equals("show")) {
                for (int i = 0; i < schedNum; i++) {
                    sched[i].printData();
                }

                //this will show what a week looks like for the user
                // according to their schedual and shows what 
                //periods they have a class and which they have free
            } else if (cmd.equals("week")) {
                for (int i = 0; i < len; i++) {
                        if(sched[i].times != null){
                            Week newWeek = new Week(sched[i].times);
                        currentWeek.merge(newWeek);
                        }
                }
                currentWeek.printGrid();

            //exit the loop if the cmd quit is given
            } else if (cmd.equals("quit")) {
                loop = 1;

            //if the command is not listed above then print out below
            } else {
                System.out.println("Unknown command: " + cmd);       
            }
        }
    }
}