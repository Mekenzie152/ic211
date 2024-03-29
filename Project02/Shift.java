//import java.lang.*;

public class Shift implements Hasher {

    @Override
    public String getHashName() {
        return "shift+";
    }

    @Override
    public String hash(String plain) {
        // Check if plain is within ASCII range 42-122
        if (!isWithinASCII(plain)) {
            throw new IllegalArgumentException("Input contains characters outside ASCII range 42-122.");
        }

        // Pad the message if it's shorter than 16 characters
        StringBuilder padded = new StringBuilder(plain);
        while (padded.length() < 16) {
            padded.append('x');
        }

        char first = s.charAt(0);
        for ( int i = 0; i < 16; i ++)
        {
            if( i != 15){

                char temp = padded.charAt(i+1);
                padded.setCharAt(i, temp);
            }

            if (i == 15){
                System.out.println(first);
                padded.setCharAt(15, first);
            }
        }

        // Take the first 16 characters as the hash
        return padded.substring(0, 15);
    }

    // Helper method to check if a string is within ASCII range 42-122
    private boolean isWithinASCII(String str) {
        for (char c : str.toCharArray()) {
            if (c < 42 || c > 122) {
                return false;
            }
        }
        return true;
    }
}
