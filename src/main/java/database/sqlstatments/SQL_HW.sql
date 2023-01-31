/*INSERT STATMENTS*/

INSERT INTO employee (firstname, lastname)
VALUES ("David","Duran");

INSERT INTO employee (firstname, lastname)
VALUES ("John","Miller");

INSERT INTO employee (firstname, lastname)
VALUES ("Sarah","Price");

INSERT INTO employee (firstname, lastname)
VALUES ("Erin","Sennet");


INSERT INTO account_type (account_type_id,account_type_description)
VALUES (1,"Savings account");

INSERT INTO account_type (account_type_id,account_type_description)
VALUES (2,"Checking account");

INSERT INTO account_type (account_type_id,account_type_description)
VALUES (3,"Fixed deposit account");


INSERT INTO account_status_type (account_status_type_id,account_status_type_description)
VALUES (1,"active");

INSERT INTO account_status_type (account_status_type_id,account_status_type_description)
VALUES (2,"inactive");

/*account table*/
INSERT INTO account (current_balance, account_type_id, account_status_type_id)
VALUES (200.00,1,2);

INSERT INTO account (current_balance, account_type_id, account_status_type_id)
VALUES (350.00,1,2);

INSERT INTO account (current_balance, account_type_id, account_status_type_id)
VALUES (500.00,1,2);



INSERT INTO customer (account_id,firstname,lastname,address,email_address,phone,ssn)
VALUES (111,"Frank","Ghalagher","2323 W Fargo ave","frank@gmail.com","7741231234","123123123");

INSERT INTO customer (account_id,firstname,lastname,address,email_address,phone,ssn)
VALUES (222,"Hacer","Turan","7120 W Sheridan road","hazer@gmail.com","7741235324","347683464");

INSERT INTO customer (account_id,firstname,lastname,address,email_address,phone,ssn)
VALUES (125,"Emilly","Swan","2356 N Sammerdale ave","emy@gmail.com","7741235111","678683464");

INSERT INTO customer (account_id,firstname,lastname,address,email_address,phone,ssn)
VALUES (234,"Sam","Smith","1111 E Sannyside ave","sam@gmail.com","1231235111","347883464");


INSERT INTO transaction_type(transaction_type_name, transaction_type_description, transaction_fee)
VALUES ("Wire transfer","Electronically","00.99");

INSERT INTO transaction_type(transaction_type_name, transaction_type_description, transaction_fee)
VALUES ("Debit card","debit accounts","1.00");


INSERT INTO transactions(transaction_date, transaction_amount,
 new_balance, account_id, employee_id, transaction_type_id)
 VALUES ('2012-05-01', 100.00, 100.00, 10, 1, 1);
 
 INSERT INTO transactions(transaction_date, transaction_amount,
 new_balance, account_id, employee_id, transaction_type_id)
 VALUES ('2013-01-02', 500.00, 500.00, 10, 2, 2);
 
 INSERT INTO transactions(transaction_date, transaction_amount,
 new_balance, account_id, employee_id, transaction_type_id)
 VALUES ('2022-08-12', 350.00, 450.00, 10, 2, 1);
 

 /*---- UPDATE STATMENTS -----*/
 
UPDATE employee SET firstname = "Alex"
WHERE id = 2;

UPDATE customer SET address = "123 Main st"
WHERE id = 1;

UPDATE employee SET lastname = 'Knapp'
WHERE id = 1;
    
UPDATE transactions SET account_id = 13
WHERE transaction_id = 3;
 
 UPDATE transactions SET account_id = 14
 WHERE transaction_id = 2;
 
 UPDATE transaction_type SET transaction_type_description = "Debit account"
 WHERE transaction_type_id = 2;
 
 UPDATE transaction_type SET transaction_fee = "0.99"
 WHERE transaction_type_id = 1;
 
 UPDATE account SET current_balance = 500
 WHERE account_id = 10;
 
 UPDATE customer SET account_id = 10
 WHERE id = 2;
 
UPDATE customer SET account_id = 13
WHERE id = 1;
 
UPDATE account SET account_status_type_id = 1
WHERE account_id = 13;
 
UPDATE customer SET account_id = 14
WHERE id = 3;
 
UPDATE customer SET email_address = "emillys@gmail.com"
WHERE id = 3;
 
ALTER TABLE customer ADD zip_code INT NOT NULL AFTER address;

ALTER TABLE customer MODIFY zip_code bigint;

ALTER TABLE customer DROP COLUMN zip_code;

/* Join all tables*/

SELECT * from customer 
inner join account 
	on customer.account_id = account.account_id
inner join transactions
	on customer.account_id = transactions.account_id
    and account.account_id = transactions.account_id
inner join account_type
	on account.account_type_id = account_type.account_type_id
inner join account_status_type
	on account.account_status_type_id=account_status_type.account_status_type_id
inner join employee 
	on transactions.employee_id = employee.id
inner join transaction_type
	on transactions.transaction_type_id = transaction_type.transaction_type_id;


SELECT * from customer 
right join account 
on customer.account_id = account.account_id;

SELECT * from customer 
left join account 
on customer.account_id = account.account_id;

SELECT * from employee 
inner JOIN transactions 
	on employee.id = transactions.employee_id;
    
SELECT * from employee 
left JOIN transactions 
	on employee.id = transactions.employee_id;
    
 
 SELECT 
    firstname, lastname, account.current_balance
FROM
    customer
        INNER JOIN
    account ON customer.account_id = account.account_id;


SELECT 
    firstname, lastname, account.current_balance
FROM
    customer
        INNER JOIN
    account ON customer.account_id = account.account_id
WHERE
    current_balance = (SELECT 
            MAX(current_balance)
        FROM
            account)
ORDER BY firstname;

SELECT 
    firstname, lastname, account.current_balance
FROM
    customer
        INNER JOIN
    account ON customer.account_id = account.account_id
WHERE
    current_balance = (SELECT 
            MIN(current_balance) 
        FROM
            account)
ORDER BY firstname;


SELECT 
    firstname, lastname, account.current_balance
FROM
    customer
        INNER JOIN
    account ON customer.account_id = account.account_id
    HAVING current_balance > 400;


SELECT 
    account_id, AVG(current_balance)
FROM
    account
GROUP BY account_id
HAVING MIN(current_balance) < 500;


DELETE FROM employee 
WHERE id = 8;

DELETE FROM customer 
WHERE id = 2;

DELETE FROM account_type 
WHERE
    account_type_id = 3;



