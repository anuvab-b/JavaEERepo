package com.telusko.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Replacement of Web.xml file
public class MyFrontController extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {MVCConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		//Config the {servletName}-servlet file equivalent.
		
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		//For all requests, use "/"
		return new String[] {"/"};
	}
	
	
}
