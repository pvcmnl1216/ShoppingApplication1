package com.niit.Demo;

//import com.niit.Demo.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	@Bean
//	public FilterRegistrationBean frb(){
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
//		filterRegistrationBean.setFilter(new JwtFilter());
//		filterRegistrationBean.addUrlPatterns("/api/v1/*");
//		return filterRegistrationBean;
//	}
}
