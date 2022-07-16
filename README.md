# Week 3 - Task
### Intro:
### Challenge
Your task is to create a console application that model’s a Bank and its operations using OOP concepts 
and SOLID principles with a Design Pattern of your choice.
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
This task is aimed at evaluating your understanding and implementation of OOP
rules and SOLID principles with Design Architecture.
Task requirements
- No database is required for this project. Use any of the data structures you feel appropriate
- All functional requirements should be completed.
- Task should be submitted on or before 4pm Wednesday, 11th July 2022.
- Submissions should be made to this GitHub classroom link:
  https://classroom.github.com/a/XX0dKYvs
  Functional requirements
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
  Marking Scheme
  Follow the rubric marking system
  Minus 5 marks for those who failed to handle errors in their work Add 5 marks for good folder structure and modelling