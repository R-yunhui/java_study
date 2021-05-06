#### mysql查询当前数据库的锁信息
```java
show status like 'innodb_row_lock%';

Innodb_row_lock_current_waits  //当前正在等待锁定的数量；
Innodb_row_lock_time    //从系统启动到现在锁定总时间长度；
Innodb_row_lock_time_avg    //每次等待所花平均时间；
Innodb_row_lock_time_max    //从系统启动到现在等待最常的一次所花的时间；
Innodb_row_lock_waits    //系统启动后到现在总共等待的次数；
```

