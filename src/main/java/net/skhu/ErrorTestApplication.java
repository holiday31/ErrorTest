package net.skhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import net.skhu.property.FileUploadProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileUploadProperties.class
})
public class ErrorTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorTestApplication.class, args);
	}

}
