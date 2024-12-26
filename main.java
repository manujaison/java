import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Carrier {
    int carrierId;
    String carrierName;
    int discount30Days;
    int discount60Days;
    int discount90Days;
    int bulkDiscount;
    int refund2Days;
    int refund10Days;
    int refund20Days;
    int silverUserDiscount;
    int goldUserDiscount;
    int platinumUserDiscount;

    public Carrier(int carrierId, String carrierName,int discount30Days, int discount60Days, int discount90Days,
    int bulkDiscount, int refund2Days, int refund10Days, int refund20Days,
    int silverUserDiscount, int goldUserDiscount, int platinumUserDiscount) {
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.discount30Days = discount30Days;
        this.discount60Days = discount60Days;
        this.discount90Days = discount90Days;
        this.bulkDiscount = bulkDiscount;
        this.refund2Days = refund2Days;
        this.refund10Days = refund10Days;
        this.refund20Days = refund20Days;
        this.silverUserDiscount = silverUserDiscount;
        this.goldUserDiscount = goldUserDiscount;
        this.platinumUserDiscount = platinumUserDiscount;
    }

    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public int getDiscount30Days() {
        return discount30Days;
    }

    public void setDiscount30Days(int discount30Days) {
        this.discount30Days = discount30Days;
    }

    public int getDiscount60Days() {
        return discount60Days;
    }

    public void setDiscount60Days(int discount60Days) {
        this.discount60Days = discount60Days;
    }

    public int getDiscount90Days() {
        return discount90Days;
    }

    public void setDiscount90Days(int discount90Days) {
        this.discount90Days = discount90Days;
    }

    public int getBulkDiscount() {
        return bulkDiscount;
    }

    public void setBulkDiscount(int bulkDiscount) {
        this.bulkDiscount = bulkDiscount;
    }

    public int getRefund2Days() {
        return refund2Days;
    }

    public void setRefund2Days(int refund2Days) {
        this.refund2Days = refund2Days;
    }

    public int getRefund10Days() {
        return refund10Days;
    }

    public void setRefund10Days(int refund10Days) {
        this.refund10Days = refund10Days;
    }

    public int getRefund20Days() {
        return refund20Days;
    }

    public void setRefund20Days(int refund20Days) {
        this.refund20Days = refund20Days;
    }

    public int getSilverUserDiscount() {
        return silverUserDiscount;
    }

    public void setSilverUserDiscount(int silverUserDiscount) {
        this.silverUserDiscount = silverUserDiscount;
    }

    public int getGoldUserDiscount() {
        return goldUserDiscount;
    }

    public void setGoldUserDiscount(int goldUserDiscount) {
        this.goldUserDiscount = goldUserDiscount;
    }

    public int getPlatinumUserDiscount() {
        return platinumUserDiscount;
    }

    public void setPlatinumUserDiscount(int platinumUserDiscount) {
        this.platinumUserDiscount = platinumUserDiscount;
    }

    public void displayCarrierDetails() {
        System.out.println("\nCarrier ID: " + carrierId);
        System.out.println("Carrier Name: " + carrierName);
        System.out.println("Discount 30 Days: " + discount30Days + "%");
        System.out.println("Discount 60 Days: " + discount60Days + "%");
        System.out.println("Discount 90 Days: " + discount90Days + "%");
        System.out.println("Bulk Booking Discount: " + bulkDiscount + "%");
        System.out.println("Refund (2 Days Before): " + refund2Days + "%");
        System.out.println("Refund (10 Days Before): " + refund10Days + "%");
        System.out.println("Refund (20+ Days Before): " + refund20Days + "%");
        System.out.println("Silver User Discount: " + silverUserDiscount + "%");
        System.out.println("Gold User Discount: " + goldUserDiscount + "%");
        System.out.println("Platinum User Discount: " + platinumUserDiscount + "%");

    }
}

class Flight {
    int flightId;
    LocalDate travelDate;
    boolean isCancelled;
    double ticketPrice;

    public Flight(int flightId, LocalDate travelDate, boolean isCancelled, double ticketPrice) {
        this.flightId = flightId;
        this.travelDate = travelDate;
        this.isCancelled = isCancelled;
        this.ticketPrice = ticketPrice;
    }

    public void displayFlightDetails() {
        System.out.println("\nFlight ID: " + flightId);
        System.out.println("Travel Date: " + travelDate);
        System.out.println("Cancelled: " + (isCancelled ? "Yes" : "No"));
        System.out.println("Ticket Price: " + ticketPrice);
    }
}

