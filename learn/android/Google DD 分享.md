# Google DD分享

今年的开发者大会主要有几个关键点

- 安卓10 特性
- Kotlin相关
- Flutter （1.9版本上线）
- TensorFlow

### 安卓10相关

- 5G支持
- 深色主题
- 折叠屏、全面屏适配
- AS 3.6版本更新
- Tls1.3支持
- Jetpack 
- 隐私安全

##### 隐私增强

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916141416.png)

针对下面两个层面展开讲

##### **位置权限**

- 安卓10增加仅仅在使用中才可以访问位置。
- 判定使用中：可见act，前台服务。

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916141752.png)

**对开发者建议，最小权限申请**

- 权限配置有另外一个permission 

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916142356.png)

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916142440.png)

**前台服务申请须知**

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916142613.png)

- 与target sdk版本无关。
- 前台服务声明规范

##### 外置存储

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916142733.png)

上图为某些应用错误使用外置存储被投诉的情况

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916142815.png)

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916142846.png)

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916142933.png)

- 不需要申请权限了

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916143031.png)

新增了 IS_PENDING 属性，标识图片是否 正在写状态

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916143540.png)

删除某个文件如果无权限的代码实例

##### Notification

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916143643.png)

##### 其他

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916143839.png)

##### 设备ID禁止

以前mac、wifi等信息获取手段都被屏蔽

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916144004.png)

##### WIFI api

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916144117.png)

##### 音频

用户和app都可以屏蔽

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916144200.png)

关于权限，开发者需要考虑的几个点

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916144252.png)

安卓10并不会强制，但是后面的版本会逐步要求应用强制执行

### Kotlin相关

kotlin **first**

优势

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916144831.png)



- 语言工具兼容
- 且更少bug
- 更简洁
- 高级功能

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916144959.png)

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916145019.png)

java 多态 方法重载

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916145211.png)

##### 协程（高级功能）

- 并发问题
- 解决。主线程问题，不会阻塞主线程

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916145431.png)

##### kotlin发展

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916145509.png)

##### 更多

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916145538.png)

独立另外一套扩展库

大部分代码都在库内部实现了

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916145626.png)

##### AS 支持

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916145719.png)



迁移到kotlin

1. 培养个人  学习，培养专家
2. 制定规范
3. 代码审核

推进步骤

1. 先做测试
2. 新代码编写
3. 更新旧代码

- As自带工具转换java  到kotlin 
-  java和kt文件可以共存
- Kt可以调用java所有库

说服管理层替换成kotlin

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916150623.png)

### Flutter相关

1.9版本发布，以下是 flutter的特性。flutter是一个大前端跨平台方案

- 美观
- 快速
- 高效
- 开源

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916151437.png)



![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916151502.png)

腾讯，大前端框架，原生＋flutter架构

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916151600.png)

**动画美术设计好，直接导出可用，不用再用代码写动画，然后不断沟通动画细节问题。**

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916151625.png)

人力成本节省

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916151726.png)

五个人，三个月，第一个版本上线

##### 字节跳动 flutter应用

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916151841.png)

性能损耗少，跨平台性能最好的方案

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916151859.png)

x

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916152032.png)

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916152055.png)



新公司，业务发展快，效率要求更高，所以选择flutter新技术。

##### grab分享

东南亚的，滴滴，美团加支付宝

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916152209.png)

fish redux：闲鱼团队的flutter 状态管理框架

起初有rn和flutter两个方案，但是最终迭代选择了flutter。**效率和最终应用表现**



![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916152728.png)

##### 阿里闲鱼混合框架

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916152951.png)

- 编译调试快
- 性能接近原生

碰到的问题

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916153107.png)

大部分情况都是较大原生工程

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916153216.png)

内存水位较高

- 以前是flutter 引擎多个~共用单引擎
- 缺少路由管理混合~多个导航器

##### Fluttet boost

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916153328.png)

![img](file:///Users/luoxiaozhuo/.duoyiim/users/luoxiaozhuo@henhaoji.com/image/marscreenshot20190916153400.png)