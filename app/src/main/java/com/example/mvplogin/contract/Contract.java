package com.example.mvplogin.contract;

public interface Contract {

    interface IUser {
        String getEmail();
        String getPassword();
        int isValidData();
    }

    interface ILoginPresenter {
        void onLogin(String email,String password);
    }

    interface ILoginView {
        //    Untuk toast
        void onLoginSuccess(String message);
        void onLoginError(String message);
    }
}
