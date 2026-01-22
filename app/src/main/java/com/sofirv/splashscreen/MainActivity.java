package com.sofirv.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Activar EdgeToEdge
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        // Ajuste de Insets (para que no se superponga con barra de sistema)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ---------------------------
        // ANIMACIONES
        // ---------------------------

        // 1️⃣ Top TextView (fade_in2)
        View topTitle = findViewById(R.id.TextViewTopTitle);
        Animation fadeIn2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        topTitle.startAnimation(fadeIn2);

        // Listener para pasar a MainMenuActivity al finalizar fade_in2
        fadeIn2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Cambia a tu Activity principal (MainMenuActivity)
                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);
                finish(); // cierra splash
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });

        // 2️⃣ TableLayout (animación compuesta: rotate + scale + alpha)
        View tableLayout = findViewById(R.id.TableLayout01);
        Animation customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        tableLayout.startAnimation(customAnim);
    }
}
