package cn.com.sina.alan.b.out;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import cn.com.sina.alan.b.in.Converters;

/**
 * @author Ilayaperumal Gopinathan
 */
@EnableBinding(SampleSource.Source.class)
public class SampleSource {

	@Bean
	@InboundChannelAdapter(value = Source.SAMPLE, poller = @Poller(fixedDelay = "45000", maxMessagesPerPoll = "1"))
	public MessageSource<String> timerMessageSource() {
		return new MessageSource<String>() {
			public Message<String> receive() {
				System.out.println("******************");
				System.out.println("At the Source");
				System.out.println("******************");
				Converters.Foo foo = new Converters.Foo();
				foo.setValue("hi");
				System.out.println("Sending value: " + foo.getValue() + " of type " + foo.getClass());
				return new GenericMessage(foo);
			}
		};
	}

	public interface Source {
		String SAMPLE = "sample-source";

		@Output(SAMPLE)
		MessageChannel sampleSource();
	}
}
