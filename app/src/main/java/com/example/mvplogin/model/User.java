package com.example.mvplogin.model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser{

    private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
// Ngambil dari interface IUser
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
//        0. Check email and password is empty
//        1. Check email is empty
//        2. Check password is empty
//        3. Check email match with pattern (valid/not)
//        4. Check password length > 6
        if (TextUtils.isEmpty(getEmail()) && TextUtils.isEmpty(getPassword()))
            return 0;
        else if (TextUtils.isEmpty(getEmail()))
            return 1;
        else if (TextUtils.isEmpty(getPassword()))
            return 2;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 3;
        else if (getPassword().length()<=6)
            return 4;
        else
            return -1;
    }
}
