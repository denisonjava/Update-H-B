package com.example.denis.uhb;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EmailToRecord extends AppCompatActivity implements View.OnClickListener {

    private TextView procedure;
    String name_procedure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_to_record);

        String fontPath_header = "fonts/header_2.otf";
        TextView text_header = (TextView) findViewById(R.id.textView12);
        Typeface typeface_header = Typeface.createFromAsset(getAssets(), fontPath_header);
        text_header.setTypeface(typeface_header);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        name_procedure = getIntent().getStringExtra("name");
        procedure = (TextView) findViewById(R.id.textView13);
        procedure.setText(name_procedure);
    }
    public void smsEmailSend(View v) {
        EditText message=(EditText)findViewById(R.id.message_email);
        String sendmessage = message.getText().toString();
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"deku@mail.ru"});
        email.putExtra(Intent.EXTRA_SUBJECT,"Запись по E-mail");
        email.putExtra(Intent.EXTRA_TEXT, name_procedure + ". Клиент: " + sendmessage);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Выберите email клиент :"));
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
