package cn.com.sina.alan.a.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sink3Application {

	public static void main(String[] args) {

		String[] args2 = new String[]{"--server.port=8803","--spring.profiles.active=ain3"};
		SpringApplication.run(Sink3Application.class, args2);

	}
	
}
