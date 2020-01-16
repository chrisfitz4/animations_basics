package com.illicitintelligence.android.animationbasics.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.illicitintelligence.android.animationbasics.R;
import com.illicitintelligence.android.animationbasics.customview.DroidSpace;

public class MainActivity extends AppCompatActivity {

    //private DroidSpace droidSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //droidSpace = new DroidSpace(this);


        setContentView(R.layout.activity_main);
        //droidSpace = findViewById(R.id.image);
        //setContentView(droidSpace);
        Button stop = findViewById(R.id.stop);
        Button speedUp = findViewById(R.id.speedUp);
        Button slowDown = findViewById(R.id.slowDown);
        Button rotate = findViewById(R.id.rotate);


//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                droidSpace.stop();
//                droidSpace.stopSpin();
//            }
//        });
//        speedUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                droidSpace.speedUp();
//            }
//        });
//        slowDown.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                droidSpace.slowDown();
//            }
//        });
//        rotate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                droidSpace.spin();
//            }
//        });

    }
}
