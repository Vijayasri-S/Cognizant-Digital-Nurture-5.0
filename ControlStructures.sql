
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER,
    IsVIP CHAR(1)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER,
    DueDate DATE,
    CONSTRAINT fk_customer
        FOREIGN KEY (CustomerID)
        REFERENCES Customers(CustomerID)
);
INSERT INTO Customers VALUES (1, 'Alice', 65, 15000, 'N');
INSERT INTO Customers VALUES (2, 'Bob', 45, 8000, 'N');
INSERT INTO Customers VALUES (3, 'Charlie', 70, 12000, 'N');
INSERT INTO Customers VALUES (4, 'David', 30, 5000, 'N');
INSERT INTO Customers VALUES (5, 'Eva', 62, 20000, 'N');


INSERT INTO Loans VALUES (101, 1, 8.5, DATE '2026-07-20');
INSERT INTO Loans VALUES (102, 2, 9.2, DATE '2026-08-25');
INSERT INTO Loans VALUES (103, 3, 7.8, DATE '2026-07-12');
INSERT INTO Loans VALUES (104, 4, 10.0, DATE '2026-10-15');
INSERT INTO Loans VALUES (105, 5, 8.0, DATE '2026-07-28');

COMMIT;
SET SERVEROUTPUT ON;

---------------------------------------------------------
-- Scenario 1
-- Apply a 1% discount on loan interest rates
-- for customers above 60 years old.
---------------------------------------------------------

DECLARE
BEGIN
    FOR customer_rec IN (
        SELECT c.CustomerID,
               c.Age,
               l.LoanID,
               l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
    )
    LOOP
        IF customer_rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = customer_rec.LoanID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Scenario 1 Completed');
END;
/

---------------------------------------------------------
-- Scenario 2
-- Promote customers to VIP
-- if balance exceeds 10000.
---------------------------------------------------------

DECLARE
BEGIN
    FOR customer_rec IN (
        SELECT CustomerID,
               Balance
        FROM Customers
    )
    LOOP
        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Scenario 2 Completed');
END;
/

---------------------------------------------------------
-- Scenario 3
-- Print reminder messages
-- for loans due within the next 30 days.
---------------------------------------------------------

DECLARE
BEGIN
    FOR loan_rec IN (
        SELECT c.Name,
               l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan payment for '
            || loan_rec.Name
            || ' is due on '
            || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
