package com.rathana.notificationdemo.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import com.rathana.notificationdemo.R;

public class NotificationHelper {

    public static final String CH_NAME="announcement";
    public static final String CH_ID="announcement_id";

    @RequiresApi(api = Build.VERSION_CODES.O)

    public static void createChannel(Context context){

        NotificationChannel channel=new NotificationChannel(
                CH_ID,
                CH_NAME,
                NotificationManager.IMPORTANCE_HIGH
        );
        channel.setDescription("announce to all users");
        channel.setName(CH_NAME);
        channel.setLightColor(Color.RED);
        channel.enableVibration(true);

        NotificationManager notificationManager=
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.createNotificationChannel(channel);
    }

    public static void pushNotification(Context context){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CH_ID);
        builder.setContentTitle("new version release");
        builder.setContentText("Dear all user! the new version is available on google play");
        builder.setSmallIcon(R.drawable.ic_audiotrack_black_24dp);

        NotificationManager manager=(NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        int id= (int) System.currentTimeMillis()/1000;
        manager.notify(id,builder.build());
    }
}
