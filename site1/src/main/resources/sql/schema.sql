DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`idx`)
);

CREATE TABLE `post` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `user_idx` int(11) NOT NULL,
  PRIMARY KEY (`idx`),
  KEY `FK8fepup8sn6kmveiiffdcab7sc` (`user_idx`),
  CONSTRAINT `FK8fepup8sn6kmveiiffdcab7sc` FOREIGN KEY (`user_idx`) REFERENCES `user` (`idx`)
)
