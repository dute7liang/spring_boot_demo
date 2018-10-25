过滤器简称	对应的java类<br/>
- anon	org.apache.shiro.web.filter.authc.AnonymousFilter
- authc	org.apache.shiro.web.filter.authc.FormAuthenticationFilter
- authcBasic	org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter
- perms	org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter
- port	org.apache.shiro.web.filter.authz.PortFilter
- rest	org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter
- roles	org.apache.shiro.web.filter.authz.RolesAuthorizationFilter
- ssl	org.apache.shiro.web.filter.authz.SslFilter
- user	org.apache.shiro.web.filter.authc.UserFilter
- logout	org.apache.shiro.web.filter.authc.LogoutFilter

anon:例子/admins/**=anon 没有参数，表示可以匿名使用。<br/>
authc:例如/admins/user/**=authc表示需要认证(登录)才能使用，FormAuthenticationFilter是表单认证，没有参数 <br/> 
perms：例子/admins/user/**=perms[user:add:*],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，例如/admins/user/**=perms["user:add:*,user:modify:*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。<br/>
user:例如/admins/user/**=user没有参数表示必须存在用户, 身份认证通过或通过记住我认证通过的可以访问，当登入操作时不做检查 <br/>
