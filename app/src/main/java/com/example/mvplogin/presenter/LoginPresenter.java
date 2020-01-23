package com.example.mvplogin.presenter;

import com.example.mvplogin.model.User;
import com.example.mvplogin.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {
//    Perlu dideklarasikan agar bisa digunakan fungsinya (onLoginError/onLoginSuccess)
    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }
// Implement login presenter :
    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValidData();

        if(loginCode == 0)
            loginView.onLoginError("Harap masukkan email dan password kamu");
        else if (loginCode == 1)
            loginView.onLoginError("Harap masukkan email kamu");
        else if (loginCode == 2)
            loginView.onLoginError("Harap masukkan password kamu");
        else if (loginCode == 3)
            loginView.onLoginError("Harap masukkan email yang valid");
        else if (loginCode == 4)
            loginView.onLoginError("Password kamu harus lebih dari 6 karakter :3");
        else
            loginView.onLoginSuccess("Login berhasil ^^");
    }
}
