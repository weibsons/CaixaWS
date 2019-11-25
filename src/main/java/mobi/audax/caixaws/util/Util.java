/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.util;

import java.security.MessageDigest;
import java.text.Normalizer;
import java.util.Base64;

/**
 *
 * @author links
 */
public class Util {

    public static String sha256Base64(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(data.getBytes("ISO8859-1"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String onlyNumber(String s) {
        StringBuilder builder = new StringBuilder();
        if (s != null) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    builder.append(s.charAt(i));
                }
            }
        }
        return builder.toString();
    }

    public static String unaccent(String s) {
        return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String alphanumeric(String s) {
        StringBuilder alphanumeric = new StringBuilder();
        if (s != null) {
            int blankcount = 0;
            for (int i = 0; i < s.length(); i++) {
                char character = s.charAt(i);
                if (Character.isWhitespace(character)) {
                    blankcount++;
                } else {
                    blankcount = 0;
                }
                if (blankcount <= 1) {
                    if (Character.isLetterOrDigit(character) || Character.isWhitespace(character)) {
                        alphanumeric.append(s.charAt(i));
                    }
                }
            }
        }
        return alphanumeric.toString().trim();
    }
}
