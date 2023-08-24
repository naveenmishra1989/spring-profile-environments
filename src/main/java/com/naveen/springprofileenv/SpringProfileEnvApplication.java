package com.naveen.springprofileenv;

import com.naveen.springprofileenv.entity.College;
import com.naveen.springprofileenv.entity.University;
import com.naveen.springprofileenv.repo.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringProfileEnvApplication {

    @Value("${spring.profiles.active}")
    private String active;
    @Value("${spring.application.name}")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(SpringProfileEnvApplication.class, args);
    }

    @Bean
    public CommandLineRunner op(final UniversityRepository universityRepository) {
        return args -> {
            System.out.println("Active profile: " + active);
            System.out.println("Application name: " + applicationName);
         University university = University.builder().name("PUNE University of Engineering").build();
            College college = College.builder().name("College of Engineering")
                    .city("Pune")
                    .location("Pune")
                    .state("Maharashtra")
                    .university(university)
                    .build();
            university.setColleges(List.of(college));
            universityRepository.save(university);
        };
    }
}
