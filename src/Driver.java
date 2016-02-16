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
