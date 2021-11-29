CREATE TABLE EMPLOYEE(
	num int primary key,-- 직원번호 / pk 
	ename varchar(50) not null,-- 직원이름
	phone varchar(50) not null,-- 전화번호 
	grade varchar(50) not null,-- 직급
	email varchar(50) not null-- 이메일 주소 
);


-- 테스트용 데이터 
INSERT INTO EMPLOYEE (NUM,ENAME,PHONE,GRADE,EMAIL) VALUES ((SELECT NVL(MAX(NUM),999)+1 FROM EMPLOYEE),
'김하나','010-3228-6063','사원','AAA@NAVER.COM');
INSERT INTO EMPLOYEE (NUM,ENAME,PHONE,GRADE,EMAIL) VALUES ((SELECT NVL(MAX(NUM),999)+1 FROM EMPLOYEE),
'나두리','010-3128-6063','사원','BBB@NAVER.COM');
INSERT INTO EMPLOYEE (NUM,ENAME,PHONE,GRADE,EMAIL) VALUES ((SELECT NVL(MAX(NUM),999)+1 FROM EMPLOYEE),
'단아한','010-3228-6065','과장','CCC@NAVER.COM');
INSERT INTO EMPLOYEE (NUM,ENAME,PHONE,GRADE,EMAIL) VALUES ((SELECT NVL(MAX(NUM),999)+1 FROM EMPLOYEE),
'홍길동','010-3228-6065','팀장','CCC@NAVER.COM');
INSERT INTO EMPLOYEE (NUM,ENAME,PHONE,GRADE,EMAIL) VALUES ((SELECT NVL(MAX(NUM),999)+1 FROM EMPLOYEE),
'임꺽정','010-3228-6065','사원','CCC@NAVER.COM');

UPDATE EMPLOYEE SET ENAME='이수정', GRADE='차장', PHONE='010-7878-7878',EMAIL='ykouo@naver.com' WHERE NUM=1003;

SELECT * FROM EMPLOYEE ORDER BY ENAME ASC;
SELECT * FROM EMPLOYEE WHERE ename LIKE '%다%' ORDER BY ENAME ASC;