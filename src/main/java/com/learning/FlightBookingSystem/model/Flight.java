package com.learning.FlightBookingSystem.model;

public class Flight {
	
	private int flightId;
	private String airline;
	private String source;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	private double price;
	private int seatsAvailable;
	
	

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
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}



	/**
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}



	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}



	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}



	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}



	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}



	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}



	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}



	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}



	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}



	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}



	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}



	/**
	 * @return the seatsAvailable
	 */
	public int getSeatsAvailable() {
		return seatsAvailable;
	}



	/**
	 * @param seatsAvailable the seatsAvailable to set
	 */
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}



}
