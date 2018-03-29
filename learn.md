# spring-cloud-vue
learn
## 后端工程说明

### **cloud-eureka-server：注册中心。**
    
* Eureka作为服务注册中心对整个微服务架构起着最核心的整合作用。
    
    包含eureka-core模块、eureka-client模块、eureka-server模块。
    `com.netflix.eureka.resources.ApplicationResource//web 控制器`
    
    Spring Cloud Netflix Eureka Server模块
   
    `@EnableEurekaServer @EnableEurekaClient`
    
* Eureka保证AP

   CAP理论指出，一个分布式系统不可能同时满足C(一致性)、A(可用性)和P(分区容错性)
   
* 访问地址http://localhost:8888/
    
### **cloud-config-server：配置中心。**

* 分布式系统的配置管理

   Spring Cloud Config项目提供了一个解决分布式系统的配置管理方案。它包含了Client和Server两个部分。
   
   Spring Cloud Config Sever的管理git或svn的外部配置，集中配置到所有客户端。
    
    `@EnableConfigServer `  
   
   Spring Cloud Config Client根据Spring框架的Environment和PropertySource从Spring Cloud Config Sever获取配置。
   
   `@EnableDiscoveryClient`
    
* 访问地址http://localhost:1111/
    
### **cloud-simple-service：自定义的微服务。**
  
* 技术栈：mybatis tkmybatis
* 访问地址

    API： http://localhost/ 
     
    RESTful接口文档： http://localhost/swagger-ui.html
    
    服务器性能监控： http://localhost/monitoring  
         
    
### cloud-zipkin-ui：

* 分布式链路调用监控系统，聚合各业务系统调用延迟数据，达到链路调用监控跟踪。
    服务器
    `@EnableZipkinServer`
    客户端
    `@EnableDiscoveryClient`
* 访问地址   http://localhost:9012
    
    
### **数据库使用的mysql数据库** 
    
## 前端工程说明 
* **cloud-vue** : vue（Vue2.x + Vue-router2.x + Vuex)的前端项目

    fore-end/cloud-vue/.eslintrc.json  进行eslint 校验配置
    
    端口8080  用户admin 密码123456
    
        
       