package nl.ordina.cursus_spring.springbootdi;

import nl.ordina.cursus_spring.springbootdi.controller.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private GameController game;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		System.out.println(game.play());
	}
}
