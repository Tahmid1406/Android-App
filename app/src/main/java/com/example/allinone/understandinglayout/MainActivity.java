package com.example.allinone.understandinglayout;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    // player zero gets red ball and player 1 gets black ball
    int player = 0;

    //2 means not played
    int[] playedOrNot = {2,2,2,2,2,2,2,2,2};
    //To store the winning position i'm using an array of arrays where each array holds a winning condition
    int[][] winIfPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void bringRed(View view){



        ImageView counter = (ImageView) view;
        int tappedCell = Integer.parseInt(counter.getTag().toString());
        if(playedOrNot[tappedCell]==2) {
            counter.setTranslationY(-1000f);
            playedOrNot[tappedCell] = player;
            if (player == 0) {
                counter.setImageResource(R.drawable.red);
                player = 1;
            } else {
                counter.setImageResource(R.drawable.black);
                player = 0;
            }

            counter.animate().alpha(1).translationYBy(1000f).rotationY(360f).setDuration(300);
        }
        for(int[] match : winIfPosition){
            if(playedOrNot[match[0]]== playedOrNot[match[1]] && playedOrNot[match[1]]== playedOrNot[match[2]]
                    && playedOrNot[match[0]] != 2){
                TextView winnerMessage = (TextView)findViewById(R.id.winnerMessage);
                if(playedOrNot[match[0]]==0){
                    winnerMessage.setText("Red Has Won!");
                }else{
                    winnerMessage.setText("Black Has Won!");
                }

                //winnerMessage.setText(" Wins!!");
                //Toast.makeText(this, "Someone Won", Toast.LENGTH_SHORT).show();
                //after someone has won we want to display the play again layout
                LinearLayout layout = (LinearLayout)findViewById(R.id.win);
                layout.setVisibility(View.VISIBLE);

            }
        }
    }

    public void playAgain(View view){
        // to play again first we need to make that Linear Layout disapper
        LinearLayout layout = (LinearLayout)findViewById(R.id.win);
        layout.setVisibility(View.INVISIBLE);
        //then we need to take the gamestate to the inital state
        player = 0;
        // then we need to set the gamestates back to 2's
        for(int i=0; i<playedOrNot.length; i++){
            playedOrNot[i] = 2;
        }
        ImageView img0 = (ImageView)findViewById(R.id.img0);
        img0.setAlpha(0f);

        ImageView img1 = (ImageView)findViewById(R.id.img1);
        img1.setAlpha(0f);

        ImageView img2 = (ImageView)findViewById(R.id.img2);
        img2.setAlpha(0f);

        ImageView img3 = (ImageView)findViewById(R.id.img3);
        img3.setAlpha(0f);

        ImageView img4 = (ImageView)findViewById(R.id.img4);
        img4.setAlpha(0f);

        ImageView img5 = (ImageView)findViewById(R.id.img5);
        img5.setAlpha(0f);

        ImageView img6 = (ImageView)findViewById(R.id.img6);
        img6.setAlpha(0f);

        ImageView img7 = (ImageView)findViewById(R.id.img7);
        img7.setAlpha(0f);

        ImageView img8 = (ImageView)findViewById(R.id.img8);
        img8.setAlpha(0f);




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
