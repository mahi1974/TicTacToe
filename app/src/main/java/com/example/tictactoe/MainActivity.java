package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int flag=0;
    int count=0;
    ArrayList<Button> bList;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent a = getIntent();
        flag=a.getIntExtra("Choise", -1);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        btnRestart=findViewById(R.id.btnRestart);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=0;
                count=0;
                enableBtn();
                for (Button b : bList){
                    b.setText(null);
                }
            }
        });
        bList=new ArrayList<>();
        bList.add(b1);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);
        bList.add(b5);
        bList.add(b6);
        bList.add(b7);
        bList.add(b8);
        bList.add(b9);

        for (Button b : bList){
            b.setOnClickListener(view ->{
                if(b.getText().toString().isEmpty())
                {
                    count++;
                    if(flag==0){
                        b.setText("X");
                        flag=1;
                    }
                    else{
                        b.setText("O");
                        flag=0;
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"☠️☠️☠️☠️",Toast.LENGTH_SHORT).show();
                }
                if(count>4)
                {
                    String t1 =b1.getText().toString();
                    String t2 =b2.getText().toString();
                    String t3 =b3.getText().toString();
                    String t4 =b4.getText().toString();
                    String t5 =b5.getText().toString();
                    String t6 =b6.getText().toString();
                    String t7 =b7.getText().toString();
                    String t8 =b8.getText().toString();
                    String t9 =b9.getText().toString();
                    if(t1.equals(t2) && t1.equals(t3) && !t1.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Winner Is:"+t1 ,Toast.LENGTH_SHORT).show();
                        disableBtn();
                    }
                    else if (t1.equals(t4) && t1.equals(t7) && !t1.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Winner Is:"+t1+" 🏆🥇"  ,Toast.LENGTH_SHORT).show();
                        disableBtn();
                    }
                    else if (t1.equals(t5) && t1.equals(t9) && !t1.isEmpty()) {
                        Toast.makeText(getApplicationContext(),"Winner Is:"+t1+" 🏆🥇"  ,Toast.LENGTH_SHORT).show();
                        disableBtn();
                    }
                    else if(t4.equals(t5) && t4.equals(t6) && !t4.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Winner Is:"+t4+" 🏆🥇"  ,Toast.LENGTH_SHORT).show();
                        disableBtn();
                        
                    } else if ( t3.equals(t5) && t3.equals(t7) && !t3.isEmpty()) {
                        Toast.makeText(getApplicationContext(),"Winner Is:"+t3+" 🏆🥇"  ,Toast.LENGTH_SHORT).show();
                        disableBtn();
                        
                    } else if (t7.equals(t8) && t7.equals(t9) && !t7.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Winner Is:"+t7+" 🏆🥇"  ,Toast.LENGTH_SHORT).show();
                        disableBtn();

                    } else if (t2.equals(t5)&&t2.equals(t8) && !t2.isEmpty()) {
                        Toast.makeText(getApplicationContext(),"Winner Is:"+t2+" 🏆🥇"  ,Toast.LENGTH_SHORT).show();
                        disableBtn();

                    }else if (t3.equals(t6)&& t3.equals(t9) && !t3.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Winner Is:"+t3+" 🏆🥇" ,Toast.LENGTH_SHORT).show();
                        disableBtn();
                    }
                    else if (!t1.isEmpty()&&!t2.isEmpty()&&!t3.isEmpty()&&!t4.isEmpty()&&!t5.isEmpty()&&!t6.isEmpty()&&!t7.isEmpty()&&!t8.isEmpty()&&!t9.isEmpty()){
                        Toast.makeText(this, "It's A Draw Try Again!", Toast.LENGTH_SHORT).show();
                        disableBtn();
                    }
                }
            });
        }

    }
    public void enableBtn()
    {
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
    }
    public void disableBtn()
    {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }
}