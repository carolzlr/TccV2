package com.example.tccv2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowInsets;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurações de tela cheia
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        setContentView(R.layout.activity_splash);

        // Postagem atrasada para iniciar a próxima atividade após 1 segundo
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                startLoginActivity();
                finish(); // Finaliza a atividade de splash após iniciar a atividade de login
            }
        }, 1000); // 1000 milissegundos = 1 segundo
    }

    // Método para iniciar a atividade de login
    private void startLoginActivity() {
        Intent intent = new Intent(Splash.this, Login.class);
        startActivity(intent);
    }
}