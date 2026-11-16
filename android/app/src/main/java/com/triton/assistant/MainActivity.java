package com.triton.assistant;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(20, 30, 20, 20);
        mainLayout.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("TRITON");
        title.setTextSize(30);
        title.setTextColor(Color.BLUE);
        title.setGravity(Gravity.CENTER);
        title.setPadding(10, 20, 10, 20);
        mainLayout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("DRIVER ASSISTANT");
        subtitle.setTextSize(16);
        subtitle.setGravity(Gravity.CENTER);
        mainLayout.addView(subtitle);

        addButton("HOME");
        addButton("FILTERS");
        addButton("HISTORY");
        addButton("TOOLS");

        addSwitch("Driver Assistant");
        addSwitch("Floating Button");
        addSwitch("Ola");
        addSwitch("Rapido");
        addSwitch("Uber");
        addSwitch("Namma Yatri");
        addSwitch("Porter");

        setContentView(mainLayout);
    }
        @Override
protected void onResume() {
    super.onResume();

    android.content.SharedPreferences prefs =
        getSharedPreferences("TRITON", MODE_PRIVATE);

    String app = prefs.getString("last_app", "No ride yet");
    String title = prefs.getString("last_title", "");
    String message = prefs.getString("last_message", "");

    android.widget.Toast.makeText(
        this,
        app + "\n" + title + "\n" + message,
        android.widget.Toast.LENGTH_LONG
    ).show();
        }

    private void addButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setBackgroundColor(Color.BLUE);

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.setMargins(0, 8, 0, 8);
        mainLayout.addView(button, params);
    }

    private void addSwitch(String text) {
        Switch sw = new Switch(this);
        sw.setText(text);
        sw.setTextSize(16);
        sw.setPadding(5, 10, 5, 10);
        mainLayout.addView(sw);
    }
}
