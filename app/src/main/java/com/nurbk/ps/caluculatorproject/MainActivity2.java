package com.nurbk.ps.caluculatorproject;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.nurbk.ps.caluculatorproject.model.CalculatorModel;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ArrayList<Button> mBtnNumber = new ArrayList<>();
    private ArrayList<Button> mBtnOperates = new ArrayList<>();


    private String number = "0";

    private CalculatorModel cModel = new CalculatorModel();

    TextView txtResult, tvInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtResult=findViewById(R.id.txtResult);
        tvInput=findViewById(R.id.tvInput);

        Resources tmpRes = getResources();
        for (int i = 0; i < 10; i++) {
            int idBtn = tmpRes.getIdentifier("button" + i, "id", getPackageName());
            Button bntNumber = findViewById(idBtn);
            mBtnNumber.add(bntNumber);
        }
        mBtnNumber.add((Button) findViewById(R.id.button_point));

        mBtnOperates.add((Button) findViewById(R.id.button_clear));
        mBtnOperates.add((Button) findViewById(R.id.button_plus_negative));
        mBtnOperates.add((Button) findViewById(R.id.button_percent));
        mBtnOperates.add((Button) findViewById(R.id.button_division));
        mBtnOperates.add((Button) findViewById(R.id.button_multiplication));
        mBtnOperates.add((Button) findViewById(R.id.button_subtraction));
        mBtnOperates.add((Button) findViewById(R.id.button_addition));
        mBtnOperates.add((Button) findViewById(R.id.button_equal));

        for (Button btn : mBtnNumber) {
            btn.setOnClickListener(onClickOperand);
        }

        for (Button btn : mBtnOperates) {
            btn.setOnClickListener(onClickOperate);
        }


    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("dataResult", txtResult.getText().toString());
        outState.putString("dataInput", tvInput.getText().toString());
    }


    private Button.OnClickListener onClickOperand = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btnNumber = (Button) v;
            String tmpText = btnNumber.getText().toString();
            number = number.equals("0") ? tmpText : number + tmpText;
            txtResult.setText(number);

            if (!number.equals("0")) {
                ((Button) findViewById(R.id.button_clear)).setText("C");
            }
        }
    };

    private Button.OnClickListener onClickOperate = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button tmpClickBTN = (Button) v;
            String tmpText = tmpClickBTN.getText().toString();

            if (tmpText.equalsIgnoreCase("C")) {
                cModel.reset();
                number = "0";
                txtResult.setText(number);
                return;
            }
            if (!number.equals("0"))
                cModel.pushOperand(number);
            double tmpResult = cModel.pushOperate(tmpText);
            if (tmpResult % 1d == 0d) {
                int tmp = Double.valueOf(tmpResult).intValue();
                txtResult.setText(String.valueOf(tmp));
            } else {
                txtResult.setText(String.valueOf(tmpResult));
            }
            number = "0";
        }
    };
}