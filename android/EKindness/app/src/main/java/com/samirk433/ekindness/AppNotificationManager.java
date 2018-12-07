package com.samirk433.ekindness;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;



public class AppNotificationManager {
    private static final String TAG = AppNotificationManager.class.getSimpleName();

    public static final int NOTIFICATION_NORMAL_ID = 100;
    public static final int NOTIFICATION_LOCATION_ID = 101;
    public static final String URGENT_NOTI_CHANNEL_ID = "urgentNotifications";
    public static final String NORMAL_NOTI_CHANNEL_ID = "normalNotifications";

    Context mContext;

    public AppNotificationManager(Context context) {
        this.mContext = context;
    }

    public void showNotification(String title, String msg, long jobId) {

        Bundle bundle = new Bundle();

        Intent intent = new Intent(mContext, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtras(bundle);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        //create notification-channel fro Android O+
        createUrgentNotificationChannel();

        //get default notification
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(mContext,
                URGENT_NOTI_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_NORMAL_ID, notificationBuilder.build());

    }

    private void createUrgentNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(NORMAL_NOTI_CHANNEL_ID,
                    "Urgent", importance);
            NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(
                    mContext.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(mChannel);
        }

    }

    private void createNormalNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel mChannel = new NotificationChannel(NORMAL_NOTI_CHANNEL_ID,
                    "Normal", importance);
            NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(
                    mContext.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(mChannel);

        }
    }
}
