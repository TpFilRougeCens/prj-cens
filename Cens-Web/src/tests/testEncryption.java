package tests;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Gawel on 13/03/2016.
 */
public class testEncryption {

    public static void main(String[] args) {
        try {
            String key = "1234567890123456"; //MAX LENGHT 16CHARS
            String az = encrypt(key, "motdepasse");
            System.out.println(az);
            System.out.println(decrypt(key, az));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String encrypt(String key, String password) throws Exception {
        byte[] keyData = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(password.getBytes());
        return new BASE64Encoder().encode(hasil);
    }

    private static String decrypt(String key, String password) throws Exception {
        byte[] keyData = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(new BASE64Decoder().decodeBuffer(password));
        return new String(hasil);
    }
}
