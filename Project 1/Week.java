import java.util.*;

public class Week {
    private boolean[][] periods; // Grid to represent the availability of each period

    // Constructor to create an empty week
    public Week() {
        periods = new boolean[5][6]; // 5 days, 6 periods
    }

    // Constructor to create a week based on a given meeting time pattern
    public Week(String pattern) {
        this();
        String[] meetings = DrBrown.explode(pattern);
        for (String meeting : meetings) {
            char day = meeting.charAt(0);
            int period = Integer.parseInt(String.valueOf(meeting.charAt(1))) - 1;
            switch (day) {
                case 'M':
                    periods[0][period] = true;
                    break;
                case 'T':
                    periods[1][period] = true;
                    break;
                case 'W':
                    periods[2][period] = true;
                    break;
                case 'R':
                    periods[3][period] = true;
                    break;
                case 'F':
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

    // Method to print the grid
    public void printGrid() {
        System.out.println("  M T W R F");
        for (int i = 0; i < 6; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 5; j++) {
                if (periods[j][i]) {
                    System.out.print("x ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Week currentWeek = new Week();

        System.out.println("Enter meeting patterns (e.g., MWF3,T34), or type 'quit' to exit:");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("quit")) {
                break;
            }
            Week newWeek = new Week(input);
            currentWeek.merge(newWeek);
            currentWeek.printGrid();
        }
        scanner.close();
    }
}
