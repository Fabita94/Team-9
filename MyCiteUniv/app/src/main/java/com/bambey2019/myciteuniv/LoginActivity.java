package com.bambey2019.myciteuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflat = getMenuInflater();
        inflat.inflate(R.menu.custom_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnReserv = (Button) findViewById(R.id.button);
        Button btnContact = (Button) findViewById(R.id.button3);
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentContact = new Intent(getApplicationContext(), ContactEchange.class);
                startActivity(intentContact);
                finish();

            }
        });
        btnReserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentAutre = new Intent(getApplicationContext(), PavillonActivity.class);
                startActivity(intentAutre);
                finish();
            }
        });
    }
}
