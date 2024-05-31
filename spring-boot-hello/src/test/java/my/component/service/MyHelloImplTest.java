package my.component.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AppConfig.class)
public class MyHelloImplTest {

	@Autowired
	MyHello myHello;

	@Test
	public void testSayHello() {
		Assertions.assertNotNull(myHello);
		String result = myHello.sayHello("Toto");
		Assertions.assertEquals("Hello : Toto", result);
	}
}
