package service.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Gawel : 01/04/2016.
 */
public class EncryptPassword {
    private String KEY_ENCRYPTAGE = "XmdROtkOpSKlsAKd"; //MAX LENGHT 16CHARS

    /**
     * CRYPTAGE BASE 64
     * <p>
     * ALGORYHTME BLOWFISH
     *
     * @param password
     * @return
     */
    public String encrypt(String password) {
        String key = KEY_ENCRYPTAGE;  // TODO Variable global à l'application a faire au lancement serveur
        try {
            byte[] keyData = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] hasil = cipher.doFinal(password.getBytes());
            return new BASE64Encoder().encode(hasil);
        } catch (Exception e) {
            return password;
        }
    }

    /**
     * NE DOIT PAS ÊTRE UTILISE
     *
     * @param password
     * @return
     * @throws Exception
     */
    private String decrypt(String password) throws Exception {
        String key = KEY_ENCRYPTAGE;
        byte[] keyData = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(new BASE64Decoder().decodeBuffer(password));
        return new String(hasil);
    }
}
