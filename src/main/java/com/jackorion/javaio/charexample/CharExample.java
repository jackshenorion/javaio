package com.jackorion.javaio.charexample;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class CharExample {

    public static void main(String[] args) throws UnsupportedEncodingException {
        utf16IsDefaultCharsetForChar();
        convertCharset();
    }

    private static void utf16IsDefaultCharsetForChar() {
        char c1 = '\u00DF'; // UTF-16 for ß
        System.out.println(c1); // it shows ß
        char c2 = '\uC39F'; // UTF-8 for ß
        System.out.println(c2); // it shows 쎟, which is wrong
    }

    private static void convertCharset() {
        char[] chars = new char[10];
        chars[0] = '\u6771';
        chars[1] = 'c';
        System.out.println("Default Charset: " + Charset.defaultCharset());
        System.out.println("Available Charset: " + Charset.availableCharsets());
        byte[] bs1 = new String(chars).getBytes();
        printBytes(bs1);
        byte[] bs2 = new String(chars).getBytes(Charset.forName("UTF-16"));
        printBytes(bs2);
        byte[] bs3 = new String(chars).getBytes(Charset.forName("UTF-8"));
        printBytes(bs3);
    }

    private static void printBytes(byte[] bs) {
        for (byte b : bs) {
            System.out.print((String.format("%x ",b)));
        }
        System.out.println();
    }




}
