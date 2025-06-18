# Background Management System

## 介绍

后台管理系统API,基于**Spring Boot** + **Mybatis-Plus**。数据库使用**Mysql**

## 功能

1. 登录、注册

2. CRUD

   具体接口信息请看Controller包下的文件

## 技术栈

- **后端框架**: [Spring Boot 3](https://spring.io/projects/spring-boot)
- **开发语言**: [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **构建工具**: [Maven](https://maven.apache.org/)
- **数据库**: [MySQL](https://www.mysql.com/) (推荐 8.0+)
- **ORM**: [MyBatis-Plus](https://baomidou.com/)
- **工具库**: Lombok

## 工具

IntelliJ IDEA 2025.1.1.1

## 环境

- Java 17.0.15

- Maven 3.9.9

- MySQL 8.0.32

## 配置

1. 导入数据库

```sh
mysql -u root -p databasename < filename.sql
```
其他导入方法也行

2. 修改配置文件的datasource部分

## 打包运行

1. 打包

```sh
mvn clean install
```

然后控制台输出信息找到jar包路径

2. 切换目录

```sh
cd /path
```

3. 运行jar包
```sh
java -jar filename.jar
```

   
