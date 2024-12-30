// // package flight;


// import java.util.*;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.time.*;
// import java.time.format.DateTimeFormatter;


// class Customer {
//     int customerId;
//     String username;
//     String password;
//     long phone;
//     String email;
//     String address1;
//     String address2;
//     String city;
//     String state;
//     String country;
//     long zipCode;
//     Date dob;
    
//     public Customer(int customerId, String username, String password, long phone, String email,
//                     String address1, String address2, String city, String state,
//                     String country, long zipCode, Date dob) {
//         this.customerId = customerId;
//         this.username = username;
//         this.password = password;
//         this.phone = phone;
//         this.email = email;
//         this.address1 = address1;
//         this.address2 = address2;
//         this.city = city;
//         this.state = state;
//         this.country = country;
//         this.zipCode = zipCode;
//         this.dob = dob;
//     }

//     public void displayCustomerDetails() {
//         System.out.println("\nCustomer ID: " + customerId);
//         System.out.println("Username: " + username);
//         System.out.println("Phone: " + phone);
//         System.out.println("Email: " + email);
//         System.out.println("Address1: " + address1);
//         System.out.println("Address2: " + address2);
//         System.out.println("City: " + city);
//         System.out.println("State: " + state);
//         System.out.println("Country: " + country);
//         System.out.println("ZipCode: " + zipCode);
//         System.out.println("Date of Birth: " + dob);
//     }
// }


// class Ticket {
//     int ticketId;
//     int flightId;
//     int customerId;
//     LocalDate travelDate;
//     int seatCount;
//     String seatCategory;
//     double ticketPrice;

//     public Ticket(int ticketId, int flightId, int customerId, LocalDate travelDate, int seatCount,
//                   String seatCategory, double ticketPrice) {
//         this.ticketId = ticketId;
//         this.flightId = flightId;
//         this.customerId = customerId;
//         this.travelDate = travelDate;
//         this.seatCount = seatCount;
//         this.seatCategory = seatCategory;
//         this.ticketPrice = ticketPrice;
//     }

//     public void displayTicketDetails() {
//         System.out.println("\nTicket ID: " + ticketId);
//         System.out.println("Flight ID: " + flightId);
//         System.out.println("Customer ID: " + customerId);
//         System.out.println("Travel Date: " + travelDate);
//         System.out.println("Seat Count: " + seatCount);
//         System.out.println("Seat Category: " + seatCategory);
//         System.out.println("Ticket Price: " + ticketPrice);
//     }
// }


// class Carrier {
//     int carrierId;
//     String carrierName;
//     int discount30Days;
//     int discount60Days;
//     int discount90Days;
//     int bulkDiscount;
//     int refund2Days;
//     int refund10Days;
//     int refund20Days;
//     int silverUserDiscount;
//     int goldUserDiscount;
//     int platinumUserDiscount;

//     public Carrier(int carrierId, String carrierName,int discount30Days, int discount60Days, int discount90Days,
//     int bulkDiscount, int refund2Days, int refund10Days, int refund20Days,
//     int silverUserDiscount, int goldUserDiscount, int platinumUserDiscount) {
//         this.carrierId = carrierId;
//         this.carrierName = carrierName;
//         this.discount30Days = discount30Days;
//         this.discount60Days = discount60Days;
//         this.discount90Days = discount90Days;
//         this.bulkDiscount = bulkDiscount;
//         this.refund2Days = refund2Days;
//         this.refund10Days = refund10Days;
//         this.refund20Days = refund20Days;
//         this.silverUserDiscount = silverUserDiscount;
//         this.goldUserDiscount = goldUserDiscount;
//         this.platinumUserDiscount = platinumUserDiscount;
//     }

//     public int getCarrierId() {
//         return carrierId;
//     }

//     public void setCarrierId(int carrierId) {
//         this.carrierId = carrierId;
//     }

//     public String getCarrierName() {
//         return carrierName;
//     }

//     public void setCarrierName(String carrierName) {
//         this.carrierName = carrierName;
//     }

//     public int getDiscount30Days() {
//         return discount30Days;
//     }

//     public void setDiscount30Days(int discount30Days) {
//         this.discount30Days = discount30Days;
//     }

//     public int getDiscount60Days() {
//         return discount60Days;
//     }

//     public void setDiscount60Days(int discount60Days) {
//         this.discount60Days = discount60Days;
//     }

