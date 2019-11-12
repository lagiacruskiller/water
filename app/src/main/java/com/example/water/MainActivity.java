package com.example.water;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText month, next;
    private Button cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        month = findViewById(R.id.month);
        next = findViewById(R.id.next);
        cal = findViewById(R.id.calculate);
        cal.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                int payment;
                double finalpayment;
                if(TextUtils.isEmpty(month.getText())){
                    if(TextUtils.isEmpty(next.getText())){
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Water")
                                .setMessage("Both boxes cannot be empty")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        month.setText(null);
                                        next.setText(null);
                                    }
                                })
                                .show();
                    }
                    else{
                        payment = Integer.parseInt(next.getText().toString());
                        if(payment > 100) finalpayment = payment*12.075-220.5;
                        else if(payment > 60) finalpayment = payment*11.55-168;
                        else if(payment > 20) finalpayment = payment*9.45-42;
                        else finalpayment = payment*7.35;
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Water")
                                .setMessage("Final payment: " +finalpayment)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        month.setText(null);
                                        next.setText(null);
                                    }
                                })
                                .show();
                    }
                }
                else{
                    payment = Integer.parseInt(month.getText().toString());
                    if(payment > 50) finalpayment = payment*12.075-110.25;
                    else if(payment > 30) finalpayment = payment*11.55-84;
                    else if(payment > 10) finalpayment = payment*9.45-21;
                    else finalpayment = payment*7.35;
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Water")
                            .setMessage("Final payment: " +finalpayment)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    month.setText(null);
                                    next.setText(null);
                                }
                            })
                            .show();
                }
            }
        });
    }
}