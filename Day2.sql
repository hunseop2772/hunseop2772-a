use aidev;

# 데이터 수정
# update 테이블명 Set 필드명1 = 값1, 필드명2 = 값2....  
-- 전체 값이 변경되는 문제가 발생
# update 테이블명 Set 필드명1 = 값1, 필드명2 = 값2.... where 조건절 
-- 해당 원하는 부분만 변경하기 위해 where을 사용
 # To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.000 sec
 # 메뉴 -> edit -> preference -> SQL Editor -> safe updates 테츠 없앰
 select * from tb_member;
 
 update tb_member set mem_zipcode ='12345';
 update tb_member set mem_hobby='코딩' where mem_userid = 'banana'; 
 update tb_member set mem_hobby='코딩' where mem_idx = 5; 
 -- 많은 데이터에서 하나를 찾을 때 오래 걸릴 수 있다. 그렇기 떄문에 primary key를 이용하면 속도상 유리할 수 있다.
 
 # 이메론의 주소가 서울특별시 서초구 양재동. 데이터를 변경해보자.(던'서울특별시'를 address1,'서초구'를 address2, '양재동'을 address3에 저장) 
 update tb_member set mem_address1 = '서울특별시', mem_address2 = '서초구',mem_address3 = '양재동' where mem_idx = 7;
 
 # mem_point 컬럼을 추가(단, 타입은 int, 기본값은 0)
 alter table tb_member add mem_point int default 0;
 
 # 모든 회원에게 200p 선물하기
 update tb_member set mem_point = mem_point + 200; 
 
 /*
	SQL 연산자
1. 산술 연산자
	+, -, *, /, div(나누기를 한 후 소수부분을 버림), mod(나머지 연산)
2. 대입 연산자
	=
3. 비교 연산자
	=, <, >, >=, <=, <>(다르다)
    is(왼쪽 피연산자와 오른쪽 피연산자가 같으면 참, 다르면 거짓) 예) mem_address1 is null
    between A and B (값이 A보다는 크거나 같고 B보다 작거나 같으면 참) 예) mem_point between 100 and 200
    in (연산자의 값이 매개변수로 전달받은 리스트에 존재하면 참을 반환) 예) mem_hobby in ('잠자기', '코딩', '게임')
	like (패턴으로 문자열을 검색) 예) mem_userid like 'a%' 
4. 논리 연산자 
	and, or, not, xor
 */
 
 # 데이터 삭제
 # delete from 테이블명;
 # delete from 테이블명 where 조건절;
 
 delete from tb_member; -- 전체 테이블 삭제
 delete from tb_member where mem_point = 300;
 delete from tb_member where mem_idx = 8;
 
  select * from tb_member;
  
  # 데이터 검색
  # select 필드1, 필드2... from 테이블명 
  select 100 ;
  select 100 +50;
  
  # 별명
  select 100+50 as 'sum';-- ' ' 싱글쿼트를 사용하는 이유는 띄어쓰기 때문
  select 100+50 as sum;
  select 100 +50 sum;
  
  select null; # 해당 셀에 insert가 되지 않은 것을 의미
  select ''; # 해당 셀에 ' '  데이터가 삽입된 것을 의미
  
 select 100 + null; -- null은 연산할 수 없음 결과는 null이 나오게 된다.
 
 select * from tb_member; -- * : 모든 컬럼, * 사용시 프로그램 속도가 저하 가능성 多
 select mem_userid, mem_name, mem_hp, mem_email, mem_regdate, mem_point from tb_member; 
 select mem_userid,mem_point, mem_name, mem_hp, mem_email, mem_regdate from tb_member; 
 -- 컬럼명이 아무리 많다고 하더라도 *를 사용하는 것 보다는 일일히 전부 다치는것이 속도면에서 좋다.
 -- 테이블 구현 순서는 불러올 때 순서를 조정하면 됨으로 만들 때 신경을 쓸 필요가 없다.
 
 
 # select 필드1, 필드2... from 테이블명  where 조건절
 select mem_userid,mem_name,mem_hp,mem_email from tb_member where mem_userid = 'apple';
 # 로그인 쿼리 
 select mem_userid,mem_name from tb_member where mem_userid = 'apple' and mem_userpw = '1111';
 select mem_userid,mem_name , mem_point from tb_member where mem_point = 300 or mem_point =  400 or mem_point = 500;
 select mem_userid,mem_name , mem_point from tb_member where mem_point in (300, 400, 500);
 
 # between 연산자
