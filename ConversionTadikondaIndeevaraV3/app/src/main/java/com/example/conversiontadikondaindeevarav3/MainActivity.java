package com.example.conversiontadikondaindeevarav3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText euroInput;
    private TextView dollarOutput;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euroInput = findViewById(R.id.euro_input);
        dollarOutput = findViewById(R.id.dollar_output);
        convertButton = findViewById(R.id.convert_button);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double euros = Double.parseDouble(euroInput.getText().toString());
                double dollars = euros * 1.13;
                dollarOutput.setText(String.format("%.2f", dollars));
            }
        });
    }
}