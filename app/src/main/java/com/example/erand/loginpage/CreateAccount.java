package com.example.erand.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {
    public static final String myPREF = "myPREF";
    public static final String Email = "nameKey";
    public static final String user_name = "username";
    public static final String pass_word = "pass";
    SharedPreferences sharedPreferences;

    EditText firstName, secondName, email, userName, phone, password;
    public static String first, second, emel, users, num, pass;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        firstName = (EditText) findViewById(R.id.first_name);
        firstName.requestFocus();
        secondName = (EditText) findViewById(R.id.second_name);
        email = (EditText) findViewById(R.id.email);
        userName = (EditText) findViewById(R.id.user_create);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);

        textView = (TextView) findViewById(R.id.complete_your_details);

        btn_click();

        TextView textView = (TextView) findViewById(R.id.login_here);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccount.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void btn_click() {
        Button button = (Button) findViewById(R.id.create_btn);
        sharedPreferences = getSharedPreferences(myPREF, MODE_PRIVATE);
//
//        if (firstName == null || secondName == null || emel == null || users == null || num == null || pass == null) {
//            textView.setText("Complete your details");
//        } else {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    first = firstName.getText().toString();
                    second = secondName.getText().toString();
                    emel = email.getText().toString();
                    users = userName.getText().toString();
                    num = phone.getText().toString();
                    pass = password.getText().toString();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Email, emel);
                    editor.putString(user_name, users);
                    editor.putString(pass_word, pass);
                    editor.commit();

                    Intent intent = new Intent(CreateAccount.this, DisplayProfile.class);
                    startActivity(intent);

                    LayoutInflater layoutInflater = getLayoutInflater();
                    View custom = layoutInflater.inflate(R.layout.layout, (ViewGroup) findViewById(R.id.root));

                    TextView textView = (TextView) custom.findViewById(R.id.toast_txt);
                    textView.setText("Activation Successful");

                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    toast.setView(custom);
                    toast.show();
                }
            });
//        }
    }
}


