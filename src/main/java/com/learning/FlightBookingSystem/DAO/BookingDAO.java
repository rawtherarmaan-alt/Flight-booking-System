package com.learning.FlightBookingSystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.learning.FlightBookingSystem.config.DBConnection;

public class BookingDAO {
        
	// BOOK FLIGHT
	public boolean bookFlight(int userId, int flightId, String seatNumbers, int seatCount) {
		
		boolean status = false;
		
		try {
			
			Connection conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			// check seats available
			String checkSeats = "SELECT seats_available FROM flight Where flight_id=?";
			PreparedStatement psCheck = conn.prepareStatement(checkSeats);
			psCheck.setInt(1, flightId);
			
			ResultSet rs = psCheck.executeQuery();
			
			if (rs.next()) {
				
				int availableSeats = rs.getInt("seats_available");
				
				if(seatCount > availableSeats) {
					
					System.out.println(" NOT enough seats available");
					return false;
				}
				
			} else {
				
				System.out.println("Flight not found");
				return false;
				
			}
			
			// check duplicates seats
			String bookedSeats = getBookedSeats(flightId);
			
			String[] requestedSeats = seatNumbers.split(",");
			
			for (String seat : requestedSeats) {
				
				if (bookedSeats.contains(seat.trim())) {
					
					System.out.println(" Seat " + seat + "already booked");
					return false;
				}
			}
			
			// insert Booking 
			String bookingSql = 
					"INSERT INTO bookings(user_id,flight_id,seat_number)Values(?,?,?)";
			
			PreparedStatement ps1 = conn.prepareStatement(bookingSql);
			
			ps1.setInt(1, userId);
			ps1.setInt(2, flightId);
			ps1.setString(3, seatNumbers);
			
			int bookingRows = ps1.executeUpdate();
			
			// update seats
			String updateFlight = 
					"UPDATE flight SET seats_available = seats_available - ? WHERE flight_id=?";
			
			PreparedStatement ps2 = conn.prepareStatement(updateFlight);
			
			ps2.setInt(1, seatCount);
			ps2.setInt(2, flightId);
			
			int updateRows = ps2.executeUpdate();
			
			if (bookingRows > 0 && updateRows > 0) {
				
				conn.commit();
				status = true;
				
			} else {
				conn.rollback();
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	// GET BOOKED SEATS
	public String getBookedSeats(int flightId) {
		
		StringBuilder seats = new StringBuilder();
		
		try {
			
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT seat_number FROM bookings WHERE flight_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, flightId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				seats.append(rs.getString("seat_number")).append(",");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return seats.toString();
	}
	
	// VIEW MY BOOKINGS
	public void viewBookings(int userId) {
		
		try {
			
			Connection conn = DBConnection.getConnection();
			
			String sql = 
					"SELECT b.booking_id,f.source,f.destination,f.departure_time,b.seat_number,b.status"
					 + "FROM bokings b"
					 + "JOIN flight f ON b.flight_id=f.flight_id"
					 + "WHERE b.user_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ResultSet rs  = ps.executeQuery();
			
			System.out.println("\n======= My Bookings =======");
			
			while (rs.next()) {
				
				System.out.println("-------------------------");
				
				System.out.println("Booking ID: "+ rs.getInt("booking_id"));
				
				System.out.println("Route: "
						+ rs.getString("source")
						+ " -> "
						+ rs.getString("destination"));
				
				System.out.println("Departure: " + rs.getString("departure_time"));
				
				System.out.println("Seat: "+ rs.getString("seat_number"));
				
				System.out.println("Status: "+ rs.getString("status"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// CANCEL BOOKING
	
}
