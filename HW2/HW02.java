import java.util.Scanner;

public class HW02
{
    public static int maxLength(String[] A)
    {
        int size = A.length;
        int lenghts[];
        lenghts = new int [size];

        for (int i = 0; i < size; i++)
        {
            lenghts[i] = A[i].length();
        }

        int max = 0;

        for ( int j = 0; j < size; j++)
        {
            if (max < lenghts[j])
            {
                max = lenghts[j];
            }
        }

        return max;
    }


    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        String library[];
        library = new String [size];

        for (int i = 0; i < size; i ++)
        {
            library[i] = scanner.next();
        }

        System.out.println(library[0]);
        System.out.println(library[1]);
        System.out.println(library[2]);
        System.out.println(maxLength(library));

    }
}