package com.example.amkro.tipcalculatorv0;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private tipCalculator tipCalc;
    public NumberFormat money = NumberFormat.getCurrencyInstance();
    private EditText billEditText;
    private EditText tipEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipCalc = new tipCalculator(1.17f,100.0f);
        setContentView(R.layout.activity_main);

        billEditText = (EditText) findViewById(R.id.amount_bill);
        tipEditText = (EditText) findViewById(R.id.amount_tip_percent);

        //TextChangeHandler tch = new TextChangeHandler( );
        //billEditText.addTextChangedListener( tch );
        //tipEditText.addTextChangedListener( tch );
    }

    public void calculate(View v){
        Log.w("MainActivity", "v = " + v);
        EditText billEditText = (EditText) findViewById(R.id.amount_bill);
        EditText tipEditText = (EditText) findViewById(R.id.amount_tip_percent);
        String billString = billEditText.getText().toString();
        String tipString = tipEditText.getText().toString();

        TextView tipTextView = (TextView) findViewById(R.id.amount_tip);
        TextView totalTextView = (TextView) findViewById(R.id.amount_total);
        try{
            float billAmount = Float.parseFloat(billString);
            int tipPercent = Integer.parseInt(tipString);

            tipCalc.setBill(billAmount);
            tipCalc.setTip(.01f * tipPercent);

            float tip = tipCalc.tipAmount();
            float total = tipCalc.totalAmount();

            tipTextView.setText(money.format(tip));
            totalTextView.setText(money.format(total));
        } catch (NumberFormatException nfe){
            //pop up an alert view here
        }
    }
    /*
    private class TextChangeHandler implements TextWatcher {
        public void afterTextChanged(Editable e){
            calculate();
        }
        public void  beforeTextChanged(CharSequence s, int start, int count, int after){

    }
        public void  onTextChanged(CharSequence s, int start, int before, int after){

        }
    }
    */
}