//     public int getDiscount90Days() {
//         return discount90Days;
//     }

//     public void setDiscount90Days(int discount90Days) {
//         this.discount90Days = discount90Days;
//     }

//     public int getBulkDiscount() {
//         return bulkDiscount;
//     }

//     public void setBulkDiscount(int bulkDiscount) {
//         this.bulkDiscount = bulkDiscount;
//     }

//     public int getRefund2Days() {
//         return refund2Days;
//     }

//     public void setRefund2Days(int refund2Days) {
//         this.refund2Days = refund2Days;
//     }

//     public int getRefund10Days() {
//         return refund10Days;
//     }

//     public void setRefund10Days(int refund10Days) {
//         this.refund10Days = refund10Days;
//     }

//     public int getRefund20Days() {
//         return refund20Days;
//     }

//     public void setRefund20Days(int refund20Days) {
//         this.refund20Days = refund20Days;
//     }

//     public int getSilverUserDiscount() {
//         return silverUserDiscount;
//     }

//     public void setSilverUserDiscount(int silverUserDiscount) {
//         this.silverUserDiscount = silverUserDiscount;
//     }

//     public int getGoldUserDiscount() {
//         return goldUserDiscount;
//     }

//     public void setGoldUserDiscount(int goldUserDiscount) {
//         this.goldUserDiscount = goldUserDiscount;
//     }

//     public int getPlatinumUserDiscount() {
//         return platinumUserDiscount;
//     }

//     public void setPlatinumUserDiscount(int platinumUserDiscount) {
//         this.platinumUserDiscount = platinumUserDiscount;
//     }

//     public void displayCarrierDetails() {
//         System.out.println("\nCarrier ID: " + carrierId);
//         System.out.println("Carrier Name: " + carrierName);
//         System.out.println("Discount 30 Days: " + discount30Days + "%");
//         System.out.println("Discount 60 Days: " + discount60Days + "%");
//         System.out.println("Discount 90 Days: " + discount90Days + "%");
//         System.out.println("Bulk Booking Discount: " + bulkDiscount + "%");
//         System.out.println("Refund (2 Days Before): " + refund2Days + "%");
//         System.out.println("Refund (10 Days Before): " + refund10Days + "%");
//         System.out.println("Refund (20+ Days Before): " + refund20Days + "%");
//         System.out.println("Silver User Discount: " + silverUserDiscount + "%");
//         System.out.println("Gold User Discount: " + goldUserDiscount + "%");
//         System.out.println("Platinum User Discount: " + platinumUserDiscount + "%");

//     }
// }

// class Flight {
//     int flightId;
//     LocalDate travelDate;
//     boolean isCancelled;
//     double ticketPrice;

//     public Flight(int flightId, LocalDate travelDate, boolean isCancelled, double ticketPrice) {
//         this.flightId = flightId;
//         this.travelDate = travelDate;
//         this.isCancelled = isCancelled;
//         this.ticketPrice = ticketPrice;
//     }

//     public void displayFlightDetails() {
//         System.out.println("\nFlight ID: " + flightId);
//         System.out.println("Travel Date: " + travelDate);
//         System.out.println("Cancelled: " + (isCancelled ? "Yes" : "No"));
//         System.out.println("Ticket Price: " + ticketPrice);
//     }
// }

// class Main {
//     private static List<Carrier> carriers = new ArrayList<>();
//     private static List<Flight> flights = new ArrayList<>();
//     private static int carrierIdCounter = 1;
//     public static List<Ticket> tickets=new ArrayList<>();
//     public static List<Customer> customers=new ArrayList<>();
//     public static int customerIdCounter = 1;
//     public static int ticketIdCounter=1;
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        
//         while(true) {
//         	System.out.println("Welcome to Airline Management System - AMS");
//         	System.out.println("1. Admin Sign-in");
//         	System.out.println("2. Customer Sign-in");
//         	System.out.println("3. Exit");
//         	int choice=scanner.nextInt();
//         	switch(choice) {
//         	case 1: adminMenu();
//         			break;
//         	case 2: customerMenu();
//         			break;
//         	case 3:System.out.println("Existing AMS....");
//         			return;
//         	default: System.out.println("Invalid choice.");
//         	}
//         }
    
    
//     }
// private static void adminMenu() {
// 	Scanner scanner = new Scanner(System.in);
//         while (true) {
//             System.out.println("\nAdmin Menu:");
//             System.out.println("1. Add Carrier");
//             System.out.println("2. Edit Carrier Details by Carrier ID");
//             System.out.println("3. Remove Carrier by ID");
//             System.out.println("4. Flight Cancellation - Refund Price Calculation");
//             System.out.println("5. Exit AMS");
//             System.out.println("6. Display Carrier Details");
//             System.out.println("7. Display Flight Details");
//             System.out.print("Enter your choice: ");
//             int choice = scanner.nextInt();

