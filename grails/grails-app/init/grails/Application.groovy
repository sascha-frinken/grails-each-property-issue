package grails


import grails.boot.GrailsAppBuilder
import grails.boot.config.GrailsAutoConfiguration
import io.micronaut.context.ApplicationContext
import io.micronaut.spring.context.MicronautApplicationContext
import org.springframework.context.annotation.ComponentScan

@ComponentScan([
        "net.safri"
])
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsAppBuilder builder = new GrailsAppBuilder()
        def context = new MicronautApplicationContext(ApplicationContext.build())
        context.start()
        builder.parent(context)
        builder.sources(Application)
        builder.build().run()
    }
}