package com.example.patrick.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    private ImageView imageView;

    private ProgressBar progressBar, progressBar2;

    int pic = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_text = (Button) findViewById(R.id.button_text);
        Button button_img = (Button) findViewById(R.id.button_img);
        Button button_pb = (Button) findViewById(R.id.button_pb);
        Button button_pb2 = (Button) findViewById(R.id.button_pb2);
        Button button_dialog = (Button) findViewById(R.id.button_dialog);
        Button button_progress_dialog = (Button) findViewById(R.id.button_progress_dialog);
        button_text.setOnClickListener(this);
        button_pb.setOnClickListener(this);
        button_img.setOnClickListener(this);
        button_pb2.setOnClickListener(this);
        button_dialog.setOnClickListener(this);
        button_progress_dialog.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar2 = (ProgressBar) findViewById(R.id.progress_bar2);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_text:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_img:
                if (pic == 1) {
                    imageView.setImageResource(R.drawable.mom);
                    pic = 2;
                } else {
                    imageView.setImageResource(R.drawable.sg);
                    pic = 1;
                }

                break;
            case R.id.button_pb:
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.button_pb2:
                int progress = progressBar2.getProgress();
                if (progress >= 100) {
                    progress = 0;
                } else {
                    progress = progress + 10;
                }
                progressBar2.setProgress(progress);
                break;
            case R.id.button_dialog:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);  // 不能用返回键关闭
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
            case R.id.button_progress_dialog:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
