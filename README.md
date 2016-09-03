# SpringCloudStream
SpringCloudStream DEMO

[blog](http://blog.spring-cloud.io/blog/sc-stream.html)

项目demo需要kafka服务，自行替换配置中的参数。

	spring.cloud.stream.kafka.binder.brokers=10.79.96.52:9092
	spring.cloud.stream.kafka.binder.zk-nodes=10.79.96.52:2182

## 快速开始

按顺序启动包路径`cn.com.sina.alan.a.`下的main方法

```
1、启动Sink1Application
2、启动Sink2Application
3、启动Sink3Application
4、启动SourceApplication
```

> 如果先启动SourceApplication，则只有一个消费者能拿到所有所数据。
> 原因参见博客内容

## 调用send生产者服务，观察消费者控制台输出

```
1、curl http://localhost:8800/send/9301
2、curl http://localhost:8800/send/9302
3、curl http://localhost:8800/send/9303
```



