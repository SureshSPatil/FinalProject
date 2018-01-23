package edu.tjhsst.finalproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private Button settingsButton;
    private Button addButton;
    public static ArrayList<Task> tasks = new ArrayList<Task>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tasks = new ArrayList<Task>();

        settingsButton = (Button)(findViewById(R.id.button1));
        addButton = (Button)(findViewById(R.id.button2));

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
//                boolean answer =mQuestionBank[mCurrentIndex].isAnswerTrue();
//                i.putExtra("answer", answer);
                startActivity(i);

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
//                boolean answer =mQuestionBank[mCurrentIndex].isAnswerTrue();
//                i.putExtra("answer", answer);
                startActivity(i);

            }
        });
//        tasks.add(new Task("Task1", 20, "Math", new Date(2018,1,10)));
//        // get the listview
//        expListView = (ExpandableListView) findViewById(R.id.lvExp);
//
//        // preparing list data
//        prepareListData();
//
//        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
//
//        // setting list adapter
//        expListView.setAdapter(listAdapter);



        //tasks.remove(0);
        Task dfault = new Task("Click on + to add task", -1, "LOL", new Date(2018,1,10));
        tasks.add(dfault);
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        tasks.remove(dfault);


    }

    /*
     * Preparing the list data
     */
    public void prepareListData() {
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
//
//        // Adding child data
//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");
//
//        // Adding child data
//        List<String> top250 = new ArrayList<String>();
//        top250.add("The Shawshank Redemption");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");
//
//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("The Conjuring");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");
//
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("2 Guns");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");
//
//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);


        //sort using compareTo

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        for(Task t: tasks) {
            listDataHeader.add(t.getName());
            List<String> info = new ArrayList<>();
            info.add("Duration: "+t.getDurationMins() +" mins");
            info.add("Subject: "+t.getSubject());
            info.add("Due Date "+(t.getDue().getMonth() + 1)+"/"+t.getDue().getDate()+"/"+t.getDue().getYear());
            listDataChild.put(t.getName(), info);
            info.add("Get Help");
            info.add("Complete Task");
        }

    }
}