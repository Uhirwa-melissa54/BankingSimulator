
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;
  class SavingAccount{
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
    public void details() {
        input1.nextLine();


        System.out.print("Enter full Names:");
        String fullNames = input1.nextLine();
        this.name = fullNames;
        System.out.print("Enter initial deposit:");
        int initialDeposit = input1.nextInt();
        this.initialdeposit = initialDeposit;
        this.accountNumber = (int) (Math.random() * 10000);

        try {
            File clientsFile = new File("D:/Backend//Clients/" + this.name + this.accountNumber);
            if (clientsFile.createNewFile()) {
                System.out.println("Account created successfully\nThe account number is" + this.accountNumber);
            } else {
                System.out.println("The user already exists");
            }


        } catch (IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();

        }
//        try {
//
//            FileWriter writeToFile = new FileWriter("D:/Backend//Clients/" + this.name + this.accountNumber);
//            writeToFile.write(this.accountNumber);
//
//        }
//        catch(IOException e){
//            System.out.println("Error occured");
//            e.printStackTrace();
//        }
    }

        public void deposit() {
            while (true) {
                System.out.print("Enter your name");
                String promptedName=input1.nextLine();
                System.out.print("Enter Your account number:");
                int promptedAccountNumber = input1.nextInt();

                File folder=new File("D:/Backend//Clients/");
                String[] you=folder.list((dir,name)->name.endsWith(promptedName+promptedAccountNumber));

                if (promptedAccountNumber == this.accountNumber) {
                    break;


                }

            }
            System.out.print("Amount you want to deposit:");
            int promptedDeposit = input1.nextInt();
            this.newDeposit = promptedDeposit;
            this.deposit = this.initialdeposit + this.newDeposit;
            System.out.println("Amount deposited successfully, Total amount you have now is " + NumberFormat.getCurrencyInstance().format(deposit))
        ;
            this.deposit = this.initialdeposit + this.newDeposit;
        }
    public void withdraw(){
        while(true) {
            System.out.print("Enter Your account number:");
            int promptedAccountNumber = input1.nextInt();
            if (promptedAccountNumber == this.accountNumber) {
                break;

            }
            System.out.println("Invalid account number.Try again!");
        }
        System.out.print("Enter the amount of money you want to withdraw:");
        int withdrawingMoney=input1.nextInt();
        if(withdrawingMoney > (this.deposit)){
            System.out.println("You can not withdrew amount on money greater than what you have");
        }
        System.out.println("The new balance:"+ (this.deposit-withdrawingMoney));


    }
}

public class Main{

    public static void main(String[] args){
        SavingAccount account=new SavingAccount();


        while(true){
            System.out.println("====================\nWelcome to Fast Bank\n====================\n1.Create account\n2.Deposit money\n3.Withdraw money\n4.Exit");
            Scanner scanner=new Scanner(System.in);
            int option=scanner.nextByte();
            if(option==4){
                break;
            }
            switch(option){
                case 1:
                    account.createAccount();
                    account.details();
                    break;
                case 2:
                    account.deposit();
                case 3:
                    account.withdraw();


            }

        }


    }
}