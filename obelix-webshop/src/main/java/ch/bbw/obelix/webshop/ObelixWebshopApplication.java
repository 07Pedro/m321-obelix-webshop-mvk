package ch.bbw.obelix.webshop;

import ch.bbw.obelix.webshop.configuration.QuarryProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {
        "ch.bbw.obelix.webshop", 
        "ch.bbw.obelix.common"
})
@EnableConfigurationProperties(QuarryProperties.class)
public class ObelixWebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObelixWebshopApplication.class, args);
	}

}
