package com.mobpro.hslu.itengebs.helloeve;


import android.os.Bundle;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterPhoneNumberFragement extends Fragment {


    private EditText txtPhoneNumber;
    private FloatingActionButton fabNext;


    public RegisterPhoneNumberFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register_phone_number_fragement, container, false);
        txtPhoneNumber = (EditText)view.findViewById(R.id.RegisterPhoneNumbertxtPhonenumber);
        fabNext = (FloatingActionButton)view.findViewById(R.id.RegisterPhoneNumberfabNext);

        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextClicked();
            }
        });

        return view;
    }
    private void nextClicked(){
        final String phoneNumber = txtPhoneNumber.getText().toString();
        final RegisterPhoneNumberFragement fragement = this;

        WebAPIManager.getInstance().sendCode(this.getContext(), phoneNumber, new WebAPICallback<SendCode_Response>() {
            @Override
            public void onCompleted(Exception e, SendCode_Response response) {
                DatabaseManager.getInstance().saveUserData(phoneNumber,response.Token,response.PhoneHash);
                ((RegisterActivity)fragement.getActivity()).goToNextScreen("Code");
            }
        });


    }

}
