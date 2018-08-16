# IPC 进程间通信机制
IPC指的的跨进程进行数据交换的过程。
进程间通讯方式有
* 使用Bundle intent传递数据
* 文件共享
* AIDL
* Messenger
* ContentProvider
* Socket

**android中开启多进程为再manifest中配置:remote属性。**

注意两点：
1. process属性，:开头的表示为私有进程，其他应用组件不能跑到同一个进程中。
2. com.xxxx.xxx.xxx属于全局进程，其他应用可以通过UID方式和他跑到同一个进程中。


多进程会造成的问题
* 静态成员和单例模式完全失效
  * 创建了另外一个内存
* 线程的同步机制完全失效
  * 不再同一个内存，同步锁失效
* SharedPreference 可靠性降低
  * 并发操作同一个sp，会出现并发异常问题
* Application 多次初始化

### 序列化和反序列化
* 序列化就是将对象转化成可保存的字节序列
* 反序列号：将字节序列恢复成对象的过程




# Bundle通信机制
首先明确bundle实现了Parcelable接口，支持进程间通讯。

**可以看成一个支持进程间通讯的map。**

## Messenger 信使
轻量级的IPC通讯方式，底层是基于AIDL，是对AIDL的一次封装，使用简单。
