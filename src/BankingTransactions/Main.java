package BankingTransactions;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;
  class SavingAccount {
      Scanner input1 = new Scanner(System.in);
      public int typeOfAccount;
      public String name;
      public int initialDeposit;
      public int accountNumber;
      public int newDeposit;
      public int deposit;

      public boolean checkCredentials(String promptedName, int promptedAccountNumber) {
          File folder = new File("D:/Backend//Clients/");
          String[] you = folder.list((dir, name) -> name.endsWith(promptedName + promptedAccountNumber + ".txt"));
          return you.length != 0;
      }

      public void writeTofile(String pathTofile, int content) {
          try {
              FileWriter writeToFile1 = new FileWriter(pathTofile);
              int ascii=content;
              writeToFile1.write(String.valueOf(ascii));
              writeToFile1.close();
          } catch (IOException e) {
              System.out.println("Error occured");
              e.printStackTrace();
          }
      }

      public int readFile(String pathTofile) {
          int lastLine = 0;
          try {
              File myfile = new File(pathTofile);
              Scanner contentFromFile = new Scanner(myfile);

              while (contentFromFile.hasNextLine()) {
                  lastLine = contentFromFile.nextInt();
              }
          } catch (IOException e) {
              System.out.println("Error occured");
              e.printStackTrace();
          }
          return lastLine;
      }


      public void createAccount() {
          System.out.println("Which type of account do you want \n1.Savings Account\n2.Checking Account");
          int choice = input1.nextInt();
          this.typeOfAccount = choice;

      }

      public void details() {
          input1.nextLine();


          System.out.print("Enter full Names:");
          String fullNames = input1.nextLine();
          this.name = fullNames;
          System.out.print("Enter initial deposit:");
          int initialDeposit = input1.nextInt();
          input1.nextLine();
          this.initialDeposit = initialDeposit;
          this.accountNumber = (int) (Math.random() * 10000);

          try {
              String filename = "D:/Backend//Clients/" + this.name + this.accountNumber + ".txt";
              File clientsFile = new File(filename);
              if (clientsFile.createNewFile()) {
                  System.out.print("Account created successfully\nThe account number is" + this.accountNumber);
                  writeTofile(filename, this.initialDeposit);
              } else {
                  System.out.println("The user already exists");
              }


          } catch (IOException e) {
              System.out.println("Error occured");
              e.printStackTrace();

          }

      }

      public void deposit() {

          while (true) {
              System.out.print("Enter your name:");
              String promptedName = input1.nextLine();
              System.out.print("Enter Your account number:");
              int promptedAccountNumber = input1.nextInt();
              input1.nextLine();

              boolean result = checkCredentials(promptedName, promptedAccountNumber);
              if (result) {
                  System.out.print("Amount you want to deposit:");
                  int promptedDeposit = input1.nextInt();
                  input1.nextLine();
                  this.newDeposit = promptedDeposit;
                  int currentDeposit = readFile("D:/Backend//Clients/" + promptedName + promptedAccountNumber + ".txt");
                  this.deposit = currentDeposit + this.newDeposit;
                  writeTofile("D:/Backend//Clients/" + promptedName + promptedAccountNumber + ".txt", this.deposit);
                  System.out.println("Amount deposited successfully, Total amount you have now is " + NumberFormat.getCurrencyInstance().format(this.deposit));
                  break;
              }

              System.out.println("Wrong credentials.Try again!");

          }

      }

      public void withdraw() {

          while (true) {
              System.out.print("Enter Your Full name:");
              String promptedName = input1.nextLine();
              System.out.print("Enter Your account number:");
              int promptedAccountNumber = input1.nextInt();
              boolean result = checkCredentials(promptedName, promptedAccountNumber);

              if (result) {
                  System.out.print("Enter the amount of money you want to withdraw:");
                  int withdrawingMoney = input1.nextInt();
                  int currentDeposit = readFile("D:/Backend//Clients/" + promptedName + promptedAccountNumber + ".txt");
                  this.deposit = currentDeposit;
                  if (withdrawingMoney > (this.deposit)) {
                      System.out.println("You can not withdraw amount of money greater than what you have");
                      break;
                  }
                  System.out.println("The new balance:" + (this.deposit - withdrawingMoney));
                  break;

              }
              System.out.println("Invalid account number.Try again!");
          }


      }
  }

      public class Main {

          public static void main(String[] args) {
              SavingAccount account = new SavingAccount();


              while (true) {
                  System.out.println("====================\nWelcome to Fast Bank\n====================\n1.Create account\n2.Deposit money\n3.Withdraw money\n4.Exit");
                  Scanner scanner = new Scanner(System.in);
                  int option = scanner.nextByte();
                  if (option == 4) {
                      break;
                  }
                  switch (option) {
                      case 1:
                          account.createAccount();
                          account.details();
                          break;
                      case 2:
                          account.deposit();
                          break;
                      case 3:
                          account.withdraw();
                          break;



                  }

              }


          }
      }
