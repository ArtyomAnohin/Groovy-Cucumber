package org.test.pages

import org.openqa.selenium.By
import org.test.logic.Client

import static com.codeborne.selenide.Selenide.$

/**
 * Created by note on 1/26/2017.
 */
class ClientsListPage {
    def verifyClient(Client client){
        $("#patients_search").sendKeys(client.firstName + " " + client.lastName)
        $("#search_btn").click()
        $(By.xpath(".//*[@id='patients']/table/tbody/tr/td[contains(.,'"+client.firstName + " " + client.lastName+"')]")).click()
        NewClientPage newClientPage = new NewClientPage()
        newClientPage.verifyClient(client)
    }
}
