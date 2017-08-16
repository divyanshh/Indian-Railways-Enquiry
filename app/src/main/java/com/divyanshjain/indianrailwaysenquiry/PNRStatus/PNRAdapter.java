package com.divyanshjain.indianrailwaysenquiry.PNRStatus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.divyanshjain.indianrailwaysenquiry.R;
import com.divyanshjain.indianrailwaysenquiry.liveTrainStatus.ListItem;

import java.util.List;

/**
 * Created by divyanshjain on 30/07/17.
 */

public class PNRAdapter extends RecyclerView.Adapter<PNRAdapter.ViewHolder> {

    private List<PNRListItem> listItems;
    private Context context;

    public PNRAdapter(List<PNRListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pnr_list_item , parent , false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PNRListItem listItem = listItems.get(position);

        holder.passengerNo.setText("Passenger No - " + listItem.getPassengerNo());
        holder.coachPosition.setText("Coach Position - " + listItem.getCoachPosition());
        holder.currentStatus.setText("Current Status - " + listItem.getCurrentStatus());
        holder.bookingStatus.setText("Booking Status - " + listItem.getBookingStatus());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView passengerNo;
        public TextView coachPosition;
        public TextView currentStatus;
        public TextView bookingStatus;

        public ViewHolder(View itemView) {
            super(itemView);

            passengerNo = (TextView) itemView.findViewById(R.id.passengerNo);
            coachPosition = (TextView) itemView.findViewById(R.id.coachPosition);
            currentStatus = (TextView) itemView.findViewById(R.id.currentStatus);
            bookingStatus = (TextView) itemView.findViewById(R.id.bookingStatus);

        }
    }
}
