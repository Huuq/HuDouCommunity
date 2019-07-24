项目名：胡豆社区<br>
技术：<br>
    SpringBoot、SpringMVC、MyBatis、Maven、gitHub授权登录、Ajax、Json、bootstrap前端框架<br>
目的：<br>
            快速学习和掌握SpringBoot、SpringMVC、MyBatis、bootStrap、thymeleaf开发技术和开发技巧<br>        
插件:<br>
    spring-boot-devtools热部署减少在开发中重启服务器的操作<br>
	lombok自动注入实体的get和sit方法，通过注解@Data实现<br>
资料文档地址：<br>
	[GitHub](https://github.com/)<br>
	[bootStrap](https://www.bootcss.com/)<br>
	[okHttp](https://square.github.io/okhttp/)<br>
	[thymeleaf](https://www.thymeleaf.org/)<br>
	[spring.io](https://docs.spring.io/spring)<br>
	[mybatis generator](http://www.mybatis.org/generator/)<br>
	[flyway](//flywaydb.org/getstarted/firststeps/maven)<br>
注意事项：<br>
    在使用bootstrap前端框架是注意在引用bootstrap.js和bootstrap.min.js之前需要引用jQuery.js<br>
    并且在使用时主要版本的兼容问题，不然无法实现js的效果<br>
 mybatis.configuration.map-underscore-to-camel-case=true可以解决驼峰命名法出现数据库无法映射的问题<br>
   在使用SpringMVC拦截器时，对WebConfig进行注解注入时不要使用@EnableWebMvc，@EnableWebMvc需要对路径进行重<br>
   新配置，不然无法加载静态资源，所以选择不使用@EnableWebMvc，spring会注入默认配置<br>
 maven集成flyway和mybatis_generate的常用命令<br>
 mvn flyway:migrate<br>
 mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate<br>