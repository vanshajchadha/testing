package com.example.vanshajchadha.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.Alarm);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager am= (AlarmManager) MainActivity.this.getSystemService(Context.ALARM_SERVICE); // SYNTAX ----> context.getSystemService()
                Intent i=new Intent(MainActivity.this,AlarmReceiver.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,1,i,0); /* To indicate that pendingIntent is whether being used to invoke a Broadcast Receiver or an Activity
                                                                                                    PendingIntent is created because we dont want to immediately startActivity*/
                am.set(AlarmManager.RTC,System.currentTimeMillis()+2000,pendingIntent);
            }
        });

    }
}
