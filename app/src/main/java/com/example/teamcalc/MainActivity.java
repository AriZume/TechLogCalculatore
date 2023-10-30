package com.example.teamcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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
}
