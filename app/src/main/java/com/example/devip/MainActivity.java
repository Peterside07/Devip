package com.example.devip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private Button buttonRegister;
    EditText emailEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.reg_et_email);
        passwordEditText = findViewById(R.id.log_et_email);
        loginButton = findViewById(R.id.log_btn_login);
        //final Button btnRegister = findViewById(log_btn_register);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginScreen = new Intent(MainActivity.this, Dashboardactivity.class);
                startActivity(loginScreen);
            }
        });

        buttonRegister = findViewById(R.id.log_btn_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(RegisterIntent);
            }
        });

        //todo: You have declared a onClick listener above(line 25).
        // what you can do it copy the details here to the initial onCLick method

        /*loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                String userDetails = preferences.getString(user + password + "data", "Username or Password is incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.commit();

                Intent displayScreen = new Intent(MainActivity.this, Dashboardactivity.class);
                startActivity(displayScreen);
                buttonRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent regScreen = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(regScreen);
                    }
                });
            }
        });*/
    }

}
