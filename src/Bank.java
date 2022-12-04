import java.util.Scanner;


public class Bank {
    private BankAccount[] accounts;
    private int size;
    private Scanner scanner;
     public Bank() {
        accounts = new BankAccount[10];
        size = 0;
        scanner = new Scanner(System.in);

        /*try {
            BufferedReader accNumReader = new BufferedReader(new FileReader("accNumSeq.txt"));
            Long accNumSeq = Long.parseLong(accNumReader.readLine());
            new AtomicLong(accNumSeq);

        } catch (FileNotFoundException e) {
            System.out.println("accNumSeq.txt is not found");
            
        }catch(IOException e){
            e.printStackTrace();
        }*/
    }

    private void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public void OpenAccount() {
        System.out.println("Enter account holder name:");
        String accHName = scanner.nextLine();

        System.out.println("Enter balance :");
        double balance = scanner.nextDouble(); scanner.nextLine();

        System.out.println("BanckAccount object creation started....");
        pause();

        BankAccount account = new BankAccount(accHName, balance);
        System.out.println("Bank Object is created");
        pause();

        accounts[size++] = account;
        System.out.println("Bank Account object is stored in bank");
        pause();

    }/* open sccount method is close */

    private BankAccount getAccount(long accNum) throws IllegalArgumentException {
        if (accNum <= 0) 
            throw new IllegalArgumentException("Account number can not be -ve number and zero");

            System.out.println("Searching for given Account Number :");
            pause();
            // linear search algorithm
            for (int i = 0; i < size; i++) {
                BankAccount account = accounts[i];
                if (account.getAccNum() == accNum)
                    return account;
                
            }
        
        return null;
    }

    private boolean ampuntZeroOrNegative(double amt) {
        return amt < 0;
    }

    private boolean amountGreterThanBalance(BankAccount account, double amt) {
        return amt > account.getBalance();
    }

    public void deposit(long accNum, double amt) throws IllegalArgumentException {
        System.out.println("Deposit operation start");
        pause();

        /* reteriving the bank aoount object of the given number */

        BankAccount account = getAccount(accNum);

        // checking account and balance are valid or not
        if (account == null) 
            throw new IllegalArgumentException(
                    "Account not found with the given account number");

            if (amt <= 0) 
                throw new IllegalArgumentException("amount can not be -ve and zero");

                // deposit given amount in given account
                account.deposit(amt);
                System.out.println("Cash RS:" + amt + "is created to your account");

                pause();
                
    }// deposit close
    public void withdraw(long accNum, double amt)throws IllegalArgumentException{
        System.out.println("Withdraw operation start");
        pause();
        
        /*Retriving the bankaccount object of the given account number */
        BankAccount account = getAccount(accNum);
        
        /*checking account and balance are valid or not */
        if(account == null)
                    throw new IllegalAccessError(
                        "Account not found with the given details");
          if(amt<=0)
          throw new IllegalAccessError(
            "Amount cannot be -ve or zero");

            if(amt>account.getBalance())
                                throw new IllegalAccessError(
                                        "Insufficient fund");
            account.withdraw(amt);
            System.out.println("Cash RS : "+amt+ "is debited from your account");
            pause();

    } /*close withdraw */

    public void balanceEnquiry(long accNum){
        System.out.println("Balance enquiry operation start");
        pause();
        /*retriving the bank account object of the given account number */
        BankAccount account  = getAccount(accNum);
        /*checking account and balance valid or not  */
        if(account== null)
                        throw new IllegalArgumentException(
                            "Account is not found with the given details");
        System.out.println("Current balance :");
        account.currentBalance();
        pause();
    } /*balance enqurry close */
    public void transferMoney(long srcAccNum, long dstAccNum, double amt)throws IllegalArgumentException{
        System.out.println("Transfer money operation start");
        pause();

        withdraw(srcAccNum, amt);
        deposit(dstAccNum, amt);
        System.out.println("Transfer money operation end");
        pause();
    } /*transfer close */

    public void updateAccount(long accNum){
        // create by yourself
    }
    public void closeAcoount(long accNum)throws IllegalArgumentException{
        System.out.println("Close account operation start");
        pause();

        if(accNum<=0)
            throw new IllegalArgumentException(
                "account can not be -ve and zero");
        
        System.out.println("Searching for given account number");
        pause();

        //linear search algorithm
        for(int i =0; i<size; i++){ // for finding bank account with the given accnum
            BankAccount account = accounts[i];

            if(account.getAccNum()==accNum){
                for(int j =0; j<size -1; j++){
                    /* retriving current loaction object by moving next object one location */
                    accounts[j] = accounts[j+1];
                }
                accounts[size-1] = null;
                size--;
                System.out.println("account is closed");
                pause();
                return;
            }
        }// loop closed
        throw new IllegalArgumentException("account not found with the given details");
    
    }// close account end

    public void displayAccount(long accNum)throws IllegalArgumentException{
        System.out.println("Display account operation start");
        pause();

        /*Retriving bank account object for the given details */
        BankAccount account = getAccount(accNum);

        /*checking account and balance are valid or not */
        if(account==null)
            throw new IllegalArgumentException("Account is not found with the given details");
            System.out.println("Account details");
            System.out.println(account);
        
    } // display account close

    @Override
    public String toString(){
        StringBuilder accountsBuilder = new StringBuilder();

        if(size == 0)
        return "NO account found";

        for(int i =0; i<size; i++){
            accountsBuilder.append("\nAccount "+(i+1)+" Details :");
            accountsBuilder.append(accounts[i]+"\n");

        }
        return accountsBuilder.toString();
    
    }
}
