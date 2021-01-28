USE db;

CREATE TABLE IF NOT EXISTS `user` (
    `username` VARCHAR(30) NOT NULL ,
    `password` VARCHAR(60) NOT NULL ,
    PRIMARY KEY(`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `emotion_reason` (
    `username` VARCHAR(30) NOT NULL ,
    `emotion_id` INT(11),
    `reason` VARCHAR(100),
    CONSTRAINT `emotion_reason_user_username_fk` FOREIGN KEY (`username`) REFERENCES `user`(`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;