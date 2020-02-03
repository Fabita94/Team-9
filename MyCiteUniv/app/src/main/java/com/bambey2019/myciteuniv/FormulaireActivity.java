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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class FormulaireActivity extends AppCompatActivity {

    private TextInputEditText inputCodePermanent, inputFilire, inputNiveau, inputCni, inputNom, inputNumChambre, inputTel;
    private Button btnEnreg;
    private ProgressDialog loanding;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater in = getMenuInflater();
        in.inflate(R.menu.custom_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        btnEnreg = (Button) findViewById(R.id.enregistrer);
        inputCodePermanent = (TextInputEditText) findViewById(R.id.codePerm);
        inputFilire = (TextInputEditText) findViewById(R.id.filiere);
        inputNiveau = (TextInputEditText) findViewById(R.id.niveau);
        inputCni = (TextInputEditText) findViewById(R.id.cni);
        inputNom = (TextInputEditText) findViewById(R.id.nom);
        inputNumChambre = (TextInputEditText) findViewById(R.id.numChambre);
        inputTel = (TextInputEditText) findViewById(R.id.tel);
        loanding = new ProgressDialog(this);

        btnEnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reserver();
            }
        });
    }

    private void Reserver() {

        String codePermanent = inputCodePermanent.getText().toString();
        String numeroChamre = inputNumChambre.getText().toString();
        String nomEtu = inputNom.getText().toString();
        String filiereEtu = inputFilire.getText().toString();
        String niveauEtu = inputNiveau.getText().toString();
        String cniEtu = inputCni.getText().toString();
        String telEtu = inputTel.getText().toString();

        if(TextUtils.isEmpty(codePermanent)){
            Toast.makeText(this, "entrez votre code permanent stp", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(numeroChamre)){
            Toast.makeText(this, "entrez le numero de chambre que vous voulez reserve stp", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(nomEtu)){
            Toast.makeText(this, "entrez votre nom stp", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(filiereEtu)){
            Toast.makeText(this, "entrez votre filiere stp", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(niveauEtu)){
            Toast.makeText(this, "entrez votre niveau stp", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(cniEtu)){
            Toast.makeText(this, "entrez votre CNI stp", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(telEtu)){
            Toast.makeText(this, "entrez votre numero de telephone stp", Toast.LENGTH_SHORT).show();
        }
        else{
            loanding.setTitle("Reservation en cour ");
            loanding.setMessage("Patienter un peu");
            loanding.setCanceledOnTouchOutside(false);
            loanding.show();

            ValiderInfos(codePermanent, numeroChamre, nomEtu, filiereEtu, niveauEtu, cniEtu, telEtu);
        }

    }

    private void ValiderInfos(final String codePermanent, final String numeroChamre, final String nomEtu, final String filiereEtu, final String niveauEtu, final String cniEtu, final String telEtu) {

        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();
        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Users").child(codePermanent).exists()) {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("numeroChamre", numeroChamre);
                    userdataMap.put("nom", nomEtu);
                    userdataMap.put("filiere", filiereEtu);
                    userdataMap.put("niveau", niveauEtu);
                    userdataMap.put("numCni", cniEtu);
                    userdataMap.put("tel", telEtu);

                    Rootref.child("Users").child(codePermanent).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(FormulaireActivity.this, "Felicitation, votre reservation a ete enregistre", Toast.LENGTH_SHORT).show();
                                        loanding.dismiss();
                                        final Intent intentAutre = new Intent(FormulaireActivity.this, PavillonActivity.class);
                                        startActivity(intentAutre);
                                    }
                                    else{
                                        loanding.dismiss();
                                        Toast.makeText(FormulaireActivity.this, "Erreur de reseau! veuillez resaiyer", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
                else{
                    loanding.dismiss();
                    final Intent intentAutreAc = new Intent(FormulaireActivity.this, AutreActivity.class);
                    startActivity(intentAutreAc);

                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
