package com.example.teamcalc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void multOnClick(View view){
        if(equation.length() > 0)
            setEquation("*");
    }
}
