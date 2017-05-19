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
import com.mobpro.hslu.itengebs.helloeve.model.HelloEveUser;
import com.mobpro.hslu.itengebs.helloeve.model.SignIn_Response;
import com.orm.Database;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_register_code_fragement)
public class RegisterCodeFragement extends Fragment {


    @ViewById(R.id.RegisterCodetxtCode)
    EditText txtCode;
    @ViewById(R.id.RegisterCodefabNext)
    FloatingActionButton fabNext;

    @Bean
    DatabaseManager dbManager;

    @Bean
    WebAPIManager webmanager;

    private ProgressDialog progressDialog;


    public RegisterCodeFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return null;
    }

    @AfterViews
    void setProgressDialog(){
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("signing In");

    }


    @Click(R.id.RegisterCodefabNext)
    void nextClicked() {
        Util.hideKeyboard(this.getActivity());
        progressDialog.show();
        signIn();
    }

    @Background
    void signIn(){
        String code = txtCode.getText().toString();
        HelloEveUser user = dbManager.getUserInfo();
        final RegisterCodeFragement fragement = this;

        webmanager.signIn(this.getContext(), user.getToken(), user.getPhoneHash(), user.getPhoneNumber(), code, new WebAPICallback<SignIn_Response>() {
            @Override
            public void onCompleted(Exception e, SignIn_Response response) {
                hideLoading();
                ((RegisterActivity) fragement.getActivity()).goToNextScreen("Main");
            }
        });
    }
    @UiThread
    void hideLoading(){
        progressDialog.hide();
    }

}
