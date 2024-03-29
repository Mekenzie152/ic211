// Encryptor providing the Vigenere algorithm
public class Vigenere implements Encryptor {
    private String key;
   
    //initalizied the key for the cypher
    public Vigenere() {
        this.key = "";
    }
   
    //the name for the algrotim so it can be called
    public String getAlgName() {
        return "vigenere";
    }
   
    public void init(char[] key) throws IllegalArgumentException {
        for (char c : key) {
            if (c < 42 || c > 122) {
                throw new IllegalArgumentException("Key contains invalid characters. ASCII range allowed: 42-122.");
            }
        }
        this.key = new String(key);
    }
   
    public String encrypt(String plain) {
        if (key.isEmpty()) {
            throw new IllegalStateException("Key not initialized.");
        }
        StringBuilder cipher = new StringBuilder();
        int keyIndex = 0;
        for (char c : plain.toCharArray()) {
            if (c < 42 || c > 122) {
                throw new IllegalArgumentException("Plaintext contains invalid characters. ASCII range allowed: 42-122.");
            }
            int shift = key.charAt(keyIndex) - 42;
            int encryptedChar = ((c - 42 + shift) % 81) + 42;
            cipher.append((char) encryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
        }
        return cipher.toString();
    }
   
    public String decrypt(String cipher) {
        if (key.isEmpty()) {
            throw new IllegalStateException("Key not initialized.");
        }
        StringBuilder plain = new StringBuilder();
        int keyIndex = 0;
        for (char c : cipher.toCharArray()) {
            if (c < 42 || c > 122) {
                throw new IllegalArgumentException("Ciphertext contains invalid characters. ASCII range allowed: 42-122.");
            }
            int shift = key.charAt(keyIndex) - 42;
            int decryptedChar = ((c - 42 - shift + 81) % 81) + 42;
            plain.append((char) decryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
        }
        return plain.toString();
    }
 }
 