//             switch (choice) {
//                 case 1: // Add Carrier
//                     System.out.print("Enter Carrier Name: ");
//                     scanner.nextLine(); // Consume newline
//                     String carrierName = scanner.nextLine();
//                     System.out.print("Enter Discount for 30 Days Advance Booking: ");
//                     int discount30Days = scanner.nextInt();
//                     System.out.print("Enter Discount for 60 Days Advance Booking: ");
//                     int discount60Days = scanner.nextInt();
//                     System.out.print("Enter Discount for 90 Days Advance Booking: ");
//                     int discount90Days = scanner.nextInt();
//                     System.out.print("Enter Bulk Booking Discount: ");
//                     int bulkDiscount = scanner.nextInt();
//                     System.out.print("Enter Refund Percentage for Cancellation 2 Days Before: ");
//                     int refund2Days = scanner.nextInt();
//                     System.out.print("Enter Refund Percentage for Cancellation 10 Days Before: ");
//                     int refund10Days = scanner.nextInt();
//                     System.out.print("Enter Refund Percentage for Cancellation 20+ Days Before: ");
//                     int refund20Days = scanner.nextInt();
//                     System.out.print("Enter Silver User Discount: ");
//                     int silverUserDiscount = scanner.nextInt();
//                     System.out.print("Enter Gold User Discount: ");
//                     int goldUserDiscount = scanner.nextInt();
//                     System.out.print("Enter Platinum User Discount: ");
//                     int platinumUserDiscount = scanner.nextInt();

//                     carriers.add(new Carrier(carrierIdCounter++, carrierName, discount30Days, discount60Days, discount90Days,
//                             bulkDiscount, refund2Days, refund10Days, refund20Days, silverUserDiscount, goldUserDiscount,
//                             platinumUserDiscount));
//                     System.out.println("Carrier added successfully.");
//                     break;

//                 case 2: // Edit Carrier Details by Carrier ID
//                     System.out.print("Enter Carrier ID to Edit: ");
//                     int editCarrierId = scanner.nextInt();
//                     Carrier carrierToEdit = findCarrierById(editCarrierId);
//                     if (carrierToEdit == null) {
//                         System.out.println("Carrier not found!");
//                     } else {
//                         System.out.print("Enter New Carrier Name: ");
//                         carrierToEdit.setCarrierName(scanner.next());
//             System.out.print("Enter New Discount Percentage (30 Days Advance): ");
//             carrierToEdit.setDiscount30Days(scanner.nextInt());
//             System.out.print("Enter New Discount Percentage (60 Days Advance): ");
//             carrierToEdit.setDiscount60Days(scanner.nextInt());
//             System.out.print("Enter New Discount Percentage (90 Days Advance): ");
//             carrierToEdit.setDiscount90Days(scanner.nextInt());
//             System.out.print("Enter New Bulk Booking Discount: ");
//             carrierToEdit.setBulkDiscount(scanner.nextInt());
//             System.out.print("Enter New Refund Percentage (2 Days Before): ");
//             carrierToEdit.setRefund2Days(scanner.nextInt());
//             System.out.print("Enter New Refund Percentage (10 Days Before): ");
//             carrierToEdit.setRefund10Days(scanner.nextInt());
//             System.out.print("Enter New Refund Percentage (20 Days Before): ");
//             carrierToEdit.setRefund20Days(scanner.nextInt());
//             System.out.print("Enter New Silver User Discount: ");
//             carrierToEdit.setSilverUserDiscount(scanner.nextInt());
//             System.out.print("Enter New Gold User Discount: ");
//             carrierToEdit.setGoldUserDiscount(scanner.nextInt());
//             System.out.print("Enter New Platinum User Discount: ");
//             carrierToEdit.setPlatinumUserDiscount(scanner.nextInt());

//             System.out.println("Carrier Details Updated Successfully.");
//                     }
//                     break;

