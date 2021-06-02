package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(basePackages ={"in.ashokit.controller","in.ashokit.dto","in.ashokit.dto","in.ashokit.entity","in.ashokit.service"} )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
