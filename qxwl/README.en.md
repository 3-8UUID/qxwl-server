# wllt-qxwl 项目架构
##Spring boot(基础) + Security(安全) + mysql(关系数据库) + redis
##comm 公共资源文件
用于存放一些工具类帮助类..

##congif 配置文件
用于存放配置 目前只存了spring security

##modules 业务模块

####account 用户安全模块
用户关注(attention)、
用户消息(message)、
用户权限(permission)目前第一个版本不使用、
用户角色权限关系(relation)、
角色(role)、
用户(user)、
####article 文章模块
收藏(collect)、
评论(comment)、
文章连接(link)目前第一个版本不使用、
文章帖子(post)、
文章内资源图片视频文件地址(source)目前第一个版本不使用、
文章对于的类型(type)、
####custom 常用业务
匿名访问(anon)开放一些不要权限的接口、
点击率(click)、
点赞率(great)、
日志(log)、
分享(share)、
废弃的不管它(src)、

##Resources


