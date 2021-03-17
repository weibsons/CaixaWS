/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.Normalizer;
import java.util.Base64;
import org.apache.commons.lang3.StringUtils;

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

    public static String smartCut(String text, int length) {
        return (StringUtils.isNotBlank(text) && text.length() > length) ? text.substring(0, length) : text;
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

    /**
     * Função estatica para adicionar zero a esquerda e manté-los no respectivo
     * numeral. <br /> O valor de zeros para adicionar não deve ser superior a
     * String completa, por exemplo. <br /><br />
     *
     * valor = 123<br /> zeros = 2<br /><br />
     *
     * Retornará exceção a quantidade de zeros deve ser igual ou maior ao
     * numeral informado.<br /><br />
     *
     * Forma correta:<br /><br />
     *
     * valor = 123<br /> zeros = 4<br /><br /> retorno 0123 (quatro algarimos)
     *
     *
     * @param BigInteger valor Valor que deseja adicionar zeros
     * @param int zeros quantidade de zeros para adicionar
     * @return String
     */
    public static String zeroFill(int valor, int zeros) {
        return zeroFill(valor + "", zeros);
    }

    public static String zeroFill(String valor, int zeros) {
        String sValor = valor;

        if (sValor.length() > zeros) {
            return sValor;
        }

        int restantes = zeros - sValor.length();
        String zadd = "";
        for (int i = 0; i < restantes; i++) {
            zadd += "0";
        }

        return zadd.concat(sValor);
    }

    public static String zeroFill(Long valor, int zeros) {
        return zeroFill(valor + "", zeros);
    }

    public static String zeroFill(BigInteger valor, int zeros) {
        return zeroFill(valor + "", zeros);
    }
}
