package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sqlite.dao.PersonneDatabase;
import com.example.sqlite.dao.PersonneDatabaseAccessor;
import com.example.sqlite.model.Personne;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView liste;
ArrayAdapter<Personne> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=findViewById(R.id.liste);
        //On va creer un nouveau thread
        Thread td =  new Thread(new Runnable() {
            @Override
            public void run() {
                Personne p= new Personne("Patino", "Ismael", 40, 2800.90f);
                PersonneDatabase dbobjet= PersonneDatabaseAccessor.getInstance(getBaseContext());
                dbobjet.daoGestion().insertPersonne(p);
                ArrayList<Personne> liste = (ArrayList<Personne>) dbobjet.daoGestion().loadAllPersonnes();
                for(Personne pers:liste){
                    Log.d("personne", pers.toString());
                }
                //init adapter
                aa=new ArrayAdapter<Personne>(getBaseContext(),android.R.layout.simple_expandable_list_item_1,liste);
                //envoyer adapter au ThreadUI
                afficherUI(aa);
            }
        });
        td.start();
    }
    // cette methode se deroule dans le Thread UI
    private void afficherUI(final ArrayAdapter<Personne> adp) {
            runOnUiThread(new Runnable() {
            @Override
            public void run() {
                liste.setAdapter(adp);
            }
        });
    }
}
