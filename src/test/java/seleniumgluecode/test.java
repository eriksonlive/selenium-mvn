package seleniumgluecode;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class test extends TestBase {

    @Given("^El usuario se encuentra en la pagina de home de imalittletester$")
    public void el_usuario_se_encuentra_en_la_pagina_de_home_de_imalittletester() throws Throwable {
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @When("^Hace click sobre el boton little tester comics$")
    public void hace_click_sobre_el_boton_little_tester_comics() throws Throwable {
        homePage.clickOnTitleComics();
    }

    @Then("^Se debe redirigir a la pantalla de Comics$")
    public void se_debe_redirigir_a_la_pantalla_de_Comics() throws Throwable {
        Assert.assertTrue("No se redirecciono correctamente a la pagina de comics", comicsPage.isTitleComicDisplay());
    }

}
