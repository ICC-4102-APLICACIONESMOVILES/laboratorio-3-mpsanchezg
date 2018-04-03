package com.example.mpsan.laboratorio3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        final EditText userEmail = (EditText) findViewById(R.id.email_user_login_edit_text);
        final EditText userPassword = (EditText) findViewById(R.id.password_user_login_edit_text);
        Button loginButton = (Button) findViewById(R.id.user_login_button);
        Button registerButton = (Button) findViewById(R.id.user_register_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userEmail.getText().toString();
                String password = userPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String userDetails = preferences.getString(user + password + "data", "Email or Password is Incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.commit();

                Intent displayMainMenu = new Intent(UserLoginActivity.this, MainActivity.class);
                startActivity(displayMainMenu);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displayUserRegister = new Intent(UserLoginActivity.this, UserRegisterActivity.class);
                startActivity(displayUserRegister);
            }
        });
    }
}
