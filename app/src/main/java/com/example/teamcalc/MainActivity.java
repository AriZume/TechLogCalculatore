package com.example.teamcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity{
    TextView tvResult,tvEquation;
    String equation = "";
    String formula="", tempFormula="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEquation = findViewById(R.id.tvEquation);
        tvResult = findViewById(R.id.tvResult);
    }

    public void setEquation(String data){
        equation = equation + data;
        tvEquation.setText(equation);
    }

    public void equalsOnClick(View view) {
        if(equation.length() != 0) {
            Double result = null;
            String str="";
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
            checkForScientific();

            try {
                result = (double) engine.eval(formula);
                DecimalFormat df = new DecimalFormat("#.######");
                result= Double.valueOf(df.format(result));
                str=result.toString();
                if (str.endsWith(".0")){
                    str= str.replace(".0","");
                }
            } catch (ScriptException e) {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            }

            if (result != null)
                tvResult.setText(String.valueOf(result.doubleValue()));
        }
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
