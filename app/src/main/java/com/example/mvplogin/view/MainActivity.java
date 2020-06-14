package com.example.mvplogin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvplogin.contract.Contract;
import com.example.mvplogin.R;
import com.example.mvplogin.presenter.LoginPresenter;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements Contract.ILoginView {
    EditText edt_email,edt_pass;
    Button btn_login;

    Contract.ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusBarTranslucent(this);

        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_pass);
        btn_login = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edt_email.getText().toString(),edt_pass.getText().toString());
            }
        });
    }
// Login berhasil
    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this,message,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
        finish();
    }
// Login gagal
    @Override
    public void onLoginError(String message) {
        Toasty.error(this,message,Toast.LENGTH_SHORT).show();
    }

    public static void statusBarTranslucent(Activity activity){
        Window window = activity.getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    public void backButton(View view) {
        finish();
    }
}
