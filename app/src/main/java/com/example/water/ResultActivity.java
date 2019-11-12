package com.example.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    private EditText resultbox;
    private Button resetbtn;
    double payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultbox = findViewById(R.id.resultbox);
        resetbtn = findViewById(R.id.resetbtn);
        Bundle value = getIntent().getExtras();
        if(value!=null){
            payment = value.getDouble("Final Payment");
        }
        resultbox.setText(String.format("%.2f", payment));
        resetbtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent home = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(home);
            }
        });
    }
}
