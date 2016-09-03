package cn.com.sina.alan.b.in;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

import cn.com.sina.alan.b.in.Converters.Bar;

/**
 * @author Ilayaperumal Gopinathan
 */
@EnableBinding(SampleSink.Sink.class)
public class SampleSink {

	// Sink application definition
	@StreamListener(Sink.SAMPLE)
	public void receive(Converters.Bar barMessage) {
		System.out.println("******************");
		System.out.println("At the Sink");
		System.out.println("******************");
		System.out.println("Received transformed message " + barMessage.getValue() + " of type " + barMessage.getClass());
	}

	public interface Sink {
		String SAMPLE = "sample-sink";

		@Input(SAMPLE)
		SubscribableChannel sampleSink();
	}
}
