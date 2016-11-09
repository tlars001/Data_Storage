package com.example.trevor.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

// This class saves the number in the textview
public class MainActivity extends AppCompatActivity {

    int number;
    SharedPreferences shared;
    String key = "secret";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.textView);
        shared = getPreferences(MODE_PRIVATE);
        number = shared.getInt(key, Integer.parseInt(text.getText().toString()));
        String item = Integer.toString(number);
        text.setText(item);
    }

    public void onClickAdvance(View v) {

        TextView text = (TextView) findViewById(R.id.textView);
        number = Integer.parseInt(text.getText().toString());
        number++;
        String item = Integer.toString(number);
        text.setText(item);
    }

    public void onClickSave(View v) {
        SharedPreferences shared = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = shared.edit();
        edit.putInt(key,number);
        edit.commit();

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(),"Item Saved!",duration);
        toast.show();
    }
}
