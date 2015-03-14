# 概述 #
基于struts2.23 + spring2.5.6 + hibernate3.7.4 + hibernate-generic-dao1.1.0 + xmemcached1.3.5 全注解方式基础开发框架，采用Maven管理。
# 详细内容 #
http://www.chinasb.org/archives/2011/07/2961.shtml
## hibenate-generic-dao ##
http://code.google.com/p/hibernate-generic-dao/
# 下载 #
https://code.google.com/p/ssh-base-framework/downloads/list
# SVN Checkout #
http://ssh-base-framework.googlecode.com/svn/trunk/
# 更新日志 #
## 2.0.3 (更新日期：2011-11-14) ##
  1. 增加Struts2-jquery-plugin插件
  1. 更新CURD例子（jqgrid）
## 2.0.2 (更新日期：2011-11-09) ##
  1. 更新包结构
  1. 增加Struts2-json-plugin插件与相应实例
  1. 修复泛型引起的编译错误
## 2.0.1 (更新日期：2011-11-08) ##
  1. 替换hibernate缓存插件（ehcache -> hibernate-memcached -> XMemcached）
  1. Spring集成XMemcached，增加MemcachedUtils工具类
  1. 删除项目中hibenate-generic-dao中的源码，使用依赖jar包管理
  1. 更新Demo的单元测试，增加Search实例
## 2.0.0 (更新日期：2011-09-16) ##
  1. 更改使用Maven管理项目.
  1. 去掉proxool pool，使用c3p0 pool.
  1. 使用手动事务（注解方式）
  1. 去掉及优化冗余配置项.
## 1.0.0 (更新日期：2011-07-07) ##
Eclipse项目工程初始导入。