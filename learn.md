# spring-cloud-vue
learn
## 工程说明

* cloud-eureka-server：注册中心。
    springboot
    http://localhost:8888/
    
* cloud-config-server：配置中心。
    springboot
    1111
Spring Cloud Config项目提供了一个解决分布式系统的配置管理方案。它包含了Client和Server两个部分。

Spring Cloud Config Sever的管理git或svn的外部配置，集中配置到所有客户端。

Spring Cloud Config Client根据Spring框架的Environment和PropertySource从Spring Cloud Config Sever获取配置。
    
* cloud-simple-service：自定义的微服务。
    springboot
    80
    
    swagger rest api测试管理界面
    http://localhost/v2/api-docs
    http://localhost/swagger-ui.html
    
* cloud-zipkin-ui：分布式链路调用监控系统，聚合各业务系统调用延迟数据，达到链路调用监控跟踪。
    springboot
    9012
    
* cloud-vue : vue（Vue2.x + Vue-router2.x + Vuex)的前端项目

        fore-end/cloud-vue/.eslintrc.json  进行eslint 校验配置
    8080  
    
        admin 123456
        
* 数据库使用的mysql数据库        