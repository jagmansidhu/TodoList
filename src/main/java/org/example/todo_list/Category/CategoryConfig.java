//package org.example.todo_list.Category;
//
//import org.example.todo_list.List.Lists;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class CategoryConfig {
//    private static final Logger log = LoggerFactory.getLogger(CategoryConfig.class);
//
//    @Bean
//    CommandLineRunner initDatabase(CategoryRepository repository) {
//        List<String> groceryItems = List.of("Milk", "Eggs", "Bread");
//        List<String> errandItems = List.of("Grocery", "Barber");
//
//        return args -> {
//            log.info("Preloading " + repository.save( "beans",groceryItems));
//            log.info("Preloading " + repository.save(new Lists(errandItems )));
//        };
//    }
//}
