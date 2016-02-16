/* Dillon Mabry Student ID: 800854402 */
import java.util.ArrayList;

public class airplane {

	ArrayList<Seat> firstClass = new ArrayList<Seat>();
	ArrayList<Seat> economyClass = new ArrayList<Seat>();
	
	public airplane() {
		int num = 1;
		for(int i=0; i< 20; i++) {
			if(num%2 != 0) {
				firstClass.add(new Seat(num,"",0,"window"));
			} else {
				firstClass.add(new Seat(num,"",0,"aisle"));
			}
			num++;
		}
		int count = 1;
		for(int j=0; j < 90; j++) {
			if(count%3 ==0) {
				economyClass.add(new Seat(count,"",0,"aisle"));
			} else if(count%3 == 1) {
				economyClass.add(new Seat(count,"",0,"window"));
			} else {
				economyClass.add(new Seat(count,"",0,"center"));
			}
			count++;
		}
	}
	
	public void firstClassAddSeat(int num, String seatClass, int numPass, String pref) {
		firstClass.add(new Seat(num,seatClass,numPass,pref));
//		if(seatClass.toLowerCase().equals("first")) {
//			
//			if(numPass < 1 || numPass > 2) {
//				System.out.println("Error please enter between 1 and 2 passengers for first class!");
//				return;	
//			} 
//			
//			if(!(pref.toLowerCase().equals("window")|| pref.toLowerCase().equals("aisle"))) {
//				System.out.println("Error please enter window or aisle for seat preferences!");
//				return;
//			}
//			
//			firstClass.add(new Seat(num,seatClass,numPass,pref));
//			
//		} else if (seatClass.toLowerCase().equals("economy")) {
//			economyClass.add(new Seat(num, seatClass,numPass,pref));
//		}
	}
	
	public void economyClassAddSeat(int num, String seatClass, int numPass, String pref) {
		economyClass.add(new Seat(num,seatClass,numPass,pref));
	}
	
	public void printFirstClassSeats() {
		System.out.println("Left Side of Plane (from TOP LEFT to BOTTOM RIGHT): \n");
		for(int i=0; i< firstClass.size()/2; i++) {
			System.out.print("Seat class: First | "+"Seat number: "+firstClass.get(i).seatNum+" | "+
					" "+"taken: "+firstClass.get(i).isTaken+"Seat loc: "+firstClass.get(i).seatPref);
			System.out.println();
		}
		System.out.println();
		System.out.println("Right side of Plane (from TOP RIGHT TO BOTTOM LEFT): \n");
		for(int i=10; i< firstClass.size(); i++) {
			System.out.print("Seat class: First | "+"Seat number: "+firstClass.get(i).seatNum+" | "+
					" "+"taken: "+firstClass.get(i).isTaken+"Seat loc: "+firstClass.get(i).seatPref);
			System.out.println();
		}
		
	}
	
	public void printEconomyClassSeats() {
//		for(int i=0; i< economyClass.size(); i++) {
//			System.out.print("Seat class: Economy | "+"Seat number: "+economyClass.get(i).seatNum+" | "+
//					" "+"taken: "+economyClass.get(i).isTaken+"Seat loc: "+economyClass.get(i).seatPref);
//			System.out.println();
//		}
		System.out.println("Left Side of Plane (from TOP LEFT to BOTTOM RIGHT): \n");
		for(int i=0; i< economyClass.size()/2; i++) {
			System.out.print("Seat class: Economy | "+"Seat number: "+economyClass.get(i).seatNum+" | "+
					" "+"taken: "+economyClass.get(i).isTaken+"Seat loc: "+economyClass.get(i).seatPref);
			System.out.println();
		}
		System.out.println();
		System.out.println("Right side of Plane (from TOP RIGHT TO BOTTOM LEFT): \n");
		for(int i=45; i< economyClass.size(); i++) {
			System.out.print("Seat class: Economy | "+"Seat number: "+economyClass.get(i).seatNum+" | "+
					" "+"taken: "+economyClass.get(i).isTaken+"Seat loc: "+economyClass.get(i).seatPref);
			System.out.println();
		}
	}

	public class Seat {
		private int seatNum;
		private String seatClass;
		private int numPassengers;
		private String seatPref;
		private boolean isTaken;
		
		public Seat(int seatNum,String seatClass, int numPass, String seatPref) {
			this.seatNum = seatNum;
			this.seatClass = seatClass;
			this.numPassengers = numPass;
			this.seatPref = seatPref;
			this.isTaken = false;
		}

		public void setStatus(boolean status) {
			this.isTaken = status;
		}
		
		public boolean getStatus() {
			return this.isTaken;
		}
		
		public int getNumber() {
			return this.seatNum;
		}
		
	} //end of Seat class
	
} //end of airplane class