//                 case 3: // Remove Carrier by ID
//                     System.out.print("Enter Carrier ID to Remove: ");
//                     int removeCarrierId = scanner.nextInt();
//                     Carrier carrierToRemove = findCarrierById(removeCarrierId);
//                     if (carrierToRemove == null) {
//                         System.out.println("Carrier not found!");
//                     } else {
//                         carriers.remove(carrierToRemove);
//                         System.out.println("Carrier removed successfully.");
//                     }
//                     break;

//                 case 4: // Flight Cancellation - Refund Price Calculation
//                     System.out.print("Enter Flight ID: ");
//                     int flightId = scanner.nextInt();
//                     Flight flight = findFlightById(flightId);
//                     if (flight == null) {
//                         System.out.println("Flight not found!");
//                     } else {
//                         double refundAmount = flight.ticketPrice;
//                         if (flight.isCancelled) {
//                             System.out.println("Refund Amount: " + refundAmount);
//                             if (LocalDate.now().isAfter(flight.travelDate.minusDays(7))) {
//                                 System.out.println("Additional Compensation: " + (0.1 * refundAmount));
//                             }
//                         } else {
//                             System.out.println("Flight is not cancelled. No refund applicable.");
//                         }
//                     }
//                     break;

//                 case 5: // Exit AMS
//                     System.out.println("Exiting AMS...");
//                     return;

//                 case 6: // Display Carrier Details
//                     if (carriers.isEmpty()) {
//                         System.out.println("No carriers found.");
//                     } else {
//                         for (Carrier carrier : carriers) {
//                             carrier.displayCarrierDetails();
//                         }
//                     }
//                     break;

//                 case 7: // Display Flight Details
//                     if (flights.isEmpty()) {
//                         System.out.println("No flights found.");
//                     } else {
//                         for (Flight fl : flights) {
//                             fl.displayFlightDetails();
//                         }
//                     }
//                     break;

//                 default:
//                     System.out.println("Invalid choice! Please try again.");
//             }
//         }
// 	}
   
// private static void customerMenu(){
// 	Scanner scanner = new Scanner(System.in);
// 	System.out.println("\nCustomer Menu:");
// 	System.out.println("1. Customer registration");
// 	System.out.println("2. Edit Customer Profile");
// 	System.out.println("3. Ticket Booking");
// 	System.out.println("4. Ticket Cancellation");
// 	System.out.println("5. Exit to Main Menu");
// 	System.out.println("6.Display Customers");
// 	System.out.println("7. Display ticket");
// 	System.out.print("Enter your choice: ");
// 	int choice=scanner.nextInt();
// 	switch (choice) {
//     case 1:
//         registerCustomer();
//         break;
//     case 2:
//         editCustomerProfile();
//         break;
//     case 3:
//         bookTickets();
//         break;
//     case 4:
//         cancelTickets();
//         break;
//     case 5:
//         System.exit(0);
//     case 6: displayCustomers();
//     		break;
//     case 7: displayTickets();
//     		break;
//     default:
//         System.out.println("Invalid choice. Please try again.");
// }
// }


// private static void displayCustomers() {
// 	System.out.println();
// 	if(customers.isEmpty()) {
// 		System.out.println("No customers found");
// 	}
// 	else {
// 		for(Customer customer: customers) {
// 			customer.displayCustomerDetails();
// 		}
// 	}
// }


// private static void displayTickets() {
// 	System.out.println();
// 	if(customers.isEmpty()) {
// 		System.out.println("No customers found");
// 	}
// 	else {
// 		for(Ticket ticket: tickets) {
// 			System.out.println(ticket);
// 		}
// 	}
// }


// private static void registerCustomer() {
// 	Scanner scanner = new Scanner(System.in);
//     System.out.print("Enter Username: ");
    
//     String username = scanner.nextLine();
//     System.out.print("Enter Password: ");
//     String password = scanner.nextLine();
//     System.out.print("Enter Phone: ");
//     long phone = scanner.nextLong();
//     System.out.print("Enter Email: ");
//     scanner.nextLine(); // Consume newline
//     String email = scanner.nextLine();
//     System.out.print("Enter Address1: ");
//     String address1 = scanner.nextLine();
//     System.out.print("Enter Address2: ");
//     String address2 = scanner.nextLine();
//     System.out.print("Enter City: ");
//     String city = scanner.nextLine();
//     System.out.print("Enter State: ");
//     String state = scanner.nextLine();
//     System.out.print("Enter Country: ");
//     String country = scanner.nextLine();
//     System.out.print("Enter Zip Code: ");
//     long zipCode = scanner.nextLong();
//     System.out.print("Enter Date of Birth (dd-mm-yyyy): ");
    
