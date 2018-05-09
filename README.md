# springBootHouse  房屋销售平台

##一、配置视图解析器  使用thymeleaf模板方式
该项目使用的事freemarker模板实现ftl前端页面，这里介绍thymeleaf模板实现html界面
spring-boot很多配置都有默认配置,比如默认页面映射路径为 
classpath:/templates/*.html 
同样静态文件路径为 
classpath:/static/

在application.properties中可以配置thymeleaf模板解析器属性.就像使用springMVC的JSP解析器配置一样

#thymeleaf start
spring.thymeleaf.mode=HTML5
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.content-type=text/html
#开发时关闭缓存,不然没法看到实时页面
spring.thymeleaf.cache=false
#thymeleaf end

具体可以配置的参数可以查看 
org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties这个类,上面的配置实际上就是注入到该类中的属性值.
##二、举例demo
1.控制器
    @Controller
    public class HelloController {
        private Logger logger = LoggerFactory.getLogger(HelloController.class);
        /**
         * 测试hello
         * @return
         */
        @RequestMapping(value = "/hello",method = RequestMethod.GET)
        public String hello(Model model) {
            model.addAttribute("name", "Dear");
            return "hello";
        }
    }
2.view(注释为IDEA生成的索引,便于IDEA补全)
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<!--/*@thymesVar id="name" type="java.lang.String"*/-->
<p th:text="'Hello！, ' + ${name} + '!'" >3333</p>
</body>
</html>