
#技术栈

JAVA SE 
数据结构、算法-->Collection
设计模式
NIO、juc、多线程、jvm  面试必备
Spring全家桶：AOP(代理cglib asm)  IOC、DI-->容器：放对象bean(xml、annotation)|取对象-->bean加载过程-->消息转换器 HttpMessageConverter
tips：面向容器取对象的过程叫控制反转，如果要取的这个对象比较复杂，比如对象的属性是另一个对象的话，这时spring会先初始化依赖的对象。
      这个过程称之为依赖注入（Spring 循环依赖问题...）
中间件
分布式、微服务
SQL


##集合

集合体系：java.util包中：主要包含三大类List、Set、Map
Collection是List Set Queue的顶层接口，主要定义了集合类公共的方法（add contains size remove iterator）
Iterator模式：遍历集合元素
Map:映射表顶层接口
    HashMap:
            数据结构：数组、链表、红黑树（jdk1.8）
            hash算法：hashCode^(hashCode>>>16)
            数组下标的计算：hash%16
            hash冲突：hash%16的取值相同，数组中存的是链表，当长度超过8时jdk1.8会转成红黑树来提升性能
    Hashtable:
    TreeMap:
    CurrentHashMap:
List的实现类（有序可重复）：ArrayList（数组、扩容1.5 DEFAULT_CAPACITY = 10）、LinkedArrayList(链表)、Vector(数组、扩容2)
Set的实现类（无序不可重复）：
                        HashSet:底层是hash表实现，存取快，内部是HashMap
                        TreeSet:二叉树实现，排序存储
                        LinkedHashSet:


##线程


- java为什么会有多线程问题？

    前提：多线程之间不能相互传递数据通信，它们之间的沟通只能通过共享变量来进行

    CPU计算时读取数据的优先级：寄存器>高速缓存>内存  
    线程计算时，原始数据来自于内存。在计算过程中有些数据可能被频繁读取，这些数据被存储在寄存器和高速缓存中。
    当线程计算完成后，这些数据在适当的时候应该写回内存，当多个线程同时读写某个内存数据时。由于涉及数据的可见性、
    操作的有序性，所以就产生了多线程并发问题

- java的解决方案
    JLS定义了一个统一的内存管理模型JMM(Java Memory Model)：屏蔽了底层平台内存管理细节，在多线程环境中必须解决
    可见性(volatile)和有序性问题(synchronized Lock)


CAS 
lock cmpexchg

##线程池

- 为什么需要线程池?

- jdk中创建线程池的工厂：java.util.concurrent.Executors

    newSingleThreadExecutor（）：
        底层：new FinalizableDelegatedExecutorService
                       (new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()));
        特点：核心线程和最大线程数大小一样都是1，阻塞队列是LinkedBlockingQueue
        工作机制：
                1. 线程池中没有线程时，新建一个线程执行任务
                2. 有一个线程以后，将任务加入阻塞队列，不停加加加
                3. 唯一的这一个线程不停地去队列里取任务执行
        适用场景：适用于串行执行任务的场景，每个任务必须按顺序执行，不需要并发执行
        
    newCachedThreadPool():
        底层：new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>())
        工作机制：
                1. 没有核心线程，直接向SynchronousQueue中提交任务
                2. 如果有空闲线程，就去取出任务执行；如果没有空闲线程，就新建一个
                3. 执行完任务的线程有60秒生存时间，如果在这60s内接到新任务就可以继续活下去，否则就拜拜
        适用场景：用于并发执行大量短期的小任务
    
    newFixedThreadPool(int nThreads):
        底层：new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
        特点：核心线程数和最大线程数一样，阻塞队列是LinkedBlockingQueue
        工作机制：
                1. 线程数小于核心线程时，新建线程执行任务
                2. 线程数达到核心线程后，将任务加入到阻塞队列LinkedBlockingQueue
                3. 执行完任务的线程反复去阻塞队列中那任务执行
        适用场景：适用于处理CPU密集型的任务，确保CPU在长期被工作线程使用的情况下，尽可能的少的分配线程即可。一般N*cpu+1 
    
    newScheduledThreadPool

-code example:com.ai.mvc.interview.basic.juc.ThreadPool.ThreadPoolDemo




黄 24+34.5+39
张 15+171+41+100+77+94+175+25+77+81.9+46+371+83+110+141+268+90+65+32=2062.9
头发：196
口罩：69




java.util.concurrent.Executors

##事务 & spring事务

###Spring事务失效的场景
当前类里面一个没有事务的方法调用了一个有事务方式时，事务不会生效：
因为spring事务是通过aop动态代理来实现的，代理类在处理时，先要判断哪些需要进行事务的植入。而判断的依据就是有没有声明@Transactional注解

###传播行为
1、PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。
2、PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。
3、PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。
4、PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。
5、PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
6、PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。
7、PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。

##动态代理

##jvm 


    ### 内存模型(JMM)
     Run-time data areas:
     native method stacks
     Program Counter
     method area --include-->run-time constant pool
     JVM stacks
     Heap 
     
     - GC Algorithm
     
         1， Mark-Sweep(标记清除)：产生碎片
         2， Coping(拷贝)：内存浪费
         3， Mark-Compact(标记压缩)：标记清除的基础上移动内存
 
    ### 类加载机制
    ![classLoad.png](https://i.loli.net/2020/04/15/XoAHVqO7ZrbLw6a.png)
    加载（loading）-->验证(Verification)-->准备(Preparation)-->解析(Resolution)-->初始化(Initialization)-->Using-->Unloading
    
    虚拟机设计团队把加载动作放到JVM外部实现，以便让应用程序决定如何获取所需的类，JVM提供了3种类加载器：
    1. 启动类加载器（Bootstrap ClassLoader）:负责加载JAVA_HOME\lib目录中的类
    2. 扩展类加载器（Extension ClassLoader）:负责加载JAVA_HOME\ext目录中的类
    3. 应用程序类加载器(Application ClassLoader):负责加载用户路径（classpath）上的类
    
    ####双亲委派模型：主要是为了保证使用不同类加载器最终得到的都是同样一个对象
    

## 中间件（redis zk rpc mq）

zk注册中心挂了，服务之间还能不能通信?
可以的，消费者在启动时，消费者会从zk拉取注册的生产者的地址接口等数据，缓存在本地
每次调用时，按照本地存储的地址进行调用

##major framework

##DB

##netty

