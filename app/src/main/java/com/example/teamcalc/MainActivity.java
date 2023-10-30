package com.example.teamcalc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void changeSqrt(Integer index){
        String number = "";

        for(int i=index + 1; i<equation.length();i++){
            if(isNumeric(equation.charAt(i)))
                number = number + equation.charAt(i);
            else
                break;
        }

        String original = "√" + number;
        String changed = "Math.sqrt(" + number + ")";
        tempFormula = tempFormula.replace(original,changed);
    }
    public void clearOnClick(View view){
        equation="";
        tvEquation.setText("0");
        tvResult.setText("");
    }

    public void delOnClick(View view){
        if(equation!=null && (equation.length() > 0))
            equation = equation.substring(0, equation.length() - 1);
        tvEquation.setText(equation);
    }

    public void powerOfOnClick(View view) {
        if(equation.length() > 0)
            setEquation("^");
    }

    public void sqrtOnClick(View view){
        setEquation("√");
    }

    public void modOnClick(View view){
        if(equation.length() > 0)
            setEquation("%");
    }
}
