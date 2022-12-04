import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;


public class BankAccount {
    
    private static String bankName;
    private static String branchName;
    private static String ifsc;

    private Long accNum;
    private String accHName;
    private double balance;

    static{
        out.println("\nBank account class is loaded");
        try{Thread.sleep(1000);}
        catch(InterruptedException e){ }

        out.println("\nSV(Static variable) memory allocated with default value");
         try {Thread.sleep(1000);}
         catch (InterruptedException e) { }
        
        out.println("\nReading static variables from file and initalizing them");
         try {Thread.sleep(1000);}
         catch (InterruptedException e) { }
    
         try{
            /* connecting to file */
            BufferedReader filReader =new BufferedReader(new FileReader("bankDetails.txt"));
            /*Reading value from file and storing in static variables */
            bankName   = filReader.readLine();
            branchName = filReader.readLine();
            ifsc       = filReader.readLine();

            out.println("SV are initialized with the file value\n");
            try{Thread.sleep(1000);}
            catch(InterruptedException e) {}

         }catch(FileNotFoundException e){
            out.println("Error : bankDetails.txt file is not found");

         }catch(IOException e){
            e.printStackTrace();
         }
         try{Thread.sleep(1000);}
            catch(InterruptedException e) {}
    } /*static block close */

   {/*non static block for initialized accnum */
    out.println("NSV memory allocated");
    
    try{Thread.sleep(100);}
      catch(InterruptedException e){}

      out.println("Reading accNum value from the file and initialized it");
      try{Thread.sleep(100);}
      catch(InterruptedException e){}
      BufferedReader br = null;
      try{
        /* connecting to file */
        br = new BufferedReader(new FileReader("accNumSeq.txt"));

        /* reading accnumber converting and storing */
        Long oldaccNum= Long.parseLong(br.readLine());
        this.accNum  = oldaccNum + 1;
       
        out.println("accnum is initialized with file value");
        try{Thread.sleep(100);}
          catch(InterruptedException e){}
      }catch(FileNotFoundException e){
        System.out.println("accNumSeq.txt file not found");
      }catch(IOException e){
        e.printStackTrace();
      }finally{
        if(br!=null){
          try{br.close();}
          catch(IOException e){}
        }
      }
      /* saving new account number in file */
      FileWriter fileWriter = null;
      try{
        fileWriter = new FileWriter("accNumSeq.txt");
        fileWriter.write(""+this.accNum);
      }catch(FileNotFoundException e){
        System.out.println("accNumSeq.txt file in not found and unable create");
        
      }catch(IOException e){
        e.printStackTrace();
      }finally{
        if(fileWriter!=null){
          try{fileWriter.close();}
          catch(IOException e){ }
        }
      }

   } // non static block close
    

    public BankAccount(String accHName, double balance){
      out.println("Other NSVs are initalized with given values\n");
      try{Thread.sleep(1000);}
         catch(InterruptedException e){ }
      this.accHName = accHName;
      this.balance  = balance;

      out.println("NSVs are initalized with the given object values \n");
      try{Thread.sleep(1000);}
      catch(InterruptedException e){}

    } /* constructor close */

    public void setBankName(String bankName){
      BankAccount.bankName = bankName;
    }

    public static String getBankName() {
      return bankName;
    }
    public static void setBrachName(String branchName){
      BankAccount.branchName = branchName;
    }
    public static String getBranchName(){
      return branchName;
    }
    public static void setifsc(String ifsc){
      BankAccount.ifsc = ifsc;
    }
    public static String getifsc() {
      return ifsc;
    }
    public long getAccNum(){
      return accNum;
    }
    public void setAccHName(String accHName){
      this.accHName = accHName;
    }
    public String getAccHName(){
      return accHName;
    }
    public double getBalance(){
      return balance;
    }
    public void deposit(double amt){
      this.balance = this.balance + amt;
    }
    public void withdraw(double amt ){
      this.balance = this.balance - amt;
    }
    public void currentBalance(){
      out.println(balance);
    }

    public String toString(){
      return("\n bankName\t:"    +bankName)   + "\n" +
            (" branchName\t:"    +branchName) + "\n" +
            (" ifsc\t\t:"        +ifsc)       + "\n" +
            (" accNum\t\t:"      +accNum)     + "\n" +
            (" accHName\t:"      +accHName)   + "\n" +
            (" balance\t:"       +balance             );
    }

}
