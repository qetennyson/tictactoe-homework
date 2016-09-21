package com.wesleyreisz.tictactoe.Game;

import com.wesleyreisz.tictactoe.R;

/**
 * Created by wesleyreisz on 9/21/16.
 */
public class GameUtil {
    public static String getPosition(int buttonId){
        switch(buttonId){
            case R.id.btn1_1:
                return "1_1";
            case R.id.btn1_2:
                return "1_2";
            case R.id.btn1_3:
                return "1_3";
            case R.id.btn2_1:
                return "2_1";
            case R.id.btn2_2:
                return "2_2";
            case R.id.btn2_3:
                return "2_3";
            case R.id.btn3_1:
                return "3_1";
            case R.id.btn3_2:
                return "3_2";
            default:
                return "3_3";
        }
    }
}
