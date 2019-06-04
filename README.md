#外键
```
  PRIMARY KEY  (`ID`),
  KEY `FK_Reference_8` (`UID`),//指定UID为外键
  //关联account表UID--User表id
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`UID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```