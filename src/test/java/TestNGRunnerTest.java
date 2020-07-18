import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src\\test\\resources\\cucumber\\Avito.feature",
        tags = "@Feature"
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

}
