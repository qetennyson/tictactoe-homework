package com.wesleyreisz.tictactoe;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.wesleyreisz.tictactoe.Game.Game;
import com.wesleyreisz.tictactoe.Game.GameUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireEvents();
    }

    @Override
    public void onClick(View view) {
        Game game = Game.getInstance();
        game.makeMove(GameUtil.getPosition(view.getId()));
        updateUI(game,view);

        int winner = game.checkForWin();
        if(winner==Game.PLAYER1 || winner==Game.PLAYER2){
           Toast.makeText(this, "Player " + winner + " wins",Toast.LENGTH_SHORT).show();
        }else if(winner==Game.DRAW){
            Toast.makeText(this, "Game was a Draw",Toast.LENGTH_SHORT).show();
        }else{ /* nothing, keep playing */}
    }

    private void updateUI(Game game, View view){
        if (game.getCurrentPlayer()==Game.PLAYER1) {
            ((ImageButton) view).setImageResource(R.drawable.o);
        }else{
            ((ImageButton) view).setImageResource(R.drawable.x);
        }
    }
    private void wireEvents() {
        ImageButton button1_1 = (ImageButton)findViewById(R.id.btn1_1);
        button1_1.setOnClickListener(this);
        ImageButton button1_2 = (ImageButton)findViewById(R.id.btn1_2);
        button1_2.setOnClickListener(this);
        ImageButton button1_3 = (ImageButton)findViewById(R.id.btn1_3);
        button1_3.setOnClickListener(this);
        ImageButton button2_1 = (ImageButton)findViewById(R.id.btn2_1);
        button2_1.setOnClickListener(this);
        ImageButton button2_2 = (ImageButton)findViewById(R.id.btn2_2);
        button2_2.setOnClickListener(this);
        ImageButton button2_3 = (ImageButton)findViewById(R.id.btn2_3);
        button2_3.setOnClickListener(this);
        ImageButton button3_1 = (ImageButton)findViewById(R.id.btn3_1);
        button3_1.setOnClickListener(this);
        ImageButton button3_2 = (ImageButton)findViewById(R.id.btn3_2);
        button3_2.setOnClickListener(this);
        ImageButton button3_3 = (ImageButton)findViewById(R.id.btn3_3);
        button3_3.setOnClickListener(this);

        Button btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageButton button1_1 = (ImageButton)findViewById(R.id.btn1_1);
                button1_1.setImageResource(R.drawable.blank);
                ImageButton button1_2 = (ImageButton)findViewById(R.id.btn1_2);
                button1_2.setImageResource(R.drawable.blank);
                ImageButton button1_3 = (ImageButton)findViewById(R.id.btn1_3);
                button1_3.setImageResource(R.drawable.blank);
                ImageButton button2_1 = (ImageButton)findViewById(R.id.btn2_1);
                button2_1.setImageResource(R.drawable.blank);
                ImageButton button2_2 = (ImageButton)findViewById(R.id.btn2_2);
                button2_2.setImageResource(R.drawable.blank);
                ImageButton button2_3 = (ImageButton)findViewById(R.id.btn2_3);
                button2_3.setImageResource(R.drawable.blank);
                ImageButton button3_1 = (ImageButton)findViewById(R.id.btn3_1);
                button3_1.setImageResource(R.drawable.blank);
                ImageButton button3_2 = (ImageButton)findViewById(R.id.btn3_2);
                button3_2.setImageResource(R.drawable.blank);
                ImageButton button3_3 = (ImageButton)findViewById(R.id.btn3_3);
                button3_3.setImageResource(R.drawable.blank);

                Game game = Game.getInstance();
                game.reset();

            }
        });
    }
}
