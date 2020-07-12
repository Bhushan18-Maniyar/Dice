package com.example.dell.dice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {


    Button roll;
    LottieAnimationView dice;
    TextView num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dice = (LottieAnimationView) findViewById(R.id.animation_view);
        dice.setVisibility(View.VISIBLE);
        dice.playAnimation();
        roll = (Button) findViewById(R.id.roll);
        num = (TextView) findViewById(R.id.num);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDice();
                dice.playAnimation();
            }
        });
        dice.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onAnimationEnd(Animator animator) {
                hideDice();
                int random = ThreadLocalRandom.current().nextInt(1, 7);
                String s = random + "";
                num.setText(s);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });


    }


    public void hideDice(){
        dice.setVisibility(View.INVISIBLE);
        num.setVisibility(View.VISIBLE);
        roll.setEnabled(true);
    }

    public void showDice(){
        dice.setVisibility(View.VISIBLE);
        num.setVisibility(View.INVISIBLE);
        roll.setEnabled(false);
    }

}
