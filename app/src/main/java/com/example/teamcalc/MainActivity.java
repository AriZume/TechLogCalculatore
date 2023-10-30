package com.example.teamcalc;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void divOnClick(View view){
        if(equation.length() > 0)
            setEquation("/");
    }



    public void parOpenOnClick(View view){
        setEquation("(");
    }

    public void parCloseOnClick(View view){
        setEquation(")");
    }


    public void sinOnClick(View view){
        setEquation("sin");
    }

    public void cosOnClick(View view){
        setEquation("cos");
    }



    private void changeSin(Integer index){
        String number = "";

        for(int i=index + 1; i<equation.length();i++){
            if(isNumeric(equation.charAt(i)))
                number = number + equation.charAt(i);
            else
                break;
        }

        String original = "sin" + number;
        double degrees = Math.toRadians(Double.parseDouble(number));
        String changed = "Math.sin(" + degrees + ")";
        tempFormula = tempFormula.replace(original,changed);
    }

    private void changeCos(Integer index){
        String number = "";

        for(int i=index + 3; i<equation.length();i++){
            if(isNumeric(equation.charAt(i)))
                number = number + equation.charAt(i);
            else
                break;
        }

        String original = "cos" + number;
        double degrees = Math.toRadians(Double.parseDouble(number));
        String changed = "Math.cos(" + degrees + ")";
        tempFormula = tempFormula.replace(original,changed);
    }

    public void divOnClick(View view){
        if(equation.length() > 0)
            setEquation("/");
    }

    public void parOpenOnClick(View view){
        setEquation("(");
    }

    public void parCloseOnClick(View view){
        setEquation(")");
    }

    public void sinOnClick(View view){
        setEquation("sin");
    }

    public void cosOnClick(View view){
        setEquation("cos");
    }
}
