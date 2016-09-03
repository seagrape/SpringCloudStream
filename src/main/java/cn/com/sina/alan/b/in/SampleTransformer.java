package cn.com.sina.alan.b.in;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author Ilayaperumal Gopinathan
 */
@EnableBinding(Processor.class)
//@EnableRxJavaProcessor
public class SampleTransformer {

	private static final String TRANSFORMATION_VALUE = "HI";

	// Transformer application definition

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
//	@ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
//	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public Converters.Bar receive(Converters.Bar barMessage) {
		System.out.println("******************");
		System.out.println("At the transformer");
		System.out.println("******************");
		System.out.println("Received value "+ barMessage.getValue() + " of type " + barMessage.getClass());
		System.out.println("Transforming the value to " + TRANSFORMATION_VALUE + " and with the type " + barMessage.getClass());
		barMessage.setValue(TRANSFORMATION_VALUE);
		return barMessage;
	}
	
//	@Bean
//	public RxJavaProcessor<String,String> processor() {
//		return inputStream -> inputStream.map(data -> {
//			System.out.println("Got data = " + data);
//			return data;
//		}).buffer(5).map(data -> String.valueOf(avg(data)));
//	}
//
//	private static Double avg(List<String> data) {
//		double sum = 0;
//		double count = 0;
//		for(String d : data) {
//			count++;
//			sum += Double.valueOf(d);
//		}
//		return sum/count;
//	}
}
