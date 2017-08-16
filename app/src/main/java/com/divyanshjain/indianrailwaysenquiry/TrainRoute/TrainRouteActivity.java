package com.divyanshjain.indianrailwaysenquiry.TrainRoute;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TrainRouteActivity extends AppCompatActivity {

    String URL = "https://api.railwayapi.com/v2/route/train/";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<TrainRouteListItem> listItems;
    private TextView trainNameNO;
    private TextView runningDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_route);

        Bundle bundle = getIntent().getExtras();
        String trainNo = bundle.getString("trainNo");
        String finalUrl = URL+trainNo+"/apikey/1fg74i4g4f/";
        URL = finalUrl;
        Log.i("URL" , URL);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        trainNameNO = (TextView) findViewById(R.id.trainNameNno);
        runningDays = (TextView) findViewById(R.id.runningDays2);

        listItems = new ArrayList<>();

        loadRecyclerViewData();

    }

    private void loadRecyclerViewData() {

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
                            JSONObject object = jsonObject.getJSONObject("train");
                            trainNameNO.setText(object.getString("name") + "( " + object.getString("number") + " )");
                            JSONArray days = object.getJSONArray("days");
                            String runningDaysString = "Running Days =";

                            for (int i = 0; i < days.length(); i++) {

                                JSONObject day = days.getJSONObject(i);
                                if (day.getString("runs").equals("Y")) {
                                    runningDaysString = runningDaysString + "  " + day.getString("code");
                                }
                            }

                            if (runningDaysString != null) {
                                runningDays.setText(runningDaysString);
                                System.out.println("hello");
                            } else {
                                runningDays.setText("Running Days Not Available");
                            }

                            JSONArray array = jsonObject.getJSONArray("route");
                            System.out.println(array.getJSONObject(0));
                            System.out.println("hello");

                            for (int i = 0; i < array.length(); i++) {

                                JSONObject o = array.getJSONObject(i);
                                JSONObject name = o.getJSONObject("station");

                                Log.i("name" , name.getString("name"));

                                TrainRouteListItem item = new TrainRouteListItem(
                                        name.getString("name") + " ( " + name.getString("code") + " )",
                                        o.getString("no"),
                                        o.getString("scharr"),
                                        o.getString("schdep"),
                                        o.getString("distance"),
                                        o.getString("halt"),
                                        o.getString("day")
                                );
                                listItems.add(item);
                            }

                            adapter = new TrainRouteAdapter(listItems, getApplicationContext());
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
}
