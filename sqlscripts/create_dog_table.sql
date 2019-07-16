CREATE TABLE `dog` (
	`id_dog` int not null auto_increment,
    `name` varchar(255) default null,
    `race` varchar(255) default null,
    `age` int default 0,
    `id_cage` int default null,
    `sex` varchar(255) default null,
    `duration_of_stay_in_days` int default 0,
    `start_of_stay_date` date default null,
    `end_of_stay_date` date default null,
    `owner_full_name` varchar(255) default null,
    `owner_phone_number` int default 0,
    `owner_charge` int default 0,
    primary key (`id_dog`),
    CONSTRAINT FK_CAGE FOREIGN KEY (id_cage) REFERENCES cage (id_cage)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET= utf8mb4;