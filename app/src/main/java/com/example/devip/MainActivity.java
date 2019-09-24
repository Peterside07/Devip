package com.example.devip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.devip.R.id.log_btn_register;

public class MainActivity extends AppCompatActivity {
    private Editable textView;
    private Button loginButton = findViewById(R.id.log_btn_login);
    private Button ButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginScreen = new Intent(MainActivity.this, Dashboardactivity.class);

                startActivity(loginScreen);
            }
        });

        ButtonRegister = findViewById(R.id.log_btn_register);
        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(RegisterIntent);
            }
        });
        final EditText eName = (EditText) findViewById(R.id.reg_et_email);
        final EditText epassword = (EditText) findViewById(R.id.log_et_email);
        final Button btnLogin = (Button) findViewById(R.id.log_btn_login);
        final Button btnRegister = (Button) findViewById(log_btn_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = eName.getText().toString();
                String password = epassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                String userDetails = preferences.getString(user + password + "data", "Username or Password is incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.commit();

                Intent displayScreen = new Intent(MainActivity.this, Dashboardactivity.class);
                startActivity(displayScreen);
                btnRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent regScreen = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(regScreen);


                    }
                });

            }
        });


    }

}
