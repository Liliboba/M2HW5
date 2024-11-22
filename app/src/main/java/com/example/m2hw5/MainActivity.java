package com.example.m2hw5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private  Boolean isOperation;
    private Long number1;
    private Long number2;
    private double numberDouble1;
    private double numberDouble2;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textOfCalculator);
    }

    @SuppressLint("ResourceType")
    public void clickOnNumber(View view) {
        String textNumber = ((MaterialButton) view).getText().toString();

        if (textNumber.equals("AC")){
            textView.setText("0");
        } else if (textNumber.equals(".") && textView.getText().toString().equals("0")){
            textView.append(textNumber);
        } else if (textNumber.equals(".") && textView.getText().toString().contains(".")){
            textView.append("");
        } else if (textView.getText().toString().equals("0") || isOperation){
            textView.setText(textNumber);
        }  else {
            textView.append(textNumber);
        }
        isOperation = false;
    }

    public void clickOnOperation(View view) {
       if (view.getId() == R.id.operation_plus){
           if (textView.getText().toString().contains(".")){
               numberDouble1 = Double.parseDouble(textView.getText().toString());
           }else {
               number1 = Long.valueOf(textView.getText().toString());
           }
           operation = "+";
           isOperation = true;
       } else if (view.getId() == R.id.operation_mines){
           if (textView.getText().toString().contains(".")){
               numberDouble1 = Double.parseDouble(textView.getText().toString());
           }else {
               number1 = Long.valueOf(textView.getText().toString());
           }
           operation = "-";
           isOperation = true;
       } else if (view.getId() == R.id.operation_multiply){
           if (textView.getText().toString().contains(".")){
               numberDouble1 = Double.parseDouble(textView.getText().toString());
           }else {
               number1 = Long.valueOf(textView.getText().toString());
           }
           operation = "*";
           isOperation = true;
       } else if (view.getId() == R.id.operation_divide){
           if (textView.getText().toString().contains(".")){
               numberDouble1 = Double.parseDouble(textView.getText().toString());
           }else {
               number1 = Long.valueOf(textView.getText().toString());
           }
           operation = "/";
           isOperation = true;
       } else if (view.getId() == R.id.operation_percent){
           if (textView.getText().toString().contains(".")){
               numberDouble1 = Double.parseDouble(textView.getText().toString());
           }else {
               number1 = Long.valueOf(textView.getText().toString());
           }
           operation = "%";
           isOperation = true;
       } else if (view.getId() == R.id.operation_revers){
           if (textView.getText().toString().contains(".")){
               numberDouble1 = Double.parseDouble(textView.getText().toString());
           }else {
               number1 = Long.valueOf(textView.getText().toString());
           }
           textView.setText(String.valueOf(-number1));
       } else if (view.getId() == R.id.operation_equals) {
           if (textView.getText().toString().contains(".")){
               numberDouble2 = Double.parseDouble(textView.getText().toString());
           }else {
               number2 = Long.valueOf(textView.getText().toString());
           }
           isOperation = true;
           if (operation.equals("+")){
               if (textView.getText().toString().contains(".")){
                   textView.setText(String.valueOf(numberDouble1 + numberDouble2));
               }else {
                   textView.setText(String.valueOf(number1 + number2));
               }
           } else if (operation.equals("-")){
               if (textView.getText().toString().contains(".")){
                   textView.setText(String.valueOf(numberDouble1 - numberDouble2));
               }else {
                   textView.setText(String.valueOf(number1 - number2));
               }
           } else if (operation.equals("*")){
               if (textView.getText().toString().contains(".")){
                   textView.setText(String.valueOf(numberDouble1 * numberDouble2));
               }else {
                   textView.setText(String.valueOf(number1 * number2));
               }
           } else if (operation.equals("/")){
               if (number2 == 0 && numberDouble2 == 0.0){
                   textView.setText("Error");
               } else if (textView.getText().toString().contains(".")){
                   textView.setText(String.valueOf(numberDouble1 / numberDouble2));
               } else {
                   textView.setText(String.valueOf(number1 / number2));
               }
           } else if (operation.equals("%")){
               if (textView.getText().toString().contains(".")){
                   textView.setText(String.valueOf(numberDouble1 / 100));
               }else {
                   textView.setText(String.valueOf(number1 / 100));
               }

           }
           Button activity = findViewById(R.id.activity_btr);
           activity.setAlpha(1);
       }
    }

    public void clickOnBTRActivity(View view) {
        String text = textView.getText().toString();
Intent intent = new Intent(MainActivity.this, MainActivity2.class);
intent.putExtra("key1", text);
startActivity(intent);
onDestroy();
    }
}