package com.qiwogames.mic_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qiwogames.mic_app_android.datas.JeuxVideoModele;

public class DetailsJeuxActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_jeux);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            //les 4 champs XML
            TextView nomJeux = findViewById(R.id.nom_jeux_details);
            ImageView imageJeux = findViewById(R.id.image_jeux_video_details);
            TextView descriptionJeux = findViewById(R.id.description_jeux_video_details);
            TextView prixJeux = findViewById(R.id.prix_jeux_video_details);
            //On recup les 4 champs depuis l'adapter en fonction de leurs position
            //On recup la varaiable extra creer dans l'adapter
            String getNom = (String) bundle.get("NOM_JEUX");
            int getImage = (int) bundle.get("IMAGE_JEUX");
            String getDescription = (String) bundle.get("DESCRIPTION_JEUX");
            String getPrix = (String) bundle.get("PRIX_JEUX");

            //On assigne la valeur extra au champ xml
            nomJeux.setText(getNom);
            imageJeux.setImageResource(getImage);
            descriptionJeux.setText(getDescription);
            prixJeux.setText(getPrix);
        }
    }

    //retour a l'acceuil des jeux
    public void backToGamesGallery(){
        Button btn_retour = (Button) findViewById(R.id.btn_retour_jeux);
        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsJeuxActivity.this, JeuxVideoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void buyGames(){
        Button btn_buy = (Button) findViewById(R.id.btn_acheter);

    }


}