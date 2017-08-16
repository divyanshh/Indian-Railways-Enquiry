package com.divyanshjain.indianrailwaysenquiry.liveTrainStatus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.divyanshjain.indianrailwaysenquiry.R;

import java.util.List;

/**
 * Created by divyanshjain on 29/07/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item , parent , false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ListItem listItem = listItems.get(position);

        holder.stationName.setText(listItem.getStationName());
        holder.stationNumber.setText("Station Number " + listItem.getStationNo());
        holder.hasArrived.setText("Has Arrived on the station " + listItem.getHasArrived());
        holder.hadDeparted.setText("Has Departed from the station " + listItem.getHasDeparted());
        holder.scheduledArrival.setText("Scheduled Arrival Time " + listItem.getScheduledArrival());
        holder.scheduledDeparture.setText("Scheduled Departure Time " + listItem.getScheduledDeparture());
        holder.actualArrival.setText("Actual Arrival Time " + listItem.getActualArrival());
        holder.actualDeparture.setText("Actual Departure Time  " + listItem.getActualDeparture());
        holder.lateBy.setText("Late by " + listItem.getLateBy() + " mins");

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView stationName;
        public TextView stationNumber;
        public TextView hasArrived;
        public TextView hadDeparted;
        public TextView scheduledArrival;
        public TextView scheduledDeparture;
        public TextView actualArrival;
        public TextView actualDeparture;
        public TextView lateBy;


        public ViewHolder(View itemView) {
            super(itemView);

            stationName = (TextView) itemView.findViewById(R.id.stationName);
            stationNumber = (TextView) itemView.findViewById(R.id.stationNo);
            hasArrived = (TextView) itemView.findViewById(R.id.hasArrived);
            hadDeparted = (TextView) itemView.findViewById(R.id.hasDeparted);
            scheduledArrival = (TextView) itemView.findViewById(R.id.scheduledArrival);
            scheduledDeparture = (TextView) itemView.findViewById(R.id.scheduledDeparture);
            actualArrival = (TextView) itemView.findViewById(R.id.actualArrival);
            actualDeparture = (TextView) itemView.findViewById(R.id.actualDeparture);
            lateBy = (TextView) itemView.findViewById(R.id.lateBy);

        }
    }
}
