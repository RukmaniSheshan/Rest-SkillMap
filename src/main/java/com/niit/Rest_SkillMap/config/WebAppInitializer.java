package com.niit.Rest_SkillMap.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.Rest_SkillMap.filter.CORSFilter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	public void addCorsMapping(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	protected Filter[] getServletFilters() {
		Filter[] singleton =  { new CORSFilter() };
		return singleton;
	}

}
