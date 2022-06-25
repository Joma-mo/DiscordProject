package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extra {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$");
        Matcher m = p.matcher("+98919238861278");

        boolean b = m.find();
        System.out.println(b);
    }
}
