
public class Padcut implements Hasher {
    @Override
    public String getHashName() {
        return "padcut";
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

        // Take the first 16 characters as the hash
        return padded.substring(0, 16);
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
