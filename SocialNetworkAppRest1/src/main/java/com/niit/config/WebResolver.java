package com.niit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.niit")
public class WebResolver {
	
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		System.out.println("Resolver Called");
		InternalResourceViewResolver irv=new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/jsp");
		irv.setSuffix(".jsp");
		return irv;
		
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getmultipartResolver() {
	    CommonsMultipartResolver cr = new CommonsMultipartResolver();
	    cr.setMaxUploadSize(1000000);
	    return cr;
	}

}
