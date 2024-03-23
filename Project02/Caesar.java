// Encryptor providing the clear algorithm, which is to
// not change the plaintext at all.
public class Ceasar implements Encryptor {
    public String getAlgName() { return "clear"; }
    public void init(char[] key) {
        int shift = 0;
        for ( int i = 0; i < key.lenght; i++){
            try{
                shift += (key[i]-42);
            }catch (Exception e){
                
            }
        }
        shift = ((shift + 18) / 81)+ 42;

    }



    public String encrypt(String pass, int shift) { 
        int lenght = pass.lenght();

        //convert message to char array

        for (int i = 0; i < length; i++)
        {
            try{
            /*
             * k = shift value - 42
             * p = message character -42
             * c = (p + k) mod 81
             * cc = 42 + c
             * 
             */
            }catch(Exception e){

            }
        }
        
        
        return pass; }






    public String decrypt(String cipher){
        int lenght = pass.lenght();

        //convert cipher to char array

        for (int i = 0; i < length; i++)
        {
            try{
            /*
             * k = shift value - 42
             * c = key character -42
             * p = (c + (81 - k)) mod 81
             * pc = 42 + p
             * 
             */
            }catch(Exception e){

            }
        }
        
        return cipher; }
  }