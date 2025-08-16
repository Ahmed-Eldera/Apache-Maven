edit the URL - name - Password in the main function 

create table if not exists admin (
id int primary key auto_increment,
name varchar(255),
email varchar(255) unique,
password varchar(255)
)
