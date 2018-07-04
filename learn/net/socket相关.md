# socket相关
socket的一般操作是基于 open-write/read-close 的模式来进行操作的。
于是对应上面的过程，就存在了对应的借口函数
##### socket()函数
int socket（int domain,int type,int protocol）;创建一个socket描述符。
* domain:协议族。AF_INET、AF_INET6...
* type:socket类型。SOCK_STREAM,SOCK_RAW,SOCK_PACKET...
* protocol:协议，TCP,UDP...


##### bind()函数
将一个地址族里面的特定地址赋给socket。对应上面给的协议族，来给定是ipv4,ipv6的域名，ip，端口等。


int bind(int sockfd,sockaddr * addr,socklen_t addrlen);
* sockfd socket描述字，用来唯一表示某一个socket
* addr 地址
* addrlen 地址长度


    网络字节序和主机字节序
        这里提到有大端和小端模式，网络字节序都是大端，所以在进行socket操作之前，需要先将主机字节序转为网络字节序。
      a) Little-Endian就是低位字节排放在内存的低地址端，高位字节排放在内存的高地址端。

      b) Big-Endian就是高位字节排放在内存的低地址端，低位字节排放在内存的高地址端。

##### listen(),connect()函数
服务器用listen函数进行监听制定的socket描述字的端口，可以控制排队最大连接数。
客户端用connect函数来简历与TCP服务器的链接


##### accept()函数
TCP服务器执行了，socket(),bind(),listen()函数之后，就会监听制定的socket地址。

客户端执行 socket(),connect()之后就会跟服务器发送一个链接请求。

这个时候TCP服务器监听到了这个请求之后，就好调用accept()函数接收请求，建立好连接之后就可以忘了I/O操作了，类似操作文件。


##### read(),write()函数
有几组对应的函数
* read()/write()
* recv()/send()
* readv()/writev()
* recvmsg()/sendmsg()
* recvfrom()/sendto()

read从fd中读取数据，然后返回数据长度，如果返回0，则表示读到文件尾了。小于0则表示出错。
##### close()函数
关闭连接，注意，只有当close操作对应的这个socket的描述字引用计数尾0的生活，才会出发tcp客户端向服务器发送终止连接请求
每次调用只是将这个引用计数-1.

### 三次握手
* 客户端向服务器发送一个SYN J
* 服务器向客户端响应一个SYN K，并且对SYN J 进行确认 ACK J+1
* 客户端再向服务器发一个确认ACK K+1

这里会阻塞客户端的 connect 同时也会阻塞服务器的accept().

