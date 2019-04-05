package com.sahar.layoutsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConstraintLayoutActivity extends AppCompatActivity {

    String num1 , num2 ,operator ;
    TextView resET ;
    EditText operatorET ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        Button calcBtn = findViewById(R.id.calcBtn);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorET = findViewById(R.id.operatorET);

                resET = findViewById(R.id.resultTV);

                operator = operatorET.getText().toString();
                System.out.println("oper ->  "+operator);

                if(check(operator)) {
                    EditText oper1ET = findViewById(R.id.oper1ET);
                    EditText oper2ET = findViewById(R.id.oper2ET);

                    num1 = oper1ET.getText().toString();
                    num2 = oper2ET.getText().toString();

                    String res = calculate(num1, num2, operator);
                    resET.setText(res);
                }
                else{
                    Toast.makeText(ConstraintLayoutActivity.this, "Please Enter a valid operator", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean check(String operator)
    {
        System.out.println("operatooor -> "+operator);

        Log.i("testing operator",operator);
        operator = operator.trim();
        String opers = "+-*/";
        if(opers.contains(operator))
        {
            return true ;
        }
        else{
            return false;
        }
    }

    private String calculate(String oper1 , String oper2 ,String operator){
        int operand1 = Integer.parseInt(oper1);
        int operand2 = Integer.parseInt(oper2);
        int result = 0;
        operator = operator.trim();
        switch(operator){
            case "+":
                result = operand1 + operand2 ;
                break;
            case "-":
                result = operand1 - operand2 ;
                break;
            case "*":
                result = operand1 * operand2 ;
                break;
            case "/":
                result = operand1 / operand2 ;
                break;
        }
        Log.i("Testing oper",operator);
        System.out.println(operand1+operator+operand2);
        return String.valueOf(result) ;
    }


}
