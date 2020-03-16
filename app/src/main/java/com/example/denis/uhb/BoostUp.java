package com.example.denis.uhb;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BoostUp extends AppCompatActivity implements View.OnClickListener{

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boostup);

        String fontPath_text = "fonts/text.ttf";
        TextView text = (TextView) findViewById(R.id.textView2);
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath_text);
        text.setTypeface(typeface);

        String fontPath_header = "fonts/header_2.otf";
        TextView text_header = (TextView) findViewById(R.id.textView);
        Typeface typeface_header = Typeface.createFromAsset(getAssets(), fontPath_header);
        text_header.setTypeface(typeface_header);

        button = (Button) findViewById(R.id.button_price);
        button.setOnClickListener(this);
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
        switch (id){
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
                Intent intent = new Intent(this, Price.class);
                startActivity(intent);
    }
}
