# Android底层知识
### Binder 原理
跨进程通信机制，一般分为Client 进程 、Server进程、Binder驱动（Server Manager）

一般Client需要访问Server某个类方法，会返回一个代理对象（这个对象注册再Server Manager）
### AIDL 原理

