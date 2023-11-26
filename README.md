## ���ݿ⽨��

``` sql
sys_admin_user
CREATE TABLE `sys_admin_user` (
  `user_id` int NOT NULL COMMENT '�ͻ�id',
  `admin_id` int NOT NULL COMMENT '����Ա��ͷ�id',
  PRIMARY KEY (`user_id`,`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

sys_event
CREATE TABLE `sys_event` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '����',
  `content` varchar(255) DEFAULT NULL COMMENT '����',
  `lat` varchar(255) DEFAULT NULL COMMENT 'γ��',
  `lng` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '����',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

sys_file
CREATE TABLE `sys_file` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '�ļ�����',
  `type` varchar(255) DEFAULT NULL COMMENT '�ļ�����',
  `size` bigint DEFAULT NULL COMMENT '�ļ���С',
  `url` varchar(255) DEFAULT NULL COMMENT '��������',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '�Ƿ�ɾ��',
  `enable` tinyint(1) DEFAULT '1' COMMENT '�Ƿ����',
  `md5` varchar(255) DEFAULT NULL COMMENT '�ļ�md5',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nui_md5` (`md5`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

sys_role
CREATE TABLE `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL COMMENT 'Ȩ��',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

sys_user
CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '�û���',
  `nickname` varchar(255) DEFAULT NULL COMMENT '��������',
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL COMMENT '����',
  `address` varchar(255) DEFAULT NULL,
  `gender` tinyint(1) unsigned zerofill DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

user_role
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

```

# �ļ���

``` 
�ļ���
����java  
��  ����com  
��      ����example  
��          ����own  
��              ����common  
��              ����config  
��              ��  ����interceptor  
��              ����controller  
��              ��  ����dto  
��              ����entity  
��              ��  ����pojo  
��              ��  ��  ����direction  
��              ��  ����socketpojo  
��              ����exception  
��              ����mapper  
��              ����service  
��              ��  ����impl  
��              ����utils  
��                  ����amap  
����resources  
    ����mapper    
    ����static    
    ����templates

```
```
D:.  
����java  
��  ����com  
��      ����example  
��          ����own  
��              ��  OwnApplication.java  
��              ��    
��              ����common  
��              ��      Constants.java  
��              ��      Result.java  
��              ��        
��              ����config  
��              ��  ��  CorsConfig.java  
��              ��  ��  InterceptorConfig.java  
��              ��  ��  MybatisPlusConfig.java  
��              ��  ��    
��              ��  ����interceptor  
��              ��          AuthAccess.java  
��              ��          JwtInterceptor.java  
��              ��            
��              ����controller  
��              ��  ��  AmapController.java  
��              ��  ��  ClientController.java  
��              ��  ��  EventController.java  
��              ��  ��  FilesController.java  
��              ��  ��  RoleController.java  
��              ��  ��  UserController.java  
��              ��  ��    
��              ��  ����dto  
��              ��          Response.java  
��              ��            
��              ����entity  
��              ��  ��  Client.java  
��              ��  ��  Event.java  
��              ��  ��  Files.java  
��              ��  ��  Role.java  
��              ��  ��  RoleUser.java  
��              ��  ��  User.java  
��              ��  ��    
��              ��  ����pojo  
��              ��  ��  ��  AmapPoi.java  
��              ��  ��  ��  AmapSuggestion.java  
��              ��  ��  ��  AmapWeather.java  
��              ��  ��  ��    
��              ��  ��  ����direction  
��              ��  ��          Walking.java  
��              ��  ��            
��              ��  ����socketpojo  
��              ��          MessageInfoStructure.java  
��              ��            
��              ����exception  
��              ��      GlobalExceptionHandler.java  
��              ��      ServiceException.java  
��              ��        
��              ����mapper  
��              ��      ClientMapper.java  
��              ��      EventMapper.java  
��              ��      FilesMapper.java  
��              ��      RoleMapper.java  
��              ��      RoleUserMapper.java  
��              ��      UserMapper.java  
��              ��        
��              ����service  
��              ��  ��  IEventService.java  
��              ��  ��  IRoleService.java  
��              ��  ��  IUserService.java  
��              ��  ��    
��              ��  ����impl  
��              ��          AmapServiceImpl.java  
��              ��          EventServiceImpl.java  
��              ��          RoleServiceImpl.java  
��              ��          UserServiceImpl.java  
��              ��            
��              ����utils  
��                  ��  CodeGenerator.java  
��                  ��  TokenUtils.java  
��                  ��    
��                  ����amap  
����resources  
    ��  application.yml  
    ��    
    ����mapper  
    ��      ClientMapper.xml  
    ��      EventMapper.xml  
    ��      FilesMapper.xml  
    ��      RoleMapper.xml  
    ��      RoleUserMapper.xml  
    ��        
    ����static  
    ����templates  
            controller.java.vm  
            entity.java.vm  
            mapper.java.vm  
            service.java.vm  
            serviceImpl.java.vm
```
