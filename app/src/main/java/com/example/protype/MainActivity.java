package com.example.protype;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private SmsReceiver smsReceiver;
     private Button setKeyWord;
     private EditText keyWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //检测是否为默认短信引用，
        final String myPackageName = getPackageName();
            if (!Telephony.Sms.getDefaultSmsPackage(this).equals(myPackageName))
            {
              Intent intent =
              new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
              intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME,
                         myPackageName);
              startActivity(intent);
               Log.d("liueg", "11111111111");
             }


        smsReceiver= new SmsReceiver();

        setKeyWord=findViewById(R.id.button);
        keyWord=findViewById(R.id.myKeyWord);

        setKeyWord.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String word=keyWord.getText().toString().trim();

                SharedPreferences List;
                List= getSharedPreferences("user",0);
                SharedPreferences.Editor editor=List.edit();
                editor.putString("keyword",word);
                editor.commit();

                Toast.makeText(getApplication(),"You have set your key word "+word,Toast.LENGTH_SHORT).show();
            }
        });

        SharedPreferences sp;
        sp=getSharedPreferences("user",0);
        String st=sp.getString("keyword","");
        if (!st.equals(""))keyWord.setText(st);



    }
}
