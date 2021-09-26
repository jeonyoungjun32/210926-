create table ice(
id int auto_increment primary key not null,   --상품아이디	
name nvarchar(30) not null,						--아이스크림 이름
kind nvarchar(60) not null,						--아이스크림 종류	
country nvarchar(20) not null,					--아이스크림 설명
price int,										--아이스크림 가격
image nvarchar(40),								--이미지
readcount int 									--조회수	
count int										--갯수
);	


create table ice(
id int auto_increment primary key not null,
name nvarchar(30) not null,
kind nvarchar(60) not null,						
country nvarchar(60) not null,					
price int,										
image nvarchar(40),
readcount int, 	
count int 
);

drop table ice

select * from ice

insert into ice(kind,country,price,image,readcount,count)
values('사랑에 빠진 딸기','딸기와 초몰릿이 치즈케이크에 반해번린 사랑의 맛',5480,'strawberry.jpg',0,100);

select FORMAT(price,0) from ice; --이러면  5,480 이 출력된다 

DATE_FORMAT(now(), '%Y-%m-%d);

