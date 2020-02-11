package com.bambey2019.myciteuniv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bambey2019.myciteuniv.Adapter.ReservationAdapter;
import com.bambey2019.myciteuniv.Model.ReservationItem;

import java.util.ArrayList;
import java.util.List;

public class ResponsActivity extends AppCompatActivity {
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respons);

        listView = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(ResponsActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.reservation));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view , int i, long l){

                Intent intent = new Intent(ResponsActivity.this, PublierReservation.class);
                intent.putExtra("NumChambre", listView.getItemAtPosition(i).toString());
                startActivity(intent);

            }
        });
        listView.setAdapter(mAdapter);
    }
}
