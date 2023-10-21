package com.example.teamcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

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

    private void changePower(Integer index){
        String numberLeft = "";
        String numberRight = "";

        for(int i = index + 1; i< equation.length(); i++){
            if(isNumeric(equation.charAt(i)))
                numberRight = numberRight + equation.charAt(i);
            else
                break;
        }

        for(int i = index - 1; i >= 0; i--){
            if(isNumeric(equation.charAt(i)))
                numberLeft = numberLeft + equation.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);
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

    private boolean isNumeric(char c){
        return (c <= '9' && c >= '0') || c == '.';
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

    public void zeroOnClick(View view){
        setEquation("0");
    }

    public void oneOnClick(View view){
        setEquation("1");
    }

    public void twoOnClick(View view){
        setEquation("2");
    }

    public void threeOnClick(View view){
        setEquation("3");
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

    public void sevenOnClick(View view){
        setEquation("7");
    }

    public void eightOnClick(View view){
        setEquation("8");
    }

    public void nineOnClick(View view){
        setEquation("9");
    }

    public void plusOnClick(View view){
        if(equation.length() > 0)
            setEquation("+");
    }

    public void minusOnClick(View view){
        if(equation.length() > 0)
            setEquation("-");
    }

    public void multOnClick(View view){
        if(equation.length() > 0)
            setEquation("*");
    }

    public void divOnClick(View view){
        if(equation.length() > 0)
            setEquation("/");
    }

    public void modOnClick(View view){
        if(equation.length() > 0)
            setEquation("%");
    }

    public void commaOnClick(View view){
        if(equation.length() > 0)
            setEquation(".");
    }

    public void parOpenOnClick(View view){
        setEquation("(");
    }

    public void parCloseOnClick(View view){
        setEquation(")");
    }

    public void powerOfOnClick(View view) {
        if(equation.length() > 0)
            setEquation("^");
    }

    public void sinOnClick(View view){
        setEquation("sin");
    }

    public void cosOnClick(View view){
        setEquation("cos");
    }

    public void sqrtOnClick(View view){
        setEquation("√");
    }
}
