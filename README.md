<h1 align="center">Welcome to SpringBoot-sell 👋</h1>
<p>
  <a href="https://github.com/gb145234/SpringBoot-sell">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" target="_blank" />
  </a>
</p>

> 本系统是一个用SpringBoot+JPA打造的基于微信服务号平台的点餐系统的后端，前端是一个使用Vue.js构建的运行于微信公众号的WebApp。前后端完全分离，前后端之间通过RESTful风格的接口相连。

### 🏠 [主页](https://github.com/gb145234/SpringBoot-sell)

# 项目整体介绍

### 目录

- [项目介绍](http://www.sqmax.top/springboot-project/#%E9%A1%B9%E7%9B%AE%E4%BB%8B%E7%BB%8D)
- 项目设计
  - [角色划分](http://www.sqmax.top/springboot-project/#%E8%A7%92%E8%89%B2%E5%88%92%E5%88%86)
  - [功能模块划分](http://www.sqmax.top/springboot-project/#%E5%8A%9F%E8%83%BD%E6%A8%A1%E5%9D%97%E5%88%92%E5%88%86)
  - [部署架构](http://www.sqmax.top/springboot-project/#%E9%83%A8%E7%BD%B2%E6%9E%B6%E6%9E%84)
  - [数据库设计](http://www.sqmax.top/springboot-project/#%E6%95%B0%E6%8D%AE%E5%BA%93%E8%AE%BE%E8%AE%A1)
- [项目使用的技术栈](http://www.sqmax.top/springboot-project/#%E9%A1%B9%E7%9B%AE%E4%BD%BF%E7%94%A8%E7%9A%84%E6%8A%80%E6%9C%AF%E6%A0%88)
- [开发环境及工具](http://www.sqmax.top/springboot-project/#%E5%BC%80%E5%8F%91%E7%8E%AF%E5%A2%83%E5%8F%8A%E5%B7%A5%E5%85%B7)
- 项目演示
  - [卖家端（PC端）](http://www.sqmax.top/springboot-project/#%E5%8D%96%E5%AE%B6%E7%AB%AF%EF%BC%88PC%E7%AB%AF%EF%BC%89)
  - [买家端（手机微信端）](http://www.sqmax.top/springboot-project/#%E4%B9%B0%E5%AE%B6%E7%AB%AF%EF%BC%88%E6%89%8B%E6%9C%BA%E5%BE%AE%E4%BF%A1%E7%AB%AF%EF%BC%89)
  - [买家端和卖家端的通信](http://www.sqmax.top/springboot-project/#%E4%B9%B0%E5%AE%B6%E7%AB%AF%E5%92%8C%E5%8D%96%E5%AE%B6%E7%AB%AF%E7%9A%84%E9%80%9A%E4%BF%A1)

------

## 项目介绍

- 前端是由Vue.js构建的WebApp，后端由Spring Boot打造，后端的前台页面使用Bootstrap+Freemarker+JQuery构建,后端和前端通过RESTful风格的接口相连。

![](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/2343433434.jpg)

- 数据库方面使用Spring Boot+JPA，兼顾Spring Boot+Mybatis；缓存方面，使用Spring Boot+Redis；基于Redis，应对分布式Session和分布式锁；消息推送方面，使用WebSocket。

![](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/21.jpg)

- 这是一个基于微信的点餐系统，所以还涉及许多微信相关的特性，如微信扫码登陆，微信模板消息推送和微信支付和退款。

## 项目设计

### 角色划分

- 买家（手机端）：由微信公众号提供的一个服务
- 卖家（PC端）：一个简单的商家管理系统

### 功能模块划分

- 功能分析 
- ![](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/35.jpg)
- 关系图 
- ![36.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/36.jpg)

### 部署架构

- 买家端在手机端，卖家端在PC端，两端都会发出数据请求，请求首先到达nginx服务器，如果请求的是后端接口，nginx服务器会进行一个转发，转发到后面的Tomcat服务器，即我们的Java项目所在，如果这个接口作了缓存，那么就会访问redis服务器，如果没有缓存，就会访问我们的MySQL数据库。值得注意的是我们的应用是**支持分布式部署**的，也就是说图上的Tomcat表示的是多台服务器，多个应用。

  ![](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/37.jpg)

  ### 数据库设计

- 共5个表，表之间的关系如下，其中商品表（product_info）存放的就是商品的名称、价格、库存、图片链接等信息；类目表(product_category含有类目id、类目名字等信息，一个类目下有多种商品，类目表和商品表之间是一对多的关系；订单详情(order_detail)表含有购买的商品名称、数量、所属订单的订单号等信息；订单主表(order_master)包含包含该订单的订单号、买家的信息、订单状态和支付状态等信息，订单主表和订单详情表之间是一对多的关系；最后是卖家信息表(seller_info)，存放的卖家的账号和密码等信息，作为卖家后台管理的权限认证。 
  ![38.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/38.jpg)

## 项目使用的主要技术栈

- Spring Boot的相关特性
  - Spring Boot+JPA
  - Spring Boot+Redis
  - Spring Boot+WebSocket
- 微信相关特征
  - 微信支付、退款
  - 微信授权登陆
  - 微信模板消息推送
  - 使用微信相关的开源SDK
- 利用Redis应用分布式Session和分布式锁
  - 对用户的登陆信息使用分布式Session存储
  - 利用一个抢购商品的例子，来对Redis分布式锁进行详细的说明

## 开发环境及工具

- IDEA
- Maven
- MySQL
- Nginx
- Redis
- Postman，模拟用户使用微信创建订单
- Fiddler对手机请求抓包
- Natapp内网穿透
- Apache ab模拟高并发，抢购一个商品

## 项目演示

### 卖家端（PC端）

浏览器输入授权路径,进入微信扫码登陆系统页面

![24.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/24.jpg)

登陆后，从左侧导航栏可以看到有四项【订单】、【商品】、【类目】、【登出】，右侧是卖家管理系统的首页，也即【订单】界面。

![25.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/25.jpg)

对每项订单有【取消】和【详情】操作。点击【详情】来查看订单详情，来到下面的界面：

![](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/28.jpg)

我们可以选择【完结订单】或【取消订单】。

【商品】和【商品类目】下均有两项操作：【列表】【新增】。 
下面以【商品】栏为例演示。 
点击【商品】->【列表】可以查看商品的详情，可以看到对每件商品又有【修改】和【上架】/【下架】操作 。

![26.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/26.jpg)

点击商品->新增来新增商品 

![23.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/23.jpg)

### 买家端（手机微信端）

买家端是基于微信公众号的点餐app。

![29.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/29.jpg)

选购好商品后就可以去结算。

![30.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/30.jpg)

结算完成，可以看到一条微信支付凭证消息。

![31.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/31.jpg)

可以选择查看账单。

![32.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/32.jpg)

### 买家端和卖家端的通信

因为我是借用的微信公众账号，所以买家端和卖家端不能连调，我这里用Postman这个工具，发送一条post请求，来模拟微信下单。这时卖家端首页，即【订单】页面就会弹出一个窗口，并播放音乐。

![27.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/27.jpg)

点击关闭按钮，在订单页面找到找到新下的订单，点击【详情】来到订单详情界面，点击【完结订单】按钮。

![33.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/33.jpg)

这时微信那边就会收到如下的模板消息。

![42.png](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/42.jpg)



# 运行说明

## 运行环境：

1. MySQL
2. Redis。可以在解压后的根目录下看到redis-server.exe文件，双击即可启动redis服务器
3. Nginx。下载的zip压缩包，解压后根目录下有一个名为nginx.exe文件，双击即可启动nginx服务器
4. IntelliJ IDEA
5. JDK1.8+、maven等

## 运行方式：

1. 使用命令`git clone https://github.com/gb145234/SpringBoot-sell`将项目克隆到本地。
2. 将项目导入IDEA。在IDEA里，File->open...，然后选择项目文件夹（springboot-project）。如果是初次使用spring boot，这个过程可能会有点久，需要下载许多依赖的jar包。
3. 为IDEA安装lombok插件。在IDEA里，File->Settings...->Plugin，搜索lombok，安装。
4. 项目的配置文件是在resources目录下的application.yml文件。修改MySQL数据库连接信息。我的数据库账号密码分别为root，1234，改为你的即可。
5. 在MySQL数据库终端运行建表语句的sql脚本（或者使用Navicat for MySQL等图形化工具）。
6. 启动redis。在刚才解压的Redis根目录下，双击redis-server.exe即可运行redis服务。
7. 最后就可以启动项目了。在IDEA里以Spring Boot的方式运行SellApplication这个主类。可以看到这和我们传统的web项目启动的方式不一样，我们没有配置tomcat等之类的服务器，因为Spring Boot已将服务器引入起步依赖中了。
8. 经过以上步骤，我们的项目应该已经可以启动起来了。访问：`http://127.0.0.1:8080/sell/seller/product/list`，即可来到我们的**卖家端的商家管理系统界面**。效果如下：

![](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/68747470733a2f2f692e706f7374696d672e63632f5a6e736d4d6b574d2f50432e706e67.png)

## 访问买家的前端界面

1. 项目的前后端是完全分离的，买家端前端的代码在另一个仓库，使用`git clone https://github.com/gb145234/vue-project.git`下载前端项目，其中项目根路径（vuejs-project）下的dist目录就是前端编译后的代码。

2. 修改nginx的配置文件，让nginx可以找到前端代码。在nginx根目录下的conf目录下有一个nginx.conf文件，它就是我们要修改的配置文件，其中有下面一段：

    ```shell
    server {
            listen       80;
            server_name  localhost;
    
            #charset koi8-r;
    
            #access_log  logs/host.access.log  main;
    
            location / {
                root   C:\Users\dell\Downloads\Compressed\vuejs-project-master\dist; #前端资源路径
                index  index.html index.htm;
            }
    	location /sell/ {
    		proxy_pass http://127.0.0.1:8080/sell/;
    	}
    ```

上面的`C:\Users\dell\Downloads\Compressed\vuejs-project-master\dist;`该为你刚才git clone下的前端项目的dist目录。

4.双击nginx.exe启动nginx服务器，如果已启动过，命令行进入nginx的根目录，输入`nginx -s reload`重启nginx服务器。

5.浏览器访问：`http://127.0.0.1/#/order/`，这是会出现空白界面，按F2打开浏览器的开发者工具，在浏览器的控制台输入`document.cookie='openid=abc123'` 向该域名下添加cookie。再次访问：`http://127.0.0.1`，这时就可以访问到前端界面了。如下：

![](https://github.com/gb145234/SpringBoot-sell/blob/master/sell/68747470733a2f2f692e706f7374696d672e63632f4d473053386663522f77656978696e2e706e67.png)

6.对于手机端微信公众号内访问，还要使用到内网穿透工具，由于微信里不能直接访问ip地址，还要购买域名，还涉及到挺复杂的微信调试。这里就不再介绍。可以使用postman这个工具模拟微信点餐下单。访问接口参见controller包下以Buyer开头的类。

7.如果想查看微信端的访问效果，可以在微信客户端访问这个链接：`http://sell.springboot.cn/`。（注意这是师兄上线的项目演示） 如果使用电脑访问的话，可以首先访问：<http://sell.springboot.cn/#/order/>； 然后，按`F12`打开浏览器的开发者工具，点击控制台，在控制台输入：`document.cookie='openid=abc123'`； 然后重新访问：[http://sell.springboot.cn](http://sell.springboot.cn/)，就可以看到前端效果了。

> 关于前端。前端的vue.js项目，我并没有去学习，我只是拿来做演示，有兴趣的可以到慕课网学习。

## Author

👤 **Gaobo**

* Github: [@gb145234](https://github.com/gb145234)
* 博客：<https://www.cnblogs.com/kyoner/>

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page](https://github.com/gb145234/SpringBoot-sell/issues).

## Show your support

Give a ⭐️ if this project helped you!

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_