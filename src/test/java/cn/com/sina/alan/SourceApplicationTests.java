package cn.com.sina.alan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.sina.alan.a.out.SourceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SourceApplication.class)
@WebAppConfiguration
@DirtiesContext
public class SourceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
