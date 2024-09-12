package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

     EditText edtA;
     EditText edtB;
     TextView txtResult;
     Button btnCal;
     Button btnMoveToSecondView;

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

        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        btnCal = (Button) findViewById(R.id.btnCal);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                double num1 = Double.parseDouble(edtA.getText().toString());
                double num2 = Double.parseDouble(edtB.getText().toString());
                b.putDouble("soa", num1);
                b.putDouble("sob", num2);
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("rs", b);
                startActivity(i);
            }
        });
    }



    public double sum() {
        double num1 = Double.parseDouble(edtA.getText().toString());
        double num2 = Double.parseDouble(edtB.getText().toString());
        return num1 + num2;
    }
}