package cn.com.sina.alan.b.in;

import org.springframework.cloud.stream.converter.AbstractFromMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.util.MimeType;

/**
 * @author Ilayaperumal Gopinathan
 */
@Configuration
public class Converters {

	//Register custom converter
	@Bean
	public AbstractFromMessageConverter fooConverter() {
		return new FooToBarConverter();
	}

	public static class Foo {

		private String value = "foo";

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public static class Bar {

		private String value = "init";

		public Bar(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	public static class FooToBarConverter extends AbstractFromMessageConverter {

		public FooToBarConverter() {
			super(MimeType.valueOf("test/bar"));
		}

		@Override
		protected Class<?>[] supportedTargetTypes() {
			return new Class[] {Bar.class};
		}

		@Override
		protected Class<?>[] supportedPayloadTypes() {
			return new Class<?>[] {Foo.class};
		}

		@Override
		public Object convertFromInternal(Message<?> message, Class<?> targetClass, Object conversionHint) {
			Object result = null;
			try {
				if (message.getPayload() instanceof Foo) {
					Foo fooPayload = (Foo) message.getPayload();
					result = new Bar(fooPayload.getValue());
				}
			}
			catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new MessageConversionException(e.getMessage());
			}
			return result;
		}
	}
}
