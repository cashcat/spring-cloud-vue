package cloud.simple.crawler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableWebMvc
@MapperScan(basePackages={"cloud.simple.crawler.dao","com.framework.common.base"})
public class CloundSimpleCrawlerApplication extends WebMvcConfigurerAdapter  {
	
    public static void main(String[] args) {
    	SpringApplication.run(CloundSimpleCrawlerApplication.class, args);
    }

}	
