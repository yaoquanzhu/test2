create database zufang;

--用户表
--用户id
--用户名
--登录密码
--电话
--真实名
--是否管理员
create table users
(
  id        int primary key auto_increment,        
  name      VARCHAR(50),          
  password  VARCHAR(50),          
  telphone VARCHAR(15),        
  username  VARCHAR(50),          
  isadmin   VARCHAR(5)             
);

--地区表
--地区id
--地区名
create table district
(
  id   int primary key ,          
  name VARCHAR(50) 
);
--街道表
--街道id
--街道名
--地区id
create table street
(
  id        int primary key,      
  name        VARCHAR(50),        
  district_id int               
);

--房屋类型表
--类型id
--类型名
create table housetype
(
  id    int primary key auto_increment,            
  name VARCHAR(20) 
)
select name from street where district_id=1004
--房屋信息表
--信息id
--发信息人id
--房屋类型id
--信息标题 
--描述
--价格
--发布日期
--面积
--联系方式
--街道id
create table house
(
  ID          int primary key auto_increment,                
  USER_ID     int,                
  TYPE_ID     int,                 
  TITLE       NVARCHAR(50),          
  DESCRIPTION text,     
  PRICE       double,                
  PUBDATE     DATE,                  
  floorage    int,   --面积              
  contact     VARCHAR(100),--联系方式        
  STREET_ID   int                 
);


select * from street where district_id=1004 
select * from street where district_id=1004
select id,name from street where district_id=1004
--根据区id查所有的街道 
select * from district
select * from street
select * from street where district_id=1004;
select street.name from district left join street on district.id=street.district_id
 where id=1004;

select title,type_id,STREET_ID,id from house 
select * from  house  where id='1'
    (select title,type_id,STREET_ID,id from house )
select * from housetype;
select * from house
select * from users;
select * from users where id=1
select count(1) from users where username='x'
				select * from users where username='a' and password='a'

insert into house(user_id,type_id,title,DESCRIPTION,price,PUBDATE,floorage,contact,street_id)
values(4,1,'花果山','安逸','250',
				'2018-08-12',1500,'123456789',100)
				
				
insert into house(USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,
           PUBDATE,floorage,contact,STREET_ID)
values(4,1,'水帘洞','舒适','150',
          '2018-08-10',1000,'123456789',1000)
   				
	insert into house(USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,
           PUBDATE,floorage,contact,STREET_ID)
values(9,2,'天子三号','舒适+1','150',
          '2018-08-19',1000,'123456789',1000)
   insert into house(USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,
           PUBDATE,floorage,contact,STREET_ID)
values(9,2,'天子四号','舒适+2','150',
          '2018-08-19',1000,'123456789',1000)
   		insert into house(USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,
           PUBDATE,floorage,contact,STREET_ID)
values(9,2,'天子五号','舒适+3','150',
          '2018-08-19',1000,'123456789',1000)
insert into house(USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,
           PUBDATE,floorage,contact,STREET_ID)
values(9,2,'天子六号','舒适+4','150',
          '2018-08-19',1000,'123456789',1000)						
	  		insert into house(USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,
           PUBDATE,floorage,contact,STREET_ID)
values(9,2,'天子七号','舒适+5','150',
          '2018-08-19',1000,'123456789',1000)									
select * from house
update house set  user_id=9,type_id=1,title='地字2号',description='舒适++',price='250',
				pubDate='2018-08-22',floorage=2000,contact='223456789',
				street_id=1000
				where id=26
select id,user_id,type_id,title,description,price,pubDate,floorage,contact,street_id
from house
limit 0,5