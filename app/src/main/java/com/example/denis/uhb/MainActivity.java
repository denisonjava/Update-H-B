package com.example.denis.uhb;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String fontPath_text = "fonts/text.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath_text);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_1 = (Button) findViewById(R.id.button_1);
        button_1.setTypeface(typeface);
        button_1.setOnClickListener(this);
        button_2 = (Button) findViewById(R.id.button_2);
        button_2.setTypeface(typeface);
        button_2.setOnClickListener(this);
        button_3 = (Button) findViewById(R.id.button_3);
        button_3.setTypeface(typeface);
        button_3.setOnClickListener(this);
        button_4 = (Button) findViewById(R.id.button_4);
        button_4.setTypeface(typeface);
        button_4.setOnClickListener(this);
        button_5 = (Button) findViewById(R.id.button_5);
        button_5.setTypeface(typeface);
        button_5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                Intent intent = new Intent(this, BoostUp.class);
                startActivity(intent);
                break;
            case R.id.button_2:
                Intent intent1 = new Intent(this, Sugaring.class);
                startActivity(intent1);
                break;
            case R.id.button_3:
                Intent intent2 = new Intent(this, Price.class);
                startActivity(intent2);
                break;
            case R.id.button_4:
                Intent intent3 = new Intent(this, Contacts.class);
                startActivity(intent3);
                break;
            case R.id.button_5:
                Intent intent4 = new Intent(this, Barber.class);
                startActivity(intent4);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_feedback:
                Intent intent5 = new Intent(this, Feedback.class);
                startActivity(intent5);
                break;
            case R.id.action_about:
                Intent intent4 = new Intent(this, About.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



