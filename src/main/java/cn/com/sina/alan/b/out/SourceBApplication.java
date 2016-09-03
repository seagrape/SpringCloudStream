package cn.com.sina.alan.b.out;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SourceBApplication {

	public static void main(String[] args) {

		String[] args2 = new String[]{"--server.port=8803","--spring.profiles.active=b"};
		SpringApplication.run(SourceBApplication.class, args2);

	}
	
}
