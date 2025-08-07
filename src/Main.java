
import java.util.Scanner;

public class SavingAccount{
    Scanner input1=new Scanner(System.in);
    public int typeOfaccount;
    public String name;
    public int initialdeposit;
    public int accountNumber;
    public int newDeposit;
    public int deposit;


    public void createAccount(){
        System.out.println("Which type of account do you want \n1.Savings Account\n2.Checking Account");
        int choice=input1.nextInt();

        this.typeOfaccount=choice;

    }
    public void details(){


        System.out.print("Enter full Names:");
        String fullNames=input1.nextLine();
        this.name=fullNames;
        System.out.println("Enter initial deposit");
        int initialDeposit=input1.nextInt();
        this.initialdeposit=initialDeposit;
        this.accountNumber=(int)(Math.random() *10000);
        System.out.println("Account created successfully\nThe account number is" + this.accountNumber);

    }
        public void deposit(){
        System.out.print("Enter Your account number:");
        int promptedAccountNumber=input1.nextInt();
        if(promptedAccountNumber!=this.accountNumber){
            System.out.println("Invalid account number");

        }
            System.out.print("Amount you want to deposit:");
            int promptedDeposit=input1.nextInt();
            this.newDeposit=promptedDeposit;
            this.deposit=this.initialdeposit + this.newDeposit;
            System.out.println("Amount deposited successfully, Total amount you have now" + this.deposit);
            this.deposit=this.initialdeposit + this.newDeposit;
    }
    public void withdraw(){
        System.out.print("Enter Your account number:");
        int promptedAccountNumber=input1.nextInt();
        if(promptedAccountNumber!=this.accountNumber){
            System.out.println("Invalid account number");

        }
        System.out.println("Enter the amount of money you want to withdraw");
        int withdrawingMoney=input1.nextInt();
        if(withdrawingMoney > (this.deposit)){
            System.out.println("You can not withdrew amount on money greater than what you have");
        }
        System.out.println("The new balance"+ (this.deposit-withdrawingMoney));


    }
}

public class Main{

    public static void main(String[] args){


    }
}