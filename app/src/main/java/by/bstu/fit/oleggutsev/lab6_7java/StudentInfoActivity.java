package by.bstu.fit.oleggutsev.lab6_7java;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import by.bstu.fit.oleggutsev.lab6_7java.units.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoActivity extends AppCompatActivity {

    final static String textViewNameKey = "NAME_TEXT";
    final static String textViewMiddleNameKey = "TEXTMIDDLENAME_TEXT";
    final static String textViewSurnameKey = "TEXTSURNAME_TEXT";
    final static String textViewAgeKey = "TEXTAGE_TEXT";
    final static String textViewFacultyKey = "TEXTFACULTY_TEXT";
    final static String textViewSpecialityKey = "TEXTSPECIALITY_TEXT";

    private TextView mNameTextView;
    private TextView mMiddleNameTextView;
    private TextView mSurnameTextView;
    private TextView mAgeTextView;
    private TextView mFacultyTextView;
    private TextView mSpecialityTextView;

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();
        Intent intent = getIntent();

        mNameTextView = (TextView) findViewById(R.id.Name_textView);
        mMiddleNameTextView = (TextView) findViewById(R.id.MiddleName_textView);
        mSurnameTextView = (TextView) findViewById(R.id.Surname_textView);
        mAgeTextView = (TextView) findViewById(R.id.Age_textView);
        mFacultyTextView = (TextView) findViewById(R.id.Faculty_textView);
        mSpecialityTextView = (TextView) findViewById(R.id.Speciality_textView);

        mNameTextView.setText(intent.getSelector().getStringExtra("name"));
        mMiddleNameTextView.setText(intent.getSelector().getStringExtra("middleName"));
        mSurnameTextView.setText(intent.getSelector().getStringExtra("surname"));
        mAgeTextView.setText(intent.getSelector().getStringExtra("age"));
        mSpecialityTextView.setText(intent.getStringExtra("spec"));
        mFacultyTextView.setText(intent.getStringExtra("faculty"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(textViewNameKey, mNameTextView.getText().toString());
        outState.putString(textViewMiddleNameKey, mMiddleNameTextView.getText().toString());
        outState.putString(textViewSurnameKey, mSurnameTextView.getText().toString());
        outState.putString(textViewAgeKey, mAgeTextView.getText().toString());
        outState.putString(textViewFacultyKey, mFacultyTextView.getText().toString());
        outState.putString(textViewSpecialityKey, mSpecialityTextView.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mNameTextView.setText(savedInstanceState.getString(textViewNameKey));
        mMiddleNameTextView.setText(savedInstanceState.getString(textViewMiddleNameKey));
        mSurnameTextView.setText(savedInstanceState.getString(textViewSurnameKey));
        mAgeTextView.setText(savedInstanceState.getString(textViewAgeKey));
        mFacultyTextView.setText(savedInstanceState.getString(textViewFacultyKey));
        mSpecialityTextView.setText(savedInstanceState.getString(textViewSpecialityKey));
    }

    public void Back_onClick(View view) {
        Intent intent = new Intent(this, StudentSpecActivity.class);
        startActivity(intent);
    }

    public void Save_onClick(View view) {

        Intent intent = new Intent(this, MainActivity.class);

        Student student = new Student(
                mNameTextView.getText().toString(),
                mSurnameTextView.getText().toString(),
                mMiddleNameTextView.getText().toString(),
                mSpecialityTextView.getText().toString(),
                mFacultyTextView.getText().toString(),
                Integer.parseInt(mAgeTextView.getText().toString()));

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, student.getFirstName());
        cv.put(DatabaseHelper.COLUMN_SURNAME, student.getSecondName());
        cv.put(DatabaseHelper.COLUMN_MIDDLENAME, student.getMiddleName());
        cv.put(DatabaseHelper.COLUMN_AGE, student.getAge());
        cv.put(DatabaseHelper.COLUMN_FACULTY, student.getFaculty());
        cv.put(DatabaseHelper.COLUMN_SPECIALITY, student.getSpeciality());
        long rowid = db.insert(DatabaseHelper.TABLESTUDENT, null, cv);
        Log.d("Log", "row inserted, ID = " + rowid);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
