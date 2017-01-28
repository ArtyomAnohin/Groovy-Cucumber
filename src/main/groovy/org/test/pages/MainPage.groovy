package org.test.pages

import com.codeborne.selenide.Condition

import static com.codeborne.selenide.Selenide.$

/**
 * Created by note on 1/26/2017.
 */
class MainPage{
    def goToNewClients(){
//        $("#nav_clients").click()
//        $("#menu_new_client_link").click()
        $("#menu_new_client_link").displayed ?: $("#nav_clients").click()
        $("#menu_new_client_link").click()
        $("#new_client>fieldset>legend").shouldHave(Condition.text("New client"))
    }
    def goToClientList(){
        $("#menu_search_clients_link").displayed ?: $("#nav_clients").click()
        $("#menu_search_clients_link").click()
    }
}