use aidev;

create table tb_board(
	b_idx int auto_increment primary key,
	b_userid varchar(20) not null,
	b_name varchar(20) not null,
	b_title varchar(100) not null,
	b_content text not null,
	b_hit int default 0,
	b_regdate datetime default now(),
	b_like int default 0
);

create table tb_reply(
	re_idx int auto_increment primary key,
	re_userid varchar(20) not null,
	re_name varchar(20) not null,
	re_content varchar(2000) not null,
	re_regdate datetime default now(),
	re_boardidx int,
    foreign key (re_boardidx) references tb_board(b_idx) on update cascade
);

select * from tb_board;
select * from tb_reply;