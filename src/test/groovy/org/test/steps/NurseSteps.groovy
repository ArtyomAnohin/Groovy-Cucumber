package org.test.steps

import com.codeborne.selenide.Configuration
import cucumber.api.PendingException
import org.test.SetUp
import org.test.logic.Client
import org.test.logic.Nurse
import org.test.logic.Users
import org.test.pages.ClientsListPage
import org.test.pages.LoginPage
import org.test.pages.MainPage
import org.test.pages.NewClientPage

import static cucumber.api.groovy.EN.*

/**
 * Created by note on 1/26/2017.
 */

SetUp.setUp()

def loginPage = new LoginPage()
def mainPage = new MainPage()
def newClientPage = new NewClientPage()
def clientListPage = new ClientsListPage()
def nurse = new Nurse()
def client = new Client();

Given(~/^nurse login to clinic site$/) { ->
    loginPage.loginAs(nurse)
}
When(~/^go to New Client page$/) { ->
    mainPage.goToNewClients()
}
Then(~/^create new client$/) { ->
    newClientPage.createNewClient(client)
    newClientPage.verifyClient(client)
}
And(~/^client should be in the Client List$/) { ->
    mainPage.goToClientList()
    clientListPage.verifyClient(client)
}