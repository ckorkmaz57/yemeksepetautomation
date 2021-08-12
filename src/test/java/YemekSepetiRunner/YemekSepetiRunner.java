package YemekSepetiRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/htmlreports.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "YemekSepetiStepDefinitions",
        features = "classpath:/YemekSepeti/YemekSepetiLogin.feature")
public class YemekSepetiRunner {


}
