create table if not exists account (
    username varchar(255) primary key,
    password varchar(255),
    role int
);

create table if not exists year (
 year_id int primary key auto_increment,sys_configvariable
    year_name varchar(255),
    year_price double
);

create table if not exists class (
 class_id int primary key auto_increment,
    class_name varchar(255)
);

create table if not exists student (
 student_id int primary key auto_increment,
    student_code varchar(10),
    studentName longtext,
    student_birthday date,
    student_status bit,
    student_username varchar(255),
    student_year_id int,
    student_class_id int,
    foreign key (student_username) references `account`(username),
    foreign key (student_year_id) references `year`(year_id),
    foreign key (student_class_id) references class(class_id)
);

insert into account (username, password, role) values ('branch', '123123', 0),
             ('20CNTT', '123123', 1);
                                                    
                                                      
insert into year (year_name, year_price) values ('2022-2023', 100000);
                                                  
insert into class (class_name) values ('20CNTT');                                                  
                                        
insert into student (student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id) 
values ('SV-001', 'Ngô Ðức Tuấn', '2002-10-04', 1, '20CNTT', 1, 1),
    ('SV-002', 'Bùi Việt Hùng', '2002-05-18', 0, 'branch', 1, 1),
    ('SV-003', 'Lương Minh Sơn', '2002-12-05', 1, '20CNTT', 1, 1),
    ('SV-004', 'Nguyễn Bích Như', '2002-06-17', 0, '20CNTT', 1, 1),
    ('SV-005', 'Trần Phương Linh', '2002-09-26', 1,'20CNTT', 1, 1),
    ('SV-006', 'Dương Diễm Trang', '2002-06-12', 0, '20CNTT', 1, 1),
    ('SV-007', 'Nguyễn Vĩnh Long', '2002-08-08', 1, '20CNTT', 1, 1),
    ('SV-008', 'Hoàng Ngọc Loan', '2002-12-24', 0, '20CNTT', 1, 1),
    ('SV-009', 'Trần Thanh Hương', '2002-04-15', 1, '20CNTT', 1, 1),
    ('SV-010', 'Đỗ Xuân Nam', '2002-03-09', 0, '20CNTT', 1, 1);