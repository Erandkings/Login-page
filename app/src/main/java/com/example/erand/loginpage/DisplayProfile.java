package com.example.erand.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);

        TextView textView1 = (TextView) findViewById(R.id.first_pro);
        TextView textView2 = (TextView) findViewById(R.id.second_pro);
        TextView textView3 = (TextView) findViewById(R.id.email);
        TextView textView4 = (TextView) findViewById(R.id.number);
        TextView textView5 = (TextView) findViewById(R.id.username);

        textView1.setText(CreateAccount.first);
        textView2.setText(CreateAccount.second);
        textView3.setText(CreateAccount.emel);
        textView5.setText(CreateAccount.users);
        textView4.setText(CreateAccount.num);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.signout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(DisplayProfile.this, LoginActivity.class);
        startActivity(intent);
        return true;
    }
}
