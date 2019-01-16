package grails

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import io.micronaut.context.annotation.Prototype
import io.micronaut.spring.beans.MicronautBeanProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import javax.inject.Singleton

@ComponentScan([
        "net.safri"
])
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Bean
    MicronautBeanProcessor httpClientMicronautBeanProcessor() {
        return new MicronautBeanProcessor(Prototype, Singleton)
    }
}