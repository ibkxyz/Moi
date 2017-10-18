package com.example.abc.moi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ImageButton btn_push;
    private TextView txt_random_number;
    private String m_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        alert();
        btn_push = (ImageButton) findViewById(R.id.button_random_image);
        txt_random_number = (TextView) findViewById(R.id.text_random_number);


        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_push.setImageResource(R.drawable.push_gif);

                Random random_number = new Random();

                int in_text = Integer.valueOf(m_Text);
                final int number = random_number.nextInt(in_text - 1) + 1;


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        String numbr = Integer.toString(number);
                        txt_random_number.setText(numbr);

                        btn_push.setImageResource(R.drawable.moi_push_small);

                    }
                }, 2000);


            }
        });

    }

    public void alert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Moi Range");

        // Set up the input
        final EditText input = new EditText(this);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text

        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                btn_push.setEnabled(false);
                Toast.makeText(getApplicationContext(), "Press the reset button to activate Moi", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Add Menu Item
        getMenuInflater().inflate(R.menu.menu_moi, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the Reset menu option
            case R.id.action_reset:
                txt_random_number.setText("0");
                alert();
                btn_push.setEnabled(true);

                return true;
            // Respond to a click on the Quit menu option
            case R.id.action_quit:

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getApplicationContext(), "Thank you for using Moi - @ibk_xyz", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }, 2000);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
