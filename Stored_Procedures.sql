CREATE TABLE Accounts (
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    account_type VARCHAR2(20),
    balance NUMBER
);

CREATE TABLE Employees (
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(50),
    department VARCHAR2(30),
    salary NUMBER
);
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'Savings';

    COMMIT;
END;
/
/*Senario 1*/
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'Savings';

    COMMIT;
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/

/*Senario 2*/
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET salary = salary + (salary * p_bonus_percentage / 100)
    WHERE department = p_department;

    COMMIT;
END;
/
BEGIN
    UpdateEmployeeBonus('HR',10);
END;
/
/*Senario 3*/
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_source_account IN NUMBER,
    p_destination_account IN NUMBER,
    p_amount IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN

    SELECT balance
    INTO v_balance
    FROM Accounts
    WHERE account_id = p_source_account;

    IF v_balance >= p_amount THEN

        UPDATE Accounts
        SET balance = balance - p_amount
        WHERE account_id = p_source_account;

        UPDATE Accounts
        SET balance = balance + p_amount
        WHERE account_id = p_destination_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');

    END IF;

END;
/
BEGIN
    TransferFunds(101,102,500);
END;
/
