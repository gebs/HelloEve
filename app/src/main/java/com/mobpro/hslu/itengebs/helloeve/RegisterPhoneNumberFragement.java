package com.mobpro.hslu.itengebs.helloeve;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mobpro.hslu.itengebs.helloeve.api.DatabaseManager;
import com.mobpro.hslu.itengebs.helloeve.api.WebAPICallback;
import com.mobpro.hslu.itengebs.helloeve.api.WebAPIManager;
import com.mobpro.hslu.itengebs.helloeve.model.SendCode_Response;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_register_phone_number_fragement)
public class RegisterPhoneNumberFragement extends Fragment {


    @ViewById(R.id.RegisterPhoneNumbertxtPhonenumber)
    EditText txtPhoneNumber;

    @ViewById(R.id.RegisterPhoneNumberfabNext)
    FloatingActionButton fabNext;

    @Bean
    DatabaseManager dbmanager;

    @Bean
    WebAPIManager webmanager;

    private ProgressDialog progressDialog;

    public RegisterPhoneNumberFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return null;
    }

    @AfterViews
    void setProgressDialog(){
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("sending Code");

    }

    @Click(R.id.RegisterPhoneNumberfabNext)
    void nextClicked() {
        Util.hideKeyboard(this.getActivity());
        progressDialog.show();
        sendCode();
    }

    @Background
    void sendCode() {
        final String phoneNumber = txtPhoneNumber.getText().toString();
        final RegisterPhoneNumberFragement fragement = this;

        webmanager.sendCode(this.getContext(), phoneNumber, new WebAPICallback<SendCode_Response>() {
            @Override
            public void onCompleted(Exception e, SendCode_Response response) {
                if (response != null) {
                    dbmanager.saveUserData(phoneNumber, response.Token, response.PhoneHash);
                    ((RegisterActivity_) fragement.getActivity()).goToNextScreen("Code");
                    hideLoading();
                }else{
                    hideLoading();
                }

            }
        });
    }
    @UiThread
    void hideLoading(){
        progressDialog.hide();
    }

}
