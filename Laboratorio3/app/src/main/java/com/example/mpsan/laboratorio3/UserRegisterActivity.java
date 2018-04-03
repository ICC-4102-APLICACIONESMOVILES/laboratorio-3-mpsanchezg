package com.example.mpsan.laboratorio3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by mpsan on 02-04-2018.
 */

public class UserRegisterActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);

        final EditText UserName = (EditText) findViewById(R.id.name_user_register_edit_text);
        final EditText UserEmail = (EditText) findViewById(R.id.email_user_register_edit_text);
        final EditText UserPassword = (EditText) findViewById(R.id.password_user_register_edit_text);
        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUserName = UserName.getText().toString();
                String newUserEmail = UserEmail.getText().toString();
                String newUserPassword = UserPassword.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(newUserName + newUserPassword + "data", newUserName + "\n" + newUserEmail);
                editor.commit();

                Intent LoginScreen = new Intent(UserRegisterActivity.this, UserLoginActivity.class);
                startActivity(LoginScreen);

            }
        });
    }


}
