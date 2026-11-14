package com.triton.assistant;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout root, content;

    int blue = Color.rgb(20, 105, 220);
    int dark = Color.rgb(20, 35, 60);
    int light = Color.rgb(242, 247, 255);

    GradientDrawable shape(int color, int radius) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(radius);
        return d;
    }

    TextView text(String s, int size, int color) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setPadding(12, 12, 12, 12);
        return t;
    }

    void card(String title) {
        TextView t = text(title, 18, dark);
        t.setTypeface(null, Typeface.BOLD);
        t.setBackground(shape(Color.WHITE, 24));
        LinearLayout.LayoutParams p =
            new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 12, 0, 12);
        content.addView(t, p);
    }

    void toggle(String title) {
        Switch s = new Switch(this);
        s.setText(title);
        s.setTextSize(16);
        s.setTextColor(dark);
        s.setPadding(12, 16, 12, 16);
        content.addView(s);
    }

    void button(String title, Runnable action) {
        Button b = new Button(this);
        b.setText(title);
        b.setTextColor(Color.WHITE);
        b.setBackground(shape(blue, 20));
        b.setOnClickListener(v -> action.run());

        LinearLayout.LayoutParams p =
            new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 8, 0, 8);
        content.addView(b, p);
    }

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        showHome();
    }

    void showHome() {

        root = new LinearLayout(this);
        root.setOrientation(1);
        root.setBackgroundColor(light);

        TextView header = text("🚖 TRITON", 30, blue);
        header.setTypeface(null, Typeface.BOLD);
        root.addView(header);

        TextView subtitle = text(
            "SMART DRIVER ASSISTANT", 13, dark);
        root.addView(subtitle);

        LinearLayout tabs = new LinearLayout(this);
        tabs.setPadding(8, 8, 8, 8);
        tabs.setBackground(shape(Color.WHITE, 20));

        String[] names = {"HOME", "FILTERS", "HISTORY", "TOOLS"};

        for (String name : names) {
            Button t = new Button(this);
            t.setText(name);
            t.setTextSize(10);
            tabs.addView(t, new LinearLayout.LayoutParams(
                0, 60, 1));

            t.setOnClickListener(v -> {
                if (name.equals("HOME")) showHome();
                else if (name.equals("FILTERS")) showFilters();
                else if (name.equals("HISTORY")) showHistory();
                else showTools();
            });
        }

        root.addView(tabs);

        ScrollView scroll = new ScrollView(this);
        content = new LinearLayout(this);
        content.setOrientation(1);
        content.setPadding(16, 16, 16, 20);
        scroll.addView(content);

        card("WELCOME TO TRITON");
        content.addView(text(
            "Your smart driving companion",
            16, dark));

        card("MASTER CONTROL");
        toggle("Enable Driver Assistant");

        card("FLOATING BUTTON");
        toggle("Show Floating Button");

        card("RIDE APPS");

        toggle("Rapido");
        toggle("Ola");
        toggle("Uber");
        toggle("Namma Yatri");
        toggle("Porter");

        card("QUICK ACTIONS");

        button("RIDE FILTER SETTINGS", () -> showFilters());
        button("RIDE HISTORY", () -> showHistory());
        button("TOOLS & PERMISSIONS", () -> showTools());

        content.addView(text(
            "TRITON v1.0 | BLUE EDITION",
            13, blue));

        root.addView(scroll,
            new LinearLayout.LayoutParams(-1, 0, 1));

        setContentView(root);
    }

    void showFilters() {
        showPage("RIDE FILTERS",
            "Set your minimum fare and distance preferences.");
    }

    void showHistory() {
        showPage("RIDE HISTORY",
            "Your accepted and completed rides will appear here.");
    }

    void showTools() {
        showPage("TOOLS & PERMISSIONS",
            "Configure Android permissions and assistant settings.");
    }

    void showPage(String title, String message) {

        root = new LinearLayout(this);
        root.setOrientation(1);
        root.setPadding(20, 30, 20, 20);
        root.setBackgroundColor(light);

        TextView heading = text(title, 25, blue);
        heading.setTypeface(null, Typeface.BOLD);
        root.addView(heading);

        TextView info = text(message, 17, dark);
        root.addView(info);

        Button back = new Button(this);
        back.setText("BACK TO HOME");
        back.setBackground(shape(blue, 20));
        back.setTextColor(Color.WHITE);
        back.setOnClickListener(v -> showHome());

        root.addView(back);

        setContentView(root);
    }
          }
