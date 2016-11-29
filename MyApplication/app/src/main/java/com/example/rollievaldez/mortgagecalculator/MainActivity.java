package com.example.rollievaldez.mortgagecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // User input boxes
        final EditText homeVal = (EditText) findViewById(R.id.homeValue);
        final EditText downPayment = (EditText) findViewById(R.id.downPayment);
        final EditText apr = (EditText) findViewById(R.id.APR);
        final EditText terms = (EditText) findViewById(R.id.Terms);
        final EditText taxRate = (EditText) findViewById(R.id.taxRate);

        // Buttons
        final Button calcButton = (Button) findViewById(R.id.calcButton);
        final Button resetButton = (Button) findViewById(R.id.reset_button);


        // Calculate button listener
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Converts the string to double/integer and stores to variable.
                double homeValVar = Double.parseDouble(homeVal.getText().toString());
                double downPaymentVar = Double.parseDouble(downPayment.getText().toString());
                double aprVar = Double.parseDouble(apr.getText().toString());
                int termsVar = Integer.parseInt(terms.getText().toString());
                double taxRateVar = Double.parseDouble(taxRate.getText().toString());

                MortgageCalculator calc = new MortgageCalculator(homeValVar, downPaymentVar, aprVar, termsVar, taxRateVar );

            }
        }
        );

        // Reset button listener
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                homeVal.setText(null);
                downPayment.setText(null);
                apr.setText(null);
                terms.setText(null);
                taxRate.setText(null);
            }
        }
        );
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

}
