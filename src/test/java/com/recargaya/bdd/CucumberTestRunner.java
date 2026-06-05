package com.recargaya.bdd;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "com.recargaya.bdd"
)
public class CucumberTestRunner {
}