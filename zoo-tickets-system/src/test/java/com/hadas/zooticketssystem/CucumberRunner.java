package com.hadas.zooticketssystem;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty","json:cucumber/test-report/SearchProject Reports/cucumber.json"},
        features ={ "classpath:features"},
        glue = {"com.hadas.zooticketssystem"}
)
public class CucumberRunner
{


}

