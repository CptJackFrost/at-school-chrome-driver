import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/cucumber",
        tags = "@Поиск",
        glue = "stepDef"
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

}
