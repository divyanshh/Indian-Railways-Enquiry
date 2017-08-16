package com.divyanshjain.indianrailwaysenquiry.liveTrainStatus;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.divyanshjain.indianrailwaysenquiry.R;

public class LiveTrainStatus extends AppCompatActivity {

    private static final String TAG = "LiveTrainStatusActivity";
    private TextView mDisplayDate;
    private EditText trainNo;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_train_status);
        mDisplayDate = (TextView) findViewById(R.id.textViewDate);
        trainNo = (EditText) findViewById(R.id.trainNo);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                //Theme_DeviceDefault_Dialog

                DatePickerDialog dialog = new DatePickerDialog(
                        LiveTrainStatus.this,
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
                date = day+"-"+month+"-"+year;
                mDisplayDate.setText(date);
            }
        };
    }

    public void getStatus(View view) {

        Intent intent = new Intent(LiveTrainStatus.this , MainActivity.class);
        intent.putExtra("date" , date );
        intent.putExtra("trainNo" , trainNo.getText().toString());
        startActivity(intent);
    }
}
