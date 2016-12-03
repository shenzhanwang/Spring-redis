# Spring-redis
  随着Nosql分布式数据库的不断出现，各种非关系型数据库的重要性日益涌现。redis是一个在内存中运行的键值数据库，是一个业界闻名的分布式缓存。本项目基于Spring平台，整合redis数据库，为我们的业务逻辑添加redis数据缓存的功能。主要特性如下：
  
  1.redis的连接基于Spring-data-redis模块，官网：http://projects.spring.io/spring-data-redis/
  
  2.界面的功能与项目http://git.oschina.net/shenzhanwang/SSM 一模一样，只是在业务逻辑层ActorServiceImpl中添加了缓存支持；
  
  3.添加缓存使用@Cacheable注解，清空缓存使用@CacheEvict注解。一般读取方法需要添加@Cacheable，而删除、更新、添加需要使用@CacheEvict，以防止失效的缓存数据在前端进行了展示；
  
  4.为了不引起歧义，缓存的名称保持与方法名相同；
  
  5.为了表明一个操作是读取缓存数据还是拉取数据库数据，方法体中有控制台输出，如果是读取缓存则不会有控制台输出:
       ![alt text](https://github.com/shenzhanwang/Spring-redis/blob/master/%E6%88%AA%E5%9B%BE/2.jpg)
       
 6.当访问了一次actor列表的页面后，我们看到redis数据库中新增了记录：
     ![alt text](https://github.com/shenzhanwang/Spring-redis/blob/master/%E6%88%AA%E5%9B%BE/3.jpg)
     
 7.以下是添加了缓存的页面：
  ![alt text](https://github.com/shenzhanwang/Spring-redis/blob/master/%E6%88%AA%E5%9B%BE/1.jpg)
