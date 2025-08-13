# Fast Banking Simulator

## Project Overview
A fast banking simulator built in Java using Object-Oriented Programming (OOP).  
It allows users to create accounts, deposit and withdraw money, check balances, and maintain transaction history through a console interface.

## Features
- Create Savings and Checking accounts  
- Deposit and withdraw money with validation  
- Check account balances  
- Persistent storage using files  
- User login system  
- Data persists between program runs  

## Technologies Used
- Java SE  
- OOP concepts: classes, inheritance, encapsulation  
- Console input/output with `Scanner`  
- File handling with `File`, `FileWriter`, `BufferedReader`, and `Scanner`  

## How It Works
1. **Account Creation:** User enters their name and chooses account type. An account number is generated and account data is saved to a file.  
2. **Login:** Users enter their account number to access their account. Program reads the corresponding file to load account information.  
3. **Transactions:** Users can deposit or withdraw money. Updated balances are written back to the account file.  
4. **Persistence:** All account information and transaction data are saved in files. Users can log out and return later without losing their data.

