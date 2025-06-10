import java.time.LocalDateTime;
import java.lang.Math;
import java.util.*;
// Flight(Airport) Class
class Airport {
    LocalDateTime Current = LocalDateTime.now(); // For Date and Time
    Scanner sc = new Scanner(System.in); // For Scanner Class
    // For Default Details
    String flight_name[] = new String[5];
    static int flight_number[] = new int[9];
    static int flight_price[] = new int[9];
    static String flight_details[] = new String[9];
    static String flight_Time_Data[] = new String[9];
    // For Seats
    static int Empty_Seat[] = new int[8];
    static int Total = 6;
    Airport() // Flightname & FlightDetails
    {
        int temp = 1;
        for (int i = 0; i < flight_number.length; i++) // For Flight Name
        {
            flight_number[i] = temp;
            temp++;
        }
        flight_name[0] = "Air India";
        flight_name[1] = "Indigo";
        flight_name[2] = "Air India Express";
        flight_name[3] = "Vistara";
        flight_name[4] = "British Airways";
        // For Flight Details
        // For Flight Number
        flight_number[0] = 1122;
        flight_number[1] = 1254;
        flight_number[2] = 1212;
        flight_number[3] = 5432;
        flight_number[4] = 4321;
        flight_number[5] = 9852;
        // For Flight city and Price
        flight_details[0] = "Bangkok";
        flight_price[0] = 14968;
        flight_details[1] = "Dubai";
        flight_price[1] = 22509;
        flight_details[2] = "New York";
        flight_price[2] = 87758;
        flight_details[3] = "New Delhi";
        flight_price[3] = 5597;
        flight_details[4] = "London";
        flight_price[4] = 56319;
        flight_details[5] = "Singapore";
        flight_price[5] = 18209;
        // For Flight Time
        flight_Time_Data[0] = "Time:15:30";
        flight_Time_Data[1] = "Time:4:45";
        flight_Time_Data[2] = "Time:13:00";
        flight_Time_Data[3] = "Time:9:25";
        flight_Time_Data[4] = "Time:16:00";
        flight_Time_Data[5] = "Time:10:30";
        // For Seats Details
        for (int i = 0; i < 6; i++) {
            Empty_Seat[i] = (int) (Math.random() * 100);
        }
    }
    void FlightDetails_Add(int a) {
        // Add Detials
        boolean b = true;
        boolean found = true;
        for (int j = Total; j < a; j++) {
            while (b == true) {
                System.out.println("Enter Flight Number");
                int Num = sc.nextInt();
                for (int i = 0; i < Total; i++) {
                    if (flight_number[i] != Num) {
                        found = false;
                        break;
                    }
                }
                if (found != true) {
                    flight_number[j] = Num;
                    b = false;
                } else {
                    System.out.println("Flight number already exists! Try again.");
                }
            }
            System.out.println("Enter Flight destination");
            sc.nextLine();
            flight_details[j] = sc.nextLine();
            System.out.println("Enter price");
            flight_price[j] = sc.nextInt();
            System.out.println("Enter flight Time");
            sc.nextLine();
            flight_Time_Data[j] = sc.nextLine();
            Empty_Seat[j] = (int) (Math.random() * 100);
        }
        System.out.println("Adding Data...");
        System.out.println("\u001B[32mData Added\u001B[0m");
        this.Total = a;
    }
    void flight_details_display() { // For Display
        for (String e : flight_name) {
            System.out.println("=======================================================================================");
            System.out.println(" ");
            System.out.println("                                     " + e);
            System.out.println(" ");
        }
        System.out.println("=======================================================================================");
    }
    void Display(int i) { // For Display
        System.out.println("----------------------------------------------------------------");
        System.out.print(i + 1 + ". ");
        System.out.print(flight_details[i] + "  ");
        System.out.println(" ");
        System.out.println("Flight Number:" + flight_number[i]);
        System.out.println("Price " + flight_price[i] + " Rs");
        System.out.println(flight_Time_Data[i]);
        System.out.println("Empty seats: " + Empty_Seat[i]);
        System.out.println("----------------------------------------------------------------");
    }
    void Delete_Flight(int Delete_F) {
        int Delete_in;
        boolean Delete_Flight = false;
        for (int j = 0; j <= Delete_F; j++) {
            System.out.println("Enter Flight Number you Want to Delete:");
            int Delet_num = sc.nextInt();
            for (int i = 0; i <= Total; i++) {
                if (flight_number[i] == Delet_num) {
                    Delete_in = i;
					
                    this.Remove(Delete_in);
                    Delete_F--;
                    Delete_Flight = false;
                    System.out.println("Deleting...");
                    System.out.println("\u001B[32mDeleting Successful\u001B[0m");
                    break;
                } else if (flight_number[i] != Delet_num) {
                    Delete_Flight = true;
                } else {
                    Delete_Flight = false;
                }
            }
            if (Delete_Flight == true) {
                System.out.println("\033[0;31mNot Found Please Enter Valid Flight Number!\033[0m");
                this.Delete_Flight(Delete_F);
            }
        }
    }
    void Remove(int j) {
        for (int i = j; i < Total - 1; i++) {
            flight_number[i] = flight_number[i + 1];
            flight_price[i] = flight_price[i + 1];
            flight_Time_Data[i] = flight_Time_Data[i + 1];
            flight_details[i] = flight_details[i + 1];
            Empty_Seat[i] = Empty_Seat[i + 1];
        }
        this.Total--;
    }
}

