package com.arvind.learn.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arvind.learn.utility.StringUtilities.StringUtility;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button clear, del, divide, multiply, minus, plus, equal, dot,
            _0, _1, _2, _3, _4, _5, _6, _7, _8, _9;
    String operand1 = "0", operand2;
    byte operator;
    boolean operatorFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textView = (TextView)findViewById(R.id.textView2);
        clear = (Button)findViewById(R.id.button2);
        del = (Button)findViewById(R.id.button3);
        divide = (Button)findViewById(R.id.button4);
        multiply = (Button)findViewById(R.id.button8);
        minus = (Button)findViewById(R.id.button12);
        plus = (Button)findViewById(R.id.button16);
        equal = (Button)findViewById(R.id.button19);
        dot = (Button)findViewById(R.id.button18);
        _0 = (Button)findViewById(R.id.button17);
        _1 = (Button)findViewById(R.id.button13);
        _2 = (Button)findViewById(R.id.button14);
        _3 = (Button)findViewById(R.id.button15);
        _4 = (Button)findViewById(R.id.button9);
        _5 = (Button)findViewById(R.id.button10);
        _6 = (Button)findViewById(R.id.button11);
        _7 = (Button)findViewById(R.id.button5);
        _8 = (Button)findViewById(R.id.button6);
        _9 = (Button)findViewById(R.id.button7);

        clear.setOnClickListener(this);
        del.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        dot.setOnClickListener(this);
        equal.setOnClickListener(this);
        _0.setOnClickListener(this);
        _1.setOnClickListener(this);
        _2.setOnClickListener(this);
        _3.setOnClickListener(this);
        _4.setOnClickListener(this);
        _5.setOnClickListener(this);
        _6.setOnClickListener(this);
        _7.setOnClickListener(this);
        _8.setOnClickListener(this);
        _9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String text = ""+textView.getText();
        if(v.getId()==clear.getId())
        {
            textView.setText("");
            operand1 = "0";
            operand2 = "0";
            operator = ' ';
            
        }
        if(v.getId()==_1.getId())
        {
            if(text.equals("0")||text.equals("Infinity")||text.equals("Error!"))
            {
                textView.setText("1");
                
            }
            else
                textView.setText(text+"1");
        }
        if(v.getId()==_2.getId())
        {
            if(text.equals("0")||text.equals("Infinity")||text.equals("Error!"))
            {
                textView.setText("2");
                
            }
            else
                textView.setText(text+"2");
        }
        if(v.getId()==_3.getId())
        {
            if(text.equals("0")||text.equals("Infinity")||text.equals("Error!"))
            {
                textView.setText("3");
                
            }
            else
                textView.setText(text+"3");
        }
        if(v.getId()==_4.getId())
        {
            if(text.equals("0")||text.equals("Infinity")||text.equals("Error!"))
            {
                textView.setText("4");
                
            }
            else
                textView.setText(text+"4");
        }
        if(v.getId()==_5.getId())
        {
            if(text.equals("0")||text.equals("Infinity")||text.equals("Error!"))
            {
                textView.setText("5");
                
            }
            else
                textView.setText(text+"5");
        }
        if(v.getId()==_6.getId())
        {
            if(text.equals("0")||text.equals("Infinity")||text.equals("Error!"))
            {
                textView.setText("6");
                
            }
            else
                textView.setText(text+"6");
        }
        if(v.getId()==_7.getId())
        {
            if(text.equals("0")||text.equals("Infinity")||text.equals("Error!"))
            {
                textView.setText("7");
                
            }
            else
                textView.setText(text+"7");
        }
        if(v.getId()==_8.getId())
        {
            if(text.equals("0")||text.equals("Infinity")||text.equals("Error!"))
            {
                textView.setText("8");
                
            }
            else
                textView.setText(text+"8");
        }
        if(v.getId()==_9.getId())
        {
            if(text.equals("0")||text.equals("Infinity")||text.equals("Error!"))
            {
                textView.setText("9");
                
            }
            else
                textView.setText(text+"9");
        }
        if(v.getId()==_0.getId())
        {
            if(!text.equals("0")==true)
            {
                textView.setText(text+"0");
                
            }
        }
        if(v.getId()==dot.getId())
        {
            if(text.equals("")||text.equals("0"))
                textView.setText("0.");
            else if(!StringUtility.isContains(""+text, "."))
                textView.setText(text+".");
        }
        if(v.getId()==del.getId())
        {
            String s = ""+text;
            if(!(s.length() == 0))
            textView.setText(s.subSequence(0,s.length()-1));
        }
        if(v.getId()==plus.getId())
        {
            operand1 = ""+text;
            operator = '+';
            
            textView.setText("");
        }
        if(v.getId()==minus.getId())
        {
            operand1 = ""+text;
            operator = '-';
            
            textView.setText("");
        }
        if(v.getId()==multiply.getId())
        {
            operand1 = ""+text;
            operator = '*';
            
            textView.setText("");
        }
        if(v.getId()==divide.getId())
        {
            operand1 = ""+text;
            operator = '/';
            
            textView.setText("");
        }
        if(v.getId()==equal.getId())
        {
            operand2 = ""+text;
            System.out.println("Operand1--"+operand1+",  Operand2--"+operand2+"Operator--"+operator);
            if(operator == '+')
            {
                textView.setText(""+((Integer.valueOf(operand1))+Integer.valueOf(operand2)));
            }
            if(operator == '-')
            {
                textView.setText(""+((Integer.valueOf(operand1))-Integer.valueOf(operand2)));
            }
            if(operator == '*')
            {
                textView.setText(""+((Integer.valueOf(operand1))*Integer.valueOf(operand2)));
            }
            if(operator == '/')
            {
                try
                {
                    textView.setText(""+((Integer.valueOf(operand1))/Integer.valueOf(operand2)));
                }
                catch (Exception e)
                {
                    textView.setText("Error!");
                }
            }
        }

    }
    //Toast.makeText(Calculator.this, textView.getText(), Toast.LENGTH_SHORT);
}
