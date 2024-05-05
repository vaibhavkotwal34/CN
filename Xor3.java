public class Xor4 {
    public static void main(String args[]) {
        String Msg = "SSBTCOET";
        char Key = 'a';
        String CTxt = "";
        String DTxt = "";

        // Encryption
        for (int i = 0; i < Msg.length(); i++) {
            int xor = Msg.charAt(i) ^ Key;
            char temp = (char) xor;
            CTxt += temp;
        }

        // Decryption
        for (int i = 0; i < CTxt.length(); i++) {
            int xor1 = CTxt.charAt(i) ^ Key;
            char temp1 = (char) xor1;
            DTxt += temp1;
        }

        // Output
        System.out.println("Encryption and Decryption using XOR Cryptogrpahy");
        System.out.println("Original Message is: " + Msg);
        System.out.println("Encrypted Message is: " + CTxt);
        System.out.println("Decrypted Message is: " + DTxt);
    }
}
