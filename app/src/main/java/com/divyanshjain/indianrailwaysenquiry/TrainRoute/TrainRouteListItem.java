package com.divyanshjain.indianrailwaysenquiry.TrainRoute;

/**
 * Created by divyanshjain on 31/07/17.
 */

public class TrainRouteListItem {

    private String stationNameNo;
    private String stationNo;
    private String scheduledArrival;
    private String scheduledDeparture;
    private String distanceFromSource;
    private String haltTime;
    private String dayOfJourney;

    public TrainRouteListItem(String stationNameNo, String stationNo,
                              String scheduledArrival, String scheduledDeparture,
                              String distanceFromSource, String haltTime, String dayOfJourney) {

        this.stationNameNo = stationNameNo;
        this.stationNo = stationNo;
        this.scheduledArrival = scheduledArrival;
        this.scheduledDeparture = scheduledDeparture;
        this.distanceFromSource = distanceFromSource;
        this.haltTime = haltTime;
        this.dayOfJourney = dayOfJourney;
    }

    public String getStationNameNo() {
        return stationNameNo;
    }

    public String getStationNo() {
        return stationNo;
    }

    public String getScheduledArrival() {
        return scheduledArrival;
    }

    public String getScheduledDeparture() {
        return scheduledDeparture;
    }

    public String getDistanceFromSource() {
        return distanceFromSource;
    }

    public String getHaltTime() {
        return haltTime;
    }

    public String getDayOfJourney() {
        return dayOfJourney;
    }
}
