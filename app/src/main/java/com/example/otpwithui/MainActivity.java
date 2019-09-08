package com.example.otpwithui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    PinView pinView;
    Button btnNext;
    TextView topText;
    EditText userName, userPhoneNo;
    LinearLayout first, second;
    TextView textU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pinView = findViewById(R.id.otp_pinView);
        btnNext = findViewById(R.id.btn_next);
        topText = findViewById(R.id.top_text);
        userName = findViewById(R.id.full_name);
        userPhoneNo = findViewById(R.id.phone_no);
        textU = findViewById(R.id.textView_noti);

        first = findViewById(R.id.layout_first);
        second = findViewById(R.id.layout_second);

        first.setVisibility(View.VISIBLE);


        btnNext.setOnClickListener(this);

        /*btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp = pinView.getText().toString();

                if (otp.equals("3457")){

                }else {
                    pinView.setLineColor(Color.RED);
                }
            }
        });*/
    }


    @Override
    public void onClick(View view) {
        if (btnNext.equals("Let's go")){
            String name = userName.getText().toString();
            String phone = userPhoneNo.getText().toString();

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone)){

                btnNext.setText("Verify");
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);

            }else {
                Toast.makeText(MainActivity.this, "Please Enter Details", Toast.LENGTH_LONG).show();
            }
        } else if (btnNext.getText().equals("Verify")){
            String otp = pinView.getText().toString();
            if (otp.equals("3456")){

                pinView.setLineColor(Color.GREEN);
                textU.setText("OTP Verified");
                textU.setTextColor(Color.GREEN);

            }else {
                pinView.setLineColor(Color.RED);
                textU.setText("X incorrect OTP");
                textU.setTextColor(Color.RED);
            }
        }
    }
}
