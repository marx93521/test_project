DROP TABLE IF EXISTS coin;
DROP TABLE IF EXISTS coinname;

CREATE TABLE coin (
  coin VARCHAR(250) PRIMARY KEY,
  rate_float decimal(14,4) NOT NULL,
  updateTime dateTime
);

CREATE TABLE coinname (
  coin VARCHAR(250) PRIMARY KEY,
  Name VARCHAR(250)
);
INSERT INTO coinname (coin,Name) VALUES('USD', '美金');
INSERT INTO coinname (coin,Name) VALUES('GBP', '英鎊');
INSERT INTO coinname (coin,Name) VALUES('EUR', '歐元');