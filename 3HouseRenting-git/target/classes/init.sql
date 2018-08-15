
insert into DISTRICT (ID, NAME)
values (1001, '东城');
insert into DISTRICT (ID, NAME)
values (1002, '西城');
insert into DISTRICT (ID, NAME)
values (1003, '石景山');
insert into DISTRICT (ID, NAME)
values (1006, '朝阳');
insert into DISTRICT (ID, NAME)
values (1000, '丰台');
insert into DISTRICT (ID, NAME)
values (1004, '海淀');

insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '知春路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '中关村大街', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, '学院路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '朝阳路', 1006);


insert into housetype ( NAME)
values ('一室一厅');
insert into housetype ( NAME)
values ('一室两厅');
insert into housetype ( NAME)
values ( '两室一厅');
insert into housetype ( NAME)
values ( '两室两厅');
insert into housetype ( NAME)
values ('三室一厅');
insert into housetype ( NAME)
values ( '三室两厅');
insert into housetype (NAME)
values ( '四室一厅');
insert into housetype ( NAME)
values ( '四室两厅');
insert into housetype ( NAME)
values ( '四十三厅');

insert into USERS ( NAME,password,telphone,username,isadmin)
values ( 'yao','a','18374715691','a','1');
insert into USERS ( NAME,password,telphone,username,isadmin)
values ( 'yao2','a','18374715691','a2','1');
insert into USERS ( NAME,password,telphone,username,isadmin)
values ( 'yao3','a','18374715691','a3','1');


insert into users(name,password,telphone,username,isadmin)
values (#{name},#{password}),#{telphone},#{username},
				#{isadmin}</when>
						<otherwise>'0'</otherwise>
				</choose>
				}







insert into house(USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,
           PUBDATE,floorage,contact,STREET_ID)
values(4,1,'水帘洞','舒适','150',
          '2018-08-10',1000,'123456789',1000)
     

select * from house;


select * from housetype;

select * from street;
select * from district;
select * from users;

