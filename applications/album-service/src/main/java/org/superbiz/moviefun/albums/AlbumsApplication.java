package org.superbiz.moviefun.albums;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.superbiz.moviefun.ServiceCredentials;

@SpringBootApplication
public class AlbumsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbumsApplication.class);
    }

    @Bean
    ServiceCredentials serviceCredentials(@Value("${vcap.services}") String vcapServices) {
        return new ServiceCredentials(vcapServices);
    }


}
