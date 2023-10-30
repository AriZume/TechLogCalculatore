package com.example.teamcalc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    public void plusOnClick(View view){
        if(equation.length() > 0)
            setEquation("+");
    }

}
