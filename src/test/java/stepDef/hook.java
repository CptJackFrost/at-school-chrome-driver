package stepDef;

import io.cucumber.java.Before;

public class hook {
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    }
}
