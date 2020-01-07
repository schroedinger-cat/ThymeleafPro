# 英雄角⾊管理

**项⽬框架:**
+ SpringBoot+SpringMVC+Spring+Mybatis+Thymeleaf+Bootstrap 

**数据存储:** 
+ Mysql8.0.3

**实现功能:** 
+ 1.RESTful 实现CRUD操作 
+ 2.Druid连接池对sql的监控  
+ 3.集成了了Swagger2

**需要修改的地方:** 
+ [application.yml](/src/main/resources/application.yml)
+ *数据库名称:*
+ *用户名:*
+ *密码*

````yml
    url: jdbc:mysql://localhost:3306/????useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
    username: ????
    password: ????
````
**创建数据库**
+ 执行 [resources](/src/main/resources)下的.sql文件

**程序运行后查看地址**
+ 首页: http://localhost
+ Swagger2: http://localhost/swagger-ui.html
+ Druid(admin:1234): http://localhost/druid/login.html

**预览**
![](/src/main/resources/static/images/预览1.png)
![](/src/main/resources/static/images/预览2.png)



