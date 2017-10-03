package by.bstu.fit.oleggutsev.lab6_7java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private RadioButton mStundentRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStundentRadioButton = (RadioButton) findViewById(R.id.Student_radioButton);
    }

    public void Back_onClick(View view) {
        finish();
    }

    public void Next_onClick(View view) {
        if (mStundentRadioButton.isChecked()) {
            Intent intent = new Intent(this, PersonNameActivity.class);
            intent.putExtra("id", true);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, PersonNameActivity.class);
            intent.putExtra("id", false);
            startActivity(intent);
        }
    }

    public void PersonList_onClick(View view) {
        if (mStundentRadioButton.isChecked()) {
            Intent intent = new Intent(this, FullInfoActivity.class);
            intent.putExtra("id", true);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, FullInfoActivity.class);
            intent.putExtra("id", false);
            startActivity(intent);
        }
    }
}
