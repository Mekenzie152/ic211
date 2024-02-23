import java.util.*;
import ic211.*;

public class Week {
    // Grid to represent the availability of each period
    private boolean[][] periods; 

    // Constructor to create an empty week
    public Week() {
        periods = new boolean[5][6]; // 5 days, 6 periods
    }

    // Constructor to create a week based on a given meeting time pattern
    public Week(String pattern) {
        this();

        //the exploded meeting times will go into an array
        String[] meetings = DrBrown.explode(pattern);
        
        //for loop to go though the entire array and correctly allocating X's
        for (String meeting : meetings) {
            char day = meeting.charAt(0);
            int period = Integer.parseInt(String.valueOf(meeting.charAt(1))) - 1;
            switch (day) {
                case 'M': //Monday
                    periods[0][period] = true;
                    break;
                case 'T': //Tuesday
                    periods[1][period] = true;
                    break;
                case 'W': //Wednesday
                    periods[2][period] = true;
                    break;
                case 'R': //Thrusday
                    periods[3][period] = true;
                    break;
                case 'F': //Friday
                    periods[4][period] = true;
                    break;
                default:
                    System.out.println("Invalid day: " + day);
            }
        }
    }

    // Method to merge two weeks
    public void merge(Week other) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                periods[i][j] = periods[i][j] || other.periods[i][j];
            }
        }
    }

    //Method to print the grid
    public void printGrid() {
        //Print the headder of the week
        System.out.println("  M T W R F");

        //For loop to run though the array
        for (int i = 0; i < 6; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 5; j++) {
                
                //if there is a period present then print an x
                if (periods[j][i]) {
                    System.out.print("x ");

                //if there isn't a class dont print anything
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    //Testing the week class to make sure it works
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //to keep track of all the classes
        Week currentWeek = new Week();

        currentWeek.printGrid();

        //loop to run though the weeks until "quit" it given
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("quit")) {
                break;
            }

            //New input for the week
            Week newWeek = new Week(input);

            //Merging the two weeks to its all in one place
            currentWeek.merge(newWeek);

            //Print out the current week with the periods
            currentWeek.printGrid();
        }
    }
}
