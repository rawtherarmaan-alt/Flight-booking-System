package com.learning.FlightBookingSystem.model;

public class Booking {
	
	private int bookingId;
	private int userId;
	private int flightId;
	private String seatNumber;
	private String status;
	
	

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}



	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}



	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}



	/**
	 * @return the flightId
	 */
	public int getFlightId() {
		return flightId;
	}



	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}



	/**
	 * @return the seatNumber
	 */
	public String getSeatNumber() {
		return seatNumber;
	}



	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}



	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}



	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


}
