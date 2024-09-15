package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button btnPlus;
    Button btnMinus;
    Button btnMulti;
    Button btnDivide;
    TextView txtNumA;
    TextView txtNumB;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNumA = (TextView) findViewById(R.id.txtNumA);
        txtNumB = (TextView) findViewById(R.id.txtNumB);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDivide = (Button) findViewById(R.id.btnDivide);

        i = getIntent();
        double num1 = i.getDoubleExtra("soa",0);
        double num2 = i.getDoubleExtra("sob",0);

        txtNumA.setText("Number A: "+num1);
        txtNumB.setText("Number B: "+num2);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("rs", doPlus(num1, num2));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("rs", doMinus(num1, num2));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("rs", doMulti(num1, num2));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("rs", doDivide(num1, num2));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private double doPlus(double num1, double num2) {
        return num1 + num2;
    };

    private double doMinus(double num1, double num2) {
        return num1 - num2;
    };

    private double doMulti(double num1, double num2) {
        return num1 * num2;
    }

    private double doDivide(double num1, double num2) {
        if (num2 == 0) {
            // You can either return a special value or throw an exception
            Toast.makeText(MainActivity2.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            return 0; // Or you can return any value you'd prefer for this case
        }
        return num1 / num2;
    }
}