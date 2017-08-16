package com.divyanshjain.indianrailwaysenquiry;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.divyanshjain.indianrailwaysenquiry.PNRStatus.PnrActivity;
import com.divyanshjain.indianrailwaysenquiry.TrainBetweenStations.TrainBetweenStationsActivity;
import com.divyanshjain.indianrailwaysenquiry.TrainBetweenStations.TrainBetweenStationsDetails;
import com.divyanshjain.indianrailwaysenquiry.TrainRoute.TrainRouteActivity;
import com.divyanshjain.indianrailwaysenquiry.liveTrainStatus.LiveTrainStatus;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    public void liveTrainStatus(View view) {
        startActivity(new Intent(getApplicationContext() , LiveTrainStatus.class));
    }

    public void pnrStatus(View view) {

        View v = LayoutInflater.from(LauncherActivity.this).inflate(R.layout.pnr_alert_dialog_box , null);
        final EditText enterPNR = (EditText) v.findViewById(R.id.enterPNR); // view k baad add karna h bcoz vo is view me hai
        enterPNR.setHint("Enter PNR No");

        AlertDialog.Builder builder = new AlertDialog.Builder(LauncherActivity.this);

        builder.setMessage("PNR STATUS")
                .setView(v)
                .setPositiveButton("SHOW STATUS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(LauncherActivity.this, enterPNR.getText().toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LauncherActivity.this, PnrActivity.class);
                        intent.putExtra("pnrNo", enterPNR.getText().toString());
                        startActivity(intent);
                    }
                })
                .setNegativeButton("CANCEL" , null)
                .setCancelable(false);

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void trainRoute(View view) {

        View v = LayoutInflater.from(LauncherActivity.this).inflate(R.layout.pnr_alert_dialog_box , null);
        final EditText enterPNR = (EditText) v.findViewById(R.id.enterPNR); // view k baad add karna h bcoz vo is view me hai
        enterPNR.setHint("Enter train No");

        AlertDialog.Builder builder = new AlertDialog.Builder(LauncherActivity.this);

        builder.setMessage("Train Route")
                .setView(v)
                .setPositiveButton("SHOW ROUTE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(LauncherActivity.this, enterPNR.getText().toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LauncherActivity.this, TrainRouteActivity.class);
                        intent.putExtra("trainNo", enterPNR.getText().toString());
                        startActivity(intent);
                    }
                })
                .setNegativeButton("CANCEL" , null)
                .setCancelable(false);

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void trainBWStations(View view) {

        Intent intent = new Intent(LauncherActivity.this, TrainBetweenStationsDetails.class);
        startActivity(intent);
    }
}
