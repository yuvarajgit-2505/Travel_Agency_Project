package com.travelagency;

import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Customermthds {
    public int year=2025;
    public int month;
    public int dates;
    public boolean weekend;
    Scanner scan=new Scanner(System.in);
    PassengerDAO psg = new PassengerDAO();
    String choosestart ;
    String choosedestination;

    public void TicketBooking(){

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO customer (Name,MobileNo,Gender,Email,month,date,Boarding_point,Destination_point,BusType,Amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            System.out.println("Enter your Name:");
            psg.setName(scan.nextLine());
            System.out.println("Enter your Mobile no:");
            psg.setMobNo(scan.nextLine());
            System.out.println("Enter your Gender:");
            psg.setGender(scan.nextLine());
            System.out.println("Enter your Email ID:");
            psg.setEmailid(scan.nextLine());
//            ps.setInt(1, student.getId());
            ps.setString(1, psg.getName());
            ps.setString(2, psg.getMobNo());
            ps.setString(3, psg.getGender());
            ps.setString(4, psg.getEmailid());
            ps.setNull(5, java.sql.Types.INTEGER);
            ps.setNull(6,java.sql.Types.INTEGER);
            ps.setNull(7,java.sql.Types.VARCHAR);
            ps.setNull(8,java.sql.Types.VARCHAR);
            ps.setNull(9, java.sql.Types.VARCHAR);
            ps.setNull(10, java.sql.Types.INTEGER);
            ps.executeUpdate();
        }catch (Exception e) {
            System.out.println("Error In Customer Details: " + e.getMessage());
        }
    }
    public void BusDetails() {

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE customer SET month = ?,date = ?, Boarding_point = ?, Destination_point = ? " +
                     "WHERE Boarding_point IS NULL AND Destination_point IS NULL ")) {
            System.out.println("Enter Your Booking Details");
            System.out.println("Enter the month you want to travel:");
            month= scan.nextInt();
            System.out.println("Enter the date you  want to travel:");
            dates= scan.nextInt();

            scan.nextLine();
            System.out.println("Enter Your Boarding Point:");
            String boarding=scan.nextLine();
            psg.setBoarding_point(boarding);
            System.out.println("Enter Your Destination Point:");
            String destination=scan.nextLine();
            psg.setDestination_point(destination);
            choosestart = psg.getBoarding_point();
            choosedestination = psg.getDestination_point();

            if (choosestart.equalsIgnoreCase("chennai") && choosedestination.equalsIgnoreCase("salem")) {
                System.out.println("Your starting point is:" + choosestart);
                System.out.println("Your destination point is:" + choosedestination);

            } else if (choosestart.equalsIgnoreCase("Banglore") && choosedestination.equalsIgnoreCase("salem")) {
                System.out.println("Your starting point is:" + choosestart);
                System.out.println("Your destination point is:" + choosedestination);
            } else if (choosestart.equalsIgnoreCase("Mumbai") && choosedestination.equalsIgnoreCase("Hyderabad")) {
                System.out.println("Your starting point is:" + choosestart);
                System.out.println("Your destination point is:" + choosedestination);
            } else {
                System.out.println("Enter a valid places");
            }
            ps.setInt(1,month);
            ps.setInt(2,dates);
            ps.setString(3, psg.getBoarding_point());
            ps.setString(4, psg.getDestination_point());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Invalid data Please enter a valid data.");
        }
    }

    //Bus type and fair for the trip

    // Declare these instance variables at the class level
    int AC, SLEEPER, GENERAL;

    public void bustype() {
        choosestart = psg.getBoarding_point();
        choosedestination = psg.getDestination_point();
        String gend = psg.getGender();

        try {
            LocalDate traveldate = LocalDate.of(year, month, dates);
            DayOfWeek day = traveldate.getDayOfWeek();
            weekend = (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);

            // ✅ Step 1: Calculate base fares
            if (choosestart.equalsIgnoreCase("chennai") && choosedestination.equalsIgnoreCase("salem")) {
                if (weekend) {
                    AC = 1500; SLEEPER = 800; GENERAL = 600;
                    System.out.println("Weekend fare selected.");
                } else {
                    AC = 1000; SLEEPER = 600; GENERAL = 400;
                    System.out.println("Weekday fare selected.");
                }
            } else if (choosestart.equalsIgnoreCase("banglore") && choosedestination.equalsIgnoreCase("salem")) {
                if (weekend) {
                    AC = 1300; SLEEPER = 700; GENERAL = 500;
                    System.out.println("Weekend fare selected.");
                } else {
                    AC = 900; SLEEPER = 500; GENERAL = 350;
                    System.out.println("Weekday fare selected.");
                }
            } else if (choosestart.equalsIgnoreCase("mumbai") && choosedestination.equalsIgnoreCase("hyderabad")) {
                if (weekend) {
                    AC = 1700; SLEEPER = 1000; GENERAL = 800;
                    System.out.println("Weekend fare selected.");
                } else {
                    AC = 1500; SLEEPER = 700; GENERAL = 500;
                    System.out.println("Weekday fare selected.");
                }
            } else {
                System.out.println("Enter the locations correctly");
                return;
            }

            // ✅ Step 2: Apply female discount
            if (gend.equalsIgnoreCase("female")) {
                AC = (int) (AC * 0.7);
                SLEEPER = (int) (SLEEPER * 0.7);
                GENERAL = (int) (GENERAL * 0.7);
                System.out.println("30% discount applied for female passenger.");
            }

            // ✅ Step 3: Now ask user to choose bus type
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(
                         "UPDATE customer SET BusType = ?, Amount = ? WHERE BusType IS NULL AND Amount IS NULL")) {

                System.out.println("Enter The Bus Type:");
                System.out.println("1. AC SLEEPER");
                System.out.println("2. SLEEPER");
                System.out.println("3. GENERAL");
                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        psg.setBustype("AC");
                        psg.setAmount(AC);
                        break;
                    case 2:
                        psg.setBustype("SLEEPER");
                        psg.setAmount(SLEEPER);
                        break;
                    case 3:
                        psg.setBustype("GENERAL");
                        psg.setAmount(GENERAL);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        return;
                }

                System.out.println("You've selected " + psg.getBustype());
                System.out.println("The payable amount for your trip is: " + psg.getAmount());

                // ✅ Step 4: Update database
                ps.setString(1, psg.getBustype());
                ps.setInt(2, psg.getAmount());
                ps.executeUpdate();

            } catch (Exception e) {
                System.out.println("Error while saving bus type: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Invalid date. Please enter valid data.");
        }
    }
    public void cancelbooking() {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM customer WHERE MobileNo = ?");
             PreparedStatement ps1 = conn.prepareStatement("SELECT Amount FROM customer WHERE MobileNo = ?")) {

            System.out.println("Enter your Mobile number:");
            String Mobno = scan.nextLine();
            ps1.setString(1, Mobno);
            ResultSet rs = ps1.executeQuery();
            double amount = 0;
            boolean found = false;

            if (rs.next()) {
                amount = rs.getDouble("Amount");
                found = true;
            }

            // Now delete the booking
            ps.setString(1, Mobno);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0 && found) {
                double discountedAmount = amount * 0.70;
                System.out.println("Your booking is cancelled.");
                System.out.println("Since you have cancelled your booking, a 30% deduction has been applied as per our cancellation policy.");
                System.out.println("Refund amount: ₹ " + discountedAmount);
            } else {
                System.out.println("No booking found with that mobile number.");
            }

        } catch (Exception e) {
            System.out.println("Enter Correct Mobile Number");
        }
    }

}






