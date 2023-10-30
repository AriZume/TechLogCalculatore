package com.example.teamcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fourOnClick(View view){
        setEquation("4");
    }

    public void fiveOnClick(View view){
        setEquation("5");
    }

    public void sixOnClick(View view){
        setEquation("6");
    }
    public void minusOnClick(View view){
        if(equation.length() > 0)
            setEquation("-");
    }

    private void checkForScientific() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        ArrayList<Integer> indexOfSin = new ArrayList<>();
        ArrayList<Integer> indexOfCos = new ArrayList<>();
        ArrayList<Integer> indexOfSqrt = new ArrayList<>();

        for(int i = 0; i < equation.length(); i++){
            if (equation.charAt(i) == '^')
                indexOfPowers.add(i);
            else if (equation.charAt(i) =='n')
                indexOfSin.add(i);
            else if (equation.charAt(i) == 'c')
                indexOfCos.add(i);
            else if (equation.charAt(i) == '√')
                indexOfSqrt.add(i);
        }

        formula = equation;
        tempFormula = equation;

        for(Integer index: indexOfPowers){
            changePower(index);
        }

        for(Integer index: indexOfSin){
            changeSin(index);
        }

        for(Integer index: indexOfCos){
            changeCos(index);
        }

        for(Integer index: indexOfSqrt){
            changeSqrt(index);
        }

        formula = tempFormula;
    }
}
