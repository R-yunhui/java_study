#### rabbitMq的三种Exchange模式

```
Direct Exchange - 处理路由键：需要将一个队列绑定到交换机上，要求该消息与一个特定的路由键完全匹配。这是一个完整的匹配。如果一个队列绑定到该交换机上要求路由键 “dog”，则只有被标记为“dog”的消息才被转发，不会转发dog.puppy，也不会转发dog.guard，只会转发dog。
```

```
Fanout Exchange – 不处理路由键：你只需要简单的将队列绑定到交换机上。一个发送到交换机的消息都会被转发到与该交换机绑定的所有队列上。很像子网广播，每台子网内的主机都获得了一份复制的消息。Fanout交换机转发消息是最快的。 任何发送到Fanout Exchange的消息都会被转发到与该Exchange绑定(Binding)的所有Queue上。
```

```
Topic Exchange – 将路由键和某模式进行匹配：此时队列需要绑定要一个模式上。符号“#”匹配一个或多个词，符号“*”匹配不多不少一个词。因此“audit.#”能够匹配到“audit.irs.corporate”，但是“audit.*” 只会匹配到“audit.irs”。任何发送到Topic Exchange的消息都会被转发到所有关心RouteKey中指定话题的Queue上。
```



#### rabbitMq的消息确认

```
# 发送消息后直接确认消息
acknowledge-mode:none
# 根据消息消费的情况，智能判定消息的确认情况
acknowledge-mode:auto
# 手动确认消息的情况
acknowledge-mode:manual
```



#### docker启动rabbitMq访问web页面

```
进入容器：docker exec -it 容器ID /bin/bash 
启动 abbitmq-plugins enable rabbitmq_management
```

