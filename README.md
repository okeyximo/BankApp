# Week 3 - Task


### Intro:
### Challenge
Your task is to create a console application that model’s a Bank and its operations using OOP concepts 
and SOLID principles with a Design Pattern of your choice.
### Usage
- download the jar file,
- cd to the application dir on your commandline
- Run on application using the following command
  `java -jar BankApp.jar`
### User story
The result should be displayed in a tabular form as shown below:
ACCOUNT DETAILS
|-------------------|-------------------------------|--------------------------|---------------------|
| FULL NAME | ACCOUNT NUMBER | ACCOUNT TYPE | AMOUNT BAL |
|-------------------|-------------------------------|--------------------------|---------------------|
| John Doe | 0987654321 | Savings | 10,000 | |------------------- --------------------------------------------------------------------------------- |
| John Doe | 0987654311 | Current | 100,000 | |-------------------- --------------------------------------------------------------------------------|
ACCOUNT STATEMENT ON ACCOUNT NO 0987654321
|-------------------|-------------------------------|--------------------------|---------------------|
| DATE | DESCRIPTION | AMOUNT | BALANCE |
|-------------------|-------------------------------|--------------------------|---------------------|
| 14/07/2021 | Use a USSD code | 1,000 | 10,000 | |------------------- ---------------------------------------------------------------------------------|
| 10/07/2021 | Atm Trft from Agege | 20000 | 100,000 | |-------------------- --------------------------------------------------------------------------------|
- This task is aimed at evaluating your understanding and implementation of OOP
rules and SOLID principles with Design Architecture.
### Task requirements
- No database is required for this project. Use any of the data structures you feel appropriate
- All functional requirements should be completed.

### Functional requirements
- A customer should be able to login.
- A customer should be able to create an account or multiple accounts (savings or current).
- A customer should be able to deposit money into his account.
- A customer should be able to withdraw money from his account.
- A customer should be able to get the balance of a particular account.
- A customer should be able to transfer money between accounts.
- A customer should be able to get his statement of account (Account Details and Statements).
- A customer should be able to logout.
  Required Validations
- Account owners can not withdraw past the minimum balance for a savings account (1000 Naira).
- Account owners can empty their account ONLY for a current account.
- Customer names (first and last) should be sanitized so that it does not start with a digit or a small letter
- Email address should be in the valid format else user should be prompted to re-enter
- Password should be minimum 6 characters that include alphanumeric and at least one special characters (@, #, $, %, ^, &, !)
  


### Bugs 
- Have not handled the input mismatch exception on the input amount
- Have not fixed the admin panel
- Yet to create a table for the transaction list

- Report any bugs you encountered while using the application.
### Author
- Okechukwu Onwuchekwa
- onwuchekwaokechukwu57@gmail.com