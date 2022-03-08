package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.caculator.databinding.ActivityMainBinding;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);
    }

    public void onClickInputButton(View view) {
        if(binding.tvResult.getText().toString().equals("0")) {
            binding.tvResult.setText("");
            binding.tvInput.setText("");
        }
        Button b = (Button) view;
        binding.tvInput.setText(binding.tvInput.getText() + b.getText().toString());
    }

    public void onClickClearButton(View view) {
        binding.tvResult.setText("0");
        binding.tvInput.setText("0");
    }

    public void onClickEqualButton(View view) {
        String str = binding.tvInput.getText().toString();
        Expression expression = new Expression(str);
        String result = String.valueOf(expression.calculate());
        binding.tvResult.setText(result);
    }
}