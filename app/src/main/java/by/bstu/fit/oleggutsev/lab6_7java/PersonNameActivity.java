package by.bstu.fit.oleggutsev.lab6_7java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PersonNameActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mMiddleNameEditText;
    private EditText mSurameEditText;
    private EditText mAgeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        mNameEditText = (EditText) findViewById(R.id.Name_editText);
        mMiddleNameEditText = (EditText) findViewById(R.id.MiddleName_editText);
        mSurameEditText = (EditText) findViewById(R.id.Surname_editText);
        mAgeEditText = (EditText) findViewById(R.id.Age_editText);
    }

    public void Next_onClick(View view) {
        if (!mNameEditText.getText().toString().isEmpty() &&
                !mMiddleNameEditText.getText().toString().isEmpty() &&
                !mAgeEditText.getText().toString().isEmpty() &&
                !mAgeEditText.getText().toString().isEmpty()) {

            Intent intent = new Intent();

            if (getIntent().getBooleanExtra("id", true)) {
                intent = new Intent(this, StudentSpecActivity.class);
                intent.setClass(this, StudentSpecActivity.class);
                InitializedField(intent);
            } else {
                intent.setClass(this, ListenerSpecActivity.class);
                InitializedField(intent);
            }
        } else Toast.makeText(this, "Не все поля заполнены!!!", Toast.LENGTH_SHORT).show();
    }

    private void InitializedField(Intent intent) {
        intent.putExtra("name", mNameEditText.getText().toString());
        intent.putExtra("middleName", mMiddleNameEditText.getText().toString());
        intent.putExtra("surname", mSurameEditText.getText().toString());
        intent.putExtra("age", mAgeEditText.getText().toString());
        startActivity(intent);
    }
}
