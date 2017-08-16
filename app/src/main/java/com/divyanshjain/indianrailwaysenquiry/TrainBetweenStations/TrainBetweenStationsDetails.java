package com.divyanshjain.indianrailwaysenquiry.TrainBetweenStations;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.divyanshjain.indianrailwaysenquiry.R;

public class TrainBetweenStationsDetails extends AppCompatActivity {

    private static final String TAG = "TrainBetweenStationsDetails";
    private TextView mDisplayDate;
    private EditText fromStation;
    private EditText toStation;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_between_stations_details);
        mDisplayDate = (TextView) findViewById(R.id.textViewDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                //Theme_DeviceDefault_Dialog

                DatePickerDialog dialog = new DatePickerDialog(
                        TrainBetweenStationsDetails.this,
                        android.R.style.Theme_Material_Dialog,
                        mDateSetListener,
                        year,month,day);

                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {   //january is 0 december is 11
                month = month + 1;
                String date = month+"/"+day+"/"+year;
                mDisplayDate.setText(date);
            }
        };
    }

    public void search(View view) {

        Intent intent = new Intent(TrainBetweenStationsDetails.this, TrainBetweenStationsDetails.class);
        intent.putExtra("date" , mDisplayDate.getText().toString() );
        //intent.putExtra("from" , )
        startActivity(intent);
    }
}
