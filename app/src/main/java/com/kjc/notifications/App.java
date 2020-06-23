package com.kjc.notifications;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build;

import static com.kjc.notifications.Constants.*;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannelGroup group1 = new NotificationChannelGroup(
                    GROUP_1_ID,
                    "Group 1"
            );

            NotificationChannelGroup group2 = new NotificationChannelGroup(
                    GROUP_2_ID,
                    "Group 2"
            );

            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            channel1.setGroup(GROUP_1_ID);

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("This is Channel 2");
            channel2.setGroup(GROUP_2_ID);

            NotificationChannel channel3 = new NotificationChannel(
                    CHANNEL_3_ID,
                    "Channel 3",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel3.setDescription("This is Channel 3");
            channel3.setGroup(GROUP_2_ID);

            NotificationChannel channel4 = new NotificationChannel(
                    CHANNEL_4_ID,
                    "Channel 4",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel4.setDescription("This is Channel 4");


            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannelGroup(group1);
            manager.createNotificationChannelGroup(group2);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
            manager.createNotificationChannel(channel3);
            manager.createNotificationChannel(channel4);
        }
    }
}
