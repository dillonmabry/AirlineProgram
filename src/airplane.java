/* Dillon Mabry Student ID: 800854402 */
import java.util.ArrayList;

public class airplane {

	protected ArrayList<Seat> firstClass = new ArrayList<Seat>();
	protected ArrayList<Seat> economyClass = new ArrayList<Seat>();

	/**
	 * Constructor to create airplane object with new Seat objects
	 * Creates 20 first class seats with window/aisle seats and
	 * 90 economy class seat with window/center/aisle seats
	 */
	public airplane() {
		int num = 1;
		for (int i = 0; i < 20; i++) {
			if (num % 2 != 0) {
				firstClass.add(new Seat(num, "", 0, "window"));
			} else {
				firstClass.add(new Seat(num, "", 0, "aisle"));
			}
			num++;
		}
		int count = 1;
		for (int j = 0; j < 90; j++) {
			if (count % 3 == 0) {
				economyClass.add(new Seat(count, "", 0, "aisle"));
			} else if (count % 3 == 1) {
				economyClass.add(new Seat(count, "", 0, "window"));
			} else {
				economyClass.add(new Seat(count, "", 0, "center"));
			}
			count++;
		}
	}

	/**
	 * Method to add a first class seat to the airplane
	 * Modifies the current existing Seat and updates status
	 * @param seatClass the class of seat
	 * @param numPass the number of passengers
	 * @param pref the preference of location
	 * @param seat the Seat to update
	 */
	public void firstClassAddSeat(String seatClass, int numPass, String pref, Seat seat) {
		seat.setStatus(true);
		seat.setClass(seatClass);
		seat.setNumPass(numPass);
		seat.setSeatPref(pref);
	}

	/**
	 * Method to add an economy class seat to the airplane
	 * Modifies the current existing Seat and updates status
	 * @param seatClass the class of seat
	 * @param numPass the number of passengers
	 * @param pref the preference of location
	 * @param seat the Seat to update
	 */
	public void economyClassAddSeat(String seatClass, int numPass, String pref, Seat seat) {
		seat.setStatus(true);
		seat.setClass(seatClass);
		seat.setNumPass(numPass);
		seat.setSeatPref(pref);
	}

	/**
	 * Method to print out the first class seating arrangement
	 * from top left to bottom right for left side.
	 * Right side prints top right to bottom left.
	 */
	public void printFirstClassSeats() {
		System.out.println("Left Side of Plane (from TOP LEFT to BOTTOM RIGHT): \n");
		for (int i = 0; i < firstClass.size() / 2; i++) {
			System.out.print("Seat class: First | " + "Seat number: " + firstClass.get(i).getNumber() + " | " + " "
					+ "taken: " + firstClass.get(i).getStatus() + " | Seat loc: " + firstClass.get(i).getSeatPref());
			System.out.println();
		}
		System.out.println();
		System.out.println("Right side of Plane (from TOP RIGHT TO BOTTOM LEFT): \n");
		for (int i = 10; i < firstClass.size(); i++) {
			System.out.print("Seat class: First | " + "Seat number: " + firstClass.get(i).getNumber() + " | " + " "
					+ "taken: " + firstClass.get(i).getStatus() + " | Seat loc: " + firstClass.get(i).getSeatPref());
			System.out.println();
		}

	}

	/**
	 * Method to print out the economy class seating arrangement
	 * from top left to bottom right for left side.
	 * Right side prints top right to bottom left.
	 */
	public void printEconomyClassSeats() {
		System.out.println("Left Side of Plane (from TOP LEFT to BOTTOM RIGHT): \n");
		for (int i = 0; i < economyClass.size() / 2; i++) {
			System.out.print("Seat class: Economy | " + "Seat number: " + economyClass.get(i).getNumber() + " | " + " "
					+ "taken: " + economyClass.get(i).getStatus() + " | Seat loc: "
					+ economyClass.get(i).getSeatPref());
			System.out.println();
		}
		System.out.println();
		System.out.println("Right side of Plane (from TOP RIGHT TO BOTTOM LEFT): \n");
		for (int i = 45; i < economyClass.size(); i++) {
			System.out.print("Seat class: Economy | " + "Seat number: " + economyClass.get(i).getNumber() + " | " + " "
					+ "taken: " + economyClass.get(i).getStatus() + " | Seat loc: "
					+ economyClass.get(i).getSeatPref());
			System.out.println();
		}
	}

	/**
	 * Class for creating Seats for the airplane Class
	 * @author dillonmabry
	 *
	 */
	protected class Seat {
		private int seatNum;
		private String seatClass;
		private int numPassengers;
		private String seatPref;
		private boolean isTaken;

		/**
		 * Constructor for creating a seat
		 * @param seatNum the seat number
		 * @param seatClass the class assigned to the seat
		 * @param numPass number of passengers
		 * @param seatPref the preference location
		 */
		public Seat(int seatNum, String seatClass, int numPass, String seatPref) {
			this.seatNum = seatNum;
			this.seatClass = seatClass;
			this.numPassengers = numPass;
			this.seatPref = seatPref;
			this.isTaken = false;
		}

		/**
		 * Setter to set seat status
		 * @param status whether the seat is available
		 */
		public void setStatus(boolean status) { // set seat status
			this.isTaken = status;
		}

		/** 
		 * Getter to get the status of the seat
		 * @return the seat status
		 */
		public boolean getStatus() { // get seat status
			return this.isTaken;
		}

		/**
		 * Getter to get the seat number
		 * @return the seat number
		 */
		public int getNumber() { // get seat number
			return this.seatNum;
		}

		/**
		 * Getter to get the preference location
		 * @return seat location
		 */
		public String getSeatPref() { // get pref
			return this.seatPref;
		}

		/**
		 * Setter to seat seat preference
		 * @param pref the location preference 
		 */
		public void setSeatPref(String pref) { // set pref
			this.seatPref = pref;
		}

		/**
		 * Setter to set the number of passengers
		 * @param pass the number of passengers
		 */
		public void setNumPass(int pass) { // set number of passengers
			this.numPassengers = pass;
		}

		/**
		 * Setter to set the class of the seat
		 * @param sClass the class of the seat to set
		 */
		public void setClass(String sClass) { // set seat class
			this.seatClass = sClass;
		}

	} // end of Seat class

} // end of airplane class
