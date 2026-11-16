package com.triton.assistant;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.app.Notification;
import android.os.Bundle;

public class RideNotificationListener
        extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        Notification notification = sbn.getNotification();
        Bundle extras = notification.extras;

        if (extras == null) return;

        String title = extras.getString(
            Notification.EXTRA_TITLE, "");

        String message = extras.getCharSequence(
            Notification.EXTRA_TEXT, "").toString();

        String app = sbn.getPackageName();

        getSharedPreferences("TRITON", MODE_PRIVATE)
            .edit()
            .putString("last_app", app)
            .putString("last_title", title)
            .putString("last_message", message)
            .apply();
    }
        }
