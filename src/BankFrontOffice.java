import java.util.Scanner;

public class BankFrontOffice {
    public static void main(String[] args){
        Bank hdfcBank = new Bank();

        Scanner scn = new Scanner(System.in);

        loop: while(true){
                try{
                    System.out.println("\nChoose one option");
                    System.out.println(" 1. OpenAccount");
                    System.out.println(" 2. Account Details");
                    System.out.println(" 3. Deposit");
                    System.out.println(" 4. Withdraw");
                    System.out.println(" 5. Balance Enquiry");
                    System.out.println(" 6. Transfer Money");
                    System.out.println(" 7. Display All Accounts");
                    System.out.println(" 8. Close account");
                    System.out.println(" 9. Exit");

                    System.out.println("Enter Option : ");
                    int option = scn.nextInt(); scn.nextLine();

                    switch (option) {
                        case 1:{ // Open Account
                            hdfcBank.OpenAccount();
                            break;
                        }
                        case 2:{ // Account Details
                            System.out.println("Enter Account number :");
                            long accNum = scn.nextLong(); scn.nextLine();
                            hdfcBank.displayAccount(accNum);
                            break;
                        }
                        case 3: { // Deposit
                            System.out.println("Enter Account number :");
                            long accNum = scn.nextLong(); scn.nextLine();

                            System.out.println("Enter Deposit amount :");
                            double amt = scn.nextDouble(); scn.nextLine();

                            hdfcBank.deposit(accNum,amt);
                            break;
                        }
                        case 4: { // withdraw
                            System.out.println("Enter Account number :");
                            long accNum = scn.nextLong(); scn.nextLine();
                            
                            System.out.println("Enter Withdraw amount :");
                            double amt = scn.nextDouble(); scn.nextLine();

                            hdfcBank.withdraw(accNum,amt);
                            break;
                        }                
                        case 5: { //Balance enquiry
                            System.out.println("Enter Account number :");
                            long accNum = scn.nextLong(); scn.nextLine();

                            hdfcBank.balanceEnquiry(accNum);
                            break;
                        }
                        case 6: { //Transfer money
                            System.out.println("Enter Source Account number :");
                            Long srcAccNum = scn.nextLong(); scn.nextLine();

                            System.out.println("Enter dest Account number :");
                            Long dstAccNum = scn.nextLong(); scn.nextLine();

                            System.out.println("Enter Deposit amount :");
                            double amt = scn.nextDouble(); scn.nextLine();

                            hdfcBank.transferMoney(srcAccNum, dstAccNum, amt);
                            break;
                        }
                        case 7: { // Display all account
                            System.out.println(hdfcBank);
                            break;    
                        }
                        case 8: {
                        	System.out.println("Enter account number");
                        	Long accNum = scn.nextLong(); scn.nextLine();
                        	hdfcBank.closeAcoount(accNum);
                        }
                        case 9: { // Exit
                            System.out.println("_/\\__/\\__/\\_ Thank You, Please Visit Again _/\\__/\\__/\\_");
                            break;
                        }
                        default:
                            System.out.println("Invalid Option !");
                            break;
                    } // switch end
                }catch (IllegalArgumentException e){
                        System.out.println("Error :"+ e.getMessage());

            }
        }//while end
    } // main close
} // class close
