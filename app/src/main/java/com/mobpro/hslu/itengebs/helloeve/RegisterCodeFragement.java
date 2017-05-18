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
import com.mobpro.hslu.itengebs.helloeve.model.HelloEveUser;
import com.mobpro.hslu.itengebs.helloeve.model.SignIn_Response;
import com.orm.Database;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterCodeFragement extends Fragment {


    private EditText txtCode;
    private FloatingActionButton fabNext;

    public RegisterCodeFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register_code_fragement, container, false);
        txtCode = (EditText)view.findViewById(R.id.RegisterCodetxtCode);
        fabNext = (FloatingActionButton)view.findViewById(R.id.RegisterCodefabNext);
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextClicked();
            }
        });
        return view;
    }

    private void nextClicked(){
        String code = txtCode.getText().toString();
        HelloEveUser user = DatabaseManager.getInstance().getUserInfo();
        final RegisterCodeFragement fragement = this;

        WebAPIManager.getInstance().signIn(this.getContext(), user.getToken(), user.getPhoneHash(), user.getPhoneNumber(), code, new WebAPICallback<SignIn_Response>() {
            @Override
            public void onCompleted(Exception e, SignIn_Response response) {

                    ((RegisterActivity)fragement.getActivity()).goToNextScreen("Main");

            }
        });
    }

}
