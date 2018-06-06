package cloud.simple.crawler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableWebMvc
@MapperScan(basePackages={"cloud.simple.crawler.dao","com.framework.common.base"})
public class CloundSimpleCrawlerApplication extends WebMvcConfigurerAdapter  {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/team/list");
        registry.addRedirectViewController("/team/list","/templates/team/list.html");
        registry.addStatusController("/403", HttpStatus.FORBIDDEN);
        super.addViewControllers(registry);
    }

    public static void main(String[] args) {
    	SpringApplication.run(CloundSimpleCrawlerApplication.class, args);
    }

}	
