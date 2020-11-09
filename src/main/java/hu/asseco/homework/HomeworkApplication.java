package hu.asseco.homework;

import hu.asseco.homework.model.Role;
import hu.asseco.homework.model.User;
import hu.asseco.homework.model.UserRole;
import hu.asseco.homework.repository.UserRepository;
import hu.asseco.homework.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HomeworkApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(HomeworkApplication.class, args);
        UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
        UserRoleRepository userRoleRepository = configurableApplicationContext.getBean(UserRoleRepository.class);

        User user = new User("user", "password", "test@asseco.hu","Budapest, Váci út 144.");
        userRepository.save(user);
        UserRole userRole = new UserRole(user, Role.ADMIN);
        userRoleRepository.save(userRole);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
                registry.addMapping("/api/user/**").allowedOrigins("http://localhost:4200");
            }
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
