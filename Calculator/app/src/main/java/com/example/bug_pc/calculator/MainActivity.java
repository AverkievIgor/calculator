package com.example.bug_pc.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;



public class MainActivity extends Activity implements OnClickListener {

    private Button
            one,
            two,
            three,
            four,
            five;
    private Button
            six,
            seven,
            eight,
            nine,
            zero;
    private Button
            finish;
    private Button
            sum,
            min,
            deline,
            proz;
    private Button
            reset,
            del,
            point;
    private TextView disp;


    int operand1,
            operand2,
            flagAction;
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operand1 = 0;
        operand2 = 0;
        result = 0;
        flagAction = 0;

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        finish = (Button) findViewById(R.id.finish);
        sum = (Button) findViewById(R.id.sum);
        min = (Button) findViewById(R.id.min);
        reset = (Button) findViewById(R.id.reset);
        //del = (Button) findViewById(R.id.del);
        proz = (Button) findViewById(R.id.proz);
        deline = (Button) findViewById(R.id.deline);
        disp = (TextView) findViewById(R.id.disp);
        //point = (Button) findViewById(R.id.point);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        finish.setOnClickListener(this);
        sum.setOnClickListener(this);
        min.setOnClickListener(this);
        reset.setOnClickListener(this);
        del.setOnClickListener(this);
        proz.setOnClickListener(this);
        deline.setOnClickListener(this);
        point.setOnClickListener(this);

        disp.setText(Integer.toString(operand1));

    }


    @Override
    public void onClick(View v) {
        {
            switch (v.getId()) {
                case R.id.one:
                    ClickNumber(1);
                    break;
                case R.id.two:
                    ClickNumber(2);
                    break;
                case R.id.three:
                    ClickNumber(3);
                    break;
                case R.id.four:
                    ClickNumber(4);
                    break;
                case R.id.five:
                    ClickNumber(5);
                    break;
                case R.id.six:
                    ClickNumber(6);
                    break;
                case R.id.seven:
                    ClickNumber(7);
                    break;
                case R.id.eight:
                    ClickNumber(8);
                    break;
                case R.id.nine:
                    ClickNumber(9);
                    break;
                case R.id.zero:
                    ClickNumber(0);
                    break;
                case R.id.sum:
                    if (flagAction == 0) flagAction = 1;
                    break;
                case R.id.min:
                    if (flagAction == 0) flagAction = 2;
                    break;
                case R.id.proz:
                    if (flagAction == 0) flagAction = 3;
                    break;
                case R.id.deline:
                    if (flagAction == 0) flagAction = 4;
                    break;
               // case R.id.del:
               //     if(flagAction == 0) flagAction = 5;
              //      break;
                case R.id.finish:
                    switch (flagAction) {
                        case 1:
                            result = operand1 + operand2;
                            break;
                        case 2:
                            result = operand1 - operand2;
                            break;
                        case 3:
                            result = operand1 * operand2;
                            break;
                        case 4:
                            result = (double) operand1 / (double) operand2;
                            break;
                        default:
                            Toast.makeText(this, "Операция не задана", Toast.LENGTH_LONG);
                    }
                    if (flagAction != 0) {
                        disp.setText(Double.toString(result));
                        operand1 = 0;
                        operand2 = 0;
                        result = 0;
                        flagAction = 0;
                    }
                    break;
                case R.id.reset:
                    operand1 = 0;
                    operand2 = 0;
                    result = 0;
                    flagAction = 0;
                    disp.setText(Integer.toString(operand1));
                    break;
            }
        }
    }


    private void ClickNumber(int num) {
        if (flagAction == 0) {
            operand1 = operand1 * 10 + num;
            disp.setText(Integer.toString(operand1));
        } else {
            operand2 = operand2 * 10 + num;
            disp.setText(Integer.toString(operand2));
        }
    }
}

   /* @Override
    public void onClick(View v) {

        CharSequence sequence = disp.getText();
        if(sequence != null)
        {
            if(v instanceof Button)
            {
        switch (v.getId()) {
            case R.id.reset:
                disp.setText("");
                break;
            case R.id.del:

                break;
            case R.id.sum:
                
                break;
            case R.id.deline:
                break;
            case R.id.min:
                break;
            case R.id.proz:
                break;
            case R.id.finish:
                break;
            default:
                String text = sequence.toString();
                String symbol = ((Button)v).getText().toString();
                text = text.concat(symbol);
                disp.setText(text);
        }
        }
        }
    }*/

