package com.qiwogames.mic_app_android.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qiwogames.mic_app_android.DetailsJeuxActivity;
import com.qiwogames.mic_app_android.MainActivity;
import com.qiwogames.mic_app_android.R;
import com.qiwogames.mic_app_android.datas.JeuxVideoModele;


public class JeuxVideoAdapter extends RecyclerView.Adapter<JeuxVideoAdapter.ViewHolder> {

    //Tableau d'item string
    private JeuxVideoModele[] localDataJeuxVideo;

    public JeuxVideoAdapter(JeuxVideoModele[] jeuxPcEngine) {
        this.localDataJeuxVideo = jeuxPcEngine;
    }

    //Init du tableau de valeur = reference au type de valeur qu'on utilise
    //Ceci est le constructeur de localDataJeuxVideo


    public static  class ViewHolder extends RecyclerView.ViewHolder{
        //les variables du modele = ils ont besoin d'un constructeur pour l'instance soit la fonction ViewHolder
        private final TextView nomProduit;
        private final ImageView imageProduit;
        private final TextView descriptionProduit;
        private final TextView prixProduit;

        //le layout linear
        public LinearLayout dispositionLineaire;
        //La methode ViewHolder dont herite jeuxVideo Adapter
        public ViewHolder(View vue){
            //Herite du constructor
            super(vue);
            //On assigne les variables au xml = on a besoin en java de caster le type
            nomProduit = (TextView) vue.findViewById(R.id.nom_jeux_video);
            imageProduit = (ImageView) vue.findViewById(R.id.image_jeux_video);
            descriptionProduit = (TextView) vue.findViewById(R.id.description_jeux_video);
            prixProduit = (TextView) vue.findViewById(R.id.prix_jeux_video);
            //appel du layout de l'efant par son id associé a la variable
            dispositionLineaire = (LinearLayout) vue.findViewById(R.id.linear_layout_enfant_jv);

        }

    }


    //A la creation de la vue
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creer une nouvelle vue qui definit l'UI de la liste des items
        //Inflate gonfle le parent avec le layout enfant
        //Le parent activity_jeux_video.xml est associé au l'enfant : jeux_video_item.xml
        View vue = LayoutInflater.from(parent.getContext()).inflate(R.layout.jeux_video_item, parent, false);
        //Retourne le layout parent qui embarque la liste enfant
        return new ViewHolder(vue);
    }

    //La liason entre les variables, le xml et le modele
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //appel de la classe modele assigné au tableau de données
        JeuxVideoModele modeleJeux = localDataJeuxVideo[position];
        //Recup des valeur du modele avec les accesseur (getter) a la bonne position dans la liste et remplace le contenu de la vue de chaque elements
        //Le param viewHolder recup le type (Text, ImageView ,etc...) et accede au mutateur (setter) a l'index du tableau
        //On appel donc les 4 getters de la classe modele
        holder.nomProduit.setText(localDataJeuxVideo[position].getNom_jeux());
        holder.imageProduit.setImageResource(localDataJeuxVideo[position].getImage_jeux());
        holder.descriptionProduit.setText(localDataJeuxVideo[position].getDescription_jeux());
        holder.prixProduit.setText(localDataJeuxVideo[position].getPrix_jeux());

        //Triger le clic sur chaque item
        holder.dispositionLineaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsJeuxActivity.class);
                intent.putExtra("NOM_JEUX", localDataJeuxVideo[position].getNom_jeux());
                intent.putExtra("IMAGE_JEUX", localDataJeuxVideo[position].getImage_jeux());
                intent.putExtra("DESCRIPTION_JEUX", localDataJeuxVideo[position].getDescription_jeux());
                intent.putExtra("PRIX_JEUX", localDataJeuxVideo[position].getPrix_jeux());
                //Toast.makeText(view.getContext(),"clic : "+ modeleJeux.getDescription_jeux(),Toast.LENGTH_LONG).show();
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        //Retourne la longueur du tableau = donc de la liste
        return localDataJeuxVideo.length;
    }





}
