package edu.tjhsst.finalproject;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import java.util.Calendar;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener  {
private EditText et1,et2,et3;
    private Button createtask,picdate;
private Task t;
    private TextView timeView;
    private Date d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        et1 = (EditText)findViewById(R.id.edittext1);
        et2 = (EditText)findViewById(R.id.edittext2);
        et3 = (EditText)findViewById(R.id.edittext3);
 createtask = (Button)findViewById(R.id.createtask);
        picdate = (Button)findViewById(R.id.picDate);
        timeView = (TextView)findViewById(R.id.timeview);

createtask.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
//        if(d != null)
        MainActivity MN = new MainActivity();
        MN.tasks.add(new Task((et1.getText().toString()), Integer.parseInt(et2.getText().toString()), (et3.getText().toString()), d));
        TaskSorter taskSorter = new TaskSorter(MN.tasks);
        MN.tasks = taskSorter.getSorted();
//        MN.tasks.sort();
//        MN.prepareListData();
//        MN.listAdapter = new ExpandableListAdapter(AddActivity.this, MN.listDataHeader, MN.listDataChild);
//        // setting list adapter
//        MN.expListView.setAdapter(MN.listAdapter);
        Intent i = new Intent(AddActivity.this, MainActivity.class);
        startActivity(i);


    }
});
//        private void setDate(final Calendar calendar) {
//            final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
//
//            timeView.setText(dateFormat.format(calendar.getTime()));
//
//        }

        /**
         * To receive a callback when the user sets the date.
         * @param view
         * @param year
         * @param month
         * @param day
         */




    }

    /**
     * To receive a callback when the user sets the date.
     * @param view
     * @param year
     * @param month
     * @param day
     */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Date cal = new Date(year, month, day);
        d = cal;
        timeView.setText(("0"+(1+d.getMonth())+"/"+d.getDate()+"/"+d.getYear()));

//        Calendar cal = new GregorianCalendar(year, month, day);
//        setDate(cal);
    }

    /**
     * This callback method, call DatePickerFragment class,
     * DatePickerFragment class returns calendar view.
     * @param view
     */
    public void datePicker(View view){

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getFragmentManager(), "datePicker");
    }




    /**
     * Create a DatePickerFragment class that extends DialogFragment.
     * Define the onCreateDialog() method to return an instance of DatePickerDialog
     */
    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                            getActivity(), year, month, day);
        }

    }
}


