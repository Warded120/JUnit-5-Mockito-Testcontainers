package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class ConditionalTest {
    @Test
    @Disabled("Don't run until some issue is fixed")
    void basicTest() {
        //some logic
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void windowsTest() {
        //some test
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void macTest() {
        //some test
    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    void windowsMacTest() {
        //some test
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void java17Test() {
        //some test
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_17)
    void minJava17RangeTest() {}

    @Test
    @EnabledIfEnvironmentVariable(named = "some_env", matches = "12")
    void someEnvTest() {}

    @Test
    @EnabledIfSystemProperty(named = "some_prop", matches = "12")
    void somePropTest() {}
}
