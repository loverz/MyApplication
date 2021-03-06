# socket相关
### 1.socket流程
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

### 2.三次握手
![Image text](../pic/socket_three_hands_connect.png)

* 客户端向服务器发送一个SYN J
* 服务器向客户端响应一个SYN K，并且对SYN J 进行确认 ACK J+1
* 客户端再向服务器发一个确认ACK K+1

**这里会阻塞客户端的 connect 同时也会阻塞服务器的accept().**

三次握手中还存在 半连接队列和全连接队列。分别存在第一次握手之后，服务器会把这个连接信息放到半连接队列里面。
同时恢复SYN K 及第二次握手。在进行第三次握手之后，如果全连接队列没有满，则会直接把连接信息从半连接队列中拿到全连接
队列中。如果全连接队列满了，会根据设置的值进行处理，是直接返回错误，还是执行重试（过一段时间才会再次发ack给client）。
### 3.demo实例
<code>
      // 服务端代码
    
    #include<stdio.h>
    #include<string.h>
    #include<netinet/in.h>
    #include<sys/types.h>
    #include<sys/socket.h>
    
    #define MAXLINE 4096
    int main(int argc, char** argv) {
        int listenfd,connfd;
        struct sockaddr_in seraddr;
        char buff[4096];
        int n;
        if((listenfd = socket(AF_INET,SOCK_STREAM,0)) == -1){
            printf("create socket error!");
            exit(0);
        }
        memset(&servaddr,0,sizeof(servaddr));
        servaddr.sin_family = AF_INET;
        servaddr.sin_addr.s_addr = htonl(INADDR_ANY);
        servaddr.sin_port = htons(6666);
        //绑定端口
        
        if(bind(listenfd, (struct sockaddr*) &servaddr,sizeof(servaddr))== -1){
            printf("bind socket error: %s code: %d",strerror(errno),errno);
            exit(0);        
        }
        if(listen(listenfd,10) == -1){
            printf("listen socket error");
            exit(0);
        }
        printf("==================waiting request================");
        while(1){
            if((connfd = accept(listenfd,,(struct sockaddr*) NULL,NULL)) == -1){
                printf("accept error");
                continue;
            }
            n = recv(connfd,buff,MAXLINE,0);
            buff[0] = '\0';
            printf(" %s",buff);
            close(connfd);
        }
        close(listenfd);
    }
    

</code>
