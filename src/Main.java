import java.util.Scanner;

//User Management System

/* User management system is a basic system which implements a OOP concept : Encapsulation
    User Management system have  modules  like authentication, Registration, View Profile Details
    and Update Profile Details.
* */

//Main Class which Initiates a Program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // used for take user inputs
        Authentication authentication = new Authentication(); // authentication class object for invoking authenticate method

        System.out.println("-: Welcome to User Management System :-");
        System.out.println("    Authentication");

        // take email and password from user for verification
        System.out.print("Enter Email :");
        String email = scanner.next(); //

        System.out.print("Enter Password :");
        String password = scanner.next();

        /* authenticate  function takes two parameter email and password and if email and password
        match with hardcoded text(used hardcoded string because don't have persisted data)
        and if they match it prints sucess message and let user enter in system
         */
        authentication.authenticate_user(email, password);

        /* register_user method is used for registering user details in system it takes
        4 details from user and Passes this 4 parameters to User Constructor and register_user
        function returns User object for printing detail in future
        * */
        User user = register_user();

        System.out.println();

        while (true) {
            int choice;
            System.out.println();
            //gives user a choice for perform operation from below
            System.out.println("Select Operation You want to perform");
            System.out.println("1. View Your Profile Details");
            System.out.println("2. Update Your Profile Details");
            System.out.println("3. LOGOUT");
            System.out.print("Enter Your choice : ");
            choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.println("Your name : " + user.getUser_name());
                    System.out.println("Your phone no. : " + user.getUser_phoneno());
                    System.out.println("Your blood group : " + user.getUser_bloodgroup());
                    System.out.println("Your address : " + user.getUser_address());
                    break;
                case 2:
                    System.out.print("Enter Name :");
                    String upadte_name = scanner.next();

                    System.out.print("Enter Phone no. :");
                    String update_phoneno = scanner.next();

                    System.out.print("Enter Blood Group :");
                    String update_bloodgroup = scanner.next();

                    System.out.print("Enter Address :");
                    String upadte_address = scanner.next();
                    user.update_details(upadte_name, update_phoneno, update_bloodgroup, upadte_address); // update method call for upadte data
                    break;
                case 3:
                    System.exit(0); // for exiting from program
                    break;
            }

        }
    }

    /* register_user method is used for registering user details in system it takes
         4 details from user and Passes this 4 parameters to User Constructor and register_user
         function returns User object for printing detail in future
         * */

    // also as you can see this method is private so its data is encapsulates in class
    private static User register_user() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name :");
        String name = scanner.next();

        System.out.print("Enter Phone no. :");
        String phoneno = scanner.next();

        System.out.print("Enter Blood Group :");
        String bloodgroup = scanner.next();

        System.out.print("Enter Address :");
        String address = scanner.next();

        User user = new User(name, phoneno, bloodgroup, address);
        return user;
    }


    /* authentication class is private because it contains email and password of user
    which is sensitive information for any system so authentication class is also encapsulated
     */
    private static class Authentication {
        private final String user_email = "harshj.wappnet@gmail.com";
        private final String user_password = "Harsh@123";


        /* authenticate  function takes two parameter email and password and if email and password
        match with hardcoded text(used hardcoded string because don't have persisted data)
        and if they match it prints success message and let user enter in system
         */
        private void authenticate_user(String email, String password) {
            if (email.equals(user_email) && password.equals(user_password)) {
                System.out.println();
                System.out.println("Authentication Sucessful Welcome to system");
                System.out.println();
            } else {
                System.out.println("Error email or password is wrong");
                System.exit(0);
            }
        }
    }
}


/* User class is basically a data model class which is used for geting and seting
text to system and in this class also its data members are private so only through
getter and setter it is accessible, and it has also another method for updateing
information of user.
 */
class User {

    // private data member of user class
    private String user_name;
    private String user_phoneno;
    private String user_bloodgroup;
    private String user_address;

    //parameterized constructor for setting or initializing  data to variable
    public User(String user_name, String user_phoneno, String user_bloodgroup, String user_address) {

        this.user_name = user_name;
        this.user_phoneno = user_phoneno;
        this.user_bloodgroup = user_bloodgroup;
        this.user_address = user_address;
    }

    // getter methods for retrieving text data for displaying purpose
    public String getUser_name() {
        return user_name;
    }

    public String getUser_phoneno() {
        return user_phoneno;
    }

    public String getUser_bloodgroup() {
        return user_bloodgroup;
    }

    public String getUser_address() {
        return user_address;
    }

    /* update_details function is used for updateing data of user profile,
    and it takes 4 parameter which is taken from user as new updated information
     */
    void update_details(String update_name, String update_phone, String update_bloodgroup, String update_address) {

        user_name = update_name;
        user_phoneno = update_phone;
        user_bloodgroup = update_bloodgroup;
        user_address = update_address;
    }
}