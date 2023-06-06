# 配置环境

1.创建数据库时，字符集选择utf8mb4，排序规则选择utf8mb4_unicode_ci

2.在D盘下建立logs文件夹，文件夹中建立info和error两个文件夹
3.java版本使用java11
4.maven中进行修改setting.xml,修改的内容是

````
<profile>
<id>jdk-11</id>
<activation>
<activeByDefault>true</activeByDefault>
<jdk>11</jdk>
</activation>
<properties>
<maven.compiler.source>11</maven.compiler.source>
<maven.compiler.target>11</maven.compiler.target>
<maven.compiler.compilerVersion>11</maven.compiler.compilerVersion>
</properties>
</profile>

  </profiles>
````

5.在mysql中创建一个事件，每隔一个月删除一次log表，并将自增id恢复成1

````
-- 如果是0就执行这个语句
set global event_scheduler=1;  
-- 然后执行下面句子
use showselfdemo
CREATE EVENT delete_tablemonth
ON SCHEDULE
every 2592000 second 
DO
BEGIN
DELETE FROM show_log;
alter table show_log auto_increment=1;
END;
-- 查看事件
show events
-- 删除事件
drop event if exists delete_tablemonth;
````

