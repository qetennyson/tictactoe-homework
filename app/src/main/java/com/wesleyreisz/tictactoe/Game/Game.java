package com.wesleyreisz.tictactoe.Game;

import android.util.Log;

/**
 * Created by wesleyreisz on 9/21/16.
 */
public class Game {
    private static final String TAG = "GAME";

    public static final int BLANK = 0;
    public static final int PLAYER1 = 1;
    public static final int PLAYER2 = 2;
    public static final int DRAW = 3;

    public static final int MAX_ROWCOL = 3;

    private static Game game = new Game();

    private int currentPlayer;
    private int[][]board;
    private int totalMoves;

    private Game(){
        this.currentPlayer = Game.PLAYER1;
        this.board = new int[3][3];
        this.totalMoves = 0;
    }

    public static Game getInstance(){
        return game;
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public void makeMove(String position) throws RuntimeException{
        //Log.d(TAG,String.format("Player %s moved to: %s", currentPlayer, position)); //game.makeMove("3_1");//player1
        Log.d(TAG,String.format("game.makeMove(\"%s\");//%s", position, "player"+currentPlayer));
        updateBoard(position, currentPlayer);
        swapPlayer();
        totalMoves++;
    }

    /*check for win logic is NOT correct*/
    public int checkForWin() {
        //check each row for a win
        //[0,0][0,1][0,2] && [1,0][1,1][1,2] && [2,0][2,1][2,2]
        for(int x=0;x<MAX_ROWCOL;x++){
            if((board[x][0]==board[x][1])&&(board[x][1]==board[x][2]) && board[x][1]!=BLANK){
                return board[x][0];
            }
        }

        //check each col for a win
        //[0,0][1,0][2,0] && [0,1][1,1][2,1] && [0,2][1,2][2,2]
        for(int y=0;y<MAX_ROWCOL;y++) {
            if ((board[0][y]==board[1][y]) && (board[1][y]==board[2][y]) && board[0][y]!=BLANK) {
                return board[2][y];
            }
        }

        //check diagonal
        if((board[0][0]==board[1][1])&&(board[1][1]==board[2][2])&& board[1][1]!=BLANK){
            return board[1][1];
        }
        //check inverse diagonal
        if((board[0][2]==board[1][1])&&(board[1][1]==board[2][0])&& board[1][1]!=BLANK){
            return board[1][1];
        }

        //check draw
        if (totalMoves>=9){
            return DRAW;
        }

        return BLANK;
    }

    private void updateBoard(String position, int currentPlayer) throws RuntimeException{
        if(position==null || position.isEmpty()){
            throw new RuntimeException("Invalid input Exception");
        }
        int pos1 = Integer.parseInt(position.split("_")[0])-1;//zero based
        int pos2 = Integer.parseInt(position.split("_")[1])-1;//zero based
        board[pos1][pos2]=currentPlayer;
    }

    private void swapPlayer(){
        if(this.currentPlayer==Game.PLAYER1){
            this.currentPlayer=Game.PLAYER2;
        }else {
            this.currentPlayer=Game.PLAYER1;
        }
    }

    public void reset() {
        game = new Game();
    }

    public boolean hasStarted(){
        if (totalMoves>0){
            return true;
        }else{
            return false;
        }
    }

    public int[][]getBoard(){
        return board;
    }
}
