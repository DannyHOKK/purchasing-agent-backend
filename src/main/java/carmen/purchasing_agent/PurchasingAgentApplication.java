package carmen.purchasing_agent;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class PurchasingAgentApplication {


	@PostConstruct
	public void setTimeZone(){
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Hong_Kong"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PurchasingAgentApplication.class, args);
	}

}
