一个爬虫
数据来源
http://server.goteaming.com.cn/
获取所有队伍
http://server.goteaming.com.cn/Player_Base/Game/ActivityFinish
返回html
获取队伍中图片 视频信息
http://server.goteaming.com.cn/Player_Base/Game/GetTeamDataSource
返回json




储存位置
   文件c:/test/队伍id(配置文件中指定)
   数据库设计：
   队伍表 TEAM_CRAWLER 
   图片表 IMAGE_CRAWLER
   视频表 VIDEO_CRAWLER

避免重复爬取


技术栈
 mybatis  
 xml配置需要映射 dao+model
 
做一个完整的爬虫web服务器。
1 队伍管理
     功能：更新队伍，下载的状态，下载视频，下载图片，队伍详情查看
2 图片管理
     功能：图片详情页，重新下载
     
3 视频管理
     功能：视频详情页，重新下载


