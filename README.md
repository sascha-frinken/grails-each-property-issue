# `EachProperty` does not work in grails / spring 

1. Build and publish micronaut lib with an `EachProperty`
```bash
cd each-property
./gradlew publishToMavenLocal
```
**TestConfiguration class:**  

```groovy
@EachProperty("test.data")
@ToString(includeNames = true, includePackage = false)
class TestConfiguration {

    private final String name
    String prop

    TestConfiguration(@Parameter String name) {
        this.name = name
    }
}
```
**TestService class:**  
```groovy
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
```

2. Run grails project
```bash
cd grails
./grailsw run
```

3. Call Test Controller
```bash
curl http://localhost:8080/test
```

**TestController class:** 
```groovy
class TestController {
	static responseFormats = ['json']

    @Autowired
    TestService testService

    def index() {

        def configurations = testService.testConfigurations

        render([result: configurations.size()] as JSON)
    }
}
```

**Expected:**

result should be 2 as `application.yml` contains:

```yaml
test:
    data:
        a:
            prop: a
        b:
            prop: b
```


**Actually:**

result is 0
