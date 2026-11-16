package com.triton.assistant;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.app.Notification;
import android.os.Bundle;
import android.content.SharedPreferences;

public class RideNotificationListener
        extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        if (sbn == null) return;

        Notification notification = sbn.getNotification();

        if (notification == null) return;

        Bundle extras = notification.extras;

        if (extras == null) return;

        CharSequence titleText =
                extras.getCharSequence(Notification.EXTRA_TITLE);

        CharSequence messageText =
                extras.getCharSequence(Notification.EXTRA_TEXT);

        String title = titleText == null ? "" : titleText.toString();

        String message = messageText == null ? "" : messageText.toString();

        String app = sbn.getPackageName();

        SharedPreferences prefs =
                getSharedPreferences("TRITON", MODE_PRIVATE);

        prefs.edit()
                .putString("last_app", app)
                .putString("last_title", title)
                .putString("last_message", message)
                .apply();
    }
        }
