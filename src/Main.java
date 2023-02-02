import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authentication authentication = new Authentication();

        System.out.println("-: Welcome to User Management System :-");
        System.out.println("    Authentication");

        System.out.print("Enter Email :");
        String email = scanner.next();

        System.out.print("Enter Password :");
        String password = scanner.next();

        authentication.authenticate_user(email,password);

        User user = register_user();

        System.out.println();

        while (true){
            int choice;
            System.out.println();
         System.out.println("Select Operation You want to perform");
         System.out.println("1. View Your Profile Details");
         System.out.println("2. Update Your Profile Details");
         System.out.println("3. LOGOUT");
         System.out.print("Enter Your choice : ");
         choice = scanner.nextInt();
            System.out.println();
            switch (choice){
                case 1:
                    System.out.println("Your name : "+user.getUser_name());
                    System.out.println("Your phone no. : "+user.getUser_phoneno());
                    System.out.println("Your blood group : "+user.getUser_bloodgroup());
                    System.out.println("Your address : "+user.getUser_address());
                    break;
                case 2:
                    System.out.print("Enter Name :");
                    String upadte_name = scanner.next();

                    System.out.print("Enter Phone no. :");
                    String  update_phoneno = scanner.next();

                    System.out.print("Enter Blood Group :");
                    String update_bloodgroup = scanner.next();

                    System.out.print("Enter Address :");
                    String upadte_address = scanner.next();
                    user.update_details(upadte_name,update_phoneno,update_bloodgroup,upadte_address);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }

        }
    }

    private static User register_user() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name :");
        String name = scanner.next();

        System.out.print("Enter Phone no. :");
        String  phoneno = scanner.next();

        System.out.print("Enter Blood Group :");
        String bloodgroup = scanner.next();

        System.out.print("Enter Address :");
        String address = scanner.next();

        User user = new User(name,phoneno,bloodgroup,address);
        return user;
    }

    private static class Authentication{
        private String user_email = "harshj.wappnet@gmail.com";
        private String user_password = "Harsh@123";

        private void authenticate_user(String email , String password){
            if (email.equals(user_email) && password.equals(user_password)){
                System.out.println();
                System.out.println("Authentication Sucessful Welcome to system");
                System.out.println();
            }
            else {
                System.out.println("Error email or password is wrong");
                System.exit(0);
            }
        }
    }
}

class User {
    private String user_name;
    private String user_phoneno;
    private String user_bloodgroup;
    private String user_address;

    public User(String user_name,String user_phoneno,String user_bloodgroup,String user_address){

        this.user_name = user_name;

        this.user_phoneno = user_phoneno;
        this.user_bloodgroup = user_bloodgroup;
        this.user_address = user_address;
    }

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

    void update_details(String update_name,String update_phone,String update_bloodgroup,String update_address){

        user_name = update_name;
        user_phoneno = update_phone;
        user_bloodgroup = update_bloodgroup;
        user_address = update_address;
    }
}