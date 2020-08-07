package org.anuvab.java.rest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
//Registering class as a provider with JAX-RS
@Provider
public class MyDateConverterProvider implements ParamConverterProvider{

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		
		if(rawType.getName().contentEquals(MyDate.class.getName())) {
			return new ParamConverter<T>() {
				
				//Since @Param annotation maps incoming request parameters, so we are interested 
				//only in String-to-DataType conversions here.
				@Override
				public T fromString(String value) {
					// TODO Auto-generated method stub
					Calendar requestedDate = Calendar.getInstance();
					if("tomorrow".equalsIgnoreCase(value)) {
						requestedDate.add(Calendar.DATE,1);
					}
					else if ("yesterday".equalsIgnoreCase(value)) {
						requestedDate.add(Calendar.DATE,-1);
					}
					MyDate myDate = new MyDate();
					myDate.setDate(requestedDate.get(Calendar.DATE));
					myDate.setMonth(requestedDate.get(Calendar.MONTH));
					myDate.setYear(requestedDate.get(Calendar.YEAR));
					
					return rawType.cast(myDate);
				}

				@Override
				public String toString(T myBean) {
					// TODO Auto-generated method stub
					
					if(myBean == null) {
						return null;
					}
					
					return myBean.toString();
				}
				
				
			};
		}
		return null;
	}
	
	

}