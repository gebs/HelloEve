package com.mobpro.hslu.itengebs.helloeve.api;

import android.content.Context;
import android.provider.Settings;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.mobpro.hslu.itengebs.helloeve.model.SendCode_Response;
import com.mobpro.hslu.itengebs.helloeve.model.SendMessage_Response;
import com.mobpro.hslu.itengebs.helloeve.model.SignIn_Response;

import org.json.JSONObject;

/**
 * Created by gebs on 5/15/17.
 */

public class WebAPIManager {
    private static final String BASE_PATH= "http://monitoring.o-x.ch/HelloEve/api/v0/telegram/";

    private static WebAPIManager instance;

    public static WebAPIManager getInstance(){
        if (instance == null){
            instance = new WebAPIManager();
        }
        return instance;
    }

    public void sendCode(Context context,final String phoneNumber, final WebAPICallback<SendCode_Response> callback){
        JsonObject json = new JsonObject();
        json.addProperty("PhoneNumber",phoneNumber);

        Ion.with(context)
                .load(BASE_PATH + "sendCode")
                .setJsonObjectBody(json)
                .as(new TypeToken<SendCode_Response>(){})
                .setCallback(new FutureCallback<SendCode_Response>() {
                    @Override
                    public void onCompleted(Exception e, SendCode_Response result) {
                        //DatabaseManager.getInstance().saveUserData(phoneNumber,result.Token,result.PhoneHash);
                        callback.onCompleted(e,result);
                    }
                });
    }
    public void signIn(Context context, String token, String phoneHash,String phoneNumber, String code, final WebAPICallback<SignIn_Response> callback){
        JsonObject json = new JsonObject();
        json.addProperty("Token",token);
        json.addProperty("PhoneCodeHash",phoneHash);
        json.addProperty("PhoneNumber",phoneNumber);
        json.addProperty("Code",code);

        Ion.with(context)
                .load(BASE_PATH + "signIn")
                .setJsonObjectBody(json)
                .as(new TypeToken<SignIn_Response>(){})
                .setCallback(new FutureCallback<SignIn_Response>() {
                    @Override
                    public void onCompleted(Exception e, SignIn_Response result) {
                        callback.onCompleted(e,result);
                    }
                });
    }

    public void sendMessage(Context context,String token,String phoneNumber,String Message, Integer userId, final WebAPICallback<SendMessage_Response> callback){
        JsonObject json = new JsonObject();
        json.addProperty("Token",token);
        json.addProperty("PhoneNumber",phoneNumber);
        json.addProperty("Code",Message);
        json.addProperty("UserId",userId);

        Ion.with(context)
                .load(BASE_PATH + "sendMessage")
                .setJsonObjectBody(json)
                .as(new TypeToken<SendMessage_Response>(){})
                .setCallback(new FutureCallback<SendMessage_Response>() {
                    @Override
                    public void onCompleted(Exception e, SendMessage_Response result) {
                        callback.onCompleted(e,result);
                    }
                });
    }
}
