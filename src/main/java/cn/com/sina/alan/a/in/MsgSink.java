package cn.com.sina.alan.a.in;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class MsgSink {

	@StreamListener(Sink.INPUT)
	public void messageSink(Object payload) {
		System.out.println("Received: " + payload);
	}
	
//	@StreamListener(Sink.INPUT)
//	public void receiver(Message<Object> message) {
//		Object obj = message.getPayload();
//		System.out.println("接受对象:" + obj);
//	}

}
