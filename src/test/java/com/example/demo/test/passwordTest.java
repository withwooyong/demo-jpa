package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class passwordTest {

    @Autowired
    private CipherService cipherService;

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

    @Test
    void passwordTest() throws Exception {
        var result = getEncryptedPasswords("dijinda9405!");
        System.out.println(result.get(0));

        var result2 = Base64.getDecoder().decode(result.get(0));
        byte[] decodedBytes = Base64.getDecoder().decode(result.get(0));
        String decodedString = new String(decodedBytes);
        System.out.println(decodedString);
    }


}
