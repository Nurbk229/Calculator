package com.nurbk.ps.caluculatorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nurbk.ps.caluculatorproject.model.CalculatorModel;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private ArrayList<Button> mBtnNumber = new ArrayList<>();
//    private ArrayList<Button> mBtnOperates = new ArrayList<>();
//

//    private String number = "0";
//
//    private CalculatorModel cModel = new CalculatorModel();
//    ;

    Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button0,
            button_point,
            button_clear, button_plus_negative,
            button_percent, button_division, button_multiplication, button_subtraction,
            button_addition, button_equal;
    TextView txtResult, tvInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//
//        Resources tmpRes = getResources();
//        for (int i = 0; i < 10; i++) {
//            int idBtn = tmpRes.getIdentifier("button" + i, "id", getPackageName());
//            Button bntNumber = findViewById(idBtn);
//            mBtnNumber.add(bntNumber);
//        }
//        mBtnNumber.add((Button) findViewById(R.id.button_point));
//
//        mBtnOperates.add((Button) findViewById(R.id.button_clear));
//        mBtnOperates.add((Button) findViewById(R.id.button_plus_negative));
//        mBtnOperates.add((Button) findViewById(R.id.button_percent));
//        mBtnOperates.add((Button) findViewById(R.id.button_division));
//        mBtnOperates.add((Button) findViewById(R.id.button_multiplication));
//        mBtnOperates.add((Button) findViewById(R.id.button_subtraction));
//        mBtnOperates.add((Button) findViewById(R.id.button_addition));
//        mBtnOperates.add((Button) findViewById(R.id.button_equal));
//
//        for (Button btn : mBtnNumber) {
//            btn.setOnClickListener(onClickOperand);
//        }
//
//        for (Button btn : mBtnOperates) {
//            btn.setOnClickListener(onClickOperate);
//        }


        txtResult = findViewById(R.id.txtResult);
        tvInput = findViewById(R.id.tvInput);

        txtResult.setText(savedInstanceState != null ?
                savedInstanceState.getString("dataResult") : "");
        tvInput.setText(savedInstanceState != null ?
                savedInstanceState.getString("dataInput") : "");

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);


        button_point = findViewById(R.id.button_point);
        button_clear = findViewById(R.id.button_clear);
        button_plus_negative = findViewById(R.id.button_plus_negative);
        button_percent = findViewById(R.id.button_percent);
        button_division = findViewById(R.id.button_division);
        button_multiplication = findViewById(R.id.button_multiplication);
        button_subtraction = findViewById(R.id.button_subtraction);
        button_addition = findViewById(R.id.button_addition);
        button_equal = findViewById(R.id.button_equal);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);


        button_point.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_plus_negative.setOnClickListener(this);
        button_percent.setOnClickListener(this);
        button_division.setOnClickListener(this);
        button_multiplication.setOnClickListener(this);
        button_subtraction.setOnClickListener(this);
        button_addition.setOnClickListener(this);
        button_equal.setOnClickListener(this);


    }


    private void appendOnClick(boolean clear, String string) {

        if (clear) {
            txtResult.setText("");
            tvInput.append(string);
        } else {
            tvInput.append(txtResult.getText());
            tvInput.append(string);
            txtResult.setText(" ");
        }
    }

    private void clear() {
        if (button_clear.getText().toString().equals("AC")) {
            tvInput.setText("");
            txtResult.setText("");
        } else {
            String text = tvInput.getText().toString();
            text = text.substring(0, text.length() - 1);
            tvInput.setText(text);
            if (text.length() == 0) {
                button_clear.setText("AC");
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                appendOnClick(true, "0");
                button_clear.setText("CE");
                break;
            case R.id.button1:
                appendOnClick(true, "1");
                button_clear.setText("CE");
                break;
            case R.id.button2:
                appendOnClick(true, "2");
                button_clear.setText("CE");
                break;
            case R.id.button3:
                appendOnClick(true, "3");
                button_clear.setText("CE");
                break;
            case R.id.button4:
                appendOnClick(true, "4");
                button_clear.setText("CE");
                break;
            case R.id.button5:
                appendOnClick(true, "5");
                button_clear.setText("CE");
                break;
            case R.id.button6:
                appendOnClick(true, "6");
                button_clear.setText("CE");
                break;
            case R.id.button7:
                appendOnClick(true, "7");
                button_clear.setText("CE");
                break;
            case R.id.button8:
                appendOnClick(true, "8");
                button_clear.setText("CE");
                break;
            case R.id.button9:
                appendOnClick(true, "9");
                button_clear.setText("CE");
                break;
            case R.id.button_point:
                appendOnClick(true, ".");
                button_clear.setText("CE");
                break;
            case R.id.button_clear:
                clear();
                break;
            case R.id.button_plus_negative:
                break;
            case R.id.button_percent:
                appendOnClick(false, "%");
                button_clear.setText("CE");
                break;
            case R.id.button_division:
                appendOnClick(false, "/");
                button_clear.setText("CE");
                break;
            case R.id.button_multiplication:
                appendOnClick(false, "*");
                button_clear.setText("CE");
                break;
            case R.id.button_subtraction:
                appendOnClick(false, "-");
                button_clear.setText("CE");
                break;
            case R.id.button_addition:
                appendOnClick(false, "+");
                button_clear.setText("CE");
                break;
            case R.id.button_equal:
                calculate();
                button_clear.setText("AC");
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("dataResult", txtResult.getText().toString());
        outState.putString("dataInput", tvInput.getText().toString());
    }

    private void calculate() {

        try {
            Expression input = new ExpressionBuilder(tvInput.getText().toString())
                    .build();

            double output = input.evaluate();
            long longOutput = (long) output;
            if (output == (double) longOutput) {
                txtResult.setText(String.valueOf(longOutput));
            } else {
                txtResult.setText(String.valueOf(output));
            }

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    //    private Button.OnClickListener onClickOperand = new Button.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Button btnNumber = (Button) v;
//            String tmpText = btnNumber.getText().toString();
//            number = number.equals("0") ? tmpText : number + tmpText;
//            txtResult.setText(number);
//
//            if (!number.equals("0")) {
//                ((Button) findViewById(R.id.button_clear)).setText("C");
//            }
//        }
//    };
//
//
//    private Button.OnClickListener onClickOperate = new Button.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Button tmpClickBTN = (Button) v;
//            String tmpText = tmpClickBTN.getText().toString();
//
//            if (tmpText.equalsIgnoreCase("C")) {
//                cModel.reset();
//                number = "0";
//                txtResult.setText(number);
//                return;
//            }
//            if (!number.equals("0"))
//                cModel.pushOperand(number);
//            double tmpResult = cModel.pushOperate(tmpText);
//            if (tmpResult % 1d == 0d) {
//                int tmp = Double.valueOf(tmpResult).intValue();
//                txtResult.setText(String.valueOf(tmp));
//            } else {
//                txtResult.setText(String.valueOf(tmpResult));
//            }
//            number = "0";
//        }
//    };
}