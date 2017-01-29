package org.test.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.ElementsCollection
import org.openqa.selenium.By
import org.test.logic.Client

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$

/**
 * Created by artyom on 1/26/2017.
 */
class NewClientPage {
    def createNewClient(Client client){
        $("#client_last_name").sendKeys(client.lastName)
        $("#client_first_name").sendKeys(client.firstName)
        client.gender==true ? $("#client_gender_male").click() : $("#client_gender_female").click()
        $("#client_birth_date").sendKeys(client.birth)
        $("#client_medicare_number").sendKeys(client.medicareNumber)
        $("#client_medicare_irn").sendKeys(client.IRN)
        $("#client_private_health_fund_id").selectOptionContainingText(client.privateHealthFund)
        $("#client_avatar").sendKeys(client.avatar)
        $("#client_mobile").sendKeys(client.phone)
        client.phoneType==true ? $("#client_mobile_phone_type_ios").click() : $("#client_mobile_phone_type_andriod").click()
        $("#client_email").sendKeys(client.email)
        $("#client_address_line_1").sendKeys(client.address)
        $("#client_post_code").sendKeys(client.postcode)
        $("#client_occupation").sendKeys(client.occupation)
        $("#client_notes").sendKeys(client.notes)
        $("#create_client_btn").click()
    }


    def verifyClient(Client client){
        $("#client_name>b").shouldHave(Condition.text(client.firstName + " " + client.lastName))
        $$(".profile-info-value>b").first().shouldHave(Condition.text(client.gender?"Male":"Female"))
        $$(".profile-info-value>b").last().shouldHave(Condition.text(client.yearsOld))
        $(".profile-info-value>b:nth-child(1)").shouldHave(Condition.text(client.birth))
        $("#client_mobile").shouldHave(Condition.text(client.phone))
        $("#client_email").shouldHave(Condition.text(client.email))
        $("#client_address_line_1").shouldHave(Condition.text(client.address))
        ElementsCollection el = $$(By.xpath(".//*[@class='profile-info-value']/span"))
        el.get(5).shouldHave(Condition.text(client.medicareNumber + " / "+client.IRN))
        el.get(7).shouldHave(Condition.text(client.occupation))
        el.get(8).shouldHave(Condition.text(client.notes))

    }
}
