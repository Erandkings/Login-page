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

public class LoginActivity extends AppCompatActivity {
    public static final String myPREF = "myPREF";
    public static final String email = "email";
    public static final String username = "nameKey";
    public static final String pass_word = "pass";
    SharedPreferences sharedPreferences;
    public String emailAd, userLogin, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(myPREF, MODE_PRIVATE);
        final Boolean isLoggedIn = sharedPreferences.getBoolean("IsLoggedIn", false);

        if (isLoggedIn) {
            Intent intent = new Intent(this, DisplayProfile.class);
            startActivity(intent);
        }

        final String Email_token = sharedPreferences.getString(email, "DEFAULT_EMAIL");
        final String Etoken = sharedPreferences.getString(username, "DEFAULT_USERNAME");
        final String Ptoken = sharedPreferences.getString(pass_word, "DEFAULT_PASSWORD");

        TextView textView = (TextView) findViewById(R.id.clickhere);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View layout = layoutInflater.inflate(R.layout.layout, (ViewGroup) findViewById(R.id.root));

                TextView textView = (TextView) layout.findViewById(R.id.toast_txt);
                textView.setText("It's a dead end!");

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.setView(layout);
                toast.show();
            }
        });

        final EditText editText = (EditText) findViewById(R.id.user_login);
        final EditText editText1 = (EditText) findViewById(R.id.user_pass);
        final EditText editText2 = (EditText) findViewById(R.id.user_login);

        Button button = (Button) findViewById(R.id.login_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin = editText.getText().toString();
                pass = editText1.getText().toString();
                emailAd = editText2.getText().toString();

                if (userLogin.equals(Etoken) || emailAd.equals(Email_token) && (pass.equals(Ptoken))) {
                    Intent intent1 = new Intent(LoginActivity.this, DisplayProfile.class);
                    startActivity(intent1);
                } else {
                    TextView textView1 = (TextView) findViewById(R.id.error_msg);
                    textView1.setText("Wrong email or password");
                }
            }
        });
    }
}
