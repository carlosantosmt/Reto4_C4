package co.edu.usa.webapp2;

import co.edu.usa.webapp2.crud.InterfaceGadget;
import co.edu.usa.webapp2.crud.InterfaceOrder;
import co.edu.usa.webapp2.crud.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@SpringBootApplication
public class webapp2Application implements CommandLineRunner {
    @Autowired
    private InterfaceUser interfaceUser;
    @Autowired
    private InterfaceGadget interfaceGadget;
    @Autowired
    private InterfaceOrder interfaceOrder;
	public static void main(String[] args) {
		SpringApplication.run(webapp2Application.class, args);
	}
        @Override
        public void run(String...args)throws Exception{
            interfaceUser.deleteAll();
            interfaceGadget.deleteAll();
            interfaceOrder.deleteAll();
        }
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

}
