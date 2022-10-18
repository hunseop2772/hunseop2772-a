/*
MySQL 계정관리
- MySQL 8.0 Commamd Line Client 실핼
- 비밀번호 1234
- show databases;
- create database test;
- Database 사용자 생성
	@'localhost' : 해당 컴퓨터에서만 접근이 가능
	@'%' : 모든 클라이언트에서 접근이 가능
	create user '계정명'@'loacalhost' IDENTIFIED BY '비밀번호';
	create user '계정명'@'%' IDENTIFIED BY '비밀번호';
- Database 사용자 권한 생성
	grant all privileges on : 모든 데이터베이스의 모든 테이블에 대한 권한 부여(*.* : 모든 테이블)
	grant all privileges on *.* to '계정명'@'%';
	grant all privileges on DB명.* to '계정명'@'%';
	flush privileges : 변경한 권한으 즉시 반영해주는 명령어
	
	문제. 
	banana 계정을 만들어 test 데이터베이스에만 접근이 가능한 계정으로 권한 생성하기
		create user 'banana'@'%'identified by'2222';
		grant all privileges on test.* to 'banana'@'%';

*/
drop table product;
use test;
create table product(
	pro_idx varchar(10) not null,
    pro_name varchar(50) not null,
    pro_detail text,
    pro_price int,
    pro_regdate date
);

insert into product values('0000000001', '아이폰14', '예뻐요', 1400000, now());
insert into product values('0000000002', '갤럭시22', '좋아요', 1000000, now());
insert into product values('0000000003', '맥북에어', '가벼워요', 1500000, now());
insert into product values('0000000004', '갤럭시북', '싸요', 900000, now());
insert into product values('0000000005', '로지텍웹카메라', '잘보여요', 200000, now());
insert into product values('0000000006', '삼성모니터', '잘보여요', 600000, now());
insert into product values('0000000007', 'z플립', '잘접혀요', 1000000, now());
insert into product values('0000000007', 'z플립', '잘접혀요', 1000000, now());

create table product_new(
	pro_idx varchar(10) not null,
    pro_name varchar(50) not null,
    pro_detail text,
    pro_price int,
    pro_regdate date
);
insert into product_new values ('0000000001','아이폰14','예뻐요', 1400000, now());
insert into product_new values ('0000000006','삼성모니터','잘보여요', 600000, now());
select * from product;
update product_new set pro_regdate = '2022-10-17 10:43:00';

# union
# 합집합을 나타내는 연산자로 , 중복된 값을 제거함
# 서로 같은 종류의 테이블(컬럼이 같아야 함)에서만 적용이 됨
# select * from 테이블1 union select * from 테이블2
select * from product
union
select * from product_new;

# uinion all
# 합집합으 나타내는 연산자로, 중복된 값을 제거하지 않음
select * from product
union all
select * from product_new;

# 서브쿼리(subquery)
#다른 쿼리 내부에 포함되어 있는 select 문을 의미
# 서브쿼리를 포함하고 있는 쿼리를 외부쿼리라고 부으며, 서브쿼리는 내부쿼리라고도 부름alter# 서브쿼리는 괄호()로 감싸져서 표현
# 서브쿼리는 메인쿼리 컬럼 사용 가능
# 메인쿼리는 서브쿼리 컬럼 사용 불가

# 서브쿼리의 실행 순서 : 서브쿼리 실행 -> 메인 쿼리 실행 

select pro_price from product where pro_idx= '0000000002';

select * from product 
where pro_price >= (select pro_price from product where pro_idx= '0000000002');

# 서브쿼리의 위치에 따른 명칭
# select 컬럼명1, (select ..) : 컬럼처럼 사영 -> 스칼라 서브쿼리
# where 컬럼명 연산자 (select..) : 하나의 변수(상수)처럼 사용 -> 일반 서브쿼리
# select 컬럼명1 from (select..) :하나의 테이블처럼 사용 -> 인라인 뷰

# 조건값의 결과가 하나일 때
select * from product where pro_name = (select pro_name from product where pro_idx= '0000000002'); 

