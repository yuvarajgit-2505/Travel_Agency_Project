package com.travelagency;
import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Customermthds customer=new Customermthds();
        adminmthd admin=new adminmthd();
        System.out.println("Welcome To Our Travel Agency");
        System.out.println("1.Customer login");
        System.out.println("2.Login as Admin");
        int choice= scan.nextInt();
        switch (choice){
            case 1:

                System.out.println("1.Ticket Booking");
                System.out.println("2.Cancel Booking");
                int ch= scan.nextInt();
                switch (ch){
                    case 1:
                        customer.TicketBooking();
                        customer.BusDetails();
                        customer.bustype();
                        break;
                    case 2:
                        customer.cancelbooking();
                        break;
                }
                break;
            case 2:
                System.out.println("1.View Customers Details");
                System.out.println("2.Insert Customer Booking");
                System.out.println("3.Delete Customer Detail");
                int ch1= scan.nextInt();
                switch (ch1){
                    case 1:
                        admin.viewbooking();
                        break;
                    case 2:
                        admin.TicketBooking();
                        admin.BusDetails();
                        admin.bustype();
                        break;
                    case 3:
                        admin.cancelbooking();

                }
                break;

        }
    }
}