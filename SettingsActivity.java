package edu.tjhsst.finalproject;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.TreeMap;

public class SettingsActivity extends AppCompatActivity {

    private EditText class1,class2,class3,class4,class5,class6,class7;
    private EditText score1,score2,score3,score4,score5,score6,score7;
    private Button savePreferences;
    public static TreeMap<String, Integer> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        class1 = (EditText)findViewById(R.id.Class1);
        class2 = (EditText)findViewById(R.id.Class2);
        class3 = (EditText)findViewById(R.id.Class3);
        class4 = (EditText)findViewById(R.id.Class4);
        class5 = (EditText)findViewById(R.id.Class5);
        class6 = (EditText)findViewById(R.id.Class6);
        class7 = (EditText)findViewById(R.id.Class7);

        score1 = (EditText)findViewById(R.id.score1);
        score2 = (EditText)findViewById(R.id.score2);
        score3 = (EditText)findViewById(R.id.score3);
        score4 = (EditText)findViewById(R.id.score4);
        score5 = (EditText)findViewById(R.id.score5);
        score6 = (EditText)findViewById(R.id.score6);
        score7 = (EditText)findViewById(R.id.score7);

        savePreferences = (Button)findViewById(R.id.savepreferences);
        map = new TreeMap<String, Integer>();
        map.put("LOL", 0);
        savePreferences.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
                map = new TreeMap<String, Integer>();
                map.put(class1.getText().toString(), Integer.parseInt(score1.getText().toString()));
                map.put(class2.getText().toString(), Integer.parseInt(score2.getText().toString()));
                map.put(class3.getText().toString(), Integer.parseInt(score3.getText().toString()));
                map.put(class4.getText().toString(), Integer.parseInt(score4.getText().toString()));
                map.put(class5.getText().toString(), Integer.parseInt(score5.getText().toString()));
                map.put(class6.getText().toString(), Integer.parseInt(score6.getText().toString()));
                map.put(class7.getText().toString(), Integer.parseInt(score7.getText().toString()));

                Intent i = new Intent(SettingsActivity.this, MainActivity.class);


                startActivity(i);

            }
        });



    }
}