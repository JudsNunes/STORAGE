package com.almoxarifado.empetur.almoxarifado.sin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.main.allow-bean-definition-overriding=true",
		"spring.jpa.hibernate.ddl-auto=create-drop"
})
class AlmoxarifadoSinApplicationTests {

	@Test
	void contextLoads() {
	}

}
