package com.example.erand.loginpage;

import android.content.Intent;
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
    public String userLogin, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        Button button = (Button) findViewById(R.id.login_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin = editText.getText().toString();
                pass = editText1.getText().toString();

                Intent intent = new Intent(view.getContext(), DisplayProfile.class);
                intent.putExtra("name", "value");
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
