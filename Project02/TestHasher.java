// import java.util.ArrayList;
// import java.util.Scanner;

// public class TestHasher {
//     public static void main(String[] args) {

//         ArrayList<Hasher> E = new ArrayList<Hasher>();
//         E.add(new Padcut());

//         Scanner scanner = new Scanner(System.in);

//         System.out.print("algorithm: ");
//         String encalg = System.console().readLine();
//         System.out.print("password : ");
//         String password = System.console().readLine();

//     // Find index of encryptor (throw exception if not found)
//     int i = -1;
//     try { while(!E.get(++i).getHashName().equals(encalg)); }
//     catch(Exception e) {
//       throw new Exception("Unknown algorithm '"+encalg+"'.");
//     }


//         try {
//             String hashed = E.get(i).hash(password);
//             System.out.println("password read : " + password);
//             System.out.println("hash computed : " + hashed);
//         } catch (IllegalArgumentException e) {
//             System.err.println(e.getMessage());
//             System.exit(1); // Exit with error status
//         } finally {
//             scanner.close();
//         }
//     }
// }




import java.util.ArrayList;
import java.util.Scanner;

public class TestHasher {
    public static void main(String[] args) throws Exception { // Add throws Exception
        ArrayList<Hasher> E = new ArrayList<Hasher>();
        E.add(new Padcut());

        Scanner scanner = new Scanner(System.in);

        System.out.print("algorithm: ");
        String encalg = scanner.nextLine(); // Use scanner instead of System.console().readLine()
        System.out.print("password : ");
        String password = scanner.nextLine();

        // Find index of hasher (throw exception if not found)
        int i = -1;
        try {
            while (!E.get(++i).getHashName().equals(encalg)) ;
        } catch (Exception e) {
            throw new Exception("Unknown algorithm '" + encalg + "'.");
        }

        try {
            String hashed = E.get(i).hash(password); // Call hash method correctly
            System.out.println("password read : " + password);
            System.out.println("hash computed : " + hashed);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1); // Exit with error status
        } finally {
            scanner.close();
        }
    }
}
