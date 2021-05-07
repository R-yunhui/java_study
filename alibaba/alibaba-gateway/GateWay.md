### GateWay

```java
	// 自动配置类
	org.springframework.cloud.gateway.config.GatewayAutoConfiguration   
    
	// 配置类 加载gateway的配置
	org.springframework.cloud.gateway.config.PropertiesRouteDefinitionLocator
	org.springframework.cloud.gateway.config.GatewayProperties
    
	// 配置是个List 和此类的属性做映射    
	org.springframework.cloud.gateway.route.RouteDefinition  
    
	// 几个核心的过滤器
	org.springframework.cloud.gateway.filter.GatewayFilter
	org.springframework.cloud.gateway.filter.GatewayFilterChain    
	org.springframework.cloud.gateway.filter.GlobalFilter    
```



过滤器的GatewayFilterChain 执行顺序
1. 通过GatewayFilter集合构建顶层的GatewayFilterChain
2. 调用顶层GatewayFilterChain，获取第一个Filter，并创建下一个Filter索引对应的GatewayFilterChain
3. 调用filter的filter方法执行当前filter，并将下次要执行的filter对应GatewayFilterChain传入。

