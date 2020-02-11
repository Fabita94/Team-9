package com.bambey2019.myciteuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AutreActivity extends AppCompatActivity {
    ListView listView;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autre);
        FloatingActionButton floatingActionButton = findViewById(R.id.floating_action_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentAutre = new Intent(getApplicationContext(), FormulaireActivity.class);
                startActivity(intentAutre);
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(AutreActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.chambres));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view , int i, long l){

                Intent intent = new Intent(AutreActivity.this, ChambreActivity.class);
                intent.putExtra("NumChambre", listView.getItemAtPosition(i).toString());
                startActivity(intent);

            }
        });
        listView.setAdapter(mAdapter);

    }
}
