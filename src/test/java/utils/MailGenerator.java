package utils;

import com.mifmif.common.regex.Generex;

public class MailGenerator {

    public static String getRandomEmail(){
        String regex = "\\w{10}\\@gmail\\.com";
        return new Generex(regex).random();
    }
}
