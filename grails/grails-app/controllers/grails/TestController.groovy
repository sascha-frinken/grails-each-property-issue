package grails

import grails.converters.JSON
import net.safri.TestService
import org.springframework.beans.factory.annotation.Autowired

class TestController {
	static responseFormats = ['json']

    @Autowired
    TestService testService

    def index() {

        def configurations = testService.testConfigurations

        render([result: configurations.size()] as JSON)
    }
}
