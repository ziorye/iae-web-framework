# ------------------------------------------------------------
# 表 user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `email` varchar(32) DEFAULT NULL COMMENT 'email',
                        `status` int DEFAULT 1,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB COMMENT='用户表';


INSERT INTO `user` (`id`, `name`, `password`, `email`, `status`)
VALUES
    (1,'admin','$2a$10$X/uMNuiis.fyO47cxbta3OSs2sllSeLcwVfC0.ghyxeVVZRmAbzk2','admin@example.com',1),
    (2,'user','$2a$10$X/uMNuiis.fyO47cxbta3OSs2sllSeLcwVfC0.ghyxeVVZRmAbzk2','user@example.com',1);
