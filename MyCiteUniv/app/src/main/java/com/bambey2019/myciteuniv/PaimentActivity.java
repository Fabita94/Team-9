package com.bambey2019.myciteuniv;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaimentActivity extends AppCompatActivity {

    private static final int YES = 0;
    private static final int NO = 1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflat = getMenuInflater();
        inflat.inflate(R.menu.custom_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiment);

        final RadioGroup radioGroup = findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new
                                                      RadioGroup.OnCheckedChangeListener() {
                                                          @Override
                                                          public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                              View radioButton = radioGroup.findViewById(checkedId);
                                                              int index = radioGroup.indexOfChild(radioButton);
                                                              TextView textView = findViewById(R.id.fragment_header);
                                                              switch (index) {
                                                                  case YES: // User chose "Yes."
                                                                      textView.setText(R.string.orangeMoney);
                                                                      break;
                                                                  case NO: // User chose "No."
                                                                      textView.setText(R.string.cash);
                                                                      break;
                                                                  default: // No choice made.
                                                                      // Do nothing.
                                                                      break;
                                                              }
                                                          }
                                                      });

    }
}
