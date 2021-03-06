SELECT * FROM ALL_TABLES;
SELECT * FROM BOARD;
DROP TABLE BOARD;
DROP TABLE MEM;

CREATE TABLE BOARD(
	BID INT PRIMARY KEY,
	MID VARCHAR(50) NOT NULL,
	TITLE VARCHAR(50) NOT NULL,
	CONTENT VARCHAR(100) NOT NULL,
	WDATE DATE DEFAULT SYSDATE
);
-- C
INSERT INTO BOARD (BID,MID,TITLE,CONTENT) VALUES ((SELECT NVL(MAX(BID),0)+1 FROM BOARD),'hana','스프링테스트','SPRINGTEST');
-- R
SELECT * FROM BOARD ORDER BY BID DESC;
SELECT * FROM BOARD WHERE TITLE='스프링테스트';
SELECT * FROM BOARD WHERE TITLE LIKE '%테%' ORDER BY BID DESC;
-- U
UPDATE BOARD SET TITLE='업데이트 테스트 ',CONTENT='UPDATE TEST' WHERE BID=1; 
-- D
DELETE FROM BOARD WHERE BID=1 AND MID='하나';



CREATE TABLE MEM(
	MID VARCHAR(50) PRIMARY KEY,
	MPW VARCHAR(50) NOT NULL,
	MNAME VARCHAR(50) NOT NULL,
	CALL VARCHAR(50) NOT NULL,
	ROLE VARCHAR(50) DEFAULT 'USER',
	MDATE DATE DEFAULT SYSDATE
);
-- C
INSERT INTO MEM (MID,MPW,MNAME,CALL,ROLE) VALUES ('admin','1004','관리자','010-1004-1004','ADMIN');
INSERT INTO MEM (MID,MPW,MNAME,CALL,ROLE) VALUES ('hana','11','이하나','010-1111-1111','USER');
-- R
SELECT * FROM MEM;
SELECT * FROM MEM WHERE MID='hana' AND MPW='11';

-- U
UPDATE MEM SET MPW='12',CALL='010-1212-1212'WHERE MID='hana'; 
-- D
DELETE FROM MEM WHERE MID='hana' AND MPW='11';


