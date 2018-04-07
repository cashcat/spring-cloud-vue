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
   文件c:/test/队伍id
   数据库设计：
   队伍表 TEAM_CRAWLER 
   图片表 IMAGE_CRAWLER
   视频表 VIDEO_CRAWLER

避免重复爬取


技术栈
 mybatis  
 xml配置需要映射 dao+model


