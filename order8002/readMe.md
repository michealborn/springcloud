##ribbon的几种负载均衡方式
RoundRobinRule -- 轮询  
RandomRule -- 随机  
RetryRule -- 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内进行重试  
WeightedRResponseTimeRule -- 对RoundRobinRule策略的扩展，响应速度越快的权重越大，越容易被选择  
BestAvailableRule -- 先过滤掉由于访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务    
AvailabilityFilteriingRule -- 先过滤掉故障实例，再选择并发小的实例  
ZoneAvoiDanceRule -- 默认规则，复合判断server所在区域的性能h和server可用性选择服务器  
