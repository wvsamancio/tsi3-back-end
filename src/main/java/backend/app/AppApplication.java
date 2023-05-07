package backend.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {
    @Value("${spring.data.mongodb.database}")
    private static String databaseName;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		System.out.println("Database name: " + databaseName);
	}
}
