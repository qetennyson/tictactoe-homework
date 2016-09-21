package com.wesleyreisz.tictactoe;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.wesleyreisz.tictactoe.Game.Game;

import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testPlayer2Column(){
        Game game = Game.getInstance();
        game.reset();
        game.makeMove("1_1");//player1
        game.makeMove("1_3");//player2
        game.makeMove("2_2");//player1
        game.makeMove("2_3");//player2
        game.makeMove("3_1");//player1
        game.makeMove("3_3");//player2
        Assert.assertEquals(game.checkForWin(),Game.PLAYER2);

    }

    public void testPlayer1Column(){
        Game game = Game.getInstance();
        game.reset();
        game.makeMove("1_3");//player1
        game.makeMove("1_2");//player2
        game.makeMove("2_3");//player1
        game.makeMove("2_2");//player2
        game.makeMove("3_3");//player1
        Assert.assertEquals(game.checkForWin(),Game.PLAYER1);
    }

    public void testPlayer1Row(){
        Game game = Game.getInstance();
        game.reset();
        game.makeMove("3_1");//player1
        game.makeMove("2_1");//player2
        game.makeMove("3_2");//player1
        game.makeMove("2_2");//player2
        game.makeMove("3_3");//player1
        Assert.assertEquals(game.checkForWin(),Game.PLAYER1);
    }

    public void testPlayer2Row(){
        Game game = Game.getInstance();
        game.reset();
        game.makeMove("1_1");//player1
        game.makeMove("2_1");//player2
        game.makeMove("1_2");//player1
        game.makeMove("2_2");//player2
        game.makeMove("3_1");//player1
        game.makeMove("2_3");//player2
        Assert.assertEquals(game.checkForWin(),Game.PLAYER2);
    }

    public void testPlayer1Diagonial(){
        Game game = Game.getInstance();
        game.reset();
        game.makeMove("1_1");//player1
        game.makeMove("1_2");//player2
        game.makeMove("2_2");//player1
        game.makeMove("1_3");//player2
        game.makeMove("3_3");//player1
        Assert.assertEquals(game.checkForWin(),Game.PLAYER1);
    }

    public void testPlayer1CounterDiagonial(){
        Game game = Game.getInstance();
        game.reset();
        game.makeMove("1_3");//player1
        game.makeMove("1_2");//player2
        game.makeMove("2_2");//player1
        game.makeMove("3_3");//player2
        game.makeMove("3_1");//player1
        Assert.assertEquals(game.checkForWin(),Game.PLAYER1);
    }
    public void testPlayer2ResetCounterDiagonial(){
        Game game = Game.getInstance();
        game.reset();
        game.makeMove("1_3");//player1
        game.makeMove("1_2");//player2
        game.makeMove("2_2");//player1
        game.makeMove("3_3");//player2
        game.makeMove("3_1");//player1
        game.reset();

        game = Game.getInstance();
        game.makeMove("1_1");//player1
        game.makeMove("1_3");//player2
        game.makeMove("1_2");//player1
        game.makeMove("2_2");//player2
        game.makeMove("2_3");//player1
        game.makeMove("3_1");//player2
        Assert.assertEquals(game.checkForWin(),Game.PLAYER2);
    }
    public void testDraw(){
        Game game = Game.getInstance();
        game.reset();
        game.makeMove("1_1");//player1
        game.makeMove("1_2");//player2
        game.makeMove("2_1");//player1
        game.makeMove("2_2");//player2
        game.makeMove("1_3");//player1
        game.makeMove("3_1");//player2
        game.makeMove("3_2");//player1
        game.makeMove("3_3");//player2
        game.makeMove("2_3");//player1
        Assert.assertEquals(game.checkForWin(),Game.DRAW);
    }
}