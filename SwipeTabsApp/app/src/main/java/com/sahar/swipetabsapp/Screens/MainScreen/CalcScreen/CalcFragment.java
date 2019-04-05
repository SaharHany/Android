package com.sahar.swipetabsapp.Screens.MainScreen.CalcScreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sahar.swipetabsapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalcFragment extends Fragment {

    String num1 , num2 ,operator ;
    TextView resET ;
    EditText operatorET ;
    View view ;

    public CalcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calc, container, false);
        Button calcBtn = view.findViewById(R.id.calcBtn);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorET = view.findViewById(R.id.operatorET);

                resET = view.findViewById(R.id.resultTV);

                operator = operatorET.getText().toString();
                System.out.println("oper ->  "+operator);

                if(check(operator)) {
                    EditText oper1ET = view.findViewById(R.id.oper1ET);
                    EditText oper2ET = view.findViewById(R.id.oper2ET);

                    num1 = oper1ET.getText().toString();
                    num2 = oper2ET.getText().toString();

                    String res = calculate(num1, num2, operator);
                    resET.setText(res);
                }
                else{
                    Toast.makeText(getContext(), "Please Enter a valid operator", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view ;
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
