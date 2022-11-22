# 한 줄 주석문
-- 한 줄 주석문
/*
	여러 줄 주석문
	...
*/
# 데이터베이스 확인하는 방법
show databases; 

# 데이터베이스 생성 법
# create database 데이터베이스명;
create database aidev;

#데이터베이스 삭제
 
# drop database 데이터베이스명;
drop database aidev;

# 테이블(table) 
# 데이터를 행과 열로 스키마에 따라 저장할 수 있는 구조
# 스키마 : 데이터베이스의 구조와 제약조건에 관한 명세를 기술한 집합의 의미
/*
	create table 테이블명 (
    필드명1 타입 제약조건,-- 예) no int not null,  -> 속성 명은 no이고 정수형 int가 와야하며 not null 데이터가 없으면 에러가 된다.
    필드명2 타입 제약조건,
    ...
    필드명n 타입 제약조건
)
*/

/*
데이터 타입
1. 숫자 타입 
	- 정수 : tinyint, smallint, mediumint, int, bigint ...
    - 실수 : float, double
2. 문자열 타입
	- 텍스트 : char, varchar(65535byte까지 저장), text
		char(10) -> 1byte만 저장하더라도 총 10byte를 소모
		varchar(10) -> 1byte를 저장하면 총 1byte만 사용
    - 바이너리 : binary, varbinary
		EX) 이미지, 영상, 사운드 등
    - 열거 : enum
		EX) enum('남자','여자') -> 남자,여자가 들어있는 글자만 사용할 수 있다.
3. 날짜와 시간타입 - 날짜 연산하기 위해 사용
	- 날짜 : date
    - 날짜와 시간타입 : datetime, timestamp(1970년 1월 1일 0시0분0초 ~) ms(1000분에 1초마다 증가) 
*/

/*
제약조건
데이터의 무결성을 지키기 위해 데이터를 입력받을 때 실행하는 검사 규칙

- NOT NULL
	필드에 NULL 값을 저장할 수 없음
- UNIQUE
	중복된 값을 저장할 수 없음(동일한 값은 저장불가)
    NULL은 저장할 수 있음
- DEFAULT -> default 100 이면 null을 저장하면 null은 100이 된다.
	기본값을 설정, NULL을 저장할 떄 기본값을 설정 
- AUTO_INCREMENT
	자동으로 숫자가 증가되어 추가
    중복값이 저장되지 않음
    직접 데이터를 추가할 수 없음
    auto_increment를 사용한 필드는 primary key로 등록
    no int auto_increment 자동으로 1번부터 증가하며 데이터가 들어간다.
- PRIMARY KET
	UNIQUE제약과 NOT NULL제약을 동시에 적용
    테이블에 오직 하나의 필드에만 적용
    데이터를 쉽고 빠르게 검색할 수 있도록 설정(색인 - index)
    외래키가 참조할 수 있도록 설정
    EX) select 아이디, 비밀번호 from 회원 where 아이디 ='apple';
- FOREIGN KEY
	기본 키에 저장되어 있는 값만 외래 키에 저장될 수 있다.
	다른 테이블과 연결해주는 역할
    기준이 되는 테이블의 내용을 참조해서 레코드를 입력
    PRIMARY KEY를 참조
    
*/

# 데이터베이스 선택alter
# use 데이터베이스명
use aidev;

# 테이블 만들기
create table tb_member(
	mem_idx int auto_increment primary key,
    mem_userid varchar(20) unique not null,
    mem_userpw varchar(20) not null,
    mem_name varchar(20) not null,
    mem_hp varchar(20) not null,
    mem_email varchar(50) not null,
    mem_hobby varchar(100),
    mem_ssn1 varchar(6) not null,
    mem_ssn2 varchar(7) not null,
    mem_zipcode varchar(5),
    mem_address1 varchar(100),
    mem_address2 varchar(100),
    mem_address3 varchar(100),
    mem_regdate datetime default now()
);

# 테이블 확인
# desc 테이블명
desc tb_member;

# 테이블 삭제
# drop table 테이블 명
drop table tb_member;

# 테이블 필드 추가
# alter table 테이블명 add 컬럼명 타입 제약조건
alter table tb_member add mem_point int default 0;

# 테이블 필드 수정
#alter table 테이블명 modify column 컬럼명 컬럼타입 제약조건
alter table tb_member modify column mem_point double default 0;

# 테이블 필드 삭제
# alter table 테이블명 drop 컬럼명
alter table tb_member drop mem_point;

# 데이터 삽입
# insert into 테이블명 values (값1, 값2, 값3..)
 --  자동으로 들어가는 값이 있으면 사용할 수 없다.
# insert into 테이블명 (필드명1, 필드명2, 필드명3..) values ((값1, 값2, 값3..)
insert into tb_member(mem_userid,mem_userpw,mem_name,mem_hp,mem_email,mem_ssn1,mem_ssn2)
	values ('apple', '1111','김사과','010-1111-1111','apple@apple.com','001011','4068518');

insert into tb_member (mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_ssn1, mem_ssn2)
	values ('banana', '2222', '반하나', '010-2222-2222', 'banana@banana.com', '001111', '4068518');
insert into tb_member (mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_ssn1, mem_ssn2)
	values ('orange', '3333', '오렌지', '010-3333-3333', 'orange@orange.com', '001212', '4068518');
insert into tb_member (mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_ssn1, mem_ssn2)
	values ('melon', '4444', '이메론', '010-4444-4444', 'melon@melon.com', '000101', '4068518');
insert into tb_member (mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_ssn1, mem_ssn2)
	values ('cherry', '5555', '채리', '010-5555-5555', 'cherry@cherry.com', '000202', '4068518');
insert into tb_member (mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_ssn1, mem_ssn2)
	values ('berry', '6666', '배애리', '010-6666-6666', 'berry@berry.com', '000303', '4068518');
    
    create table tb_test(
		t_idx int,
        t_name varchar(20),
        t_age int,
        t_hp varchar(20)
    );
    
    insert into tb_test values(1,'김사과',20,'010-1111-1111');
    -- 한 개는 유니크한 아이덴티티가 있어야 한다. 왜냐하면 위처럼 계속해서 중복값이 들어가고 구분을 할 수 없기 떄문이다. 
insert into tb_test (t_idx,t_name,t_age) values (2,'반하나',23); 











