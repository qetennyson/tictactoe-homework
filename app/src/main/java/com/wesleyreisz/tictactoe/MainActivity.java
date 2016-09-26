package com.wesleyreisz.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.wesleyreisz.tictactoe.Game.Game;
import com.wesleyreisz.tictactoe.Game.GameUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        Game game = Game.getInstance();
        game.makeMove(GameUtil.getPosition(view.getId()));
        updateUI(game,view);
        showWinner(game.checkForWin());
    }

    @Override
    protected void onStart() {
        super.onStart();

        //reset board vs game
        Game game = Game.getInstance();
        if (game.hasStarted()){
            resetBoard();
        }else{
            resetGame();
        }

    }

    private void wireEvents(boolean isGameBoardEnabled, boolean isResettingBoard) {
        ImageButton button1_1 = (ImageButton)findViewById(R.id.btn1_1);
        button1_1.setEnabled(isGameBoardEnabled);
        button1_1.setOnClickListener(this);
        if (isResettingBoard)
            button1_1.setImageResource(R.drawable.blank);

        ImageButton button1_2 = (ImageButton)findViewById(R.id.btn1_2);
        button1_2.setEnabled(isGameBoardEnabled);
        button1_2.setOnClickListener(this);
        if (isResettingBoard)
            button1_2.setImageResource(R.drawable.blank);

        ImageButton button1_3 = (ImageButton)findViewById(R.id.btn1_3);
        button1_3.setEnabled(isGameBoardEnabled);
        button1_3.setOnClickListener(this);
        if (isResettingBoard)
            button1_3.setImageResource(R.drawable.blank);

        ImageButton button2_1 = (ImageButton)findViewById(R.id.btn2_1);
        button2_1.setEnabled(isGameBoardEnabled);
        button2_1.setOnClickListener(this);
        if (isResettingBoard)
            button2_1.setImageResource(R.drawable.blank);

        ImageButton button2_2 = (ImageButton)findViewById(R.id.btn2_2);
        button2_2.setEnabled(isGameBoardEnabled);
        button2_2.setOnClickListener(this);
        if (isResettingBoard)
            button2_2.setImageResource(R.drawable.blank);

        ImageButton button2_3 = (ImageButton)findViewById(R.id.btn2_3);
        button2_3.setEnabled(isGameBoardEnabled);
        button2_3.setOnClickListener(this);
        if (isResettingBoard)
            button2_3.setImageResource(R.drawable.blank);

        ImageButton button3_1 = (ImageButton)findViewById(R.id.btn3_1);
        button3_1.setEnabled(isGameBoardEnabled);
        button3_1.setOnClickListener(this);
        if (isResettingBoard)
            button3_1.setImageResource(R.drawable.blank);

        ImageButton button3_2 = (ImageButton)findViewById(R.id.btn3_2);
        button3_2.setEnabled(isGameBoardEnabled);
        button3_2.setOnClickListener(this);
        if (isResettingBoard)
            button3_2.setImageResource(R.drawable.blank);

        ImageButton button3_3 = (ImageButton)findViewById(R.id.btn3_3);
        button3_3.setEnabled(isGameBoardEnabled);
        button3_3.setOnClickListener(this);
        if (isResettingBoard)
            button3_3.setImageResource(R.drawable.blank);

        Button btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }
    private void updateUI(Game game, View view){
        view.setEnabled(false);
        if (game.getCurrentPlayer()==Game.PLAYER1) {
            ((ImageButton) view).setImageResource(R.drawable.o);
        }else{
            ((ImageButton) view).setImageResource(R.drawable.x);
        }
    }
    private void showWinner(int winner) {
        if(winner==Game.PLAYER1 || winner==Game.PLAYER2){
            Toast.makeText(this, "Player " + winner + " wins",Toast.LENGTH_SHORT).show();
            wireEvents(false, false);
        }else if(winner==Game.DRAW){
            Toast.makeText(this, "Game was a Draw",Toast.LENGTH_SHORT).show();
            wireEvents(false, false);
        }else{ /* nothing, keep playing */}
    }
    private void resetGame() {
        Game game = Game.getInstance();
        game.reset();
        wireEvents(true, true);
    }
    private void resetBoard() {
        wireEvents(true, false);
        resetGameTile((ImageButton)findViewById(R.id.btn1_1), Game.getInstance().getBoard()[0][0]);
        resetGameTile((ImageButton)findViewById(R.id.btn1_2), Game.getInstance().getBoard()[0][1]);
        resetGameTile((ImageButton)findViewById(R.id.btn1_3), Game.getInstance().getBoard()[0][2]);
        resetGameTile((ImageButton)findViewById(R.id.btn2_1), Game.getInstance().getBoard()[1][0]);
        resetGameTile((ImageButton)findViewById(R.id.btn2_2), Game.getInstance().getBoard()[1][1]);
        resetGameTile((ImageButton)findViewById(R.id.btn2_3), Game.getInstance().getBoard()[1][2]);
        resetGameTile((ImageButton)findViewById(R.id.btn3_1), Game.getInstance().getBoard()[2][0]);
        resetGameTile((ImageButton)findViewById(R.id.btn3_2), Game.getInstance().getBoard()[2][1]);
        resetGameTile((ImageButton)findViewById(R.id.btn3_3), Game.getInstance().getBoard()[2][2]);
    }
    private void resetGameTile(ImageButton btn, int move){
        if(move==Game.PLAYER1){
            btn.setImageResource(R.drawable.x);
        }else if(move==Game.PLAYER2){
            btn.setImageResource(R.drawable.o);
        }else{
            btn.setImageResource(R.drawable.blank);
        }
    }
}
