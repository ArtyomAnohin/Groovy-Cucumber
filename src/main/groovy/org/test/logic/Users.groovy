package org.test.logic

import groovy.json.JsonSlurper

/**
 * Created by note on 1/26/2017.
 */
class Users {
}

class Nurse {
    def username = "sharon"
    def pass = "test"
    def fullName = "Sharon Stone"
}

class Client {
    String lastName = "Smith"
    String firstName = "Bob"
    String gender = true
    String birth = randomDate().format('dd/MM/yyyy')
    String medicareNumber = "123456789"
    String IRN = '123'
    String privateHealthFund = "MBF"
    String avatar = (new File("").getAbsolutePath().split('src')[0] + "\\src\\test\\resources\\files\\avatar.png") as String
    String phone = "0491 570 156"
    String phoneType = true
    String email = "qw@er.ty"
    String address = "North Pole, Alaska"
    String postcode = "99705"
    String occupation = "jobless"
    String notes = "very important patient"
    String yearsOld;


    Client() {
        def user = new JsonSlurper().parse(new URL("https://randomuser.me/api/"))
        if (user) {
            lastName = user.results.name.last.get(0).capitalize()
            firstName = user.results.name.first.get(0).capitalize()
            gender = (user.results.gender.get(0) == 'male')
            birth = Date.parse('yyyy-MM-dd HH:mm:ss',user.results.dob.get(0)).format('dd/MM/yyyy')
            avatar = getAvatar(user.results.picture.large.get(0))
            phone = String.format("0491 %s %s", randNum(3).join(), randNum(3).join())
            email = user.results.email.get(0)
            address = user.results.location.state.get(0).capitalize()+", " +
                    user.results.location.city.get(0).capitalize() + ", " +
                    user.results.location.street.get(0)
            postcode = user.results.location.postcode.get(0)
            yearsOld=(new Date()..Date.parse('yyyy-MM-dd HH:mm:ss',user.results.dob.get(0))).collect { it[ Calendar.YEAR ]}
                    .unique()
                    .size()-2
        }
    }
    def getAvatar(def address) {

        String fileName = new File("").getAbsolutePath().split('src')[0] + "\\build\\${address.tokenize('/')[-1]}"
        new File(fileName).withOutputStream { out ->
            out << new URL(address).openStream()
        }
        return fileName
    }

    def randNum(Integer n){
        Random rand = new Random()
        def randomIntegerList = []
        (1..n).each {
            randomIntegerList << rand.nextInt(10)
        }
        return randomIntegerList
    }
    Date randomDate() {
        Date start = Date.parse('yyyy-MM-dd', '1900-01-01')
        Date end = Date.parse('yyyy-MM-dd', '2000-01-01')
        start + new Random().nextInt(end - start + 1)
    }
}

