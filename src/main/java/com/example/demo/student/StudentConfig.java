package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            Student tunc = new Student(
                    "tunc",
                    "aksuna.tunc@gmail.com",
                    LocalDate.of(1999, Month.JANUARY, 5)
            );
            Student agit = new Student(
                    "agit",
                    "agit.oktay@gmail.com",
                    LocalDate.of(1992, Month.JANUARY, 5)
            );
            repository.saveAll(
                    // saves to our database these datas
                    List.of(tunc, agit)
            );
        };
        // these two records aresample records
    }
    /**
     * repository.save(new Student("name","mail@gmail.com", LocalDate.now()));
     * It is another technic to create sample records
     */
}
