package com.example.kechaval.myfirstnotifications;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTvNotifications;
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvNotifications= findViewById(R.id.tvNotifications);
        mTvNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createSimpleNotification();
                //bigTextStyleNotification();
                //bigPictureStyleNotification();
                //notificationOpenActivity();
                //messagingStyleNotification();

            }
        });
    }

    private void createSimpleNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.drawable.ic_message);
        builder.setColor(getResources().getColor(R.color.colorAccent));
        builder.setLargeIcon(Utils.getBitmapFromAsset(this, "emma.jpg"));
        builder.setContentTitle("Kevin Reyes");
        final String text = "This is a simple notification compat example.";
        builder.setContentText(text);

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(id, notification);
        id++;
    }

    private void bigTextStyleNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_message);
        builder.setColor(getResources().getColor(R.color.colorAccent));
        builder.setLargeIcon(Utils.getBitmapFromAsset(this, "emma.jpg"));
        builder.setContentTitle("Emma W");
        final String text = "Hey, want to get some lunch? What do you think about Lomo Saltado," +
                " Arroz con Pollo or Ceviche?";
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(text));

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(id, notification);
    }

    private void bigPictureStyleNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_message);
        builder.setColor(getResources().getColor(R.color.colorAccent));
        builder.setLargeIcon(Utils.getBitmapFromAsset(this, "emma.jpg"));
        builder.setContentTitle("Emma W");

//        //get the bitmap to show in notification bar
      Bitmap bitmapImage = Utils.getBitmapFromAsset(this, "emma.jpg");
      NotificationCompat.BigPictureStyle s = new NotificationCompat.BigPictureStyle().bigPicture(bitmapImage);
      s.setSummaryText("Summary text appears on expanding the notification");
      builder.setStyle(s);

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(id, notification);
    }

    private void notificationOpenActivity() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_message);
        builder.setColor(getResources().getColor(R.color.colorAccent));
        builder.setLargeIcon(Utils.getBitmapFromAsset(this, "emma.jpg"));
        builder.setContentTitle("Cristhian Gonzales");
        final String text = "This is a simple notification compat example.";
        builder.setContentText(text);

        // Content intent that points to the activity we want to launch.
       Intent notifyIntent = new Intent(this, MainActivity.class);
      PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
       builder.setContentIntent(pendingIntent);

//        builder.setAutoCancel(true);

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(id, notification);
    }

    @TargetApi(24)
    private void messagingStyleNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_message);
        builder.setColor(getResources().getColor(R.color.colorAccent));
        builder.setLargeIcon(Utils.getBitmapFromAsset(this, "emma.jpg"));

        builder.setStyle(new NotificationCompat.MessagingStyle("Me")
                .setConversationTitle("Conversation with Emma")
                .addMessage("Lorem", 1, null) // null means device's user
                .addMessage("ipsum", 2, "Emma")
                .addMessage("dolor", 3, "Emma")
                .addMessage("sit amet", 4, null));

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(id, notification);
    }
}
