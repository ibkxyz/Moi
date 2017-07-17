package com.example.abc.moi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn_push;
    private TextView txt_reset, txt_random_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_push = (ImageButton) findViewById(R.id.button_random_image);
        txt_reset = (TextView) findViewById(R.id.text_reset);
        txt_random_number = (TextView) findViewById(R.id.text_random_number);


        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random_number = new Random();
                final int number = random_number.nextInt(50 - 1) + 1;
                String numbr = Integer.toString(number);
                txt_random_number.setText(numbr);
            }
        });


        txt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_random_number.setText("0");
            }
        });
    }
}
