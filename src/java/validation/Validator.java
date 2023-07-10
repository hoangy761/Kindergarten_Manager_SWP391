/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Validator {

    public static String upCassName(String message) {
        char[] charArray = message.toCharArray();
        boolean foundSpace = true;
        //sử dụng vòng lặp for để duyệt các phần tử trong charArray
        for (int i = 0; i < charArray.length; i++) {
            // nếu phần tử trong mảng là một chữ cái
            if (Character.isLetter(charArray[i])) {
                // kiểm tra khoảng trắng có trước chữ cái
                if (foundSpace) {
                    //đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }
        return String.valueOf(charArray);
    }
    private static char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    public static String createID() {
        Random generator = new Random();
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 3; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        String randomStrValue = "";
        StringBuilder sb1 = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 7; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb1.append(chars[index]);
        }
        return sb.toString() + sb1.toString();
    }
    public static String createNameImg() {
        Random generator = new Random();
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        String randomStrValue = "";
        StringBuilder sb1 = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb1.append(chars[index]);
        }
        return sb.toString() + sb1.toString();
    }
    public static String getExtension(String path) {
        return path.substring(path.lastIndexOf(".") + 1, path.length());
    }
}
