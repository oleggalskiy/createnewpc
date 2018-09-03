package by.epam.labproject.createmypc.controller.security;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AesCipher {
    private static final String INIT_VECTROR = "SaveYourPassword";

    public static String encrypt(String secretKey, byte[] plainText) {
        try {
            if (!isKeyLengthValid(secretKey)) {
                throw new Exception("secret key's length must be 128, 192 or 256 bits");
            }

            IvParameterSpec ivParameterSpec = new IvParameterSpec(INIT_VECTROR.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            return HexBin.encode(cipher.doFinal(plainText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static boolean isKeyLengthValid(String key){

        return key.length() == 16 || key.length() == 24 || 32 == key.length();
    }


}
