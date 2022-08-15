package com.codingstones.bdd.igic.steps;

import com.codingstones.bdd.igic.IGICCalculator;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class IGICCalculatorSteps {


    private IGICCalculator calculator;
    private float calculatedTotalPrice;

    @Before
    public void setUp() {
        calculator = new IGICCalculator();
    }

    @Given("^I have a IGIC calculator$")
    public void i_have_a_calculator() {
        assertNotNull(calculator);
    }

    @When("^tax is calculated for \"(.*?)\" with (\\d+) price$")
    public void tax_is_calculated_for_with_price(String productName, float price) {
        calculatedTotalPrice = calculator.calculateTotal(productName, price);
    }

    @Then("^the result should be (\\d*\\.?\\d+)$")
    public void the_result_should_be(float expectedTotalPrice) {
        final double delta = 0.002;
        assertEquals(expectedTotalPrice, calculatedTotalPrice, delta);
    }
}
