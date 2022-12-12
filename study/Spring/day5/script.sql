use aidev;

create table event(
	id int auto_increment primary key,
    user_id int not null,
    content varchar(1000),
	reg_date datetime default now(),
    update_date datetime,
    foreign key (user_id) references users(id) 
    on update cascade on delete cascade
);
