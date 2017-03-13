package org.wowapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("org.wowapp")
@EnableAutoConfiguration
@Configuration
public class App extends WebMvcAutoConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
        logger.info("Start Paper-Rock-Scissors game: ");
        configureApplication(new SpringApplicationBuilder()).run(args);
    }
    
    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(App.class).bannerMode(Banner.Mode.OFF);
    }
}


