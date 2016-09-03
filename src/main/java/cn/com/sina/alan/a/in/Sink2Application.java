package cn.com.sina.alan.a.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sink2Application {

	public static void main(String[] args) {

		String[] args2 = new String[]{"--server.port=8802","--spring.profiles.active=ain2"};
		SpringApplication.run(Sink2Application.class, args2);

	}
	
}
