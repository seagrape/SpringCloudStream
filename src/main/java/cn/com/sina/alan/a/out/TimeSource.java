package cn.com.sina.alan.a.out;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

//@EnableBinding(Source.class)
public class TimeSource {

	@Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerMessageSource() {
		
//		return () -> new GenericMessage<>(new SimpleDateFormat().format(new Date()));
        return new MessageSource<String>() {
			public Message<String> receive() {
				System.out.println("******************");
				System.out.println("At the TimeSource");
				System.out.println("******************");
				
				System.out.println("Sending value: " + "wsh" + " of type " + "String");
				return new GenericMessage<String>("wsh");
			}
		};
    }

}
