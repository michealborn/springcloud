package com.github.zz.lb;

import com.alibaba.fastjson.JSON;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Slf4j
public class MyLoadBalancer2 extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        try{
            log.info("iClientConfigToJSON:{}", JSON.toJSONString(iClientConfig));
        }catch (Exception e){
            log.error("iClientConfig,JSON化错误,tostring:{}",iClientConfig.toString());
        }
    }

    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = getLoadBalancer();
        try{
            log.info("objectToJSON:{}", JSON.toJSONString(o));
        }catch (Exception e){
            log.error("object,JSON化错误,tostring:{}",o.toString());
        }
        //可用的serverList
        List<Server> reachableServers = loadBalancer.getReachableServers();
        //当前所有serverList
        List<Server> allServers = loadBalancer.getAllServers();
        int i = new Random().nextInt(allServers.size());
        Server server = allServers.get(i);
        try{
            log.info("serverToJSON:{}", JSON.toJSONString(server));
        }catch (Exception e){
            log.error("server,JSON化错误,tostring:{}",server.toString());
        }
        return server;
    }
}
