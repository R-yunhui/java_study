## spring-cloud-alibaba

### nacos配置

**POM文件**

```xml
		 <!-- alibaba nacos 服务发现 -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
```

**本地配置文件**



### nacos-config配置

**POM文件**

```xml
        <!-- nacos config -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
```



### sentinel配置

**POM文件**

```xml
        <!-- 限流组件 -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>
```



### sentinel+nacos持久化策略配置

**POM文件**

```xml
		<!-- sentinel+nacos 持久化规则 -->
        <!-- SpringCloud ailibaba sentinel-datasource-nacos 持久化需要用到-->
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-datasource-nacos</artifactId>
        </dependency>
```



**本地配置文件**

```yaml
spring:
  cloud:
    sentinel:
      transport:
      # 配置规则持久化到nacos
      datasource:
        # 流控策略
        ds1:
          nacos:
          	# 命名空间
            namespace: 3c3c482f-f6c3-4ca7-b408-d7f5cb713908
            # nacos 地址
            server-addr: ${spring.cloud.nacos.config.server-addr}
            # 分组ID
            group-id: ${spring.cloud.nacos.config.group}
            # 配置文件ID
            data-id: sentine-flow-rule
            # 配置文件类型 json
            data-type: json
            # 规则类型 限流：flow  降级：degrade （param-flow，system，authority，gw-flow，gw-api-group）
            rule-type: flow
        # 降级策略
        ds2:
          nacos:
            namespace: 3c3c482f-f6c3-4ca7-b408-d7f5cb713908
            server-addr: ${spring.cloud.nacos.config.server-addr}
            group-id: ${spring.cloud.nacos.config.group}
            data-id: sentine-degrade-rule
            data-type: json
            rule-type: degrade
```



**nacos控制页面的配置文件**

```json
限流：
[
    {
        "resource": "findUserById",  // 资源名称 => @SentinelResource(value = "")的value属性 或者controller的地址
        "limitApp": "default",  // 流控针对的调用来源，若为 default 则不区分调用来源
        "grade": 1, // 限流阈值类型 （QPS或并发线程数）
        "count": 1,  // 限流阈值
        "strategy": 0, // 调用关系限流策略
        "controlBehavior": 0, // 流量控制效果 0 - 直接拒绝  1 - Warm Up  2 - 匀速排队
        "clusterMode": false // 集群模式
    }
]

熔断：
[
    {
        "resource": "findUserById", 
        "grade": 2,  // 熔断策略 支持慢调用比例/异常比例/异常数策略  deafult：慢调用比例
        "count": 1, // 慢调用比例模式下为慢调用临界 RT（超出该值计为慢调用）；异常比例/异常数模式下为对应的阈值
        "timeWindow": 1, // 熔断时长，单位为 s
        "minRequestAmount": 5, // 熔断触发的最小请求数，请求数小于该值时即使异常比率超出阈值也不会熔断（1.7.0 引入） default：5
        "statIntervalMs": "1000ms", // 统计时长（单位为 ms），如 60*1000 代表分钟级（1.8.0 引入） default：1000ms
     	"slowRatioThreshold": 1 // 慢调用比例阈值，仅慢调用比例模式有效（1.8.0 引入）
    }
]

.....
```

