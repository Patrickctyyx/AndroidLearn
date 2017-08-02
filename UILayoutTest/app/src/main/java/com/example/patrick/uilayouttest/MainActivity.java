package com.example.patrick.uilayouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent(MainActivity.this, Main5Activity.class);
                startActivity(intent4);
                break;
            case R.id.button5:
                Intent intent5 = new Intent(MainActivity.this, Main6Activity.class);
                startActivity(intent5);
                break;
            default:
                break;
        }
    }
}
