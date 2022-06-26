package com.qiwogames.mic_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qiwogames.mic_app_android.adapter.JeuxVideoAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Au clic la fonction triggerJeuxVideoActivity() appel l'activite JeuxVideoActivity
        triggerJeuxVideoActivity();
    }

    void triggerJeuxVideoActivity(){
        //recup le bouton
        Button btn_enter = findViewById(R.id.btn_enter);
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JeuxVideoActivity.class);
                startActivity(intent);

            }
        });
    }
}