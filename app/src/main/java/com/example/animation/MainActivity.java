package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout page;
    Animation leftAnimation;
    Animation rightAnimation;
    boolean isPageOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page = findViewById(R.id.page);
        leftAnimation=AnimationUtils.loadAnimation(this,R.anim.translate_left);
        rightAnimation=AnimationUtils.loadAnimation(this,R.anim.translate_right);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageOpen) {
                    page.startAnimation(rightAnimation);
                    isPageOpen=false;
                }else{
                    page.startAnimation(leftAnimation);
                    page.setVisibility(View.VISIBLE);
                    isPageOpen=true;
                }
            }
        });

        MyAnimationListener animationListener=new MyAnimationListener();
        leftAnimation.setAnimationListener(animationListener);
    }
    private class MyAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            page.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
