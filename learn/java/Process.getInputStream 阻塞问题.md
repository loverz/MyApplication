# Process getInputStream 阻塞问题
摘自：https://blog.csdn.net/yuanzihui/article/details/51093375

Java中 

    Runtime.getInstance().exec (String cmd) 
或者 

    new ProcessBuilder(String cmd).start() 
都会产生一个子进程对象。通过调用Process对象的waitFor()方法可以使主进程进入等待状态，直至子进程执行完毕，
再进行下一步工作。如果对子进程处理不当，有可能造成主进程阻塞，整个程序死掉。

创建进程的方法可能无法针对某些本机平台上的特定进程很好地工作，比如，本机窗口进程，守护进程，Microsoft Windows 
上的 Win16/DOS 进程，或者 shell 脚本。创建的子进程没有自己的终端或控制台。它的所有标准 io（即 stdin，stdout，
stderr）操作都将通过三个流 (getOutputStream()，getInputStream()，getErrorStream()) 重定向到父进程。父进程
使用这些流来提供到子进程的输入和获得从子进程的输出。因为有些本机平台仅针对标准输入和输出流提供有限的缓冲区大小，
，则可能导致子进程阻塞，甚至产生死锁。

#### 阻塞的问题在于此：

Process.getInputStream() getErrorStream()分别返回的是Process标准输出流和错误流，两个流如果处理不当就会导致缓冲区
不能被及时清除而被塞满，则主进程被阻塞。

### 解决方案

方案1：并发获取Process的输出流和错误流

通过启动两个线程来并发的读取和处理输出流和错误流

方案2：用ProcessBuilder的redirectErrorStream()方法合并输出流和错误流。

