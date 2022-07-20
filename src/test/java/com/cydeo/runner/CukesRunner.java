package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)// this annotation saying to run the class as Cucumber BDD test, comes from jUnit
@CucumberOptions(
        plugin = {
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "rerun:target/rerun.txt",
                "pretty"
        },

        features = "src/test/resources/features", //copy path/reference(from content root) ->dif location
        glue = "com/cydeo/step_definitions",//copy path/reference(from source root) ->same location
        monochrome = true,
        dryRun = false,
        tags = "@ev"

)
public class CukesRunner {
}
