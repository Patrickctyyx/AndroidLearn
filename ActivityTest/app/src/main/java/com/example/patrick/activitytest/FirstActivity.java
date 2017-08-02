package com.example.patrick.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  // 创建菜单
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Log.d("FirstActivity", this.toString());
        setContentView(R.layout.first_layout);  // 给当前活动加载布局
        Button button1 = (Button) findViewById(R.id.button_1);  // 定义按钮
        button1.setOnClickListener(new View.OnClickListener() {  // 定义按钮监视器
            @Override
            public void onClick(View v) {  // 点击事件
                // Toast.makeText(FirstActivity.this, "You clicked Button 1",
                //        Toast.LENGTH_SHORT).show();
                // finish();  // 销毁活动。相当于按下 back 键
                // 显式 Intent：显式意图，这里是用来在两个活动间转移
                // 这里的 Intent 是切换到活动二
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Button button1_5 = (Button) findViewById(R.id.button_1_5);  // 定义按钮
        button1_5.setOnClickListener(new View.OnClickListener() {  // 定义按钮监视器
            @Override
            public void onClick(View v) {
                // 隐式 Intent，没有具体指明响应的活动
                // 这里的 Intent 也是切换到活动二
                Intent intent2 = new Intent("com.example.patrick.activitytest.ACTION_START");
                intent2.addCategory("com.example.patrick.activitytest.MY_CATEGORY");
                startActivity(intent2);
            }
        });

        Button button1_10 = (Button) findViewById(R.id.button_1_10);  // 定义按钮
        button1_10.setOnClickListener(new View.OnClickListener() {  // 定义按钮监视器
            @Override
            public void onClick(View v) {
                // 这里的 Intent 是访问这个网址
                Intent intent3 = new Intent(Intent.ACTION_VIEW);
                intent3.setData(Uri.parse("https://www.apple.com/cn/"));
                startActivity(intent3);
            }
        });

        Button button1_15 = (Button) findViewById(R.id.button_1_15);  // 定义按钮
        button1_15.setOnClickListener(new View.OnClickListener() {  // 定义按钮监视器
            @Override
            public void onClick(View v) {
                // 这里的 Intent 是访问拨号界面
                Intent intent4 = new Intent(Intent.ACTION_DIAL);
                // 也可以同时输入电话号码
                intent4.setData(Uri.parse("tel:10086"));
                startActivity(intent4);
            }
        });

        Button button1_20 = (Button) findViewById(R.id.button_1_20);  // 定义按钮
        button1_20.setOnClickListener(new View.OnClickListener() {  // 定义按钮监视器
            @Override
            public void onClick(View v) {
                String data = "Hello SecondActivity";
                Intent intent5 = new Intent(FirstActivity.this, SecondActivity.class);
                intent5.putExtra("extra_data", data);
                startActivity(intent5);
            }
        });

        Button button1_25 = (Button) findViewById(R.id.button_1_25);  // 定义按钮
        button1_25.setOnClickListener(new View.OnClickListener() {  // 定义按钮监视器
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent6, 1);
            }
        });

        Button button1_30 = (Button) findViewById(R.id.button_1_30);  // 定义按钮
        button1_30.setOnClickListener(new View.OnClickListener() {  // 定义按钮监视器
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent7);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }
}
