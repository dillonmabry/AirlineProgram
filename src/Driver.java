/* Dillon Mabry Student ID: 800854402 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main Driver class
 * @author dillonmabry
 *
 */
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
				if (choice < 0 || choice > 2) {
					System.out.println("Please enter menu choice between 0 and 2!");
					continue;
				}
				switch (choice) {

				case 0:
					Scanner input = new Scanner(System.in);
					int classChoice, passChoice, pref;
					System.out.print("Enter the class for passenger (0 for First, 1 for Economy): ");
					classChoice = input.nextInt(); // class choice
					if (classChoice < 0 || classChoice > 1) {
						System.out.println("Please enter a choice between 0 and 1! Returning to menu.");
						break;
					} else if (classChoice == 0) { // first class
						System.out.print("Please enter number of passengers between 1 and 2: ");
						passChoice = input.nextInt(); // num passengers
						if (passChoice < 1 || passChoice > 2) {
							System.out.println("Please enter a choice between 1 and 2! Returning to menu.");
							break;
						} else if (passChoice == 1) {
							System.out.print("Please enter seating preferences (0 for window, 1 for aisle): "); // 1
							pref = input.nextInt();
							if (pref < 0 || pref > 1) {
								System.out.println("Please enter a choice between 0 and 1! Returning to menu.");
								break;
							} else if (pref == 0) {
								for (int i = 0; i < plane.firstClass.size(); i++) {
									if (plane.firstClass.get(i).getStatus() == false
											&& plane.firstClass.get(i).getSeatPref().equals("window")) {
										plane.firstClassAddSeat(String.valueOf(classChoice), passChoice, "window",
												plane.firstClass.get(i));
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}

							} else {
								for (int i = 0; i < plane.firstClass.size(); i++) {
									if (plane.firstClass.get(i).getStatus() == false
											&& plane.firstClass.get(i).getSeatPref().equals("aisle")) {
										plane.firstClassAddSeat(String.valueOf(classChoice), passChoice, "aisle",
												plane.firstClass.get(i));
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}
							}

						} else { // add pref for 2
							System.out.print("Please enter seating preferences (0 for window, 1 for aisle): "); // 1
							pref = input.nextInt();
							if (pref < 0 || pref > 1) {
								System.out.println("Please enter a choice between 0 and 1! Returning to menu.");
								break;
							} else if (pref == 0) {
								for (int i = 0; i < plane.firstClass.size(); i++) {
									if (plane.firstClass.get(i).getStatus() == false
											&& plane.firstClass.get(i).getSeatPref().equals("window")) {
										plane.firstClassAddSeat(String.valueOf(classChoice), passChoice, "window",
												plane.firstClass.get(i));
										if (plane.firstClass.get(i + 2).getStatus() == false
												&& plane.firstClass.get(i + 2).getSeatPref().equals("window")) {
											plane.firstClassAddSeat(String.valueOf(classChoice), passChoice, "window",
													plane.firstClass.get(i + 2));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}

							} else {
								for (int i = 0; i < plane.firstClass.size(); i++) {
									if (plane.firstClass.get(i).getStatus() == false
											&& plane.firstClass.get(i).getSeatPref().equals("aisle")) {
										plane.firstClassAddSeat(String.valueOf(classChoice), passChoice, "aisle",
												plane.firstClass.get(i));
										if (plane.firstClass.get(i + 2).getStatus() == false
												&& plane.firstClass.get(i + 2).getSeatPref().equals("aisle")) {
											plane.firstClassAddSeat(String.valueOf(classChoice), passChoice, "aisle",
													plane.firstClass.get(i + 2));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}
							}

						}
					} else { // economy
						System.out.print("Please enter number of passengers between 1 and 3: ");
						passChoice = input.nextInt(); // num passengers
						if (passChoice < 1 || passChoice > 3) {
							System.out.println("Please enter a choice between 1 and 3! Returning to menu.");
							break;
						} else if (passChoice == 1) {
							System.out.print(
									"Please enter seating preferences (0 for window, 1 for center, 2 for aisle): "); // add
																														// pref
																														// for
																														// 1
							pref = input.nextInt();
							if (pref < 0 || pref > 2) {
								System.out.println("Please enter a choice between 0 and 1! Returning to menu.");
								break;
							} else if (pref == 0) { // seat for window
								for (int i = 0; i < plane.economyClass.size(); i++) {
									if (plane.economyClass.get(i).getStatus() == false
											&& plane.economyClass.get(i).getSeatPref().equals("window")) {
										plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "window",
												plane.economyClass.get(i));
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}

							} else if (pref == 1) { // seating for center
								for (int i = 0; i < plane.economyClass.size(); i++) {
									if (plane.economyClass.get(i).getStatus() == false
											&& plane.economyClass.get(i).getSeatPref().equals("center")) {
										plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "center",
												plane.economyClass.get(i));
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}
							} else { // seating for aisle
								for (int i = 0; i < plane.economyClass.size(); i++) {
									if (plane.economyClass.get(i).getStatus() == false
											&& plane.economyClass.get(i).getSeatPref().equals("aisle")) {
										plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "aisle",
												plane.economyClass.get(i));
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}
							}

						} else if (passChoice == 2) { // add pref for 2
							System.out.print(
									"Please enter seating preferences (0 for window, 1 for center, 2 for aisle): ");
							pref = input.nextInt();
							if (pref < 0 || pref > 2) {
								System.out.println("Please enter a choice between 0 and 1! Returning to menu.");
								break;
							} else if (pref == 0) { // seat for window
								for (int i = 0; i < plane.economyClass.size(); i++) {
									if (plane.economyClass.get(i).getStatus() == false
											&& plane.economyClass.get(i).getSeatPref().equals("window")) {
										plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "window",
												plane.economyClass.get(i));
										if (plane.economyClass.get(i + 3).getStatus() == false
												&& plane.economyClass.get(i + 3).getSeatPref().equals("window")) {
											plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "window",
													plane.economyClass.get(i + 3));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}

							} else if (pref == 1) { // seating for center
								for (int i = 0; i < plane.economyClass.size(); i++) {
									if (plane.economyClass.get(i + 1).getStatus() == false
											&& plane.economyClass.get(i + 1).getSeatPref().equals("center")) {
										plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "center",
												plane.economyClass.get(i + 1));
										if (plane.economyClass.get(i + 4).getStatus() == false
												&& plane.economyClass.get(i + 4).getSeatPref().equals("center")) {
											plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "center",
													plane.economyClass.get(i + 4));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}
							} else { // seating for aisle
								for (int i = 0; i < plane.economyClass.size(); i++) {
									if (plane.economyClass.get(i + 2).getStatus() == false
											&& plane.economyClass.get(i + 2).getSeatPref().equals("aisle")) {
										plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "aisle",
												plane.economyClass.get(i + 2));
										if (plane.economyClass.get(i + 5).getStatus() == false
												&& plane.economyClass.get(i + 5).getSeatPref().equals("aisle")) {
											plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "aisle",
													plane.economyClass.get(i + 5));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}
							}

						} else { // choice for 3 passengers
							System.out.print(
									"Please enter seating preferences (0 for window, 1 for center, 2 for aisle): "); // add
																														// pref
																														// for
																														// 1
							pref = input.nextInt();
							if (pref < 0 || pref > 2) {
								System.out.println("Please enter a choice between 0 and 1! Returning to menu.");
								break;
							} else if (pref == 0) { // seat for window
								for (int i = 0; i < plane.economyClass.size(); i++) {
									if (plane.economyClass.get(i).getStatus() == false
											&& plane.economyClass.get(i).getSeatPref().equals("window")) {
										plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "window",
												plane.economyClass.get(i));
										if (plane.economyClass.get(i + 3).getStatus() == false
												&& plane.economyClass.get(i + 3).getSeatPref().equals("window")) {
											plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "window",
													plane.economyClass.get(i + 3));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										if (plane.economyClass.get(i + 6).getStatus() == false
												&& plane.economyClass.get(i + 6).getSeatPref().equals("window")) {
											plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "window",
													plane.economyClass.get(i + 6));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}

							} else if (pref == 1) { // seating for center
								for (int i = 0; i < plane.economyClass.size(); i++) {
									if (plane.economyClass.get(i + 1).getStatus() == false
											&& plane.economyClass.get(i + 1).getSeatPref().equals("center")) {
										plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "center",
												plane.economyClass.get(i + 1));
										if (plane.economyClass.get(i + 4).getStatus() == false
												&& plane.economyClass.get(i + 4).getSeatPref().equals("center")) {
											plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "center",
													plane.economyClass.get(i + 4));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										if (plane.economyClass.get(i + 7).getStatus() == false
												&& plane.economyClass.get(i + 7).getSeatPref().equals("center")) {
											plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "center",
													plane.economyClass.get(i + 7));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}
							} else { // seating for aisle
								for (int i = 0; i < plane.economyClass.size(); i++) {
									if (plane.economyClass.get(i + 2).getStatus() == false
											&& plane.economyClass.get(i + 2).getSeatPref().equals("aisle")) {
										plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "aisle",
												plane.economyClass.get(i + 2));
										if (plane.economyClass.get(i + 5).getStatus() == false
												&& plane.economyClass.get(i + 5).getSeatPref().equals("aisle")) {
											plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "aisle",
													plane.economyClass.get(i + 5));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										if (plane.economyClass.get(i + 8).getStatus() == false
												&& plane.economyClass.get(i + 8).getSeatPref().equals("aisle")) {
											plane.economyClassAddSeat(String.valueOf(classChoice), passChoice, "aisle",
													plane.economyClass.get(i + 8));
										} else {
											System.out.println("Seat not available!");
											continue;
										}
										break;
									} else {
										System.out.println("Seat not available!");
										continue;
									}
								}
							}
						}

					} // end of economy

					break;
				case 1: // print seating
					plane.printFirstClassSeats();
					System.out.println();
					System.out.println("-----End of First Class Seats-----");
					System.out.println();
					plane.printEconomyClassSeats();
					break;
				case 2: // exit
					System.out.println("Exiting application!");
					menu.close();
					System.exit(0);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter menu choice between 0 and 2!");
				menu.next();
				continue;
			}
		} // end of while

	} // end of main

}