select mem_userid,mem_name , mem_point from tb_member where mem_point between 300 and 500;
select mem_userid,mem_name , mem_point from tb_member where mem_point >= 300 and mem_point <=500;
 
 # null 사용
 select mem_userid, mem_name, mem_hobby from tb_member where mem_hobby is null; -- null을 찾을 때
 select mem_userid, mem_name, mem_hobby from tb_member where mem_hobby is  not null; -- null을 찾지 않을 때
 # like 연산자
 select mem_userid, mem_name from tb_member where mem_userid like 'a%';
 select mem_userid, mem_name from tb_member where mem_userid like '%a';
 select mem_userid, mem_name from tb_member where mem_userid like '%a%';-- a가 어디에든지 들어가는
 select mem_userid, mem_name from tb_member where mem_userid like 'app__'; -- app로 시작하고 5글자인 데이터 검색
 
 # select 필드1, 필드2... from 테이블명  where 조건절 order by 필드 [asc(오름차순), desc(내림차순)]
 select mem_userid,mem_name , mem_point from tb_member order by mem_point asc; -- 오름차순
 select mem_userid,mem_name , mem_point from tb_member order by mem_point; -- 오름차순 asc는 생략이 가능하다.
 select mem_userid,mem_name , mem_point from tb_member order by mem_point desc; -- 내림차순
 # 포인트순으로 내림차순으로 데이터 조회(단, 같은 포인트인 경우 최근 가입순으로 정렬)
 select mem_userid,mem_name , mem_point, mem_regdate from tb_member order by mem_point desc, mem_regdate desc;
 
 # 성별 필드 추가
 alter table tb_member add mem_gender enum('남자','여자'); -- 남자, 여자만 업데이트 할 수 있다. 
 update tb_member set mem_gender ='남' where mem_userid = 'orange'; -- (X)
 
 update tb_member set mem_gender ='남자' where mem_userid = 'orange';
 
 select * from tb_member;
 
# 성별이 여자인 회원을 point가 많은순으로 정렬(단, 포인트가 같을 경우 먼저 가입한 순으로 정렬하자)
 select mem-idx, mem_userid, mem_name, mem_point, mem_gender, mem_regdate 
 from tb_member 
 where mem_gender = '여자' 
 order by mem_point desc, mem_regdate;
 
 # select 필드1, 필드2... from 테이블명 limit 가져올 행의 갯수
 select mem_userid, mem_name , mem_hp,mem_email from tb_member limit 3;
 select mem_userid, mem_name , mem_hp,mem_email from tb_member limit 3, 2; # 4번째 행부터 2개를 가여옴
 
 # 집계함수
 # count : 행의 갯수를 세는 함수
 -- 회원 숫자와 같은 수를 확인하기 위해거는 절대 null값이 나올 수 없는것을 기준으로 한다.
 select count(mem_idx) from tb_member;
 select count(mem_hobby) from tb_member;
 select count(mem_point) from tb_member; -- null을 제외하고 갯수를 셈
 select count(mem_idx) user from tb_member where mem_userid = 'apple' and mem_userpw = '1111';
 -- 결과값이 1이면 로그인, 왜냐하면 아이디, 비밀번호 가 같은것은 하나만 있기 때문이다.
 
 # distinct : 뒤에 나오는 필드에 대하여 같은 값을 가진 중복된 행을 제외
 select distict mem_gender from tb_member;
 select distict mem_userid,mem_gender from tb_member;
 insert into tb_member (mem_userid,mem_userpw,mem_name,mem_hp,mem_email,mem_ssn1,mem_ssn2,mem_gender)
 value ('cherry','1111','김사과','010-1111-1111','apple@apple.com','001011','4068518','여자');
  select distict mem_userpw,mem_gender from tb_member; -- 2개의 필드 값이 모두 일치하므로 중복으로 판정
 
 
 select distinct count(mem_gender) from tb_member; -- 6
 select count(distinct mem_gender) from tb_member; -- 2
 
 # sum : 행의 값을 더함
 select mem_userid, sum(mem_point) total from tb_member; -- X / 관련 집계함수만 사용하여야 한다.
 select sum(mem_point) total from tb_member;
 
 # avg: 행의 값의 편균울 구함
 select avg(mem_point) avg from tb_member;
 
 # min max : 행의 최대값 또는 최소값을  
  select min(mem_point) min from tb_member;
  select max(mem_point) max from tb_member;
 
 # select 그룹을 맺은 컬럼 또는 집계함수 from 테이블명 [where 조건절] group by 필드 haviong 조전절 order by 필드 [asc, desc]
 select mem_gender from tb_member group by mem_gender;
 select mem_gender, count(mem_idx) cnt from tb_member group by mem_gender;
 select mem_gender, sum(mem_point) cnt from tb_member group by mem_gender;
 -- where은 모든 행의 조건이다. having은 그룹에관한 조건이다.
 select * from tb_member;
  select mem_gender, count(mem_point) cnt from tb_member  where mem_point >0 group by mem_gender;
  select mem_gender, count(mem_point) cnt from tb_member  where mem_point >0 group by mem_gender having mem_gender = '남자';
 
 # 포인트가 0이 아닌 회원의 집합에서 남자 여자로 그룹을 나눠 포인트의 평균을 구하고 포인트가 300 이상인 성별을 검색하여 포인트로 내림차순 정렬
 select mem_gender, avg(mem_point) avg 
 from tb_member 
 where mem_point > 0 
 group by mem_gender 
 having avg > 300 
 order by avg desc; 
 
