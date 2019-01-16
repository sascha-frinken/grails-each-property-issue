package net.safri

import io.micronaut.context.ApplicationContext

import javax.inject.Singleton

@Singleton
class TestService {

    private final ApplicationContext applicationContext

    TestService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext
    }

    Collection<TestConfiguration> getTestConfigurations() {
        applicationContext.getBeansOfType(TestConfiguration)
    }
}
