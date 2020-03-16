package com.example.denis.uhb;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Feedback extends AppCompatActivity implements View.OnClickListener{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        String fontPath_text = "fonts/text.ttf";
        TextView text = (TextView) findViewById(R.id.textView10);
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath_text);
        text.setTypeface(typeface);

        String fontPath_header = "fonts/header_2.otf";
        TextView text_header = (TextView) findViewById(R.id.textView3);
        Typeface typeface_header = Typeface.createFromAsset(getAssets(), fontPath_header);
        text_header.setTypeface(typeface_header);

        button = (Button) findViewById(R.id.button_send);
        button.setOnClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder dlgBuilder = new AlertDialog.Builder(this);
        dlgBuilder.setTitle(R.string.dialog);
        dlgBuilder.setItems(R.array.send_variants,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case 0:
                                Intent intent = new Intent(Feedback.this, Sms.class);
                                startActivity(intent);
                                break;
                            case 1:
                                Intent intent1 = new Intent(Feedback.this, Email.class);
                                startActivity(intent1);
                                break;
                        }
                    }
                });
        AlertDialog Dialog = dlgBuilder.create();
        Dialog.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feedback, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_about_second:
                Intent intent2 = new Intent(this, About.class);
                startActivity(intent2);
                break;
            case  android.R.id.home:
                Intent intent4 = new Intent(this, MainActivity.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
