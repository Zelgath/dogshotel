CREATE USER 'dogshoteluser'@'localhost' IDENTIFIED BY 'spike';
GRANT INSERT, SELECT, DELETE, UPDATE ON dogshotel. * TO 'dogshoteluser'@'localhost';

CREATE TABLE `cage` (
	`id_cage` int not null auto_increment,
    `description` varchar(255) default null,
    `free` boolean default true,
	`occupied` boolean default true,
    `price` int default 0,
    primary key (`id_cage`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET= utf8mb4;