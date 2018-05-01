package com.example.jesse.crushnumber;

/*
Program: Number Crush
This: MainActivity.java
Date: 15 November 2017
Author: Jesse Leskanich, Quentin Vandermay-Kirkham, Henry Laurx, Miroslav Tomic
 */

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    //initialize flags (they don't work initializing them together?)
    boolean button1Flag = true; boolean button2Flag = true; boolean button3Flag = true; boolean button4Flag = true; boolean button5Flag = true;
    boolean button6Flag = true; boolean button7Flag = true; boolean button8Flag = true; boolean button9Flag = true; boolean button10Flag = true;
    boolean button11Flag = true; boolean button12Flag = true; boolean button13Flag = true; boolean button14Flag = true; boolean button15Flag = true;
    boolean button16Flag = true; boolean button17Flag = true; boolean button18Flag = true; boolean button19Flag = true; boolean button20Flag = true;
    boolean button21Flag = true; boolean button22Flag = true; boolean button23Flag = true; boolean button24Flag = true; boolean button25Flag = true;
    boolean button26Flag = true; boolean button27Flag = true; boolean button28Flag = true; boolean button29Flag = true; boolean button30Flag = true;

    private static final int[] idArray =
            {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12,
            R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18,
            R.id.button19, R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24,
            R.id.button25, R.id.button26, R.id.button27, R.id.button28, R.id.button29, R.id.button30};

    //Array to tell if clicked or not
    private Boolean [] flagArray = {button1Flag, button2Flag, button3Flag, button4Flag, button5Flag,
            button6Flag, button7Flag, button8Flag, button9Flag, button10Flag,
            button11Flag, button12Flag, button13Flag, button14Flag, button15Flag,
            button16Flag, button17Flag, button18Flag, button19Flag, button20Flag,
            button21Flag, button22Flag, button23Flag, button24Flag, button25Flag,
            button26Flag, button27Flag, button28Flag, button29Flag, button30Flag};

    Random rand = new Random();
    private Button[] button = new Button[idArray.length];
    int i;
    int totalScore = 0; //current score

    int r1, r2, r3; //initialize row variables
    int c1, c2, c3; //initialize column variables

    ArrayList <Integer> validateArray = new ArrayList<>(); //current placement of selected button(s)
    ArrayList <Integer> numbers = new ArrayList<>(); //what is the int in the buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView Score = (TextView) findViewById(R.id.Score);
        Score.setText("Score: " + totalScore); //set initial score of zero
        Toast.makeText(getApplicationContext(), "Select 3 Similar Consecutive Numbers", Toast.LENGTH_LONG).show(); //instructions toast

        //initial set up of random numbers/set default color
        for(i = 0; i < idArray.length; i++)
        {
            int num = rand.nextInt(4) + 1;
            button[i] = (Button)findViewById(idArray[i]);
            button[i].setText("" + num);
            numbers.add(num);
            button[i].setBackgroundColor(Color.GRAY);

        }

        //----------------------Listeners----------------------------

        Button Clear = (Button)findViewById(R.id.Clear);
        Clear.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        numbers.clear(); //clear current int placements
                        for (i = 0; i < idArray.length; i++) {
                            int num = rand.nextInt(4) + 1;
                            button[i] = (Button) findViewById(idArray[i]);
                            button[i].setText("" + num); //set ints in buttons
                            numbers.add(num); //add ints to numbers
                            button[i].setBackgroundColor(Color.GRAY); //reset all colors
                            totalScore = 0; //set total score to back to 0
                            Score.setText("Score: " + totalScore); //reset score
                            validateArray.clear(); //clear selected numbers
                        }
                    }
                }
        );

        Button Enter = (Button)findViewById(R.id.Enter);
        Enter.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if(isValid(validateArray))
                        {
                            Toast.makeText(getApplicationContext(), "+5 Points!", Toast.LENGTH_SHORT).show(); //display toast
                            Score.setText("Score: " + totalScore); //update score

                            int num = rand.nextInt(4) + 1;
                            numbers.set(validateArray.get(0) - 1, num);
                            button[validateArray.get(0) - 1].setText("" + num);
                            button[validateArray.get(0) - 1].setBackgroundColor(Color.GRAY);

                            num = rand.nextInt(4) + 1;
                            numbers.set(validateArray.get(1) - 1, num);
                            button[validateArray.get(1) - 1].setText("" + num);
                            button[validateArray.get(1) - 1].setBackgroundColor(Color.GRAY);

                            num = rand.nextInt(4) + 1;
                            numbers.set(validateArray.get(2) - 1, num);
                            button[validateArray.get(2) - 1].setText("" + num);
                            button[validateArray.get(2) - 1].setBackgroundColor(Color.GRAY);
                            validateArray.clear();
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move", Toast.LENGTH_SHORT).show();

                            for(i = 0; i < idArray.length; i++)
                            {
                                button[i].setBackgroundColor(Color.GRAY);
                                validateArray.clear();
                            }
                        }
                    }
                }
        );

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button1Flag) {
                            button1.setBackgroundColor(Color.BLUE);
                            button1Flag = false;
                            validateArray.add(1);
                        } else {
                            button1.setBackgroundColor(Color.GRAY);
                            button1Flag = true;
                            validateArray.remove(Integer.valueOf(1));
                        }
                    }
                }
        );

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button2Flag) {
                            button2.setBackgroundColor(Color.BLUE);
                            button2Flag = false;
                            validateArray.add(2);
                        } else {
                            button2.setBackgroundColor(Color.GRAY);
                            button2Flag = true;
                            validateArray.remove(Integer.valueOf(2));
                        }
                    }
                }
        );

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button3Flag) {
                            button3.setBackgroundColor(Color.BLUE);
                            button3Flag = false;
                            validateArray.add(3);
                        } else {
                            button3.setBackgroundColor(Color.GRAY);
                            button3Flag = true;
                            validateArray.remove(Integer.valueOf(3));
                        }
                    }
                }
        );
        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button4Flag) {
                            button4.setBackgroundColor(Color.BLUE);
                            button4Flag = false;
                            validateArray.add(4);
                        } else {
                            button4.setBackgroundColor(Color.GRAY);
                            button4Flag = true;
                            validateArray.remove(Integer.valueOf(4));
                        }
                    }
                }
        );
        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button5Flag) {
                            button5.setBackgroundColor(Color.BLUE);
                            button5Flag = false;
                            validateArray.add(5);
                        } else {
                            button5.setBackgroundColor(Color.GRAY);
                            button5Flag = true;
                            validateArray.remove(Integer.valueOf(5));
                        }
                    }
                }
        );
        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button6Flag) {
                            button6.setBackgroundColor(Color.BLUE);
                            button6Flag = false;
                            validateArray.add(6);
                        } else {
                            button6.setBackgroundColor(Color.GRAY);
                            button6Flag = true;
                            validateArray.remove(Integer.valueOf(6));
                        }
                    }
                }
        );
        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button7Flag) {
                            button7.setBackgroundColor(Color.BLUE);
                            button7Flag = false;
                            validateArray.add(7);
                        } else {
                            button7.setBackgroundColor(Color.GRAY);
                            button7Flag = true;
                            validateArray.remove(Integer.valueOf(7));
                        }
                    }
                }
        );
        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button8Flag) {
                            button8.setBackgroundColor(Color.BLUE);
                            button8Flag = false;
                            validateArray.add(8);
                        } else {
                            button8.setBackgroundColor(Color.GRAY);
                            button8Flag = true;
                            validateArray.remove(Integer.valueOf(8));
                        }
                    }
                }
        );
        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button9Flag) {
                            button9.setBackgroundColor(Color.BLUE);
                            button9Flag = false;
                            validateArray.add(9);
                        } else {
                            button9.setBackgroundColor(Color.GRAY);
                            button9Flag = true;
                            validateArray.remove(Integer.valueOf(9));
                        }
                    }
                }
        );
        final Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button10Flag) {
                            button10.setBackgroundColor(Color.BLUE);
                            button10Flag = false;
                            validateArray.add(10);
                        } else {
                            button10.setBackgroundColor(Color.GRAY);
                            button10Flag = true;
                            validateArray.remove(Integer.valueOf(10));
                        }
                    }
                }
        );
        final Button button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button11Flag) {
                            button11.setBackgroundColor(Color.BLUE);
                            button11Flag = false;
                            validateArray.add(11);
                        } else {
                            button11.setBackgroundColor(Color.GRAY);
                            button11Flag = true;
                            validateArray.remove(Integer.valueOf(11));
                        }
                    }
                }
        );
        final Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button12Flag) {
                            button12.setBackgroundColor(Color.BLUE);
                            button12Flag = false;
                            validateArray.add(12);
                        } else {
                            button12.setBackgroundColor(Color.GRAY);
                            button12Flag = true;
                            validateArray.remove(Integer.valueOf(13));
                        }
                    }
                }
        );
        final Button button13 = (Button) findViewById(R.id.button13);
        button13.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button13Flag) {
                            button13.setBackgroundColor(Color.BLUE);
                            button13Flag = false;
                            validateArray.add(13);
                        } else {
                            button13.setBackgroundColor(Color.GRAY);
                            button13Flag = true;
                            validateArray.remove(Integer.valueOf(13));
                        }
                    }
                }
        );
        final Button button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button14Flag) {
                            button14.setBackgroundColor(Color.BLUE);
                            button14Flag = false;
                            validateArray.add(14);
                        } else {
                            button14.setBackgroundColor(Color.GRAY);
                            button14Flag = true;
                            validateArray.remove(Integer.valueOf(14));
                        }
                    }
                }
        );
        final Button button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button15Flag) {
                            button15.setBackgroundColor(Color.BLUE);
                            button15Flag = false;
                            validateArray.add(15);
                        } else {
                            button15.setBackgroundColor(Color.GRAY);
                            button15Flag = true;
                            validateArray.remove(Integer.valueOf(15));
                        }
                    }
                }
        );
        final Button button16 = (Button) findViewById(R.id.button16);
        button16.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button16Flag) {
                            button16.setBackgroundColor(Color.BLUE);
                            button16Flag = false;
                            validateArray.add(16);
                        } else {
                            button16.setBackgroundColor(Color.GRAY);
                            button16Flag = true;
                            validateArray.remove(Integer.valueOf(16));
                        }
                    }
                }
        );
        final Button button17 = (Button) findViewById(R.id.button17);
        button17.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button17Flag) {
                            button17.setBackgroundColor(Color.BLUE);
                            button17Flag = false;
                            validateArray.add(17);
                        } else {
                            button17.setBackgroundColor(Color.GRAY);
                            button17Flag = true;
                            validateArray.remove(Integer.valueOf(17));
                        }
                    }
                }
        );
        final Button button18 = (Button) findViewById(R.id.button18);
        button18.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button18Flag) {
                            button18.setBackgroundColor(Color.BLUE);
                            button18Flag = false;
                            validateArray.add(18);
                        } else {
                            button18.setBackgroundColor(Color.GRAY);
                            button18Flag = true;
                            validateArray.remove(Integer.valueOf(18));
                        }
                    }
                }
        );
        final Button button19 = (Button) findViewById(R.id.button19);
        button19.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button19Flag) {
                            button19.setBackgroundColor(Color.BLUE);
                            button19Flag = false;
                            validateArray.add(19);
                        } else {
                            button19.setBackgroundColor(Color.GRAY);
                            button19Flag = true;
                            validateArray.remove(Integer.valueOf(19));
                        }
                    }
                }
        );
        final Button button20 = (Button) findViewById(R.id.button20);
        button20.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button20Flag) {
                            button20.setBackgroundColor(Color.BLUE);
                            button20Flag = false;
                            validateArray.add(20);
                        } else {
                            button20.setBackgroundColor(Color.GRAY);
                            button20Flag = true;
                            validateArray.remove(Integer.valueOf(20));
                        }
                    }
                }
        );
        final Button button21 = (Button) findViewById(R.id.button21);
        button21.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button21Flag) {
                            button21.setBackgroundColor(Color.BLUE);
                            button21Flag = false;
                            validateArray.add(21);
                        } else {
                            button21.setBackgroundColor(Color.GRAY);
                            button21Flag = true;
                            validateArray.remove(Integer.valueOf(21));
                        }
                    }
                }
        );
        final Button button22 = (Button) findViewById(R.id.button22);
        button22.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button22Flag) {
                            button22.setBackgroundColor(Color.BLUE);
                            button22Flag = false;
                            validateArray.add(22);
                        } else {
                            button22.setBackgroundColor(Color.GRAY);
                            button22Flag = true;
                            validateArray.remove(Integer.valueOf(22));
                        }
                    }
                }
        );
        final Button button23 = (Button) findViewById(R.id.button23);
        button23.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button23Flag) {
                            button23.setBackgroundColor(Color.BLUE);
                            button23Flag = false;
                            validateArray.add(23);
                        } else {
                            button23.setBackgroundColor(Color.GRAY);
                            button23Flag = true;
                            validateArray.remove(Integer.valueOf(23));
                        }
                    }
                }
        );
        final Button button24 = (Button) findViewById(R.id.button24);
        button24.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button24Flag) {
                            button24.setBackgroundColor(Color.BLUE);
                            button24Flag = false;
                            validateArray.add(24);
                        } else {
                            button24.setBackgroundColor(Color.GRAY);
                            button24Flag = true;
                            validateArray.remove(Integer.valueOf(24));
                        }
                    }
                }
        );
        final Button button25 = (Button) findViewById(R.id.button25);
        button25.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button25Flag) {
                            button25.setBackgroundColor(Color.BLUE);
                            button25Flag = false;
                            validateArray.add(25);
                        } else {
                            button25.setBackgroundColor(Color.GRAY);
                            button25Flag = true;
                            validateArray.remove(Integer.valueOf(25));
                        }
                    }
                }
        );
        final Button button26 = (Button) findViewById(R.id.button26);
        button26.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button26Flag) {
                            button26.setBackgroundColor(Color.BLUE);
                            button26Flag = false;
                            validateArray.add(26);
                        } else {
                            button26.setBackgroundColor(Color.GRAY);
                            button26Flag = true;
                            validateArray.remove(Integer.valueOf(26));
                        }
                    }
                }
        );
        final Button button27 = (Button) findViewById(R.id.button27);
        button27.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button27Flag) {
                            button27.setBackgroundColor(Color.BLUE);
                            button27Flag = false;
                            validateArray.add(27);
                        } else {
                            button27.setBackgroundColor(Color.GRAY);
                            button27Flag = true;
                            validateArray.remove(Integer.valueOf(27));
                        }
                    }
                }
        );
        final Button button28 = (Button) findViewById(R.id.button28);
        button28.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button28Flag) {
                            button28.setBackgroundColor(Color.BLUE);
                            button28Flag = false;
                            validateArray.add(28);
                        } else {
                            button28.setBackgroundColor(Color.GRAY);
                            button28Flag = true;
                            validateArray.remove(Integer.valueOf(28));
                        }
                    }
                }
        );
        final Button button29 = (Button) findViewById(R.id.button29);
        button29.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button29Flag) {
                            button29.setBackgroundColor(Color.BLUE);
                            button29Flag = false;
                            validateArray.add(29);
                        } else {
                            button29.setBackgroundColor(Color.GRAY);
                            button29Flag = true;
                            validateArray.remove(Integer.valueOf(29));
                        }
                    }
                }
        );
        final Button button30 = (Button) findViewById(R.id.button30);
        button30.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View V) {
                        if (button30Flag) {
                            button30.setBackgroundColor(Color.BLUE);
                            button30Flag = false;
                            validateArray.add(30);
                        } else {
                            button30.setBackgroundColor(Color.GRAY);
                            button30Flag = true;
                            validateArray.remove(Integer.valueOf(30));
                        }
                    }
                }
        );
    }


    private boolean isValid(ArrayList<Integer> validateArray)
    {
        //set Rows and Columns

        int temp = 0;  //temp variable
        int place = 0; //placeholder for validatArray

        for(int r  = 0; r < 6; r++)
        {
            for(int c = 0; c < 5; c++)
            {
                place++;
                if(validateArray.contains(place))
                {
                    if(temp == 0) {r1 = r; c1 = c;}
                    if(temp == 1) {r2 = r; c2 = c;}
                    if(temp == 2) {r3 = r; c3 = c;}
                    temp++;
                }

            }
        }

        if(validateArray.size() == 3) //only accept targeted size to three
        {

            boolean valid = false;

            if (sameRow(r1, r2, r3) && areConnected(c1, c2, c3) && sameValue(numbers.get(validateArray.get(0) - 1), numbers.get(validateArray.get(1) - 1), numbers.get(validateArray.get(2) - 1)))
            {
                valid = true;
            }

            if (sameColumn(c1, c2, c3) && areConnected(r1, r2, r3) && sameValue(numbers.get(validateArray.get(0) - 1), numbers.get(validateArray.get(1) - 1), numbers.get(validateArray.get(2) - 1)))
            {
                valid = true;
            }

            if(valid)
            {
                totalScore = totalScore + 5;
                return true;
            }
        }
        return false;
    }

    private boolean sameValue(int v1, int v2, int v3)
    {
        boolean sameValue = false;

        if (v1 == v2 && v1 == v3)
        {
            sameValue = true;
        }

        return sameValue;
    }

    private boolean areConnected(int num1, int num2, int num3)
    {
        boolean connected = false;
        int largest;
        int middle;
        int smallest;

        if(num1 > num2)
        {
            if(num1 > num3)
            {
                if(num2 > num3)
                {
                    largest = num1;
                    middle = num2;
                    smallest = num3;
                }
                else
                {
                    largest = num1;
                    middle = num3;
                    smallest = num2;
                }
            }
            else
            {
                largest = num3;
                middle = num1;
                smallest = num2;
            }
        }
        else
        {
            if(num2 > num3)
            {
                if(num1 > num3)
                {
                    largest = num2;
                    middle = num1;
                    smallest = num3;
                }
                else
                {
                    largest = num2;
                    middle = num3;
                    smallest = num1;
                }
            }
            else
            {
                largest = num3;
                middle = num2;
                smallest = num1;
            }
        }

        if((largest-middle) == 1 && (middle-smallest) == 1)
        {
            connected = true;
        }
        return connected;
    }

    private boolean sameRow(int r1, int r2, int r3)
    {
        boolean same = false;
        if (r1 == r2 && r1 == r3)
        {
            same = true;
        }
        return same;
    }

    private boolean sameColumn(int c1, int c2, int c3)
    {
        boolean same = false;
        if (c1 == c2 && c1 == c3)
        {
            same = true;
        }
        return same;
    }
}
