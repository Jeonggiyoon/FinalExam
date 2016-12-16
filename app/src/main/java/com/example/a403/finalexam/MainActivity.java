package com.example.a403.finalexam;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t7, t1, t2, t3, t4, t5, t6;
    EditText e1, e2, e3;
    Switch sh1;
    RadioGroup rg1;
    RadioButton r1, r2, r3;
    ImageView i1;
    Button b1, b2;
    LinearLayout l1;
    Chronometer ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t7 = (TextView) findViewById(R.id.textView7);
        t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        t6 = (TextView) findViewById(R.id.textView6);

        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);

        sh1 = (Switch) findViewById(R.id.switch1);

        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);

        r1 = (RadioButton) findViewById(R.id.radioButton1);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);

        i1 = (ImageView) findViewById( R.id.imageView1);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        l1 = (LinearLayout) findViewById(R.id.Linear1);

        ch = (Chronometer) findViewById(R.id.chronometer1);

        l1.setVisibility(View.INVISIBLE);

        sh1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();

                if(isChecked) l1.setVisibility(View.VISIBLE);
                else
                    l1.setVisibility(View.INVISIBLE);
            }
        });

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    i1.setImageResource(R.drawable.a0);
                }
            }
        });

        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    i1.setImageResource(R.drawable.b0);
                }
            }
        });

        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    i1.setImageResource(R.drawable.c0);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ad = Double.parseDouble((e1.getText().toString()));   //어른 15000      인원
                double vo = Double.parseDouble((e1.getText().toString()));   //청소년 12000    인원
                double ba = Double.parseDouble((e1.getText().toString()));   //어린이 60000   인원

                double sum;
                sum = ad + vo + ba;


                t4.setText("총명수: " +  sum);

                if (r1.isChecked()) {
                    double dis = ((ad * 15000) + (vo * 12000) +(ba * 6000)* 0.05);
                    t6.setText("결제금액:" + dis);

                    double total;
                    total = ((ad * 15000) + (vo * 12000) +(ba * 6000)) - dis;
                    t5.setText("할인금액:" + total);
                }
                else if (r2.isChecked())
                {
                    double dis = ((ad * 15000) + (vo * 12000) +(ba * 6000)* 0.1);
                    t6.setText("결제금액:" + dis);

                    double total;
                    total = ((ad * 15000) + (vo * 12000) +(ba * 6000)) - dis;
                    t5.setText("할인금액:" + total);
                }
                else if (r3.isChecked())
                {
                    double dis = ((ad * 15000) + (vo * 12000) +(ba * 6000)* 0.2);
                    t6.setText("결제금액:" + dis);

                    double total;
                    total = ((ad * 15000) + (vo * 12000) +(ba * 6000)) - dis;
                    t5.setText("할인금액:" + total);
                }
                else
                {
                    t5.setText("결제금액:" +0);
                    double total;
                    total = (ad * 15000) + (vo * 12000) +(ba * 6000);
                    t6.setText("할인금액:" + total);
                }

                if (e1.equals(null) && e2.equals(null) && e3.equals(null))
                {
                    Toast.makeText(getApplicationContext(),
                            "인원을 입력하세요", Toast.LENGTH_SHORT).show();

                }

            }

        });


    }
}
