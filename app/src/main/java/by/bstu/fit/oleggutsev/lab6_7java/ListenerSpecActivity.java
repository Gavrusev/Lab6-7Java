package by.bstu.fit.oleggutsev.lab6_7java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import by.bstu.fit.oleggutsev.lab6_7java.organization.Organizations;

import java.util.ArrayList;
import java.util.List;

public class ListenerSpecActivity extends AppCompatActivity {

    private Spinner mSpinner;
    private String item;

    private String[] data = { Organizations.EPAM.getCompany_name(),
            Organizations.BELHARD.getCompany_name(),
            Organizations.ITECHART.getCompany_name(),
            Organizations.ITRANSITION.getCompany_name(),
            Organizations.WARGAMING.getCompany_name()};

    private EditText mCountHoursEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener_spec);
        mCountHoursEditText = (EditText) findViewById(R.id.CountHours_editText);
        mSpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setPrompt("Organizations");
        mSpinner.setSelection(2);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                item = (String)parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    public void Back_onClick(View view) {
        Intent intent = new Intent(this, PersonNameActivity.class);
        startActivity(intent);
    }

    public void Next_onClick(View view) {
        Intent intentListenerspec = getIntent();

        if (!mCountHoursEditText.getText().toString().isEmpty()) {
            Intent intent = new Intent(this, ListenerInfoActivity.class);
            intent.setSelector(intentListenerspec);

            intent.putExtra("countHours", mCountHoursEditText.getText().toString());
            intent.putExtra("organization", item);
            startActivity(intent);
        } else Toast.makeText(this, "Не все поля заполнены!!!", Toast.LENGTH_SHORT).show();
    }
}
