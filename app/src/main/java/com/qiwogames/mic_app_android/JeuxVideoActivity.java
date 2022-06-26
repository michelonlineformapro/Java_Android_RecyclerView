package com.qiwogames.mic_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.qiwogames.mic_app_android.adapter.JeuxVideoAdapter;
import com.qiwogames.mic_app_android.datas.JeuxVideoModele;

public class JeuxVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux_video);

        //Appel du modele et insatnce des données POJO (Plain old java object)
        JeuxVideoModele[] jeuxPcEngine = new JeuxVideoModele[]{
                new JeuxVideoModele("Barunba", R.drawable.barunba,"Jeux de Namco shooter side scrolling sorti sur Pc engine et MSX en 1990", "125.25 €"),
                new JeuxVideoModele("Bomberman", R.drawable.bomberman,"Appeler egalement Dyna Blaster, Bomberma est un portage du jeux arcade sorti en 1985", "75.35 €"),
                new JeuxVideoModele("Castlevania", R.drawable.castlevania,"Akumojo Dracula X est un jeu de Konami sortie en 1993 et uniquement au Japon", "352.15 €"),
        };

        //recup du parent recyclerview xml = rappel ce dernier est binder avec l'enfant grace a la classe adapter
        RecyclerView mon_rv = (RecyclerView) findViewById(R.id.rv_jv);
        //Appel de l'adapter
        //et on ajoute le tableau de donnée du modele
        JeuxVideoAdapter jv_adapter = new JeuxVideoAdapter(jeuxPcEngine);
        //Reference au layout manager = LinearLayout pour les 2
        mon_rv.setLayoutManager(new LinearLayoutManager(this));
        //Definition de l'adapter
        mon_rv.setAdapter(jv_adapter);
    }
}