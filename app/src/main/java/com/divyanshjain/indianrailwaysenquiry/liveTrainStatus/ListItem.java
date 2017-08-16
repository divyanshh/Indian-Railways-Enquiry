package com.divyanshjain.indianrailwaysenquiry.liveTrainStatus;

/**
 * Created by divyanshjain on 29/07/17.
 */

public class ListItem {

    private String stationName;
    private String stationNo;
    private String hasArrived;
    private String hasDeparted;
    private String scheduledArrival;
    private String scheduledDeparture;
    private String actualArrival;
    private String actualDeparture;
    private String lateBy;

    public ListItem(String stationName, String stationNo, String hasArrived,
                    String hasDeparted, String scheduledArrival, String scheduledDeparture,
                    String actualArrival, String actualDeparture, String lateBy) {

        this.stationName = stationName;
        this.stationNo = stationNo;
        this.hasArrived = hasArrived;
        this.hasDeparted = hasDeparted;
        this.scheduledArrival = scheduledArrival;
        this.scheduledDeparture = scheduledDeparture;
        this.actualArrival = actualArrival;
        this.actualDeparture = actualDeparture;
        this.lateBy = lateBy;
    }


    public String getStationName() {
        return stationName;
    }

    public String getLateBy() {
        return lateBy;
    }

    public String getActualDeparture() {
        return actualDeparture;
    }

    public String getScheduledArrival() {
        return scheduledArrival;
    }

    public String getScheduledDeparture() {
        return scheduledDeparture;
    }

    public String getActualArrival() {
        return actualArrival;
    }

    public String getHasDeparted() {
        return hasDeparted;
    }

    public String getHasArrived() {
        return hasArrived;
    }

    public String getStationNo() {
        return stationNo;
    }
}
