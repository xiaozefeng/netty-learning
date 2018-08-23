# Netty 学习
## Netty 服务端启动过程
### 创建服务端Channel
1. newSocket() 通过jdk来创建地底层jdk channel
2. NioServerSocketChannelConfig() tcp参数配置
3. AbstractNioChannel(), ch.configureBlocking(false); 阻塞模式
4. AbstractChannel中创建id, unsafe, pipeline等组件
### 初始化服务端Channel
### 注册selector
![](https://ws2.sinaimg.cn/large/006tNbRwgy1fujla9jry2j311m0okh5m.jpg)
### 端口绑定

