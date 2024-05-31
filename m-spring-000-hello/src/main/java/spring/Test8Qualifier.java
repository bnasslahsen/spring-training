package spring;

import spring.qualifier.ServiceFacturation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test8Qualifier {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/spring-config-8-qualifier.xml");
		//
		ServiceFacturation serv = context.getBean(ServiceFacturation.class);
		serv.faireMachin();
		//
		context.close();
	}
}
