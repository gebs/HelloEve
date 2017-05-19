package com.mobpro.hslu.itengebs.helloeve.api;

import com.mobpro.hslu.itengebs.helloeve.model.HelloEveUser;
import com.mobpro.hslu.itengebs.helloeve.model.Message;
import com.orm.Database;

import org.androidannotations.annotations.EBean;

import java.util.Date;
import java.util.List;

/**
 * Created by gebs on 5/15/17.
 */
@EBean(scope = EBean.Scope.Singleton)
public class DatabaseManager {

    public boolean isUserLogedIn(){
        List<HelloEveUser> user = HelloEveUser.listAll(HelloEveUser.class);
        return user.size() == 1;
    }
    public void saveUserData(String phoneNumber,String token,String hash){
        HelloEveUser user = new HelloEveUser(phoneNumber,token,hash);
        user.save();
    }
    public HelloEveUser getUserInfo(){
        List<HelloEveUser> user = HelloEveUser.listAll(HelloEveUser.class);
        return user.get(0);
    }
    public void saveMessage(String messageText, String receiverNumber){
        Message msg = new Message(messageText,receiverNumber,new Date());
        msg.save();
    }
    public  List<Message> getMessages(){
        return Message.listAll(Message.class);
    }

}
