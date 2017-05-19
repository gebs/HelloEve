package com.mobpro.hslu.itengebs.helloeve;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

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
    public static void hideKeyboard(Activity activity){
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
}
