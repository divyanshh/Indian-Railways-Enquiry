package com.divyanshjain.indianrailwaysenquiry.TrainRoute;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.divyanshjain.indianrailwaysenquiry.R;

import java.util.List;

/**
 * Created by divyanshjain on 31/07/17.
 */

public class TrainRouteAdapter extends RecyclerView.Adapter<TrainRouteAdapter.ViewHolder> {

    private List<TrainRouteListItem> listItems;
    private Context context;

    public TrainRouteAdapter(List<TrainRouteListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.train_route_list_item , parent , false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TrainRouteListItem listItem = listItems.get(position);

        holder.stationNameNo.setText(listItem.getStationNameNo());
        holder.stationNo.setText("Station No - " + listItem.getStationNo());
        holder.scheduledArrival.setText("Scheduled Arrival Time - " + listItem.getScheduledArrival());
        holder.scheduledDeparture.setText("Scheduled Departure Time - " + listItem.getScheduledDeparture());
        holder.distanceFromSource.setText("Distance From Source - " + listItem.getDistanceFromSource());
        holder.haltTime.setText("Halt Time = " + listItem.getHaltTime());
        holder.dayOfJourney.setText("Day of Journey - " + listItem.getDayOfJourney());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView stationNameNo;
        public TextView stationNo;
        public TextView scheduledArrival;
        public TextView scheduledDeparture;
        public TextView distanceFromSource;
        public TextView haltTime;
        public TextView dayOfJourney;

        public ViewHolder(View itemView) {
            super(itemView);

            stationNameNo = (TextView) itemView.findViewById(R.id.stationNameNo);
            stationNo = (TextView) itemView.findViewById(R.id.stationNo);
            scheduledArrival = (TextView) itemView.findViewById(R.id.scheduledArrival);
            scheduledDeparture = (TextView) itemView.findViewById(R.id.scheduledDeparture);
            distanceFromSource = (TextView) itemView.findViewById(R.id.distanceFromSource);
            haltTime = (TextView) itemView.findViewById(R.id.haltTime);
            dayOfJourney = (TextView) itemView.findViewById(R.id.dayOfJourney);

        }
    }
}
