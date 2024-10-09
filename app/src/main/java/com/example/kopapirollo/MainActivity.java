package com.example.kopapirollo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rockbutton;
    private Button paperbutton;
    private Button scissorsbutton;
    private ImageView playerimage;
    private ImageView oppimage;
    private TextView playertext;
    private TextView opptext;
    private TextView resulttext;
    private int playerszam;
    private int oppszam;
    private AlertDialog alertDialog;
    private Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

        rockbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerimage.setImageResource(R.drawable.rock);
                int[] images = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};
                int temp = random.nextInt(images.length);
                oppimage.setImageResource(images[temp]);

                switch(temp) {
                    case 2:
                        playerszam++;
                        resulttext.setText("Eredmény: Ember: " + playerszam + " Gép: " + oppszam);
                        if (playerszam >= 3) {
                            endgame("Győztél");
                        }
                        break;
                    case 1:
                        oppszam++;
                        resulttext.setText("Eredmény: Ember: " + playerszam + " Gép: " + oppszam);
                        if (oppszam >= 3) {
                            endgame("Vesztettél");
                        }
                        break;
                    default:
                        // code block
                }
            }
        });

        paperbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerimage.setImageResource(R.drawable.paper);
                int[] images = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};
                int temp = random.nextInt(images.length);
                oppimage.setImageResource(images[temp]);

                switch(temp) {
                    case 0:
                        playerszam++;
                        resulttext.setText("Eredmény: Ember: " + playerszam + " Gép: " + String.valueOf(oppszam));
                        if (playerszam >= 3) {
                            endgame("Győztél");
                        }
                        break;
                    case 2:
                        oppszam++;
                        resulttext.setText("Eredmény: Ember: " + String.valueOf(playerszam) + " Gép: " + String.valueOf(oppszam));
                        if (oppszam >= 3) {
                            endgame("Vesztettél");
                        }
                        break;
                    default:
                        // code block
                }
            }
        });

        scissorsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerimage.setImageResource(R.drawable.scissors);
                int[] images = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};
                int temp = random.nextInt(images.length);
                oppimage.setImageResource(images[temp]);

                switch(temp) {
                    case 1:
                        playerszam++;
                        resulttext.setText("Eredmény: Ember: " + String.valueOf(playerszam) + " Gép: " + String.valueOf(oppszam));
                        if (playerszam >= 3) {
                            endgame("Győztél");
                        }
                        break;
                    case 0:
                        oppszam++;
                        resulttext.setText("Eredmény: Ember: " + String.valueOf(playerszam) + " Gép: " + String.valueOf(oppszam));
                        if (oppszam >= 3) {
                            endgame("Vesztettél");
                        }
                        break;
                    default:
                        // code block
                }
            }
        });

    }


    private void endgame(String winner) {
        alertDialog = new android.app.AlertDialog.Builder(MainActivity.this).setTitle(winner).setMessage("Vége lett a játéknak").setCancelable(false).setPositiveButton("Új Játék", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        init();
                    }
                }).
                setNegativeButton("Kilépás", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).create();
        alertDialog.show();
    }

    private void init() {
        rockbutton = findViewById(R.id.rockbutton);
        paperbutton = findViewById(R.id.paperbutton);
        scissorsbutton = findViewById(R.id.scissorsbutton);
        playerimage = findViewById(R.id.playerimage);
        oppimage = findViewById(R.id.oppimage);
        playertext = findViewById(R.id.playertext);
        opptext = findViewById(R.id.opptext);
        resulttext = findViewById(R.id.resulttext);
        playerszam = 0;
        oppszam = 0;
        playertext.setText("A te választásod");
        opptext.setText("A gép választása");
        resulttext.setText("Eredmény: Ember: " + String.valueOf(playerszam) + " Gép: " + String.valueOf(oppszam));


    }
}