# 配置中心的服务端
### 本项目说明
* 具体的配置文件在项目cibei-config-center中
* 另起项目的原因在于：配置中心每次都要同步config指向的整个工程，原工程过大导致很慢
### 项目cibei-config-center说明
* 指向的配置文件是：iciyun-adi-microframe-config/target/classes/order（例，可多个）
* 因原配置中有大量的@--@取值，@会引起配置中心读取错误，所以要将@替换
* 此处直接沿用原项目中的plugin进行替换，故先mvn clean install 再指向target下文件即可
* 需配置git中的webhook
* 测试环境为方便，已将权限验证关闭，如需要可设为true打开

~~~
management:
  security:
    enabled: false
~~~

* 查看配置是否正确地址：[192.168.14.97:10900/order-service/test/dev](192.168.14.97:10900/order-service/test/dev)  
  test是profile  
  dev是开发分支


## Client客户端使用

### 接入Config Client
* POM文件中添加如下依赖

  ~~~
        <!--config center-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
  ~~~

* 按Order模块中样例添加**bootstrap.yml**配置文件（注意添加Rabbit配置）

* 类上添加注解：@RefreshScope

