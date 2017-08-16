package com.divyanshjain.indianrailwaysenquiry.PNRStatus;

/**
 * Created by divyanshjain on 30/07/17.
 */

public class PNRListItem {

    private String passengerNo;
    private String coachPosition;
    private String currentStatus;
    private String bookingStatus;

    public PNRListItem(String passengerNo, String coachPosition, String currentStatus, String bookingStatus) {
        this.passengerNo = passengerNo;
        this.coachPosition = coachPosition;
        this.currentStatus = currentStatus;
        this.bookingStatus = bookingStatus;
    }

    public String getPassengerNo() {
        return passengerNo;
    }

    public String getCoachPosition() {
        return coachPosition;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }
}
