import java.util.*;

public class BProj1 {

    public static void main(String[] args) {
        String[] unorganizedData = StringNode.get(args[0]);
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
        Week currentWeek = new Week();
        while (loop == 0) {
            System.out.print("> ");
            String cmd = sc.next();
            if (cmd.equals("sections")) {
                String section = sc.next();
                for (int i = 0; i < len; i++) {
                    if (info[i].num.equals(section)) {
                        info[i].printData();
                    }
                }
            } else if (cmd.equals("man")) {
                for (int i = 0; i < len; i++) {
                    info[i].printData();
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
                    sched[i].printData();
                }
            } else if (cmd.equals("week")) {
                for (int i = 0; i < len; i++) {
                        if(sched[i].times != null){
                            Week newWeek = new Week(sched[i].times);
                        currentWeek.merge(newWeek);

                        }
                        
                
                }
                currentWeek.printGrid();
            } else if (cmd.equals("quit")) {
                loop = 1;
            } else {
                System.out.println("Unknown command: " + cmd);
            }
        }
    }
}
