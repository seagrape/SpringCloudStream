package cn.com.sina.alan;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.stream.annotation.Bindings;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.com.sina.alan.a.in.MsgSink;
import cn.com.sina.alan.a.out.SourceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SourceApplication.class)
@WebAppConfiguration
@DirtiesContext
public class SinkApplicationTests {

	@Autowired
	@Bindings(MsgSink.class)
	private Sink sink;

	@Autowired
	private Sink same;

	@Output(Source.OUTPUT)
	private MessageChannel output;

	@Test
	public void contextLoads() {
		assertNotNull(this.sink.input());
	}

}
