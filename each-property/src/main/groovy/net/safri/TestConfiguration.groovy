package net.safri

import groovy.transform.ToString
import io.micronaut.context.annotation.EachProperty
import io.micronaut.context.annotation.Parameter

@EachProperty("test.data")
@ToString(includeNames = true, includePackage = false)
class TestConfiguration {

    private final String name
    String prop

    TestConfiguration(@Parameter String name) {
        this.name = name
    }
}
