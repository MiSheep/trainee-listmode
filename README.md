# trainee-listmode（简易购物车）
### 踩坑：

1.	表名不可与mysql关键字重复，如：order。
[关键字查询](https://dev.mysql.com/doc/refman/8.0/en/keywords.html#keywords-8-0-detailed-A)

2.	Mybatis-plus高版本可能想要修改mybatis时区（+8:00）

3.	PostMan：当后台参数无注解时，在Params设键值对；当参数注解为@RequestBody时，也可在Body里格式为row以Text直接传value（@RequestBody传JSON）
