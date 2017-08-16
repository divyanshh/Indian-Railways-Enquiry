package com.divyanshjain.indianrailwaysenquiry.liveTrainStatus;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.divyanshjain.indianrailwaysenquiry.liveTrainStatus.ListItem;
import com.divyanshjain.indianrailwaysenquiry.liveTrainStatus.MyAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String URL = "https://api.railwayapi.com/v2/live/train/";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    private TextView trainPosition;
    private TextView trainNumber;
    private TextView trainName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        String trainNo = bundle.getString("trainNo");
        String date = bundle.getString("date");

        String finalURL = URL+trainNo+"/date/"+date+"/apikey/1fg74i4g4f/";
        URL = finalURL;

        Log.i("url" , URL);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        trainPosition = (TextView) findViewById(R.id.trainPosition);
        trainNumber = (TextView) findViewById(R.id.trainNumber);
        trainName = (TextView) findViewById(R.id.trainName);

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
                            trainPosition.setText(jsonObject.getString("position"));
                            JSONObject nameNno =  jsonObject.getJSONObject("train");
                            trainName.setText(nameNno.getString("name"));
                            trainNumber.setText(nameNno.getString("number"));

                            JSONArray array = jsonObject.getJSONArray("route");

                            for (int i = 0 ; i < array.length() ; i++) {

                                JSONObject o = array.getJSONObject(i);
                                JSONObject stationName = o.getJSONObject("station");
                                ListItem item = new ListItem(
                                        stationName.getString("name"),
                                        o.getString("no"),
                                        o.getString("has_arrived"),
                                        o.getString("has_departed"),
                                        o.getString("scharr"),
                                        o.getString("schdep"),
                                        o.getString("actarr"),
                                        o.getString("actdep"),
                                        o.getString("latemin")
                                );
                                listItems.add(item);
                            }

                            adapter = new MyAdapter(listItems , getApplicationContext());
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
                        Toast.makeText(getApplicationContext() , error.getMessage() , Toast.LENGTH_LONG).show();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    }
