package org.test.pages

import com.codeborne.selenide.Condition
import org.test.logic.Nurse
import org.test.logic.Users

import static com.codeborne.selenide.Selenide.$

/**
 * Created by artyom on 1/26/2017.
 */
class LoginPage{
    def loginAs(def users){
        $("#username").sendKeys(users.username)
        $("#password").sendKeys(users.pass)
        $("#signin_button").click()
        $("#user_nav_link > span").shouldHave(Condition.text(users.fullName))
    }
}
