package org.test

import com.codeborne.selenide.Configuration
import static com.codeborne.selenide.Selenide.open
/**
 * Created by note on 1/28/2017.
 */
class SetUp {
def static setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe")
        Configuration.browser = "chrome";

        open("http://sandbox.clinicwise.net/")
    }
}
