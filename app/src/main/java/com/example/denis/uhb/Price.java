package com.example.denis.uhb;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.appcompat.app.ActionBar;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class Price extends AppCompatActivity implements View.OnClickListener{

    ListView mList;
    DBHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    String callNumber;
    String smsNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.price_second);
        ActionBar actionBar = getSupportActionBar();

        String fontPath_header = "fonts/header_2.otf";
        TextView text_header = (TextView) findViewById(R.id.textView5);
        Typeface typeface_header = Typeface.createFromAsset(getAssets(), fontPath_header);
        text_header.setTypeface(typeface_header);

        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        callNumber = "+79215547702";
        smsNumber = "+79215547702";
        mList = (ListView)findViewById(R.id.list);

        sqlHelper = new DBHelper(getApplicationContext());
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                final int pos = position + 1;
                AlertDialog.Builder dlgBuilder = new AlertDialog.Builder(Price.this);
                dlgBuilder.setTitle(R.string.dialog_to_record);
                dlgBuilder.setItems(R.array.item_select_variants,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent;
                                switch (which) {
                                    case 0:
                                        String number = String.format("tel:%s", callNumber);
                                        intent = new Intent(Intent.ACTION_DIAL);
                                        intent.setData(Uri.parse(number));
                                        startActivity(intent);
                                        break;
                                    case 1:
                                        Cursor cursorfirst = db.query(DBHelper.TABLE,
                                                new String[] {DBHelper.COLUMN_NAME},
                                                "_id = ?",
                                                new String[] {Integer.toString(pos)},
                                                null, null, null);
                                        cursorfirst.moveToFirst();
                                        String  name_column = cursorfirst.getString(
                                                cursorfirst.getColumnIndexOrThrow(DBHelper.COLUMN_NAME)
                                        );
                                        Intent intent1 = new Intent(Price.this, SmsToRecord.class);
                                        intent1.putExtra("name", name_column);
                                        startActivity(intent1);
                                        cursorfirst.close();
                                        break;

                                    case 2:
                                        Cursor cursorsecond = db.query(DBHelper.TABLE,
                                                new String[] {DBHelper.COLUMN_NAME},
                                                "_id = ?",
                                                new String[] {Integer.toString(pos)},
                                                null, null, null);
                                        cursorsecond.moveToFirst();
                                        String  name_column_2 = cursorsecond.getString(
                                                cursorsecond.getColumnIndexOrThrow(DBHelper.COLUMN_NAME)
                                        );
                                        Intent intent2 = new Intent(Price.this, EmailToRecord.class);
                                        intent2.putExtra("name", name_column_2);
                                        startActivity(intent2);
                                        cursorsecond.close();
                                        break;
                                }
                            }
                        });
                AlertDialog Dialog = dlgBuilder.create();
                Dialog.show();
            }
        });
        sqlHelper.create_db();
    }

    @Override
    public void onResume(){
        super.onResume();
        db = sqlHelper.getReadableDatabase();
        userCursor =  db.rawQuery("select * from "+ DBHelper.TABLE, null);
        String[] headers = new String[] {DBHelper.COLUMN_NAME, DBHelper.COLUMN_COST};
        userAdapter = new SimpleCursorAdapter(this, R.layout.list_view,
               userCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);
        mList.setAdapter(userAdapter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        db.close();
        userCursor.close();
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

    }
}
