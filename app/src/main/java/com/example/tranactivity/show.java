package com.example.tranactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class show extends AppCompatActivity implements View.OnClickListener{
    private TextView name2,no2;
    private EditText class2;
    Button submit;
    public String str1,str2,str3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_main);

        submit =(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);

        name2 = (TextView)findViewById(R.id.name2);
        no2 = (TextView)findViewById(R.id.no2);
        class2 = (EditText)findViewById(R.id.class2);

        //因为show是通过intend来启动的，所以通过getIntend来获取与这个Activity相关的数据
        Intent intent1 = getIntent();
        Intent intent2 = getIntent();
        //MainActivity里通过putExtra传递时名字是tran1，值是str
        str1 = intent1.getStringExtra("tran1");
        str2 = intent2.getStringExtra("tran2");

        name2.setText(str1);
        no2.setText(str2);
    }

    @Override
    public void onClick(View v) {
        str3 = class2.getText().toString();
        switch (v.getId()) {
            case R.id.submit:
                class2.setText(str3);
                Intent intent2 = new Intent();
                intent2.setClass(show.this,MainActivity.class);
                intent2.putExtra("tran3",str3);
                intent2.putExtra("tran4",str1);
                intent2.putExtra("tran5",str2);
                startActivity(intent2);
                break;
        }
    }

}
