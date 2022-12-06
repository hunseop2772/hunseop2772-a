#  관리자 테이블
use aidev;
create table admin_user(
id int auto_increment primary key,
userid varchar(20) unique not null,
userpw varchar(20) not null,
name varchar(20) not null,
statues varchar(10),
last_login_at datetime,
reg_date datetime default now()
);

select * from admin_user;
select * from users;
select * from category;
select * from partner;

# 회원테이블
create table users(
id int auto_increment primary key,
userid varchar(20) unique not null,
userpw varchar(20) not null,
hp varchar(20) not null,
email varchar(50) not null,
status varchar(10),
reg_date datetime default now(),
upadte_date datetime
);

# 카테고리 테이블
create table category(
	id int auto_increment primary key,
    type varchar(30) not null,
    title varchar(30) not null,
	reg_date datetime default now(),
    update_by varchar(20),
    upadte_date datetime
);


# 파트너 테이블
create table partner(
	id int auto_increment primary key,
    name varchar(30) not null,
    status varchar(10),
    address varchar(100),
    call_center varchar(20),
    business_number varchar(20),
    ceo_name varchar(20),
    reg_date datetime default now(),
    upadte_date datetime,
    category_id int
);

# 아이템 테이블
create table item (
	id int auto_increment primary key,
    name varchar(50) not null,
    status varchar(10) not null,
    title varchar(50) not null,
    content varchar(1000),
    price int default 0,
    reg_date datetime default now(),
    create_by varchar(20),
	upadte_date datetime,
	update_by varchar(20),
	partner_id int
);
# 상품 구매내역 상품 테이블
create table order_group(
	id int auto_increment primary key,
    order_type  varchar(20) not null,
    status  varchar(10) not null,
    rev_address  varchar(100) not null,
    rev_name  varchar(20) not null,
    payment_type  varchar(20) not null,
    total_price int default 0,
    total_quantity int default 0,
    order_at datetime,
    arrival_date datetime,
        reg_date datetime default now(),
        user_id int
);

# 주문 상세 테이블 
create table order_detail(
id int auto_increment primary key,
arrival_date datetime,
status  varchar(10) not null,
quantity int default 0,
total_price int default 0,
reg_date datetime default now(),
item_id int, 
order_group_id int
);