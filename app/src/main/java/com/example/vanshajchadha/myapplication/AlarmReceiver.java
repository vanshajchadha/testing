package com.example.vanshajchadha.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "Alarm Received", Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context)
                        .setSmallIcon(android.R.drawable.ic_menu_report_image)
                        .setContentTitle("My Notification")
                        .setAutoCancel(false)
                        .setContentText("Your first notification");

        Intent resultIntent=new Intent(context,MainActivity.class);

        PendingIntent resultPendingIntent=PendingIntent.getActivity(context,1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification mNotification=mBuilder.build();

        mNotificationManager.notify(1,mNotification);

    }

}
