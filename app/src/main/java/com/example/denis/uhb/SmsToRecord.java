package com.example.denis.uhb;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SmsToRecord extends AppCompatActivity implements View.OnClickListener {

    String smsNumber;
    private TextView procedure;
    String name_procedure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_to_record);

        String fontPath_header = "fonts/header_2.otf";

        TextView text_header = (TextView) findViewById(R.id.textView12);
        Typeface typeface_header = Typeface.createFromAsset(getAssets(), fontPath_header);
        text_header.setTypeface(typeface_header);


        smsNumber = "+79215547702";
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        name_procedure = getIntent().getStringExtra("name");
        procedure = (TextView) findViewById(R.id.textView13);
        procedure.setText(name_procedure);
    }
    public void smsSendRecord(View v) {
        EditText message=(EditText)findViewById(R.id.message_sms);
        String toSms="smsto:"+smsNumber;
        String messageText= name_procedure + ". Клиент: " + message.getText().toString();
        Intent sms=new Intent(Intent.ACTION_SENDTO, Uri.parse(toSms));
        sms.putExtra("sms_body", messageText);
        startActivity(sms);
    }

    @Override
    public void onClick(View v) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_feedback:
                Intent intent = new Intent(this, Feedback.class);
                startActivity(intent);
                break;
            case R.id.action_about:
                Intent intent_1 = new Intent(this, About.class);
                startActivity(intent_1);
                break;
            case  android.R.id.home:
                Intent intent_2 = new Intent(this, Price.class);
                startActivity(intent_2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
