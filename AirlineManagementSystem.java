import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AirlineManagementSystem {

    // User class
    static class User {
        int userId;
        String userName;
        String password;
        String role; // Admin / Customer
        String customerCategory; // Silver / Gold / Platinum
        long phone;
        String emailId;
        String address1;
        String address2;
        String city;
        String state;
        String country;
        int zipCode;
        Date dob;

        User(int userId, String userName, String password, String role, long phone, String emailId, String address1, String address2, String city, String state, String country, int zipCode, Date dob) {
            this.userId = userId;
            this.userName = userName;
            this.password = password;
            this.role = role;
            this.phone = phone;
            this.emailId = emailId;
            this.address1 = address1;
            this.address2 = address2;
            this.city = city;
            this.state = state;
            this.country = country;
            this.zipCode = zipCode;
            this.dob = dob;
            this.customerCategory = ""; // Default empty for customers
        }
    }

    // Carrier class
    static class Carrier {
        int carrierId;
        String carrierName;
        int discount30Days;
        int discount60Days;
        int discount90Days;
        int bulkBookingDiscount;
        int refund2Days;
        int refund10Days;
        int refund20Days;
        int silverUserDiscount;
        int goldUserDiscount;
        int platinumUserDiscount;

        Carrier(int carrierId, String carrierName, int discount30Days, int discount60Days, int discount90Days, int bulkBookingDiscount, int refund2Days, int refund10Days, int refund20Days, int silverUserDiscount, int goldUserDiscount, int platinumUserDiscount) {
            this.carrierId = carrierId;
            this.carrierName = carrierName;
            this.discount30Days = discount30Days;
            this.discount60Days = discount60Days;
            this.discount90Days = discount90Days;
            this.bulkBookingDiscount = bulkBookingDiscount;
            this.refund2Days = refund2Days;
            this.refund10Days = refund10Days;
            this.refund20Days = refund20Days;
            this.silverUserDiscount = silverUserDiscount;
            this.goldUserDiscount = goldUserDiscount;
            this.platinumUserDiscount = platinumUserDiscount;
        }
    }

    // Flight class
    static class Flight {
        int flightId;
        int carrierId;
        String origin;
        String destination;
        int airFare;
        int seatCapacityBusinessClass;
        int seatCapacityEconomyClass;
        int seatCapacityExecutiveClass;

        Flight(int flightId, int carrierId, String origin, String destination, int airFare, int seatCapacityBusinessClass, int seatCapacityEconomyClass, int seatCapacityExecutiveClass) {
            this.flightId = flightId;
            this.carrierId = carrierId;
            this.origin = origin;
            this.destination = destination;
            this.airFare = airFare;
            this.seatCapacityBusinessClass = seatCapacityBusinessClass;
            this.seatCapacityEconomyClass = seatCapacityEconomyClass;
            this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
        }
    }

    // FlightSchedule class
    static class FlightSchedule {
        int flightScheduleId;
        int flightId;
        Date dateOfTravel;
        int businessClassBookedCount;
        int economyClassBookedCount;
        int executiveClassBookedCount;
        


        FlightSchedule(int flightScheduleId, int flightId, Date dateOfTravel) {
            this.flightScheduleId = flightScheduleId;
            this.flightId = flightId;
            this.dateOfTravel = dateOfTravel;
            this.businessClassBookedCount = 0;
            this.economyClassBookedCount = 0;
            this.executiveClassBookedCount = 0;
        }
    }

    // FlightBooking class
    static class FlightBooking {
        int bookingId;
        int flightId;
        int userId;
        int noOfSeats;
        String seatCategory; // Economy / Business / Executive
        Date dateOfTravel;
        String bookingStatus; // Booked / Travel Completed / Cancelled
        int bookingAmount;

        FlightBooking(int bookingId, int flightId, int userId, int noOfSeats, String seatCategory, Date dateOfTravel, String bookingStatus, int bookingAmount) {
            this.bookingId = bookingId;
            this.flightId = flightId;
            this.userId = userId;
            this.noOfSeats = noOfSeats;
            this.seatCategory = seatCategory;
            this.dateOfTravel = dateOfTravel;
            this.bookingStatus = bookingStatus;
            this.bookingAmount = bookingAmount;
        }
    }

    // Sample data
    static Map<Integer, User> users = new HashMap<>();
    static Map<Integer, Carrier> carriers = new HashMap<>();
    static Map<Integer, Flight> flights = new HashMap<>();
    static Map<Integer, FlightSchedule> flightSchedules = new HashMap<>();
    static Map<Integer, FlightBooking> bookings = new HashMap<>();

    private static int currentUserId = -1;  // -1 indicates no user logged in

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeSampleData();

        while (true) {
            System.out.println("\n=== Airline Management System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    customerMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeSampleData() {
        users.put(1, new User(1, "admin", "admin", "Admin", 1234567890L, "admin@ams.com", "Admin Street", "Admin Street 2", "City", "State", "Country", 123456, new Date()));
        users.put(2, new User(2, "customer1", "password", "Customer", 9876543210L, "cust1@ams.com", "Customer Street", "Customer Street2", "City", "State", "Country", 654321, new Date()));
    }

    private static void adminMenu(Scanner scanner) {
        System.out.println("\n=== Admin Menu ===");
        System.out.print("Enter Admin Username: ");
        String username = scanner.next();
        System.out.print("Enter Admin Password: ");
        String password = scanner.next();

        User admin = users.values().stream()
                .filter(user -> user.userName.equals(username) && user.password.equals(password) && user.role.equals("Admin"))
                .findFirst()
                .orElse(null);

        if (admin == null) {
            System.out.println("Invalid Admin credentials.");
            return;
        }

        while (true) {
            System.out.println("\n1. Add Carrier");
            System.out.println("2. Edit Carrier");
            System.out.println("3. Remove Carrier");
            System.out.println("4. Flight Cancellation & Refund Calculation");
            System.out.println("5. Exit Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCarrier(scanner);
                    break;
                case 2:
                    editCarrier(scanner);
                    break;
                case 3:
                    removeCarrier(scanner);
                    break;
                case 4:
                    calculateRefundAndLoss(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Admin Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCarrier(Scanner scanner) {
        System.out.print("Enter Carrier Name: ");
        String carrierName = scanner.next();
        System.out.print("Enter Discount for 30 Days Advance Booking: ");
        int discount30 = scanner.nextInt();
        System.out.print("Enter Discount for 60 Days Advance Booking: ");
        int discount60 = scanner.nextInt();
        System.out.print("Enter Discount for 90 Days Advance Booking: ");
        int discount90 = scanner.nextInt();
        System.out.print("Enter Bulk Booking Discount: ");
        int bulkDiscount = scanner.nextInt();
        System.out.print("Enter Refund Percentage for Cancellation 2 Days Before Travel: ");
        int refund2Days = scanner.nextInt();
        System.out.print("Enter Refund Percentage for Cancellation 10 Days Before Travel: ");
        int refund10Days = scanner.nextInt();
        System.out.print("Enter Refund Percentage for Cancellation 20 Days or More Before Travel: ");
        int refund20Days = scanner.nextInt();
         System.out.print("Enter Silver User Discount: ");
        int silverDiscount = scanner.nextInt();
        System.out.print("Enter Gold User Discount: ");
        int goldDiscount = scanner.nextInt();
        System.out.print("Enter Platinum User Discount: ");
        int platinumDiscount = scanner.nextInt();


        int carrierId = carriers.size() + 1;
        Carrier carrier = new Carrier(carrierId, carrierName, discount30, discount60, discount90, bulkDiscount, refund2Days, refund10Days, refund20Days, silverDiscount, goldDiscount, platinumDiscount);
        carriers.put(carrierId, carrier);

        System.out.println("Carrier Information Saved Successfully in the System");
    }


    private static void editCarrier(Scanner scanner) {
        System.out.print("Enter Carrier ID to Edit: ");
        int carrierId = scanner.nextInt();

        Carrier carrier = carriers.get(carrierId);
        if (carrier == null) {
            System.out.println("Either the data is incorrect or no Carrier Information is available for the given Carrier ID");
            return;
        }

        System.out.println("Current Carrier Details:");
        System.out.println("CarrierID: " + carrier.carrierId);
        System.out.println("CarrierName: " + carrier.carrierName);
        System.out.println("DiscountPercentageThirtyDaysAdvanceBooking: " + carrier.discount30Days);
        System.out.println("DiscountPercentageSixtyDaysAdvanceBooking: " + carrier.discount60Days);
        System.out.println("DiscountPercentageNinteyDaysAdvanceBooking: " + carrier.discount90Days);
        System.out.println("BulkBookingDiscount: " + carrier.bulkBookingDiscount);
        System.out.println("RefundPercentageForTicketCancellation2DaysBeforeTravelDate: " + carrier.refund2Days);
        System.out.println("RefundPercentageForTicketCancellation10DaysBeforeTravelDate: " + carrier.refund10Days);
        System.out.println("RefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate: " + carrier.refund20Days);
        System.out.println("SilverUserDiscount: " + carrier.silverUserDiscount);
        System.out.println("GoldUserDiscount: " + carrier.goldUserDiscount);
        System.out.println("PlatinumUserDiscount: " + carrier.platinumUserDiscount);


        System.out.print("Enter New Carrier Name: ");
        carrier.carrierName = scanner.next();
        System.out.print("Enter New Discount for 30 Days Advance Booking: ");
        carrier.discount30Days = scanner.nextInt();
        System.out.print("Enter New Discount for 60 Days Advance Booking: ");
        carrier.discount60Days = scanner.nextInt();
        System.out.print("Enter New Discount for 90 Days Advance Booking: ");
        carrier.discount90Days = scanner.nextInt();
        System.out.print("Enter New Bulk Booking Discount: ");
        carrier.bulkBookingDiscount = scanner.nextInt();
        System.out.print("Enter New Refund Percentage for Cancellation 2 Days Before Travel: ");
        carrier.refund2Days = scanner.nextInt();
        System.out.print("Enter New Refund Percentage for Cancellation 10 Days Before Travel: ");
        carrier.refund10Days = scanner.nextInt();
        System.out.print("Enter New Refund Percentage for Cancellation 20 Days or More Before Travel: ");
        carrier.refund20Days = scanner.nextInt();
        System.out.print("Enter New Silver User Discount: ");
        carrier.silverUserDiscount = scanner.nextInt();
        System.out.print("Enter New Gold User Discount: ");
        carrier.goldUserDiscount = scanner.nextInt();
        System.out.print("Enter New Platinum User Discount: ");
        carrier.platinumUserDiscount = scanner.nextInt();


        System.out.println("Carrier updated successfully!");
    }


    private static void removeCarrier(Scanner scanner) {
        System.out.print("Enter Carrier ID to Remove: ");
        int carrierId = scanner.nextInt();

        if (!carriers.containsKey(carrierId)) {
            System.out.println("Either the data is incorrect or no Carrier Information is available for the given Carrier ID");
            return;
        }

        // Check if there are any flights mapped to this carrier
        boolean hasFlights = false;
        for (Flight flight : flights.values()) {
            if (flight.carrierId == carrierId) {
                hasFlights = true;
                break;
            }
        }

        if (hasFlights) {
            System.out.println("Remove All Flights Mapped to this Carrier before deleting this Carrier for system");
        } else {
            carriers.remove(carrierId);
            System.out.println("Carrier Information successfully removed from system");
        }
    }


    private static void calculateRefundAndLoss(Scanner scanner) {
        System.out.print("Enter Flight ID: ");
        int flightId = scanner.nextInt();
        System.out.print("Enter Travel Date (yyyy-MM-dd): ");
        String dateString = scanner.next();

        Date travelDate;
        try {
            travelDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (java.text.ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        double totalRefundAmount = 0;
        double totalLossToCarrier = 0;
        int totalBookedSeats = 0;

        for (FlightBooking booking : bookings.values()) {
            if (booking.flightId == flightId && booking.dateOfTravel.equals(travelDate) && booking.bookingStatus.equals("Booked")) {
                totalBookedSeats += booking.noOfSeats;
                totalRefundAmount += booking.bookingAmount;
                
                // Calculate extra compensation if cancelled within a week
                long timeDiff = travelDate.getTime() - new Date().getTime();
                long daysDiff = timeDiff / (1000 * 60 * 60 * 24);
                 if (daysDiff <= 7) {
                    totalLossToCarrier += booking.bookingAmount * 0.10;
                }
            }
        }
        
        totalLossToCarrier += totalRefundAmount;

        System.out.println("Total Refund Amount: " + totalRefundAmount);
        System.out.println("Total Loss to Carrier: " + totalLossToCarrier);
        System.out.println("Total Booked Seats: " + totalBookedSeats);
    }


    private static void customerMenu(Scanner scanner) {
        System.out.println("\n=== Customer Menu ===");
        System.out.print("Enter Customer Username: ");
        String username = scanner.next();
        System.out.print("Enter Customer Password: ");
        String password = scanner.next();

        User customer = users.values().stream()
                .filter(user -> user.userName.equals(username) && user.password.equals(password) && user.role.equals("Customer"))
                .findFirst()
                .orElse(null);

        if (customer == null) {
            System.out.println("Invalid Customer credentials.");
            return;
        }

        // Set the current logged-in user's ID
        currentUserId = customer.userId;

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Edit Profile");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket & View Refund");
            System.out.println("5. Exit Customer Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerCustomer(scanner);
                    break;
                case 2:
                    editProfile(scanner, customer);
                    break;
                case 3:
                    bookTicket(scanner);
                    break;
                case 4:
                    cancelTicket(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Customer Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerCustomer(Scanner scanner) {
        System.out.print("Enter Username: ");
        String userName = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        System.out.print("Enter Phone Number: ");
        long phone = scanner.nextLong();
        System.out.print("Enter Email ID: ");
        String emailId = scanner.next();
        System.out.print("Enter Address Line 1: ");
        String address1 = scanner.next();
        System.out.print("Enter Address Line 2: ");
        String address2 = scanner.next();
         System.out.print("Enter City: ");
        String city = scanner.next();
        System.out.print("Enter State: ");
        String state = scanner.next();
        System.out.print("Enter Country: ");
        String country = scanner.next();
        System.out.print("Enter Zip Code: ");
        int zipCode = scanner.nextInt();
        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        String dobString = scanner.next();

        Date dob;
        try {
            dob = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dobString);
        } catch (java.text.ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }


        int userId = users.size() + 1;
        User newUser = new User(userId, userName, password, "Customer", phone, emailId, address1, address2, city, state, country, zipCode, dob);
        users.put(userId, newUser);

        System.out.println("Customer registration successful!");
    }


    private static void editProfile(Scanner scanner, User customer) {
        // Display current profile information
        System.out.println("\n=== Current Profile Information ===");
        System.out.println("Username: " + customer.userName);
        System.out.println("Phone: " + customer.phone);
        System.out.println("Email ID: " + customer.emailId);
        System.out.println("Address Line 1: " + customer.address1);
        System.out.println("Address Line 2: " + customer.address2);
        System.out.println("City: " + customer.city);
        System.out.println("State: " + customer.state);
        System.out.println("Country: " + customer.country);
        System.out.println("Zip Code: " + customer.zipCode);
    
        // Prompt for new profile details
        System.out.println("\n=== Edit Profile ===");
        System.out.print("Enter New Username (press Enter to keep current): ");
        String newUsername = scanner.nextLine();
        if (!newUsername.isEmpty()) {
            customer.userName = newUsername;
        }
    
        System.out.print("Enter New Password (press Enter to keep current): ");
        String newPassword = scanner.nextLine();
        if (!newPassword.isEmpty()) {
            customer.password = newPassword;
        }
    
        System.out.print("Enter New Phone Number (press Enter to keep current): ");
        String newPhoneStr = scanner.nextLine();
        if (!newPhoneStr.isEmpty()) {
            customer.phone = Long.parseLong(newPhoneStr);
        }
    
        System.out.print("Enter New Email ID (press Enter to keep current): ");
        String newEmailId = scanner.nextLine();
        if (!newEmailId.isEmpty()) {
            customer.emailId = newEmailId;
        }
    
        System.out.print("Enter New Address Line 1 (press Enter to keep current): ");
        String newAddress1 = scanner.nextLine();
        if (!newAddress1.isEmpty()) {
            customer.address1 = newAddress1;
        }
    
        System.out.print("Enter New Address Line 2 (press Enter to keep current): ");
        String newAddress2 = scanner.nextLine();
        if (!newAddress2.isEmpty()) {
            customer.address2 = newAddress2;
        }
    
        System.out.print("Enter New City (press Enter to keep current): ");
        String newCity = scanner.nextLine();
        if (!newCity.isEmpty()) {
            customer.city = newCity;
        }
    
        System.out.print("Enter New State (press Enter to keep current): ");
        String newState = scanner.nextLine();
        if (!newState.isEmpty()) {
            customer.state = newState;
        }
    
        System.out.print("Enter New Country (press Enter to keep current): ");
        String newCountry = scanner.nextLine();
        if (!newCountry.isEmpty()) {
            customer.country = newCountry;
        }
    
        System.out.print("Enter New Zip Code (press Enter to keep current): ");
        String newZipCodeStr = scanner.nextLine();
        if (!newZipCodeStr.isEmpty()) {
            customer.zipCode = Integer.parseInt(newZipCodeStr);
        }
    
        // Non-editable fields
        System.out.println("\nNote: UserID, Role, and Customer Category cannot be modified.");
    
        // Update user in the system
        users.put(customer.userId, customer);
    
        System.out.println("\nProfile updated successfully!");
    }
    

    private static void bookTicket(Scanner scanner) {
    // Prompt for flight details
    System.out.print("Enter Flight ID: ");
    int flightId = scanner.nextInt();
    
    // Validate flight exists
    Flight flight = flights.get(flightId);
    if (flight == null) {
        System.out.println("Invalid Flight ID. Please try again.");
        return;
    }

    // Get carrier details for discounts
    Carrier carrier = carriers.get(flight.carrierId);
    if (carrier == null) {
        System.out.println("Carrier information not found for this flight.");
        return;
    }

    // Prompt for booking details
    System.out.print("Enter Number of Seats: ");
    int noOfSeats = scanner.nextInt();

    System.out.print("Enter Seat Category (Economy/Business/Executive): ");
    String seatCategory = scanner.next();

    // Validate seat category
    if (!Arrays.asList("Economy", "Business", "Executive").contains(seatCategory)) {
        System.out.println("Invalid Seat Category. Please choose Economy, Business, or Executive.");
        return;
    }

    // Validate seat availability
    FlightSchedule schedule = flightSchedules.get(flightId);
    if (schedule == null) {
        System.out.println("No flight schedule found for this flight.");
        return;
    }

    int availableSeats = 0;
    switch (seatCategory) {
        case "Economy":
            availableSeats = flight.seatCapacityEconomyClass - schedule.economyClassBookedCount;
            break;
        case "Business":
            availableSeats = flight.seatCapacityBusinessClass - schedule.businessClassBookedCount;
            break;
        case "Executive":
            availableSeats = flight.seatCapacityExecutiveClass - schedule.executiveClassBookedCount;
            break;
    }

    if (noOfSeats > availableSeats) {
        System.out.println("Not enough seats available in the selected category.");
        return;
    }

    // Calculate base fare
    int baseFare = flight.airFare;
    int totalFare = baseFare;

    // Apply seat category multiplier
    switch (seatCategory) {
        case "Business":
            totalFare *= 2;
            break;
        case "Executive":
            totalFare *= 5;
            break;
    }

    // Calculate advance booking discounts
    System.out.print("Enter Date of Travel (yyyy-MM-dd): ");
    String travelDateStr = scanner.next();
    Date travelDate;
    try {
        travelDate = new SimpleDateFormat("yyyy-MM-dd").parse(travelDateStr);
    } catch (ParseException e) {
        System.out.println("Invalid date format. Use yyyy-MM-dd.");
        return;
    }

    long daysDifference = (travelDate.getTime() - new Date().getTime()) / (24 * 60 * 60 * 1000);

    // Advance booking discounts
    if (daysDifference >= 90) {
        totalFare -= totalFare * carrier.discount90Days / 100;
    } else if (daysDifference >= 60) {
        totalFare -= totalFare * carrier.discount60Days / 100;
    } else if (daysDifference >= 30) {
        totalFare -= totalFare * carrier.discount30Days / 100;
    }

    // Bulk booking discount
    if (noOfSeats >= 10) {
        totalFare -= totalFare * carrier.bulkBookingDiscount / 100;
    }

    // Prompt for customer category
    System.out.print("Enter Customer Category (Silver/Gold/Platinum): ");
    String customerCategory = scanner.next();

    // Apply customer category discount
    switch (customerCategory) {
        case "Silver":
            totalFare -= totalFare * carrier.silverUserDiscount / 100;
            break;
        case "Gold":
            totalFare -= totalFare * carrier.goldUserDiscount / 100;
            break;
        case "Platinum":
            totalFare -= totalFare * carrier.platinumUserDiscount / 100;
            break;
    }

    // Total booking amount
    int totalBookingAmount = totalFare * noOfSeats;

    // Create booking
    int bookingId = bookings.size() + 1;
    FlightBooking booking = new FlightBooking(
        bookingId, 
        flightId, 
        currentUserId,  // Assuming you track current logged-in user
        noOfSeats, 
        seatCategory, 
        travelDate, 
        "Booked", 
        totalBookingAmount
    );

    // Update flight schedule booked count
    switch (seatCategory) {
        case "Economy":
            schedule.economyClassBookedCount += noOfSeats;
            break;
        case "Business":
            schedule.businessClassBookedCount += noOfSeats;
            break;
        case "Executive":
            schedule.executiveClassBookedCount += noOfSeats;
            break;
    }

    // Save booking
    bookings.put(bookingId, booking);

    // Display booking details
    System.out.println("\n=== Booking Confirmation ===");
    System.out.println("Booking ID: " + bookingId);
    System.out.println("Flight ID: " + flightId);
    System.out.println("Number of Seats: " + noOfSeats);
    System.out.println("Seat Category: " + seatCategory);
    System.out.println("Total Booking Amount: $" + totalBookingAmount);
}


private static void cancelTicket(Scanner scanner) {
    // Prompt for booking ID
    System.out.print("Enter Booking ID to Cancel: ");
    int bookingId = scanner.nextInt();

    // Find the booking
    FlightBooking booking = bookings.get(bookingId);
    if (booking == null) {
        System.out.println("No booking found with the given Booking ID.");
        return;
    }

    // Find the flight and carrier details
    Flight flight = flights.get(booking.flightId);
    Carrier carrier = carriers.get(flight.carrierId);
    if (flight == null || carrier == null) {
        System.out.println("Flight or Carrier information not found.");
        return;
    }

    // Calculate days before travel
    long daysDifference = (booking.dateOfTravel.getTime() - new Date().getTime()) / (24 * 60 * 60 * 1000);

    // Calculate refund percentage based on cancellation timing
    int refundPercentage = 0;
    if (daysDifference >= 20) {
        refundPercentage = carrier.refund20Days; // 95% refund
    } else if (daysDifference >= 10) {
        refundPercentage = carrier.refund10Days; // 70% refund
    } else if (daysDifference >= 2) {
        refundPercentage = carrier.refund2Days; // 40% refund
    }

    // Calculate refund amount
    int refundAmount = (booking.bookingAmount * refundPercentage) / 100;

    // Update booking status
    booking.bookingStatus = "Cancelled";

    // Update flight schedule booked count
    FlightSchedule schedule = flightSchedules.get(booking.flightId);
    switch (booking.seatCategory) {
        case "Economy":
            schedule.economyClassBookedCount -= booking.noOfSeats;
            break;
        case "Business":
            schedule.businessClassBookedCount -= booking.noOfSeats;
            break;
        case "Executive":
            schedule.executiveClassBookedCount -= booking.noOfSeats;
            break;
    }

    // Display cancellation and refund details
    System.out.println("\n=== Ticket Cancellation Details ===");
    System.out.println("Booking ID: " + bookingId);
    System.out.println("Flight ID: " + booking.flightId);
    System.out.println("Number of Seats: " + booking.noOfSeats);
    System.out.println("Seat Category: " + booking.seatCategory);
    System.out.println("Original Booking Amount: $" + booking.bookingAmount);
    System.out.println("Refund Percentage: " + refundPercentage + "%");
    System.out.println("Refund Amount: $" + refundAmount);
    System.out.println("Booking Status: Cancelled");
}

}
