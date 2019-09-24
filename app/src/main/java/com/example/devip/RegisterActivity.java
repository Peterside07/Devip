package com.example.devip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText username = (EditText) findViewById(R.id.reg_et_name);
        final EditText email = (EditText) findViewById(R.id.reg_et_email);
        final EditText password = (EditText) findViewById(R.id.reg_et_pword);
        final EditText cpassword = (EditText) findViewById(R.id.reg_et_cpword);
        final EditText mobile = (EditText) findViewById(R.id.reg_et_mobile);
        final Button btnReg = (Button) findViewById(R.id.reg_btn_reg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                String newUser = username.getText().toString();
                String newEmail = email.getText().toString();
                String newPassword= password.getText().toString();
                String newcPassword = cpassword.getText().toString();
                String newMobile = mobile.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newEmail + newPassword + "data", newUser + "/n" + newEmail + "/n" + newMobile);
                editor.commit();

                Intent loginScreen = new Intent(RegisterActivity.this, Dashboardactivity.class);
                startActivity(loginScreen);

            }
        });
    }

}


