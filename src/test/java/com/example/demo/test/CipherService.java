package com.example.demo.test;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.List;

@Component
public class CipherService {

    public String encryptSha256ForCertKey(final String plainText) throws RuntimeException {

        try {
            final var md = MessageDigest.getInstance("SHA-256");
            var bytes = plainText.getBytes(StandardCharsets.UTF_8);

            var hash = md.digest(bytes);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < hash.length; ++i) {
                String hex = Integer.toHexString(255 & hash[i]);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException("SHA512 암호화를 수행할 수 없습니다.", e);
        }
    }

    public String encryptSha512(final String plainText) throws RuntimeException {

        try {
            final var md = MessageDigest.getInstance("SHA-512");
            var bytes = plainText.getBytes(StandardCharsets.UTF_8);
            md.update(bytes);
            return new String(java.util.Base64.getEncoder().encode(md.digest()));
        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException("SHA512 암호화를 수행할 수 없습니다.", e);
        }
    }

    public List<String> getEncryptedPasswords(final String password) {

        return Arrays.asList(
                encryptSha512(password),
                encryptSha512(password.replaceAll("&", "&amp;")));
    }

    public String encryptAes128(final String payload) throws Exception {

        String pwd = "39390175037861139670583729278277";
        String iv = "47225728464519274011157869533216";
        String salt = "12345678";
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(pwd.toCharArray(), hex2bin(salt), 1024, 128);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

        byte[] iv_bytes = hex2bin(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv_bytes);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret, ivSpec);

        byte[] encrypted = cipher.doFinal(payload.getBytes());

        return bin2hex(encrypted);
    }

    public String decryptAes128(final String payload) throws Exception {

        final var pwd = "39390175037861139670583729278277";
        final var iv = "47225728464519274011157869533216";
        final var salt = "12345678";

        final var factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        final KeySpec spec = new PBEKeySpec(pwd.toCharArray(), hex2bin(salt), 1024, 128);
        final var tmp = factory.generateSecret(spec);
        final SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

        final var iv_bytes = hex2bin(iv);
        final var ivSpec = new IvParameterSpec(iv_bytes);

        final var cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secret, ivSpec);

        final var payload_bytes = hex2bin(payload);
        final var decrypted = cipher.doFinal(payload_bytes);

        return new String(decrypted);
    }

    private byte[] hex2bin(final String str) {

        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return null;
        } else {
            int len = str.length() / 2;
            final var buffer = new byte[len];
            try {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
                }
            } catch (Exception e) {
                return null;
            }
            return buffer;
        }
    }

    private String bin2hex(byte[] data) {

        if (data == null) {
            return null;
        }

        int len = data.length;
        String str = "";
        for (int i = 0; i < len; i++) {
            if ((data[i] & 0xFF) < 16)
                str = str + "0" + Integer.toHexString(data[i] & 0xFF);
            else
                str = str + Integer.toHexString(data[i] & 0xFF);
        }
        return str;
    }
}
