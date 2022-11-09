package com.example.Safety;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SafetyApplicationTests {

	@Test
	void contextLoads() {
		throw new RuntimeExcepton("Only for test");
	}

}
