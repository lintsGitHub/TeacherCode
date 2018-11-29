package xxx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Suanfa {

    public String rot13(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) c += 13;
            else if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) c -= 13;

            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String reverse(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString();
    }

    public boolean isEmpty(String str) {
        if (str == null || "".equals(str) || "null".equals(str) || str.trim().equals("")) {
            return true;
        }
        return false;
    }

    public char firstNotDupCharOfString(String origin) {
        if ("".equals(origin) || origin == null) {
            return 0;
        }
        int first, last;
        char[] arr = origin.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            first = origin.indexOf(arr[i]);
            last = origin.lastIndexOf(arr[i]);
            if (first == last) {
                return arr[i];
            }
        }
        return 0;
    }

    public char firstNotDupCharOfString1(String origin) {
        if ("".equals(origin) || origin == null) {
            return 0;
        }

        for (int i = 0; i < origin.length(); i++) {
            for (int j = 0; j < origin.length(); j++) {
                if (j != i && origin.charAt(i) == origin.charAt(j)) {
                    break;
                }

                if (j + 1 == origin.length()) {
                    return origin.charAt(i);
                }
            }
        }

        return 0;
    }

    public char firstNotDupCharOfString2(String origin) {
        if ("".equals(origin) || origin == null) {
            return 0;
        }
        // 以空间换时间
        HashSet<Character> chonfude = new HashSet<>();
        ArrayList<Character> buchongfude = new ArrayList<>();

        for (int i = 0; i < origin.length(); i++) {
            char c = origin.charAt(i);
            if (chonfude.contains(c)) {
                continue;
            }
            if (buchongfude.contains(c)) {
                buchongfude.remove((Character) c);
                chonfude.add(c);
            } else {
                buchongfude.add(c);
            }
        }
        if (buchongfude.size() > 0) {
            return buchongfude.get(0);
        } else{
            return 0;
        }
    }

    public String randStr(long len) {

        String seed = "abcdefghijklmnopqrsquvwxyzABCDEFGHIJKLMNOPQRSQUVWXYZ1234456789";
        StringBuilder sb = new StringBuilder();

        Random rd = new Random();
        int seedLen = seed.length();

        for (int i = 0; i < len; i++) {
            sb.append(seed.charAt(rd.nextInt(seedLen)));
        }

        return String.valueOf(sb);
    }

}