//     String dateStr=scanner.next();
//     SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//     Date date = null;
// 	try {
// 		date = sdf.parse(dateStr);
// 	} catch (ParseException e) {
// 		
// 		e.printStackTrace();
// 	}

//     customers.add(new Customer(customerIdCounter++, username, password, phone, email,
//                                address1, address2, city, state, country, zipCode, date));
//     System.out.println("Customer registered successfully.");
// }

// private static void editCustomerProfile() {
// 	Scanner scanner = new Scanner(System.in);
//     System.out.print("Enter Customer ID to Edit: ");
//     int customerId = scanner.nextInt();
//     Customer customer = findCustomerById(customerId);
//     if (customer == null) {
//         System.out.println("Customer not found!");
//         return;
//     }

//     System.out.print("Enter New Phone: ");
//     customer.phone = scanner.nextLong();
//     System.out.print("Enter New Email: ");
//     customer.email = scanner.nextLine();
//     System.out.print("Enter New Address1: ");
//     customer.address1 = scanner.nextLine();
//     System.out.print("Enter New Address2: ");
//     customer.address2 = scanner.nextLine();
//     System.out.print("Enter New City: ");
//     customer.city = scanner.nextLine();
//     System.out.print("Enter New State: ");
//     customer.state = scanner.nextLine();
//     System.out.print("Enter New Country: ");
//     customer.country = scanner.nextLine();
//     System.out.print("Enter New Zip Code: ");
//     customer.zipCode = scanner.nextLong();
//     System.out.println("Customer profile updated successfully.");
// }

// private static void bookTickets() {
// 	Scanner scanner = new Scanner(System.in);
//     System.out.print("Enter Customer ID: ");
//     int customerId = scanner.nextInt();
//     Customer customer = findCustomerById(customerId);
//     if (customer == null) {
//         System.out.println("Customer not found!");
//         return;
//     }

//     System.out.print("Enter Flight ID: ");
//     int flightId = scanner.nextInt();
//     System.out.print("Enter Travel Date (yyyy-MM-dd): ");
//     scanner.nextLine(); // Consume newline
//     LocalDate travelDate = LocalDate.parse(scanner.nextLine());
//     System.out.print("Enter Seat Count: ");
//     int seatCount = scanner.nextInt();
//     System.out.print("Enter Seat Category (Economy/Business/Executive): ");
//     scanner.nextLine(); // Consume newline
//     String seatCategory = scanner.nextLine();
//     System.out.print("Enter Ticket Price: ");
//     double ticketPrice = scanner.nextDouble();

//     tickets.add(new Ticket(ticketIdCounter++, flightId, customerId, travelDate, seatCount, seatCategory, ticketPrice));
//     System.out.println("Ticket booked successfully.");
// }

// private static void cancelTickets() {
// 	Scanner scanner = new Scanner(System.in);
//     System.out.print("Enter Ticket ID to Cancel: ");
//     int ticketId = scanner.nextInt();
//     Ticket ticket = findTicketById(ticketId);
//     if (ticket == null) {
//         System.out.println("Ticket not found!");
//     } else {
//         tickets.remove(ticket);
//         System.out.println("Ticket cancelled successfully.");
//     }
// }

// private static Customer findCustomerById(int customerId) {
//     for (Customer customer : customers) {
//         if (customer.customerId == customerId) {
//             return customer;
//         }
//     }
//     return null;
// }

// private static Ticket findTicketById(int ticketId) {
//     for (Ticket ticket : tickets) {
//         if (ticket.ticketId == ticketId) {
//             return ticket;
//         }
//     }
//     return null;
// }


// private static Carrier findCarrierById(int carrierId) {
//         for (Carrier carrier : carriers) {
//             if (carrier.carrierId == carrierId) {
//                 return carrier;
//             }
//         }
//         return null;
//     }

//     private static Flight findFlightById(int flightId) {
//         for (Flight flight : flights) {
//             if (flight.flightId == flightId) {
//                 return flight;
//             }
//         }
//         return null;
//     }
// }