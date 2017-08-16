package com.divyanshjain.indianrailwaysenquiry.TrainBetweenStations;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.divyanshjain.indianrailwaysenquiry.R;
import com.divyanshjain.indianrailwaysenquiry.TrainRoute.TrainRouteListItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TrainBetweenStationsActivity extends AppCompatActivity {

    String URL = "https://api.railwayapi.com/v2/between/source/";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<TrainBetweenStationsListItem> listItems;
    private TextView dateOfJourney;
    private TextView chartPrepared;
    private TextView fromNTo;
    private TextView boardingPoint;
    private TextView reservationUpto;
    private TextView train;
    private TextView classOfTravel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnr);

        Bundle bundle = getIntent().getExtras();
        String fromStation = bundle.getString("from");
        String toStation = bundle.getString("to");
        String finalUrl = URL + fromStation + "dest/" + toStation + "/apikey/1fg74i4g4f/";
        URL = finalUrl;
        Log.i("URL", URL);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dateOfJourney = (TextView) findViewById(R.id.dateOfJourney);
        chartPrepared = (TextView) findViewById(R.id.chartPrepared);
        fromNTo = (TextView) findViewById(R.id.fromNTo);
        boardingPoint = (TextView) findViewById(R.id.boardingPoint);
        reservationUpto = (TextView) findViewById(R.id.reservationUpto);
        train = (TextView) findViewById(R.id.train);
        classOfTravel = (TextView) findViewById(R.id.classOfTravel);

        listItems = new ArrayList<>();

        //loadRecyclerViewData();

    }
}

    /*private void loadRecyclerViewData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            dateOfJourney.setText("Date of journey - " + jsonObject.getString("doj"));
                            chartPrepared.setText("Chart Prepared - " + jsonObject.getString("chart_prepared"));
                            JSONObject object = jsonObject.getJSONObject("from_station");
                            JSONObject object1 = jsonObject.getJSONObject("to_station");
                            fromNTo.setText("From " + object.getString("name") + " To " + object1.getString("name"));
                            object = jsonObject.getJSONObject("boarding_point");
                            boardingPoint.setText("Boarding Point " + object.getString("name"));
                            object = jsonObject.getJSONObject("reservation_upto");
                            reservationUpto.setText("Reservation Upto " + object.getString("name"));
                            object = jsonObject.getJSONObject("train");
                            train.setText("Train - " + object.getString("name") + " (" + object.getString("number") + ")");
                            object = jsonObject.getJSONObject("journey_class");
                            classOfTravel.setText("Journey Class - " + object.getString("name") + " (" + object.getString("code") + ")");

                            JSONArray array = jsonObject.getJSONArray("passengers");

                            for (int i = 0; i < array.length(); i++) {

                                JSONObject o = array.getJSONObject(i);
                                TrainBetweenStationsListItem item = new TrainBetweenStationsListItem(
                                        o.getString("no"),
                                        o.getString("coach_position"),
                                        o.getString("current_status"),
                                        o.getString("booking_status")
                                );
                                listItems.add(item);
                            }

                            adapter = new TrainBetweenStationsAdapter(listItems, getApplicationContext());
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
} */

