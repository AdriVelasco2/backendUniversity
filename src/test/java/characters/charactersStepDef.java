package characters;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class charactersStepDef {

    private String BASE_URI = "https://rickandmortyapi.com/api/character/";
    private Response response;

    @Given("The user wants to search a character by id in the Rick and Morty API")
    public void theUserWantsToSearchACharacterByIdInTheRickAndMortyAPI() {
        RestAssured.baseURI = BASE_URI;
    }

    @When("The user sends a request to search a character by id {string}")
    public void theUserSendsARequestToSearchACharacterById(String id) {
        response = given().header("Content-Type", "application/json").when().get("/" + id);
    }

    @Then("The user should get the character with id {string}")
    public void theUserShouldGetTheCharacterWithId(String id) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(id, jsonPathEvaluator.get("id").toString());
    }

    @Then("The status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("The character name should be {string}")
    public void theCharacterNameShouldBe(String name) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(name, jsonPathEvaluator.get("name"));
    }

    @Then("The response should contain character details")
    public void theResponseShouldContainCharacterDetails() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        String[] fields = {"id", "name", "status", "species", "type", "gender", "origin", "location", "image", "episode", "url", "created"};
        for (String field : fields) {
            Assert.assertNotNull(jsonPathEvaluator.get(field));
        }
    }

    @Then("The error message should be {string}")
    public void theErrorMessageShouldBe(String errorMessage) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(errorMessage, jsonPathEvaluator.get("error"));
    }

    @Then("The character should have a name")
    public void theCharacterShouldHaveAName() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertNotNull(jsonPathEvaluator.get("name"));
    }

    @Then("The character should have a status")
    public void theCharacterShouldHaveAStatus() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertNotNull(jsonPathEvaluator.get("status"));
    }

    @Then("The character should have a species")
    public void theCharacterShouldHaveASpecies() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertNotNull(jsonPathEvaluator.get("species"));
    }

    @Then("The character should have a gender")
    public void theCharacterShouldHaveAGender() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertNotNull(jsonPathEvaluator.get("gender"));
    }

    @Then("The character should have an origin")
    public void theCharacterShouldHaveAnOrigin() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertNotNull(jsonPathEvaluator.get("origin"));
    }
}
