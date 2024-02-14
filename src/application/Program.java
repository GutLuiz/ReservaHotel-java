package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;
import exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check - in: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check - ou date: ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation: " + reserva);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
	
			System.out.print("Check - in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check - ou date: ");
			checkOut = sdf.parse(sc.next());
	
			reserva.updateDates(checkIn, checkOut);
	
			System.out.println("Reservation: " + reserva);
		}
		catch(ParseException e){
			System.out.println("invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage()); // a mensagem que esta no void
		}
		catch(RuntimeException e ) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
