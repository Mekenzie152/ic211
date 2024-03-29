// Encryptor providing the Caesar-shift algorithm
public class Caesar implements Encryptor {
   private int shift;

   public String getAlgName() {
       return "caesar";
   }

   public void init(char[] key) {
       int sum = 18; // Initial sum for shift calculation
       for (int i = 0; i < key.length; i++) {
           if (key[i] < 42 || key[i] > 122) {
               throw new IllegalArgumentException("Invalid character in key. ASCII range allowed: 42-122.");
           }
           sum += key[i] - 42;
       }
       this.shift = (sum % 81) + 42; // Calculate shift value within ASCII range
   }

   public String encrypt(String plain) {
       StringBuilder cipher = new StringBuilder();
       for (char c : plain.toCharArray()) {
           if (c < 42 || c > 122) {
               throw new IllegalArgumentException("Plaintext contains invalid characters. ASCII range allowed: 42-122.");
           }
           int k = shift - 42;
           int p = c - 42;
           int cc = ((p + k) % 81) + 42;
           cipher.append((char) cc);
       }
       return cipher.toString();
   }

   public String decrypt(String cipher) {
       StringBuilder plain = new StringBuilder();
       for (char c : cipher.toCharArray()) {
           if (c < 42 || c > 122) {
               throw new IllegalArgumentException("Ciphertext contains invalid characters. ASCII range allowed: 42-122.");
           }
           int k = shift - 42;
           int cc = c - 42;
           int p = ((cc + (81 - k)) % 81) + 42;
           plain.append((char) p);
       }
       return plain.toString();
   }
}
