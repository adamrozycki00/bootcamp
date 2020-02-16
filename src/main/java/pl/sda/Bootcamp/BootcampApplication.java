package pl.sda.Bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootcampApplication {

	// tylko do uruchomienia aplikacji: żeby wstał Tomcat
	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

}
