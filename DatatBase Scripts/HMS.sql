Create database HMS;
USE HMS;

 
 create table USER(id int primary key ,username varchar(50),password varchar(30),usertype varchar(30));
insert into user values(1,'Executive1@hms','Executive@123','executive');
insert into user values(2,'Pharmacist1@hms','Pharmacist@123','pharmacist');
insert into user values(4,'Diagnostic1@hms','Diagnostic@123','diagnostic');



CREATE TABLE MASTERTESTS(id int primary key auto_increment, test_name varchar(30) , rate int);

insert into MASTERTESTS(test_name , rate) values('ECG',1000);
insert into MASTERTESTS(test_name , rate) values('EMR',3000);
insert into MASTERTESTS(test_name , rate) values('BLOODTEST',500);
insert into MASTERTESTS(test_name , rate) values('CT',3500);


CREATE TABLE MASTERMEDICINE(ID INT primary key auto_increment ,NAME VARCHAR(40) unique, QUANTITY INT , PRICE INT);
INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Aciclovir tab 200 mg',1000,50);
INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Amitriptyline tab 25 mg',2000,100);
INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Beclomethasone inhaler 50 mg/dose',2000,60);


INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Ranitidine tab 150 mg',2000,100);

INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Phenytoin tab 100 mg',9000,180);

INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Ciprofloxacin tab 500 mg',2000,300);
INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Fluoxetine tab 20 mg',5000,200);
INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Metformin tab 500 mg',3000,10);
INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Zidovudine cap 100 mg',4000,100);

INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Glibenclamide tab 5 mg',2000,300);
INSERT INTO MASTERMEDICINE(NAME ,QUANTITY , PRICE ) VALUES('Diazepam tab 5mg',5000,200);











