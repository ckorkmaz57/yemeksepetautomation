package YemekSepetiTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "YemekSepetiStepDefinitions",
        features = "classpath:/YemekSepeti")
public class YemekSepetiTest {


}
