package com.bambey2019.myciteuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AutreActivity extends AppCompatActivity {
    ListView listeview;

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
        listeview= (ListView) findViewById(R.id.liste);
        ArrayList  <String> arrayList= new ArrayList<>();
        arrayList.add("Chambre 1");
        arrayList.add("Chambre 2");
        arrayList.add("Chambre 3");
        arrayList.add("Chambre 4");
        arrayList.add("Chambre 5");
        arrayList.add("Chambre 16");
        arrayList.add("Chambre 17");
        arrayList.add("Chambre 18");

        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listeview.setAdapter(arrayAdapter);

    }
}