class Admin // Admin
{
    Scanner sc = new Scanner(System.in);
    Airport Air = new Airport();
    int c;
    static String Password = "1234";
    static int a = 0;
     int Attempts_left = 3;
    Admin() {
        while (a < 3) {
            System.out.println("  ");
            System.out.println("Enter Password.           #(You have only Three Try!)");
            String Enter_Password = sc.nextLine();
            if (Enter_Password.equals(Password)) {
                System.out.println("   ");
                boolean Ach = true;
                int Add_f = 6;
                while (Ach) {
                    System.out.println("Enter 1. For Show Details");
                    System.out.println("Enter 2. For Add Flight");
                    System.out.println("Enter 3. For Delete Flight");
                    System.out.println("Enter 4. For Change Password");
                    System.out.println("Enter 5. For Exit");
                    int Ad = sc.nextInt();
                    switch (Ad) {
                        case 1:
                            for (int i = 0; i < Add_f; i++) {
                                Air.Display(i);
                            }
                            break;
                        case 2:
                            boolean Ab = true;
                            while (Ab) {
                                if (Add_f < 8) {
                                    System.out.println("Enter the Number of Flights You Want to Add:");
                                    int Add = sc.nextInt();
                                    Add_f = Add_f + Add;
                                    if (Add_f <= 8) {
                                        Air.FlightDetails_Add(Add_f);
                                        Ab = false;
                                    } else {
                                        Add_f = Add_f - Add;
                                        System.out.println("\033[0;31mPlease Enter Valid Input!\033[0m");
                                    }
                                } else {
                                    System.out.println("\033[0;31mMaximum Flights Reached!\033[0m");
                                }
                            }
                            break;
                        case 3:
                            boolean Df = true;
                            while (Df) {
                                System.out.println("Enter Number Of Flight you Want to Delete:");
                                int Delete_F = sc.nextInt();
                                if (Delete_F <= Add_f) {
                                    Air.Delete_Flight(Delete_F);
                                    Add_f = Add_f - Delete_F;
                                    Df = false;
                                } else {
                                    System.out.print("\033[0;31mPlease Enter Valid Input! your Totel number of Flight is: \033[0m");
                                    System.out.println(Add_f);
                                    System.out.println("  ");
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Enter New Password");
							sc.nextLine();
                            this.Password = sc.nextLine();
                            System.out.println("\u001B[32mPassword Changed successful\u001B[0m");
                            break;
                        case 5:
                            System.out.println("\u001B[32mThank You...\u001B[0m");
                            Ach = false;
                            return;
                        default:
                            System.out.println("\033[0;31mPlease Enter Valid Input!\033[0m");
                            break;
                    }
                }
            } else if (Enter_Password != Password) {
                if (a < 2) {
                    Attempts_left--;
                    System.out.println("\033[0;31mPlease Enter Valid Password!\033[0m");
                    System.out.println("Your Attempts left:" + Attempts_left);
                }
                a++;
            }
        }
        if (a == 3) {
            System.out.println("  ");
            System.out.println("\033[0;31mYou are not able to access!\033[0m");
            System.out.println("\033[0;31mYour Maximum attempt is over..\033[0m");
        }
    }
}
class flight extends Airport {
    static int Total_Empty_Seat = 0;
    static int Booked = 0;
    int Tickets[] = new int[500];
    int Ticket_in[] = new int[500];
    int Amount[] = new int[500];
    static int Ticket_Number = 1;
	static int n;
    void Ticket_Book(String Email) {
		Airport air=new Airport();
        boolean F_found = false;
        System.out.print("Enter Flight number: ");
        this.n = sc.nextInt();
        for (int i = 0; i <= Total; i++) {
            if (air.flight_number[i]==n) {
                super.Display(i);
                int a = this.Ticket(i, Email);
                F_found = true;
                break;
            }
        }
        if (F_found == false) {
            System.out.println("\033[0;31mNot Found Please Enter Valid Flight Number!\033[0m");
            this.Ticket_Book(Email);
        }
    }
    int Ticket(int i, String Email) {
        boolean Seat_Empty = true;
        System.out.println("Enter Number of seat You Want to Book :");
        int Book_Seat = sc.nextInt();
        if (Empty_Seat[i] >= Book_Seat) {
            Empty_Seat[i] = Empty_Seat[i] - Book_Seat;
            Amount[Booked] = flight_price[i] * Book_Seat;
            System.out.println("Your Payable Amount is: " + Amount[Booked]);
            Tickets[Booked] = Ticket_Number;
            Ticket_in[Booked] = i;
            System.out.println("\u001B[32mBooking SuccesFull Thank You...\u001B[0m");
            this.Display(i, Email, Booked);
            this.Booked++;
            Ticket_Number++;
        } else {
            System.out.println("\033[0;31mSorry Empty Seat not found Please try next Time!\033[0m");
        }
        return 0;
    }
    void Display(int i, String Email, int j) { // For Display
        System.out.println("  ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Your Email: " + Email);
        System.out.println("    ");
        System.out.println("Ticket Number:" + Tickets[j]);
        System.out.print(flight_details[i] + "  ");
        System.out.println(" ");
        System.out.println("Flight Number:" + flight_number[i]);
        System.out.println("Ticket Price " + flight_price[i] + "$");
        System.out.println(flight_Time_Data[i]);
        System.out.println("    ");
        System.out.println("Your Payable Amount is: " + Amount[j]);
        System.out.println("Your Ticket Booking Time :" + Current);
        System.out.println("----------------------------------------------------------------");
        System.out.println("    ");
    }
    void Search_Ticket(String Email) {
        boolean b = true;
        System.out.println("Enter Your Ticket Number");
        int Num = sc.nextInt();
        for (int i = 0; i <= Booked; i++) {
            if (Num == Tickets[i]) {
                this.Display(Ticket_in[i], Email, i);
                b = false;
            }
        }
        if (b) {
            System.out.println("Sorry! Your Ticket Was Not Found");
        }
    }
    void Cancel_Ticket() {
        System.out.println("Enter Your Ticket Number");
        int Num = sc.nextInt();
        for (int i = 0; i <= Booked; i++) {
            if (Num == Tickets[i]) {
                Empty_Seat[Ticket_in[i]] += (Amount[i] / flight_price[Ticket_in[i]]);
                System.out.println("\u001B[32mCanceling...\u001B[0m");
                this.Remove(i);
                return;
            }
        }
    }
    void Remove(int i) {
        for (int j = i; j <= Booked; j++) {
            Tickets[j] = Tickets[j + 1];
            Amount[j] = Amount[j + 1];
            Ticket_in[j] = Ticket_in[j + 1];
        }
        System.out.println("\u001B[32mCancel Successful\u001B[0m");
        this.Booked--;
    }
}
class Customer_data extends Airport {
    Scanner sc = new Scanner(System.in);
    String Customer_Email[] = new String[100];
    String Password[] = new String[100];
    static int Total_c = 5;
    static int c;
	String E_C;
    void Customer() {
        // For Customer Email
        Customer_Email[0] = "abc@gmail.com";
        Customer_Email[1] = "def@gmail.com";
        Customer_Email[2] = "ghi@gmail.com";
        Customer_Email[3] = "jkl@gmail.com";
        Customer_Email[4] = "mno@gmail.com";
        // For Customer Password
        Password[0] = "abc@123";
        Password[1] = "def@234";
        Password[2] = "ghi@345";
        Password[3] = "jkl@456";
        Password[4] = "mno@567";
    }
    void Search_Email() {
        this.Customer();
        boolean Search = true;
        System.out.println("Enter Your Email");
        String C_Email = sc.nextLine();
        for (int i = 0; i < Total_c; i++) {
            if (this.Customer_Email[i].equals(C_Email)) {
                Search = false;
                this.c = this.Search_Password(i);
				E_C=C_Email;
                break;
            } else {
                Search = true;
            }
        }
        if (Search == true) {
            System.out.println("\033[0;31mPlease Enter a Valid Email!\033[0m");
            this.Search_Email();
        }
    }
    int Search_Password(int i) {
        boolean Search_paas = true;
        System.out.println("Enter Your Password");
        String C_Password = sc.nextLine();
        if (Password[i].equals(C_Password)) {
            c = i;
            return i;
        } else {
            System.out.println("\033[0;31mPlease Enter a Valid Password!\033[0m");
            return this.Search_Password(i);
        }
    }
    void Add_Customer() {
        // Add Customer
        boolean cb = true;
        while (cb) {
            System.out.println("Enter Your Email.                #(Your Email ends with '@gmail.com')");
            Customer_Email[Total_c] = sc.nextLine();
            cb = this.Confirm_Email(Customer_Email[Total_c]);
            if (cb) {
                System.out.println("\033[0;31mPlease Enter a Valid Email!\033[0m");
            }
        }
        cb = true;
        while (cb) {
            System.out.println("Enter Your Password              #(Minimum 8 Letter or Number)");
            Password[Total_c] = sc.nextLine();
            cb = this.check_pass(Password[Total_c]);
            if (cb) {
                System.out.println("\033[0;31mPlease Enter a Valid Password!\033[0m");
            } else {
                System.out.println(" ");
                Total_c++;
            }
        }
    }
    boolean Confirm_Email(String C_Email) {
        boolean b = true;
        int E_length = C_Email.length();
        for (int i = 0; i < E_length; i++) {
            if (C_Email.charAt(i) == '@') {
                b = this.Check(i, C_Email);
                break;
            }
        }
        return b;
    }
    boolean Check(int i, String C_Email) {
        boolean b = true;
        String check = "gmail.com";
        int check_in = 0;
        for (int j = i + 1; j < C_Email.length(); j++) {
            if (C_Email.charAt(j) == check.charAt(check_in)) {
                check_in++;
                b = false;
            } else {
                break;
            }
        }
        return b;
    }
    boolean check_pass(String pass) {
        boolean b = true;
        int Pass_length = pass.length();
        if (Pass_length >= 8) {
            b = false;
        }
        return b;
    }
}
class Customer {
    Customer_data c = new Customer_data();
    Scanner sc = new Scanner(System.in);
    flight fli = new flight();
    Customer() {
        System.out.println("  ");
        for (int i = 0; i < c.Total; i++) {
            c.Display(i);
        }
        System.out.println("  ");
        boolean Cch = true;
        int Add_C = 5;
        System.out.println("\033[0;31mPlease Login to Your Account!\033[0m");
        System.out.println("  ");
        boolean b = true;
        while (b) {
            System.out.println("  ");
            System.out.println("Enter 1. For Create Account");
            System.out.println("Enter 2. For Login");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    c.Add_Customer();
                    break;
                case 2:
                    c.Search_Email();
                    System.out.println("\u001B[32mLogin Succesfull...\u001B[0m");
                    b = false;
                    break;
                default:
                    System.out.println("\033[0;31mPlease Enter Valid Input!\033[0m");
                    break;
            }
        }
        while (Cch) {
            System.out.println("  ");
            System.out.println("Enter 1. For Ticket Booking");
            System.out.println("Enter 2. For Show your Ticket");
            System.out.println("Enter 3. For Cancel Ticket");
            System.out.println("Enter 4. For Exit");
            int Cd = sc.nextInt();
            switch (Cd) {
                case 1:
                    fli.Ticket_Book(c.E_C);
                    break;
                case 2:
                    if (fli.Booked > 0) {
                        fli.Search_Ticket(c.E_C);
                    } else {
                        System.out.println("\033[0;31mYou are not booked a ticket\033[0m");
                    }
                    break;
                case 3:
                    if (fli.Booked > 0) {
                        fli.Cancel_Ticket();
                    } else {
                        System.out.println("\033[0;31mYou are not booked a ticket\033[0m");
                    }
                    break;
                case 4:
                    System.out.println("\u001B[32mThank You...\u001B[0m");
                    Cch = false;
                    break;
                default:
                    System.out.println("\033[0;31mPlease Enter Valid Input!\033[0m");
                    break;
            }
        }
    }
}
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Airport Air = new Airport();
        System.out.println("\u001B[32m                           Welcome To Airline Reservation System!\u001B[0m");
        Air.flight_details_display();
        boolean ch = true;
        while (ch) {
            System.out.println("   ");
            System.out.println("Enter 1. For Admin");
            System.out.println("Enter 2. For Customer");
            System.out.println("Enter 3. For Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Admin ad = new Admin();
                    break;
                case 2:
                    Customer Cu = new Customer();
                    break;
                case 3:
                    System.out.println("\u001B[32mThank You...\u001B[0m");
                    ch = false;
                    break;
                default:
                    System.out.println("\033[0;31mPlease Enter Valid Input!\033[0m");
                    break;
            }
        }
    }
}
