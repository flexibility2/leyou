# 电商购物网站仿写
## 技术选型
- 前端：
  - Vue(Vue-cli, Vue-router), npm, axios, Vuetify, ES6
- 后端
  - SpringCloud(Zuul, Eureka, Feign)
  - SpringBoot, MyBatis, MySQL
  - Nginx
  - MQ
  - Redis (短信token, 购物车)
- Node.js及Vue.js技术栈，实现前后端分离开发
- 数据库的设计贴近真实，brand表,category表，订单表，sku表，stock表，spu表，spu_detail表，属性组spec_group表，属性参数spec_param表，user表
- 基于Elasticsearch实现前台门户网站的搜索，聚合统计等功能
- 基于Thymeleaf实现页面模板和静态化，提高页面响应速度和并发能力
- 购物车数据存放在Redis(如果用户登录)和LocalStorage（如果用户未登录）。LocalStorage可以离线客户端购物车，减轻服务端压力
- MQ用于实现后台数据和前台数据同步更新，以及其它的异步或解耦功能，如短信通知
- 阿里大于，微信SDK，实现短信通知，微信支付等
- Nginx实现域名和ip地址端口的映射，并缓存Thymeleaf静态页面
## 架构图
## 系统架构解读
整个项目可以分为两部分：后台管理系统、前台门户系统。
- 后台管理，toB, 主要为商品的管理：
  - 商品分类
  - 品牌管理
  - 商品列表
  - 商品新增
  - 规格参数
- 前台门户：toC, 实现用户注册登录，搜索过滤商品，加入购物车，下单等功能
