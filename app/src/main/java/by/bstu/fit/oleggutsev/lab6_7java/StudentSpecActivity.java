package by.bstu.fit.oleggutsev.lab6_7java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudentSpecActivity extends AppCompatActivity {

    private EditText mSpecialityEditText;
    private EditText mFacultyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_spec);
        mSpecialityEditText = (EditText) findViewById(R.id.Speciality_editText);
        mFacultyEditText = (EditText) findViewById(R.id.Faculty_editText);
    }

    public void Back_onClick(View view) {
        Intent intent = new Intent(this, PersonNameActivity.class);
        startActivity(intent);
    }

    public void Next_onClick(View view) {
        Intent studentNameIntent = getIntent();

        if (!mSpecialityEditText.getText().toString().isEmpty() &&
                !mFacultyEditText.getText().toString().isEmpty()) {
            Intent intent = new Intent(this, StudentInfoActivity.class);
            intent.setSelector(studentNameIntent);

            intent.putExtra("spec", mSpecialityEditText.getText().toString());
            intent.putExtra("faculty", mFacultyEditText.getText().toString());
            startActivity(intent);
        } else Toast.makeText(this, "Не все поля заполнены!!!", Toast.LENGTH_SHORT).show();
    }
}
