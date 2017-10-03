package by.bstu.fit.oleggutsev.lab6_7java;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import by.bstu.fit.oleggutsev.lab6_7java.units.Listener;
import by.bstu.fit.oleggutsev.lab6_7java.units.Student;

public class ListenerInfoActivity extends AppCompatActivity {

    final static String textViewNameKey = "NAME_TEXT";
    final static String textViewMiddleNameKey = "TEXTMIDDLENAME_TEXT";
    final static String textViewSurnameKey = "TEXTSURNAME_TEXT";
    final static String textViewAgeKey = "TEXTAGE_TEXT";
    final static String textViewCountHoursKey = "TEXTCount_TEXT";
    final static String textViewOrganizationKey = "TEXTOrganization_TEXT";


    private TextView mNameTextView;
    private TextView mMiddleNameTextView;
    private TextView mSurnameTextView;
    private TextView mAgeTextView;
    private TextView mCountHoursTextView;
    private TextView mOrganizationTextView;

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener_info);

        mNameTextView = (TextView) findViewById(R.id.Name_textView);
        mMiddleNameTextView = (TextView) findViewById(R.id.MiddleName_textView);
        mSurnameTextView = (TextView) findViewById(R.id.Surname_textView);
        mAgeTextView = (TextView) findViewById(R.id.Age_textView);
        mCountHoursTextView = (TextView) findViewById(R.id.CountHours_textView);
        mOrganizationTextView = (TextView) findViewById(R.id.Organization_textView);

        dbHelper = new DatabaseHelper(this);
        Intent intent = getIntent();

        mNameTextView.setText(intent.getSelector().getStringExtra("name"));
        mMiddleNameTextView.setText(intent.getSelector().getStringExtra("middleName"));
        mSurnameTextView.setText(intent.getSelector().getStringExtra("surname"));
        mAgeTextView.setText(intent.getSelector().getStringExtra("age"));
        mCountHoursTextView.setText(intent.getStringExtra("countHours"));
        mOrganizationTextView.setText(intent.getStringExtra("organization"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(textViewNameKey, mNameTextView.getText().toString());
        outState.putString(textViewMiddleNameKey, mMiddleNameTextView.getText().toString());
        outState.putString(textViewSurnameKey, mSurnameTextView.getText().toString());
        outState.putString(textViewAgeKey, mAgeTextView.getText().toString());
        outState.putString(textViewCountHoursKey, mCountHoursTextView.getText().toString());
        outState.putString(textViewOrganizationKey, mOrganizationTextView.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mNameTextView.setText(savedInstanceState.getString(textViewNameKey));
        mMiddleNameTextView.setText(savedInstanceState.getString(textViewMiddleNameKey));
        mSurnameTextView.setText(savedInstanceState.getString(textViewSurnameKey));
        mAgeTextView.setText(savedInstanceState.getString(textViewAgeKey));
        mCountHoursTextView.setText(savedInstanceState.getString(textViewCountHoursKey));
        mOrganizationTextView.setText(savedInstanceState.getString(textViewOrganizationKey));
    }

    public void Back_onClick(View view) {
        Intent intent = new Intent(this, ListenerSpecActivity.class);
        startActivity(intent);
    }

    public void Save_onClick(View view) {

        Intent intent = new Intent(this, MainActivity.class);


        Listener listener = new Listener(
                mNameTextView.getText().toString(),
                mSurnameTextView.getText().toString(),
                mMiddleNameTextView.getText().toString(),
                Integer.parseInt(mAgeTextView.getText().toString()),
                Integer.parseInt(mCountHoursTextView.getText().toString()),
                mOrganizationTextView.getText().toString());

        db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, listener.getFirstName());
        cv.put(DatabaseHelper.COLUMN_SURNAME, listener.getSecondName());
        cv.put(DatabaseHelper.COLUMN_MIDDLENAME, listener.getMiddleName());
        cv.put(DatabaseHelper.COLUMN_AGE, listener.getAge());
        cv.put(DatabaseHelper.COLUMN_COUNTHOURS, listener.getListeningHours());
        cv.put(DatabaseHelper.COLUMN_ORGANIZATION, listener.getOrganization());

        long rowid = db.insert(DatabaseHelper.TABLELISTENER, null, cv);
        Log.d("Log", "row inserted, ID = " + rowid);
        startActivity(intent);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        db.close();
    }
}
