package com.averyduffin.simplepinkcalc;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.view.Window;
import android.view.WindowManager;
//-1 clear
//0 do none
//1 divide
//2 multiply
//3 add
//4 subtract
public class MainActivity extends ActionBarActivity {
    public float value;
    public String sValue;
    public TextView thisTextView;
    public boolean isPositive;
    public int operations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.symbol);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        value = 0;
        operations = 0;
        sValue = "";
        isPositive = true;
        thisTextView  = (TextView) findViewById(R.id.output);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/DinC.ttf");
        thisTextView.setTypeface(type);
        thisTextView.setText("0");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void zero(View view){
        createNumber("0");
    }
    public void point(View view){
        createNumber(".");
    }
    public void one(View view){
        createNumber("1");
    }
    public void two(View view){
        createNumber("2");
    }
    public void three(View view){
        createNumber("3");
    }
    public void four(View view){
        createNumber("4");
    }
    public void five(View view){
        createNumber("5");
    }
    public void six(View view){
        createNumber("6");
    }
    public void seven(View view){
        createNumber("7");
    }
    public void eight(View view){
        createNumber("8");
    }
    public void nine(View view){
        createNumber("9");
    }
    public void clear(View view){

        value = 0;
        sValue = "";
        operations = 0;
        thisTextView.setText("0");
    }
    public void divide(View view){
        doOperation();
        operations = 1;
        sValue = "";
    }
    public void mult(View view){
        doOperation();
        operations = 2;
        sValue = "";
    }
    public void add(View view){
        doOperation();
        operations = 3;
        sValue = "";
    }
    public void sub(View view){
        doOperation();
        operations = 4;
        sValue = "";
    }
    public void plusMinus(View view){
        if(isPositive){
            isPositive = false;
            sValue = "-" + sValue;
            thisTextView.setText(sValue);
        }
        else{
            if(sValue.indexOf("-")!=-1){
                sValue = sValue.substring(sValue.indexOf("-") + 1);
                thisTextView.setText(sValue);
            }
            isPositive = true;
        }
    }
    public void equals(View view){
        if(sValue == ""){

        }
        else if(operations == 0){
            value = Float.parseFloat(sValue);
        }
        else if(operations == 1){
            value = value/Float.parseFloat(sValue);
        }
        else if(operations == 2){
            value = value * Float.parseFloat(sValue);
        }
        else if(operations == 3){
            value = value + Float.parseFloat(sValue);
        }
        else if(operations == 4){
            value = value - Float.parseFloat(sValue);
        }
        isPositive = true;
        operations = 0;
        thisTextView.setText(Float.toString(value));
    }
    public void doOperation(){
        if(operations == 0){
            value = Float.parseFloat(sValue);
        }
        else if(operations == 1){
            value = value/Float.parseFloat(sValue);
        }
        else if(operations == 2){
            value = value * Float.parseFloat(sValue);
        }
        else if(operations == 3){
            value = value + Float.parseFloat(sValue);
        }
        else if(operations == 4){
            value = value - Float.parseFloat(sValue);
        }
        isPositive = true;
        thisTextView.setText(Float.toString(value));
    }
    public void createNumber(String digit){
        sValue += digit;
        thisTextView.setText(sValue);
    }
}
