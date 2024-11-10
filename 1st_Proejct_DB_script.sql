--------------------------------------------------------
--  파일이 생성됨 - 목요일-8월-31-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ADMIN
--------------------------------------------------------

  CREATE TABLE "ADMIN"."ADMIN" 
   (	"CODENUMBER" VARCHAR2(30 BYTE), 
	"NAME" VARCHAR2(30 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table BOOK
--------------------------------------------------------

  CREATE TABLE "ADMIN"."BOOK" 
   (	"BOOKID" NUMBER(*,0), 
	"BOOKNAME" VARCHAR2(50 BYTE), 
	"GENRE" VARCHAR2(30 BYTE), 
	"WRITER" VARCHAR2(30 BYTE), 
	"PRICE" VARCHAR2(20 BYTE), 
	"BOOKDATE" DATE, 
	"BOOKTYPE" VARCHAR2(30 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table ORDERSBOOK
--------------------------------------------------------

  CREATE TABLE "ADMIN"."ORDERSBOOK" 
   (	"ORDERID" NUMBER, 
	"ID" VARCHAR2(50 BYTE), 
	"BOOKNAME" VARCHAR2(50 BYTE), 
	"SALEDATE" DATE, 
	"BOOKTYPE" VARCHAR2(30 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."USERS" 
   (	"USERNUMBER" NUMBER, 
	"ID" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE), 
	"NAME" VARCHAR2(30 BYTE), 
	"RRN" VARCHAR2(30 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"PHONE" VARCHAR2(30 BYTE), 
	"ADDRESS" VARCHAR2(200 BYTE)
   ) ;
REM INSERTING into ADMIN.ADMIN
SET DEFINE OFF;
Insert into ADMIN.ADMIN (CODENUMBER,NAME,PASSWORD) values ('1','박효정','1234');
Insert into ADMIN.ADMIN (CODENUMBER,NAME,PASSWORD) values ('2','안성민','1234');
Insert into ADMIN.ADMIN (CODENUMBER,NAME,PASSWORD) values ('3','심규진','1234');
REM INSERTING into ADMIN.BOOK
SET DEFINE OFF;
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (5,'윈드브레이커','드라마','조용석','7800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (10,'현실퀘스트','판타지','태성','6800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (1,'마음의소리','개그','조석','8800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (2,'이두나','로맨스','민송아','9800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (3,'재벌집 막내아들','드라마','산경','6800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (4,'재벌집 막내아들','드라마','산경','5800',to_date('2023/08/31','YYYY/MM/DD'),'웹소설');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (6,'프리드로우','드라마','전선욱','6800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (7,'호랑이형님','판타지','이상규','7800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (8,'화산귀환','무협','비가','4800',to_date('2023/08/31','YYYY/MM/DD'),'웹소설');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (9,'화산귀환','무협','비가','6800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (11,'싸움독학','드라마','박태준','6800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (12,'패션왕','드라마','기안84','5800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (13,'연애혁명','로맨스','232','6800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.BOOK (BOOKID,BOOKNAME,GENRE,WRITER,PRICE,BOOKDATE,BOOKTYPE) values (14,'다이스(DICE)','판타지','윤현석','6800',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
REM INSERTING into ADMIN.ORDERSBOOK
SET DEFINE OFF;
Insert into ADMIN.ORDERSBOOK (ORDERID,ID,BOOKNAME,SALEDATE,BOOKTYPE) values (1,'an01','윈드브레이커',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
Insert into ADMIN.ORDERSBOOK (ORDERID,ID,BOOKNAME,SALEDATE,BOOKTYPE) values (3,'an01','재벌집 막내아들',to_date('2023/08/31','YYYY/MM/DD'),'웹소설');
Insert into ADMIN.ORDERSBOOK (ORDERID,ID,BOOKNAME,SALEDATE,BOOKTYPE) values (2,'an01','재벌집 막내아들',to_date('2023/08/31','YYYY/MM/DD'),'웹툰');
REM INSERTING into ADMIN.USERS
SET DEFINE OFF;
Insert into ADMIN.USERS (USERNUMBER,ID,PASSWORD,NAME,RRN,EMAIL,PHONE,ADDRESS) values (1,'an01','1234','안성민','123456-1234567','an01@naver.com','010-1111-1111','남양주시');
--------------------------------------------------------
--  DDL for Index SYS_C007084
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007084" ON "ADMIN"."USERS" ("USERNUMBER") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007085
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007085" ON "ADMIN"."USERS" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007086
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007086" ON "ADMIN"."USERS" ("RRN") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007087
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007087" ON "ADMIN"."USERS" ("EMAIL") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007088
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007088" ON "ADMIN"."USERS" ("ADDRESS") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007111
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007111" ON "ADMIN"."BOOK" ("BOOKID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007149
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007149" ON "ADMIN"."ADMIN" ("CODENUMBER") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007160
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007160" ON "ADMIN"."ORDERSBOOK" ("ORDERID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007149
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007149" ON "ADMIN"."ADMIN" ("CODENUMBER") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007111
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007111" ON "ADMIN"."BOOK" ("BOOKID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007160
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007160" ON "ADMIN"."ORDERSBOOK" ("ORDERID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007084
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007084" ON "ADMIN"."USERS" ("USERNUMBER") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007085
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007085" ON "ADMIN"."USERS" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007086
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007086" ON "ADMIN"."USERS" ("RRN") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007087
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007087" ON "ADMIN"."USERS" ("EMAIL") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007088
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SYS_C007088" ON "ADMIN"."USERS" ("ADDRESS") 
  ;
--------------------------------------------------------
--  Constraints for Table ADMIN
--------------------------------------------------------

  ALTER TABLE "ADMIN"."ADMIN" ADD UNIQUE ("CODENUMBER") ENABLE;
  ALTER TABLE "ADMIN"."ADMIN" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ADMIN" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ADMIN" MODIFY ("CODENUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BOOK
--------------------------------------------------------

  ALTER TABLE "ADMIN"."BOOK" MODIFY ("BOOKDATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."BOOK" MODIFY ("BOOKTYPE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."BOOK" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."BOOK" MODIFY ("WRITER" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."BOOK" ADD PRIMARY KEY ("BOOKID") ENABLE;
  ALTER TABLE "ADMIN"."BOOK" MODIFY ("GENRE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."BOOK" MODIFY ("BOOKNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ORDERSBOOK
--------------------------------------------------------

  ALTER TABLE "ADMIN"."ORDERSBOOK" ADD PRIMARY KEY ("ORDERID") ENABLE;
  ALTER TABLE "ADMIN"."ORDERSBOOK" MODIFY ("BOOKTYPE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDERSBOOK" MODIFY ("SALEDATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDERSBOOK" MODIFY ("BOOKNAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDERSBOOK" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."USERS" ADD UNIQUE ("ADDRESS") ENABLE;
  ALTER TABLE "ADMIN"."USERS" ADD UNIQUE ("EMAIL") ENABLE;
  ALTER TABLE "ADMIN"."USERS" ADD UNIQUE ("RRN") ENABLE;
  ALTER TABLE "ADMIN"."USERS" ADD UNIQUE ("ID") ENABLE;
  ALTER TABLE "ADMIN"."USERS" ADD PRIMARY KEY ("USERNUMBER") ENABLE;
  ALTER TABLE "ADMIN"."USERS" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("PHONE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("RRN" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("ID" NOT NULL ENABLE);
