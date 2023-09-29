import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
	
public class banking_system {

	    static double balance= 50000;
	    static String name= "groupone";
	    static String password= "123456";
	    static DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    static Date dateobj = new Date();
	    static String divider = "=======================================================";
	    
	    
	    /*Method Login*/
	    static void login() {
	        Scanner scanner = new Scanner(System.in);
	            System.out.print("                 username: ");
	            String username = scanner.nextLine();
	            System.out.print("                 password: ");
	            String userpassword = scanner.nextLine();
	            System.out.println(divider);
	        
	        if(username.equals(name) && userpassword.equals(password)){
	                System.out.println("                   ACCESS GRANTED!");
	                System.out.println(divider);
	                Transaction();
	        }else{
	                System.out.println("         Invalid Credentials, please try again!     ");
	                System.out.println("        =======================================");
	                login();
	        }
	    }
	    
	    
	    /*Method Transaction*/
	    static void Transaction() {
	        try (Scanner trans = new Scanner(System.in)) {
				System.out.println("   Good day " +name+ ", what do you like to do today? ");
				        System.out.println("[]                  [W]  Withraw                     []");
				        System.out.println("[]                  [D]  Deposit                     []");
				        System.out.println("[]                  [B]  Balance                     []");
				        System.out.println("[]                  [C]  Change Pin                  []");
				        System.out.println(divider);
				        System.out.print("                 ");
				        System.out.print("Chosen Transaction: ");
				        String choice= trans.nextLine();
				        System.out.println(divider);
				
				    
				    if (choice.equalsIgnoreCase("W")){
				        Withdraw();
				    }
				    else if (choice.equalsIgnoreCase("D")){
				        Deposit();
				    }
				    else if (choice.equalsIgnoreCase("B")){
				        Balance();
				    }
				    else if (choice.equalsIgnoreCase("C")){
				        ChangePin();
				    }
				    else {
				        System.out.println("                       Wrong Input!");
				        System.out.println(divider);
				        Transaction();
				}
			}
	        
	    }
	    
	    
	    /* Method Withdraw */
	    static void Withdraw() {
	        try (Scanner w = new Scanner(System.in)) {
				System.out.println("       Please insert amount in multiples of 10.");
				System.out.print("                      Amount: P");
				
				double withdrawalAmount = 0;
				double minimum = 200;
				double maximum = 25000;
				
				if(w.hasNextDouble()) {
				    withdrawalAmount = w.nextDouble();
				    if(withdrawalAmount>balance){
				        System.out.println("                =========================");
				        System.out.println("          Sorry, you don't have enough balance,"); 
				        System.out.println("           your current balance is P" +balance);
				        System.out.println("                    Please try again!");
				        System.out.println("                =========================");
				        Withdraw();
				    }else if ( withdrawalAmount % 10 != 0 ){
				        System.out.println("                =========================");
				        System.out.println("                I'm sorry, amount should ");
				        System.out.println("                 be in multiples of 10");
				        System.out.println("                =========================");
				        Withdraw();
				    }else if(withdrawalAmount > maximum) {
				        System.out.println("                =========================");
				        System.out.println("            I'm sorry, the maximum amount per");
				        System.out.println("         transaction is P25000. Please Try again.");
				        System.out.println("                =========================");
				        Withdraw();
				    }else if (withdrawalAmount < minimum) {
				        System.out.println("                =========================");
				        System.out.println("            I'm sorry, the minimum amount per");
				        System.out.println("         transaction is P200. Please Try again.");
				        System.out.println("                =========================");
				        Withdraw();
				    }else {
				        balance = balance-withdrawalAmount;
				        System.out.println(divider); 
				        System.out.println("      P" +withdrawalAmount+ " has been successfully deducted from      ");
				        System.out.println("                 your initial balance.               ");
				        System.out.println("              CURRENT BALANCE: P" +balance+ "            ");
				        System.out.println("                   "+df.format(dateobj));
				        conTransaction();
				    }
				    
				}else {
				    System.out.println("                =========================");
				    System.out.print("                      Error input!\n");
				    System.out.println("                =========================");
				    Withdraw();
				}
			}
	    }
	
	
	/* Method Deposit */
    static void Deposit() {
        try (Scanner d = new Scanner(System.in)) {
			System.out.println("       Please insert amount in multiples of 10.");
			System.out.print("                      Amount : P");
			double depositAmount = 0;
			double minimum = 200;
			if(d.hasNextDouble()) {
			    depositAmount= d.nextDouble();
			    if (depositAmount % 10 != 0){
			            System.out.println("                =========================");
			            System.out.println("                I'm sorry, amount should ");
			            System.out.println("                 be in multiples of 10");
			            System.out.println("                =========================");
			            Deposit();
			    }else if (depositAmount < minimum) {
			            System.out.println("                =========================");
			            System.out.println("            I'm sorry, the minimum amount per");
			            System.out.println("         transaction is P200. Please Try again.");
			            System.out.println("                =========================");
			            Deposit();
			    }else {
			            balance = balance + depositAmount;
			            System.out.println(divider); 
			            System.out.println("        P" +depositAmount+ " has been successfully added to      ");
			            System.out.println("                   your initial balance.               ");
			            System.out.println("                CURRENT BALANCE: P" +balance+ "            ");
			            System.out.println("                    "+df.format(dateobj));
			            conTransaction();
			    }
			}else{
			    System.out.println("                =========================");
			    System.out.print("                       Error input\n");
			    System.out.println("                =========================");
			    Deposit();
			}
		}

    }
        
    
    /* Method Balance */
    static void Balance() {
        System.out.println("                 Account Name: "+ name);
        System.out.println("               Current balance: P" +balance);
        System.out.println("                   "+df.format(dateobj));
        conTransaction();
    }
        
    
   /* Method Change Pin */
    static void ChangePin(){
         try (Scanner cp = new Scanner(System.in)) {
			int digCount = 0, letlowCount = 0, letupCount = 0;
			 
			 System.out.print("                  Enter new pin: ");
			 String newPin = cp.nextLine();
			
			 for (int i=0; i<newPin.length(); i++)
			
			    if (Character.isDigit(newPin.charAt(i))){
			    digCount++;
			    }else if (Character.isLowerCase(newPin.charAt(i))){
			    letlowCount++;
			    }else if (Character.isUpperCase(newPin.charAt(i))){
			    letupCount++;
			    }
			
			
			if (digCount != 6){
			    System.out.println("                =========================");
			    System.out.println("   Pin must be 6 digits long and not contain letters!");
			    System.out.println("                    Please try again.");
			    System.out.println("                =========================");
			    ChangePin();
			}
			else if (0 < letlowCount){
			    System.out.println("                =========================");
			    System.out.println("   Pin must be 6 digits long and not contain letters!");
			    System.out.println("                    Please try again.");
			    System.out.println("                =========================");
			    ChangePin();
			}
			else if (0 < letupCount){
			    System.out.println("                =========================");
			    System.out.println("   Pin must be 6 digits long and not contain letters!");
			    System.out.println("                    Please try again.");
			    System.out.println("                =========================");
			    ChangePin();
			}
			else{
			    System.out.println("                =========================");
			     System.out.print("                 Confirm new pin: ");
			     String newPin2 = cp.nextLine();
			
			    if(newPin.equals(newPin2)){
			        System.out.println("                =========================");
			    System.out.println(" Congratulations, your pin has been updated to " + newPin + "!"); 
			    password = newPin;
			    conTransaction();
			    } else{
			    System.out.println("                =========================");
			    System.out.println("           Pin doesn't match, please try again!");
			    System.out.println("                =========================");
			    ChangePin();
			    }
			}
		}
     }
        
        
    static void conTransaction(){
        try (Scanner ct = new Scanner(System.in)) {
			System.out.println(divider);
			System.out.println("[]  Thank you for your transaction. Do you want to   []");
			System.out.println("[]               do another transaction?             []");
			System.out.println("[]                 [Y] yes or [N] no?                []");
			System.out.println(divider);
			System.out.print("                           ");
			char cont= ct.next().charAt(0);
			System.out.println(divider);
			    if (cont == 'Y' || cont == 'y'){
			        Transaction();
			    }
			    else if (cont == 'N' || cont == 'n'){
			        
			        System.exit(0);  
			    }
			    else{
			        System.out.println("                        Wrong Input!");
			        conTransaction();
			    }
		}
    }

 
	
	public static void main(String[] args) {
		System.out.println(divider);
        System.out.println("[]          Hello, good day my dear client!          []");
        System.out.println("[]           Welcome to Programmer's Bank,           []");
        System.out.println("[]         your life, your money, your bank!         []");
        System.out.println("[]                  "+df.format(dateobj)+"                []");
        System.out.println(divider);
        System.out.println("                 Log-in to your account!    ");
        System.out.println("                =========================");
        login();
	}

}