class AMSAdmin {
    private static List<Carrier> carriers = new ArrayList<>();
    private static List<Flight> flights = new ArrayList<>();
    private static int carrierIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Carrier");
            System.out.println("2. Edit Carrier Details by Carrier ID");
            System.out.println("3. Remove Carrier by ID");
            System.out.println("4. Flight Cancellation - Refund Price Calculation");
            System.out.println("5. Exit AMS");
            System.out.println("6. Display Carrier Details");
            System.out.println("7. Display Flight Details");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Carrier
                    System.out.print("Enter Carrier Name: ");
                    scanner.nextLine(); // Consume newline
                    String carrierName = scanner.nextLine();
                    System.out.print("Enter Discount for 30 Days Advance Booking: ");
                    int discount30Days = scanner.nextInt();
                    System.out.print("Enter Discount for 60 Days Advance Booking: ");
                    int discount60Days = scanner.nextInt();
                    System.out.print("Enter Discount for 90 Days Advance Booking: ");
                    int discount90Days = scanner.nextInt();
                    System.out.print("Enter Bulk Booking Discount: ");
                    int bulkDiscount = scanner.nextInt();
                    System.out.print("Enter Refund Percentage for Cancellation 2 Days Before: ");
                    int refund2Days = scanner.nextInt();
                    System.out.print("Enter Refund Percentage for Cancellation 10 Days Before: ");
                    int refund10Days = scanner.nextInt();
                    System.out.print("Enter Refund Percentage for Cancellation 20+ Days Before: ");
                    int refund20Days = scanner.nextInt();
                    System.out.print("Enter Silver User Discount: ");
                    int silverUserDiscount = scanner.nextInt();
                    System.out.print("Enter Gold User Discount: ");
                    int goldUserDiscount = scanner.nextInt();
                    System.out.print("Enter Platinum User Discount: ");
                    int platinumUserDiscount = scanner.nextInt();

                    carriers.add(new Carrier(carrierIdCounter++, carrierName, discount30Days, discount60Days, discount90Days,
                            bulkDiscount, refund2Days, refund10Days, refund20Days, silverUserDiscount, goldUserDiscount,
                            platinumUserDiscount));
                    System.out.println("Carrier added successfully.");
                    break;

                case 2: // Edit Carrier Details by Carrier ID
                    System.out.print("Enter Carrier ID to Edit: ");
                    int editCarrierId = scanner.nextInt();
                    Carrier carrierToEdit = findCarrierById(editCarrierId);
                    if (carrierToEdit == null) {
                        System.out.println("Carrier not found!");
                    } else {
                        System.out.print("Enter New Carrier Name: ");
                        carrierToEdit.setCarrierName(scanner.next());
            System.out.print("Enter New Discount Percentage (30 Days Advance): ");
            carrierToEdit.setDiscount30Days(scanner.nextInt());
            System.out.print("Enter New Discount Percentage (60 Days Advance): ");
            carrierToEdit.setDiscount60Days(scanner.nextInt());
            System.out.print("Enter New Discount Percentage (90 Days Advance): ");
            carrierToEdit.setDiscount90Days(scanner.nextInt());
            System.out.print("Enter New Bulk Booking Discount: ");
            carrierToEdit.setBulkDiscount(scanner.nextInt());
            System.out.print("Enter New Refund Percentage (2 Days Before): ");
            carrierToEdit.setRefund2Days(scanner.nextInt());
            System.out.print("Enter New Refund Percentage (10 Days Before): ");
            carrierToEdit.setRefund10Days(scanner.nextInt());
            System.out.print("Enter New Refund Percentage (20 Days Before): ");
            carrierToEdit.setRefund20Days(scanner.nextInt());
            System.out.print("Enter New Silver User Discount: ");
            carrierToEdit.setSilverUserDiscount(scanner.nextInt());
            System.out.print("Enter New Gold User Discount: ");
            carrierToEdit.setGoldUserDiscount(scanner.nextInt());
            System.out.print("Enter New Platinum User Discount: ");
            carrierToEdit.setPlatinumUserDiscount(scanner.nextInt());

            System.out.println("Carrier Details Updated Successfully.");
                    }
                    break;

                case 3: // Remove Carrier by ID
                    System.out.print("Enter Carrier ID to Remove: ");
                    int removeCarrierId = scanner.nextInt();
                    Carrier carrierToRemove = findCarrierById(removeCarrierId);
                    if (carrierToRemove == null) {
                        System.out.println("Carrier not found!");
                    } else {
                        carriers.remove(carrierToRemove);
                        System.out.println("Carrier removed successfully.");
                    }
                    break;

                case 4: // Flight Cancellation - Refund Price Calculation
                    System.out.print("Enter Flight ID: ");
                    int flightId = scanner.nextInt();
                    Flight flight = findFlightById(flightId);
                    if (flight == null) {
                        System.out.println("Flight not found!");
                    } else {
                        double refundAmount = flight.ticketPrice;
                        if (flight.isCancelled) {
                            System.out.println("Refund Amount: " + refundAmount);
                            if (LocalDate.now().isAfter(flight.travelDate.minusDays(7))) {
                                System.out.println("Additional Compensation: " + (0.1 * refundAmount));
                            }
                        } else {
                            System.out.println("Flight is not cancelled. No refund applicable.");
                        }
                    }
                    break;

                case 5: // Exit AMS
                    System.out.println("Exiting AMS...");
                    scanner.close();
                    return;

                case 6: // Display Carrier Details
                    if (carriers.isEmpty()) {
                        System.out.println("No carriers found.");
                    } else {
                        for (Carrier carrier : carriers) {
                            carrier.displayCarrierDetails();
                        }
                    }
                    break;

                case 7: // Display Flight Details
                    if (flights.isEmpty()) {
                        System.out.println("No flights found.");
                    } else {
                        for (Flight fl : flights) {
                            fl.displayFlightDetails();
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static Carrier findCarrierById(int carrierId) {
        for (Carrier carrier : carriers) {
            if (carrier.carrierId == carrierId) {
                return carrier;
            }
        }
        return null;
    }

    private static Flight findFlightById(int flightId) {
        for (Flight flight : flights) {
            if (flight.flightId == flightId) {
                return flight;
            }
        }
        return null;
    }
}
