package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(final BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers

            repository.save(new BuddyInfo("Dan", "Carleton","555", 55));
            repository.save(new BuddyInfo("Steve", "Carleton","666", 77));
            repository.save(new BuddyInfo("Allen", "Carleton2","777", 88));
            repository.save(new BuddyInfo("Alex", "Carleton3","888", 99));


            // fetch customers by name
            log.info("Customer found with findByName('Dan'):");
            log.info("--------------------------------------------");
            repository.findByName("Dan").forEach(dan -> {
                log.info(dan.toString());
            });

            // fetch customers by address
            log.info("Customer found with findByAddress('Carleton'):");
            log.info("--------------------------------------------");
            repository.findByAddress("Carleton").forEach(dan -> {
                log.info(dan.toString());
            });

            // fetch customers by phone
            log.info("Customer found with findByPhone('777'):");
            log.info("--------------------------------------------");
            repository.findByPhone("777").forEach(dan -> {
                log.info(dan.toString());
            });


            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}