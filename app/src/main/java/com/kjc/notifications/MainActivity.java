package com.kjc.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.EditText;

import static com.kjc.notifications.App.CHANNEL_1_ID;
import static com.kjc.notifications.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText titleEditText;
    private EditText messageEditText;

    private MediaSessionCompat mediaSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);
        titleEditText = findViewById(R.id.title_edittext);
        messageEditText = findViewById(R.id.message_edittext);

        mediaSession = new MediaSessionCompat(this, "tag");
    }

    public void sendOnChannel1(View view) {
        String title = titleEditText.getText().toString();
        String message = messageEditText.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                activityIntent, 0);

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.ic_dragon);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(picture)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(picture)
                        .bigLargeIcon(null))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        notificationManager.notify(1, notification);
    }

    public void sendOnChannel2(View view) {
        String title = titleEditText.getText().toString();
        String message = messageEditText.getText().toString();

        Bitmap artwork = BitmapFactory.decodeResource(getResources(), R.drawable.ic_bookworm);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(artwork)
                .addAction(R.drawable.ic_dislike, "Dislike", null)
                .addAction(R.drawable.ic_previous, "Previous", null)
                .addAction(R.drawable.ic_pause, "Pause", null)
                .addAction(R.drawable.ic_next, "Next", null)
                .addAction(R.drawable.ic_like, "Like", null)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                .setShowActionsInCompactView(1,2,3)
                .setMediaSession(mediaSession.getSessionToken()))
                .setSubText("Sub Text")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(2, notification);
    }
}