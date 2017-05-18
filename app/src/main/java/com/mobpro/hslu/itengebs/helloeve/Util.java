package com.mobpro.hslu.itengebs.helloeve;

/**
 * Created by gebs on 5/18/17.
 */

public class Util {
    public static String formatPhoneNumber(String phoneNumber){
        if (phoneNumber.startsWith("07")){
            return "0041" + phoneNumber.substring(1).replace(" ","");
        }else if (phoneNumber.startsWith("+")){
            return "00" + phoneNumber.substring(1).replace(" ","");
        }else{
            return phoneNumber.replace(" ","");
        }
    }
}
