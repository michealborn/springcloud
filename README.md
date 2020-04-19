# springcloud

cloud-api-common -- 公共类jar包  
eureka7001 -- 第一台eureka  
eureka7002 -- 第二台eureka  
order8002 -- 订单服务1 client消费者 ribbon相关  
order8005 -- 订单服务2 client消费者  注册进zookeeper的  
order8007 -- 订单服务3 注册金sonsul  
payment8001 -- 支付服务集群1  client提供者  
payment8003 -- 支付服务集群2  client提供者  
payment8004 -- 支付服务 注册进zookeeper  
payment8006 -- 支付服务 注册金consul  
order8008 -- 订单服务4 openFeign相关使用  
payment8009 -- 带熔断的支付 hystrix服务端演示  
order8010 -- 订单服务4 hystrix消费端调用  
hystrixdashboard9001 -- hystrix 可视化界面，监控所有被hystrix绑定的接口的成功失败情况  
gateway9002 -- 新的网关 spring出品  替代zuul  
...