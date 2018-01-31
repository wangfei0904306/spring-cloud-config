# 配置中心调用的配置文件
这里是放置配置文件的地方

### 项目cibei-config-center说明
* Maven项目
* 配置文件存放位置在cibei-config-center\iciyun-adi-microframe-config\src\main\resources目录
* 若服务名为order-service，则resources下的配置目录名为order
* 配置中心服务指向的配置目录是：cibei-config-center/config-repo（例，可多个）
* 因原配置中有大量的@--@取值，@会引起配置中心读取错误，所以要将@替换,
  此处直接沿用原项目中的 plugin 进行替换，故先 mvn clean install 替换@值
* target下生成的配置文件（已经替换@值）被移动到config-repo目录下并重命名  
  （如application-**.yml重命名为order-service-**.yml)

### 如何将原项目中配置文件移到本配置文件中心
以order-service为例：
1. 在cibei-config-center\iciyun-adi-microframe-config\src\main\resources新建order目录
2. 将order-service模块下的\src\main\resources下的所有配置文件复制到order目录下
3. **执行mvn clean install 操作**
4. 上传代码至GitLab

测试：
1. 在cibei-config-center\iciyun-adi-microframe-config\src\main\resources\order目录下的
    application.yml文件下
    将2333修改为任意一个数字
    ~~~
    config:
       center:
         test: this is the test of config center 2333.
    ~~~
    
2. 在根目录cibei-config-center下执行 **mvn clean install**

3. 此时查看cibei-config-center/config-repo目录下的order-service.yml,若2333已经更改，说明正确。

4. 上传代码到GitLab

5. 打开order-service的swagger-ui,查找配置中心监控接口，调用接口。
    若返回第一步中修改的数字，说明配置正确。
    
### 注意事项
* 自动更新配置的类上面要加 ***@RefreshScope*** 注解
* 使用不当会造成启动失败、不能自动更新等问题，要控制自动更新范围