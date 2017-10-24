go 文件夹存放的是 go 服务端的代码
java 文件夹存放的是 java 客户端的代码
protoFile 存放的是 proto 文件

go 文件夹下的 proto 存放的是根据 proto 文件生成的 go 代码
go 文件夹下的 script 存放的是根据 proto 文件生成 go 代码的 shell 脚本
    执行就会根据 ProtoFile 文件夹的 proto.proto 文件生成对应的 go 代码
go 文件夹下的 server 文件夹是我写的服务端代码

java 文件夹下的 io.grpc 文件夹是放置根据 proto 文件生成的 java 代码
java 文件夹下的 client 文件夹是放置我写的客户端的代码
使用 mvn install 或者 mvn verify 就会根据 proto 文件生成 java 代码

request 是请求数据的封装
response 是响应数据的封装
stream 是表示请求或者响应采用流的形式 (就是说一次发几个对象或者返回几个对象)