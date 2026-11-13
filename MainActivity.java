package com.triton.assistant;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
  private LinearLayout root;
  private void label(String s, int size) { TextView t = new TextView(this); t.setText(s); t.setTextSize(size); t.setTextColor(Color.rgb(16,57,116)); t.setPadding(16,12,16,12); root.addView(t); }
  private EditText input(String hint, int type) { EditText e = new EditText(this); e.setHint(hint); e.setInputType(type); root.addView(e); return e; }
  private void button(String title, Runnable action) { Button b = new Button(this); b.setText(title); b.setOnClickListener(v -> action.run()); root.addView(b); }
  private void note(String s) { Toast.makeText(this,s,Toast.LENGTH_LONG).show(); }
  @Override public void onCreate(Bundle state) { super.onCreate(state); showHome(); }
  private void init(String title) { ScrollView scroll = new ScrollView(this); root = new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(24,32,24,24); root.setBackgroundColor(Color.WHITE); scroll.addView(root); setContentView(scroll); label(title,26); }
  private void showHome() { init("TRITON • Smart Ride Assistant"); label("Demo app • No live ride integrations",14); button("Driver registration",this::register); button("Ride filters",this::filters); button("Subscription plans",this::plans); button("Driver services",this::services); label("Kannada / English • Bike / Auto / Car / Goods",16); }
  private void register() { init("Driver registration (demo)"); EditText mobile=input("10-digit mobile",3); EditText name=input("Driver name",1); Spinner vehicle = new Spinner(this); String[] choices={"Bike","Auto","Car","Goods"}; vehicle.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,choices)); root.addView(vehicle); label("OTP login requires Firebase setup; no OTP is sent in this demo.",14); button("Save demo profile",()->note("Demo only: "+name.getText()+" / "+vehicle.getSelectedItem())); button("Back",this::showHome); }
  private void filters() { init("Ride preferences"); input("Max pickup KM (e.g. 2)",8194); input("Minimum fare ₹ (e.g. 150)",8194); input("Minimum ₹/KM (e.g. 15)",8194); button("Save demo preferences",()->note("Demo preferences only")); button("Back",this::showHome); }
  private void plans() { init("Subscription plans (demo)"); label("1 day ₹25\n3 days ₹70\n7 days ₹160\n30 days ₹350",20); label("Payments are not enabled. Never send money from this demo.",14); button("Back",this::showHome); }
  private void services() { init("Driver services"); label("Ola • Rapido • Uber • Namma Yatri • Porter",20); label("No automated accept/reject. Integration requires provider authorization and testing.",15); button("Back",this::showHome); }
}
