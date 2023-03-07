CREATE TABLE `users` (
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(50) NOT NULL,
`password` VARCHAR(500) NOT NULL,
`enabled` INT NOT NULL,
PRIMARY KEY (`id`)
);

create table `authorities` (
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(50) NOT NULL,
`authority` VARCHAR(50) NOT NULL,
PRIMARY KEY('id')
);


INSERT IGNORE INTO `users` VALUES(NULL, 'happy', '12345', '1');
INSERT IGNORE INTO `authorities` VALUES(NULL, 'happy', 'write');


SELECT * FROM `users` LIMIT 100
SELECT * FROM `authorities`LIMIT 100