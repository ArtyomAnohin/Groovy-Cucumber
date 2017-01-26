package org.test.steps

import cucumber.api.PendingException
import org.test.logic.Calculator

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When

/**
 * Created by artyom on 01/26/17.
 */

Calculator calc = new Calculator()

Given(~/^add (\d+) and (\d+)$/) { def arg1, def arg2 ->

    calc.e1 = arg1 as Integer
    calc.e2 = arg2 as Integer
}

Then(~/^result should be (\d+)$/) { int output ->
    assert output == result
}
When(~/^calculator run add$/) { ->
    result = calc.add()
}
When(~/^calculator run subtract$/) { ->
    result = calc.subtract();
}
When(~/^calculator run multiplication$/) { ->
    result = calc.multiplication()
}
When(~/^calculator run division$/) { ->
    result = calc.division()
}