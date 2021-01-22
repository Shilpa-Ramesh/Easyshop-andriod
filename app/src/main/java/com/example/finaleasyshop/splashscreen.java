package com.example.finaleasyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;
    SharedPreferences onBoardingScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_splashscreen);
        topAnim = AnimationUtils.loadAnimation( this, R.anim.top_animation );
        bottomAnim = AnimationUtils.loadAnimation( this, R.anim.bottom_animation );
        image = findViewById( R.id.imageView );
        slogan = findViewById( R.id.textView1 );
        image.setAnimation( topAnim );
        slogan.setAnimation( bottomAnim );

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        TextView textView = findViewById(R.id.textView1);
        startActivity(intent);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences( "onBoardingScreen", MODE_PRIVATE );
                boolean isFirstTime = onBoardingScreen.getBoolean( "First time", true );

                if (isFirstTime) {
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean( "First time", false );
                    editor.commit();
                    Intent intent = new Intent( splashscreen.this, MainActivity.class );
                    startActivity( intent );
                    finish();
                }
//                else {
//                    Intent intent = new Intent( splashscreen.this, drawer.class );
//                    startActivity( intent );
//                    finish();
//                }

            }
        }, SPLASH_SCREEN );
    }
}