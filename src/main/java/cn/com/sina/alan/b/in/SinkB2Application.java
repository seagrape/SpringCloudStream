package cn.com.sina.alan.b.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SinkB2Application {

	public static void main(String[] args) {

		String[] args2 = new String[]{"--server.port=8805","--spring.profiles.active=b"};
		SpringApplication.run(SinkB2Application.class, args2);

	}
	
}
