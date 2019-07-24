package club.qh.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="club.qh.web.mapper")
public class HuDouCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuDouCommunityApplication.class, args);
	}

}
