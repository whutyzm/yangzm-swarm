package com.yangzm.constants;

/**
 * description ()
 *
 * @author create by yangzm
 * @date 2023/3/11
 */

public interface AuthConstant {
   /**
    * JWT存储权限前缀
    */
   String AUTHORITY_PREFIX = "ROLE_";

   /**
    * JWT存储权限属性
    */
   String AUTHORITY_CLAIM_NAME = "authorities";

   /**
    * 后台管理client_id
    */
   String UMS_CLIENT_ID = "ums-app";

   /**
    * portal页client_id
    */
   String PORTAL_CLIENT_ID = "portal-app";

   /**
    * 后台管理接口路径匹配
    */
   String UMS_URL_PATTERN = "/swarm-ums/**";

   /**
    * Redis缓存权限规则key
    */
   String RESOURCE_ROLES_MAP_KEY = "auth:resourceRolesMap";

   /**
    * 认证信息Http请求头
    */
   String JWT_TOKEN_HEADER = "Authorization";

   /**
    * JWT令牌前缀
    */
   String JWT_TOKEN_PREFIX = "Bearer ";

   /**
    * 用户信息Http请求头
    */
   String USER_TOKEN_HEADER = "user";
}
