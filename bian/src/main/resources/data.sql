


CREATE TABLE IF NOT EXISTS Account (
  accountnumber VARCHAR PRIMARY KEY,
  amount DECIMAL,
  baldate TIMESTAMP
);


CREATE TABLE IF NOT EXISTS Transaction (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  accountnumber VARCHAR NOT NULL,
  amount DECIMAL,
  tranctype VARCHAR,
  trancdate TIMESTAMP

);
ALTER TABLE Transaction
  ADD CONSTRAINT IF NOT EXISTS fk_accountNumber
    FOREIGN KEY(accountnumber) REFERENCES Account(accountnumber) NOCHECK;

INSERT INTO ACCOUNT(accountnumber,amount,baldate) VALUES ('abc',89.1,CURRENT_TIMESTAMP()),('bca',90.1,CURRENT_TIMESTAMP());

INSERT INTO Transaction(id,accountnumber,amount,tranctype,trancdate) VALUES (1,'abc',89.1,'WITHDRAW',CURRENT_TIMESTAMP()),(2,'abc',89.1,'DEPOSIT',CURRENT_TIMESTAMP());