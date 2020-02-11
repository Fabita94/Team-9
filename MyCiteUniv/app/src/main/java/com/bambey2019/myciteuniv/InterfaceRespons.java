package com.bambey2019.myciteuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfaceRespons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_respons);

        Button btnReserv = (Button) findViewById(R.id.btnReserv);
        Button btnContact = (Button) findViewById(R.id.btnContact);
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
                final Intent intentAutre = new Intent(getApplicationContext(), ResponsActivity.class);
                startActivity(intentAutre);
                finish();
            }
        });
    }
}
