package my.component.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = AppConfig.class)
public class MyHelloImplTest {

	@Autowired
	MyHello myHello;

	@Test
	public void testSayHello() {
		Assert.notNull(myHello);
		String result = myHello.sayHello("Toto");
		Assertions.assertEquals("Hello : Toto", result);
	}
}
