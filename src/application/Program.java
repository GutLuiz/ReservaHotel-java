package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check - in: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check - ou date: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		} else {
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation: " + reserva);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.print("Check - in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check - ou date: ");
			checkOut = sdf.parse(sc.next());

			String error = reserva.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reserva);

			}

		}

		sc.close();
	}

}
