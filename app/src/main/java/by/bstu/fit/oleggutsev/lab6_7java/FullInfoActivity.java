package by.bstu.fit.oleggutsev.lab6_7java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import by.bstu.fit.oleggutsev.lab6_7java.units.Listener;
import by.bstu.fit.oleggutsev.lab6_7java.units.Student;

public class FullInfoActivity extends AppCompatActivity {
    private DatabaseHelper mDatabaseHelper;
    private Student mStudent;
    private Listener mListener;

    private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullinfo);

        mDatabaseHelper = new DatabaseHelper(this);
        mStudent = new Student();
        mListener = new Listener();

        mInfoTextView = (TextView) findViewById(R.id.Info_textView);
    }

    @Override
    public void onResume() {
        super.onResume();
        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
        Intent intent = getIntent();
        if (intent.getBooleanExtra("id", true)) {
            Cursor cursor = db.query("students", null, null, null, null, null, null);

            if (cursor.moveToFirst()) {

                int nameColIndex = cursor.getColumnIndex("name");
                int surnameColIndex = cursor.getColumnIndex("surname");
                int middleNameColIndex = cursor.getColumnIndex("middleName");
                int ageColIndex = cursor.getColumnIndex("age");
                int facultyColIndex = cursor.getColumnIndex("faculty");
                int specialityColIndex = cursor.getColumnIndex("speciality");

                do {
                    mStudent.setFirstName(cursor.getString(nameColIndex));
                    mStudent.setSecondName(cursor.getString(surnameColIndex));
                    mStudent.setMiddleName(cursor.getString(middleNameColIndex));
                    mStudent.setAge(cursor.getInt(ageColIndex));
                    mStudent.setSpeciality(cursor.getString(specialityColIndex));
                    mStudent.setFaculty(cursor.getString(facultyColIndex));
                    mInfoTextView.setText(mInfoTextView.getText().toString() + mStudent.toString());
                } while (cursor.moveToNext());
            }
        } else {
            Cursor cursor = db.query("listeners", null, null, null, null, null, null);

            if (cursor.moveToFirst()) {

                int nameColIndex = cursor.getColumnIndex("name");
                int surnameColIndex = cursor.getColumnIndex("surname");
                int middleNameColIndex = cursor.getColumnIndex("middleName");
                int ageColIndex = cursor.getColumnIndex("age");
                int countHoursColIndex = cursor.getColumnIndex("countHours");
                int organizationColIndex = cursor.getColumnIndex("organization");

                do {
                    mListener.setFirstName(cursor.getString(nameColIndex));
                    mListener.setSecondName(cursor.getString(surnameColIndex));
                    mListener.setMiddleName(cursor.getString(middleNameColIndex));
                    mListener.setAge(cursor.getInt(ageColIndex));
                    mListener.setListeningHours(cursor.getInt(countHoursColIndex));
                    mListener.setOrganization(cursor.getString(organizationColIndex));
                    mInfoTextView.setText(mInfoTextView.getText().toString() + mListener.toString());
                } while (cursor.moveToNext());
            }
        }
    }
}
