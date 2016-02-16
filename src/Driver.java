/* Dillon Mabry Student ID: 800854402 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		airplane plane = new airplane();
		Scanner menu = new Scanner(System.in);
		while (true) {
			System.out.println("---------------------------------------------");
			System.out.println("Fly-By-Night Airplanes Seating Application\n");
			System.out.println("Press 0 to add passengers.");
			System.out.println("Press 1 to show up-to-date seating.");
			System.out.println("Press 2 to exit application.");
			System.out.println("---------------------------------------------");
			try {
				int choice = menu.nextInt();
				if(choice < 0 || choice > 2) {
					System.out.println("Please enter menu choice between 0 and 2!");
					continue;
				}
				switch (choice) {
				
				case 0:
					Scanner input = new Scanner(System.in);
					int classChoice, passChoice, pref;
					System.out.print("Enter the class for passenger (0 for First, 1 for Economy): ");
					classChoice = input.nextInt();			//class choice
					if(classChoice < 0 || classChoice > 1) {
						System.out.println("Please enter a choice between 0 and 1! Returning to menu.");
						break;
					} else if (classChoice == 0) { //first class
						System.out.print("Please enter number of passengers between 1 and 2: ");
						passChoice = input.nextInt();			//num passengers
						if(passChoice < 1 || passChoice > 2) {
							System.out.println("Please enter a choice between 1 and 2! Returning to menu.");
							break;
						} else if (passChoice == 1) {
							System.out.print("Please enter seating preferences (0 for window, 1 for aisle): "); //add pref for 1 
							pref = input.nextInt();
							if(pref < 0 || pref > 1) {
								System.out.println("Please enter a choice between 0 and 1! Returning to menu.");
								break;
							} else if(pref == 0) {
								for(int i=0; i < plane.firstClass.size(); i++) {
									if(plane.firstClass.get(i).getStatus() == false && plane.firstClass.get(i).getSeatPref().equals("window")) {
										plane.firstClassAddSeat(String.valueOf(classChoice),passChoice,"window",plane.firstClass.get(i));
										break;
									} else {
										System.out.println("Moving passenger to next available seat.");
									}
								}
								
							} else {
								for(int i=0; i < plane.firstClass.size(); i++) {
									if(plane.firstClass.get(i).getStatus() == false && plane.firstClass.get(i).getSeatPref().equals("aisle")) {
										plane.firstClassAddSeat(String.valueOf(classChoice),passChoice,"aisle",plane.firstClass.get(i));
										break;
									} else {
										System.out.println("Moving passenger to next available seat.");
									}
								}
							}
								
						} else {	//add pref for 2
							System.out.print("Please enter seating preferences (0 for window, 1 for aisle): "); //add pref for 1 
							pref = input.nextInt();
							if(pref < 0 || pref > 1) {
								System.out.println("Please enter a choice between 0 and 1! Returning to menu.");
								break;
							} else if(pref == 0) {
								for(int i=0; i < plane.firstClass.size(); i++) {
									if(plane.firstClass.get(i).getStatus() == false && plane.firstClass.get(i).getSeatPref().equals("window")) {
										plane.firstClassAddSeat(String.valueOf(classChoice),passChoice,"window",plane.firstClass.get(i));
										if(plane.firstClass.get(i+2).getStatus()==false) {
											plane.firstClassAddSeat(String.valueOf(classChoice),passChoice,"window",plane.firstClass.get(i+2));
										} else {
											System.out.println("Moving passenger to next available seat.");
										}
										break;
									} else {
										System.out.println("Moving passenger to next available seat.");
									}
								}
								
							} else {
								for(int i=0; i < plane.firstClass.size(); i++) {
									if(plane.firstClass.get(i).getStatus() == false && plane.firstClass.get(i).getSeatPref().equals("aisle")) {
										plane.firstClassAddSeat(String.valueOf(classChoice),passChoice,"aisle",plane.firstClass.get(i));
										if(plane.firstClass.get(i+2).getStatus()==false) {
											plane.firstClassAddSeat(String.valueOf(classChoice),passChoice,"aisle",plane.firstClass.get(i+2));
										} else {
											System.out.println("Moving passenger to next available seat.");
										}
										break;
									} else {
										System.out.println("Moving passenger to next available seat.");
									}
								}
							}
							
							
						}
//						plane.firstClassAddSeat(num, seatClass, numPass, pref);
					} else { //economy class
						
					}
					
					
					
					
					break;
				case 1:
					plane.printFirstClassSeats();
					System.out.println();
					System.out.println("-----End of First Class Seats-----");
					System.out.println();
					plane.printEconomyClassSeats();
					break;
				case 2:
					System.out.println("Exiting application!");
					System.exit(0);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter menu choice between 0 and 2!");
				menu.next();
				continue;
			}

		}

		// airplane plane = new airplane();
		// System.out.println(plane.economyClass.get(89).getStatus());
		// plane.addSeat(0,"first", 1, "aisle");

		// plane.firstClass.get(1).setStatus(true);
		// System.out.println(plane.firstClass.get(1).getStatus());
		// plane.addSeat(1,"first", 1, "aisle");
		// plane.firstClass.get(0).setStatus(true);
		// plane.addSeat(2,"first", 1, "aisle");
		// plane.printSeats();
	}

}
