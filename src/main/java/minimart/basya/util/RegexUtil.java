package minimart.basya.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public static Boolean isAlphaOnly(String data) {
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public static Boolean isAlphaNum(String data) {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public static Boolean isName(String data) {
        String regex = "^[a-zA-Z ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static Boolean isNoTelephone(String mobileNo) {
        String regex = "^(^\\+62\\s?)(\\d{3,4}-?){2}\\d{3,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobileNo);
        return matcher.matches();
    }

    public static Boolean isAddress(String address) {
        String regex = "^[a-zA-Z0-9 \\-,./]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    public static Boolean isPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();

        //
        //^                 # start-of-string
        //(?=.*[0-9])       # a digit must occur at least once
        //(?=.*[a-z])       # a lower case letter must occur at least once
        //(?=.*[A-Z])       # an upper case letter must occur at least once
        //(?=.*[@#$%^&+=])  # a special character must occur at least once
        //(?=\S+$)          # no whitespace allowed in the entire string
        //.{8,}             # anything, at least eight places though
        //$                 # end-of-string
    }

    public static Boolean isDob(String dob) {
        String regex = "^([0123][0-9])-([0][1-9]|[1][0-2])-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dob);
        return matcher.matches();
    }
}

