package com.example.denis.uhb;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.appcompat.app.ActionBar;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contacts extends AppCompatActivity  implements View.OnClickListener {

    Button button_call;
    Button button_map;
    String callNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        String fontPath_text = "fonts/text.ttf";
        TextView text = (TextView) findViewById(R.id.textView9);
        TextView text_2 = (TextView) findViewById(R.id.textView11);
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath_text);
        text.setTypeface(typeface);
        text_2.setTypeface(typeface);

        String fontPath_header = "fonts/header_2.otf";
        TextView text_header = (TextView) findViewById(R.id.textView4);
        Typeface typeface_header = Typeface.createFromAsset(getAssets(), fontPath_header);
        text_header.setTypeface(typeface_header);

        callNumber = "+79215547702";
        button_call = (Button) findViewById(R.id.button_call);
        button_call.setOnClickListener(this);
        button_map = (Button) findViewById(R.id.button_map);
        button_map.setOnClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_feedback_second:
                Intent intent2 = new Intent(this, Feedback.class);
                startActivity(intent2);
                break;
            case R.id.action_about_second:
                Intent intent3 = new Intent(this, About.class);
                startActivity(intent3);
                break;
            case  android.R.id.home:
                Intent intent4 = new Intent(this, MainActivity.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button_call:
                String number = String.format("tel:%s", callNumber);
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(number));
                startActivity(intent);
                break;
            case R.id.button_map:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:48.858056,2.294444"));
                startActivity(intent);
                break;
        }
    }
}