# 프로필 테이블 생성
create table tb_profile(
	pro_idx int not null,
    pro_age int,
    pro_height double,
    pro_weight double,
    pro_blood varchar(5),
    pro_mbti varchar(10),
    foreign key(pro_idx) references tb_member(mem_idx)
);
select * from tb_profile;
select * from tb_member;
insert into tb_profile values (2,30,170,70,'B','INTP'); -- foreign key 제약조건 위배/ 주키에 없어서 
insert into tb_profile values (1,20,160,50,'A','INTP'); 
insert into tb_profile values (4,25,160,50,'B','INTP'); 
insert into tb_profile values (5,30,160,50,'C','INTP'); 
insert into tb_profile values (6,28,160,50,'D','INTP'); 

# 조인
/* select 필드1, 필드2 .. 
   from 테이블1[inner, leftm right] join 테이블2 on 테이블1.필드 = 테이블2.필드; 
 */
 # left
 select mem_userid,mem_name,mem_hp,pro_age,pro_blood,pro_mbti 
 from tb_member left join tb_profile on tb_member.mem_idx = tb_profile.pro_idx;
 
 # inner
  select mem_userid,mem_name,mem_hp,pro_age,pro_blood,pro_mbti 
 from tb_member inner join tb_profile on tb_member.mem_idx = tb_profile.pro_idx;
 
 # right - inner와 동일하게 나온다 왜냐하면 오른쪽에 있는 테이블은 foreign으로 교집합에 포함되기 때문이다.
  select mem_userid,mem_name,mem_hp,pro_age,pro_blood,pro_mbti 
 from tb_member right join tb_profile on tb_member.mem_idx = tb_profile.pro_idx;
 
 # 테이블 필드명 동일한 경우 
 select A.mem_userid,A.mem_name,A.mem_hp,B.pro_age,B.pro_blood,B.pro_mbti 
 from tb_member A right join tb_profile B on A.mem_idx = B.pro_idx;
 
create table tb_order(
	or_idx int,
    or_num varchar(8) not null,
    or_zipcode varchar(5),
    or_address1 varchar(100),
    or_address2 varchar(100),
    or_address3 varchar(100)
); 
 insert into tb_order values(null,'00000001','12345','서울','서초구','양재동');
 insert into tb_order values(1,'00000002','12345','서울','서초구','양재동');
 insert into tb_order values(4,'00000003','12345','서울','서초구','양재동');
 insert into tb_order values(5,'00000004','12345','서울','서초구','양재동');
 insert into tb_order values(null,'00000005','12345','서울','서초구','양재동');
 insert into tb_order values(1,'00000006','12345','서울','서초구','양재동');
 
 select * from tb_order;
 
 
 select mem_userid,mem_name,mem_hp,or_num,or_zipcode
 from tb_member inner join tb_order 
 on tb_member.mem_idx = tb_order.or_idx;
 
 select mem_userid,mem_name,mem_hp,or_num,or_zipcode
 from tb_member left join tb_order 
 on tb_member.mem_idx = tb_order.or_idx;
 
 select mem_userid,mem_name,mem_hp,or_num,or_zipcode
 from tb_member right join tb_order 
 on tb_member.mem_idx = tb_order.or_idx;
 
 # 뷰(view)
 # 가상의 테이블을 생성
 # 실제 테이블 처럼 행과 열을 가지고 있지만, 데이터를 저장하고 있지는 않음
 # SQL 코드를 간결하게 만들기 위함, 보안상 내부 데이터를 전체 공개하고 싶지 않을 때
 # 삽입, 삭제, 수정 작업에 제한 사항을 가짐
 # 자신만의 인덱스를 가질 수 없음
 # 한 번 정의된 뷰는 변경할 수 없음
 
 /*
	create view 뷰이름 
    as
    select 쿼리...
 */
 select * from tb_member;
 create view vw_member_simple
 as 
 select mem_idx, mem_userid, mem_userpw, mem_name, mem_hp
 from tb_member;
 
 select * from vw_member_simple;
 
 create view vw_member_inner_profile as 
  select mem_userid,mem_name,mem_hp,pro_age,pro_blood,pro_mbti 
 from tb_member left join tb_profile on tb_member.mem_idx = tb_profile.pro_idx;
 
 select * from vw_member_inner_profile;
 
 /*
	뷰 대체
    create or replace view 뷰이름
    as
    select 쿼리...
    
    뷰 삭제
    drop view 뷰이름
 */
 
 drop view vw_member_inner_profile;
 
 create view vw_member_left_profile as 
  select mem_userid,mem_name,mem_hp,pro_age,pro_blood,pro_mbti 
 from tb_member left join tb_profile on tb_member.mem_idx = tb_profile.pro_idx;
 
  select * from vw_member_left_profile;
 
 
 
 
 
 
 
 