package com.bsoft.consumer.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手写轮询算法
 * 这里首先有一个原子类int型,初始值为0,这里用了一个自旋锁,让他判断每次是不是我们之前的那个值,如果是就+1代表访问次数又增加一次,不是就继续循环直到判断为真跳出循环,这里保证了不用synchronized方法也能在高并发下实现线程安全的增加次数
 第二个方法instances()实现了用当前访问次数去%一个集群的数量,使这个值永远不超过集群数量,然后得到这个值作为获取单个实例的下标,返回一个当前应该返回的集群实例。
 */
@Component
public class MyLB implements LoadBalancer{

    //原子类
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get();
            //超过最大值，为0，重新计数 2147483647 Integer.MAX_VALUE
            next=current >= 2147483647 ? 0 :current + 1;
            //自旋锁
        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*******第几次访问，次数next"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index=getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
