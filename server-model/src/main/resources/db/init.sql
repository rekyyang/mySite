DROP TABLE IF EXISTS user;
CREATE TABLE user(
  `userId`    BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT 'main key',
  `userName`  VARCHAR(255)  NOT NULL                  COMMENT '用户名',
  `password`  VARCHAR(255)  NOT NULL                  COMMENT '密码',
  `role`      VARCHAR(255)  NOT NULL                  COMMENT '用户类型',
  PRIMARY KEY (`userId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

