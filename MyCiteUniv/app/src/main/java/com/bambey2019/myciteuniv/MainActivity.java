package com.bambey2019.myciteuniv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.bambey2019.myciteuniv.Model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText inputCode, inputPassword;
    private Button btnConnexion;
    private ProgressDialog loanding;
    private String parentDbName = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConnexion = (Button) findViewById(R.id.coonexion);
        inputCode = (TextInputEditText) findViewById(R.id.codeP);
        inputPassword = (TextInputEditText) findViewById(R.id.password);
        loanding = new ProgressDialog(this);
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String codePerm = inputCode.getText().toString();
        String motPass = inputPassword.getText().toString();
        if (TextUtils.isEmpty(codePerm)){
            Toast.makeText(this, "Entrer votre code permanent", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(motPass)){
            Toast.makeText(this, "Entrer vottre mot de passe", Toast.LENGTH_SHORT).show();
        }
        else{
            loanding.setTitle("Connexion en cour");
            loanding.setMessage("Patienter un peu");
            loanding.setCanceledOnTouchOutside(false);
            loanding.show();

            AllowAccessToAccount(codePerm, motPass);
        }
    }

    private void AllowAccessToAccount(final String codePerm, final String motPass) {
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();
        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentDbName).child(codePerm).exists()){
                    Users usersData = dataSnapshot.child(parentDbName).child(codePerm).getValue(Users.class);

                    if(usersData.getCodePerm().equals(codePerm)){
                        if (usersData.getMotPass().equals(motPass)){
                            Toast.makeText(MainActivity.this, "Connexion reussi ", Toast.LENGTH_SHORT).show();
                            loanding.dismiss();

                            final Intent intentAutre = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intentAutre);
                        }
                    }
                }

                else if(dataSnapshot.child("Codifies").child(codePerm).exists()){
                    Users usersData = dataSnapshot.child("Codifies").child(codePerm).getValue(Users.class);

                    if(usersData.getCodePerm().equals(codePerm)){
                        if (usersData.getMotPass().equals(motPass)){
                            Toast.makeText(MainActivity.this, "Connexion reussi ", Toast.LENGTH_SHORT).show();
                            loanding.dismiss();

                            final Intent intentCodifies = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intentCodifies);
                        }
                    }
                }
                else if(dataSnapshot.child("Responsable").child(codePerm).exists()){
                    Users usersData = dataSnapshot.child("Responsable").child(codePerm).getValue(Users.class);

                    if(usersData.getCodePerm().equals(codePerm)){
                        if (usersData.getMotPass().equals(motPass)){
                            Toast.makeText(MainActivity.this, "Connexion reussi: bienvenu cher responsable ", Toast.LENGTH_SHORT).show();
                            loanding.dismiss();

                            final Intent intentRespons = new Intent(MainActivity.this, InterfaceRespons.class);
                            startActivity(intentRespons);
                        }
                    }
                }

                else{
                    Toast.makeText(MainActivity.this,"un compte avec ce " + codePerm + "n'existe pas " , Toast.LENGTH_SHORT).show();
                    loanding.dismiss();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
