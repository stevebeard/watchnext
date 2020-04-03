package uk.co.stevebeard.watchnext.webapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DemoDataInitializer {

    @Bean
    CommandLineRunner initDatabase(ItemRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Item("Game of Thrones")));
            log.info("Preloading " + repository.save(new Item("American Horror Story")));
            log.info("Preloading " + repository.save(new Item("Lost")));
            log.info("Preloading " + repository.save(new Item("Buffy the Vampire Slayer")));
            log.info("Preloading " + repository.save(new Item("Breaking bad")));
        };
    }

}