# 조건값의 결과가 여러개일 때
# 조건에 값이 여러개 리턴되면 any(in, or과 동일한 의미)
select * from product where pro_name = any (select pro_name from product where pro_price in (1000000,1400000)); 

-- # all(and를 의미)은 도출된 모든 조건값에 대해 만족할 때
--  select * from product where pro_price > any (select pro_price from product where pro_price in (1000000));

# 서브쿼리 실행 조건
# 서브쿼리는 select 문으로만 작성할 수 있음
# 반드시 괄호() 안에 존재
# 서브쿼리 괄호가 끝나고 끝에 세미콜론을 쓰지 않음 
# order by를 사용하지 못함
# MySQL애서는 서브쿼리를 포함할 수 있는 외부쿼리는 select, insert, update, delete, set, do문  


 select * from product;
# 문제.
# 서브쿼리를 사용하여 맥북에어의 상세설명을 출력
select pro_detail from product where pro_name in (select pro_name from product where pro_idx ='0000000003');
# 겔럭시북보다 비싼 상품을 출력 
select pro_name from product where pro_price > any (select pro_price from product where pro_idx = '0000000004');
# 가격이 100만원인 상품들을 출력
select * from product where pro_price = any (select pro_price from product where pro_price = 1000000);
# 가격이 100만원인 상품들의 이름과 상세설명을 출력
select pro_name, pro_detail from product where pro_price = any (select pro_price from product where pro_price = 1000000);
# 로지텍 카메라의 가격과 전체 가격의 평균을 출력
select pro_name,pro_price, (select avg(pro_price)from product ) as avg from product
where pro_idx in (select pro_idx from product where pro_idx = '0000000005');

# product와 동일한 테이블 product2를 만들고 product에 존재하는 데이터를 모두 복사하여 product2에 저장
insert into product2 (select * from product);

drop table product2;
use test;
create table product(
	pro_idx varchar(10) not null,
    pro_name varchar(50) not null,
    pro_detail text,
    pro_price int,
    pro_regdate date
);

# 가격이 100만원인 상품들의 가격을 모두 10% 인상 (Mysql은 동일한 테이블에서 서브쿼리로 뽑은 데이터를 update, delete 할 수 없음)

update product set pro_price = (pro_price *1.1) 
where pro_idx = any (select idx from (select pro_idx as idx  from product where pro_price = 1000000) as p);

# 가격이 100만원 상품들을 모두 삭제

delete from product where pro_idx = any (select idx from (select pro_idx as idx  from product where pro_price = 1000000) as p);


# 트랜잭션(Transaction)
# 사전적 의미 : 거래 -> DB : 분할이 불가능한 업무처리 단위
/*				성공				commit
	활성			----> 부분완료 ----> 완료
    (active)			중단(Abort)
				----> 실패 ----> 철회
				오류				rollback

commit : 모든 작업들을 정상 처리하겠다고 확정하는 명령어로서, 해당 처리 과정을 DB에 영구 저장
rollback : 작업 중 문제가 발생되어 트랜잭션의 처리 과정에서 발생한 변경사항을 모두 취소하는 명령어


*/

# 자동 커밋 확인 
show variables like '%commit%';
# autocommit : on 자동으로 commit 해줌
# set autocommit =0 (off), set autocommit =1 (on)
set autocommit =0;
set autocommit =1;

start transaction; -- 트랜잭션의 시작이고 commit 또는 rollback을 해야 끝남

insert into product values('0000000011', '고철8', '팔아요', 10, now());
select* from product;
commit; -- 트랜잭션을 DB에 적용
select* from product;

start transaction;
insert into product values('0000000012', '병', '팔아요', 5, now());
rollback; -- 트랜잭션을 취소하고 start transaction 실행 전 상태로 롤백함
select* from product;-- 병은 없어짐 롤백으로 인하여

# 트랜잭션 예외
# DDL문(create, drop, alter, return, truncate)은 트랜잭션의 rollback 대상이 아님

# truncate 
# 개별적으로 행을 삭제할 수 없으며, 테이블 내부의 모든 행을 삭제
# 트랜잭션 로그에 한 번만 기록하므로 delete 보다 성능 면에서 빠름
# rollback이 불가능
# truncate table 테이블명;
truncate table product2;
select *from  product2;

































