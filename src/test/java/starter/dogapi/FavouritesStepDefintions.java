package starter.dogapi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.thucydides.core.annotations.Steps;
import starter.Model.FavouritesField;

import java.util.*;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class FavouritesStepDefintions {
    Actor actor;
    public String x_api_key="";
    @Steps
    FavouiresAPI favouiresAPI;
    List<FavouritesField> favImages;

    //private String endpoint="https://api.thedogapi.com/v1/";
    ResponseConsequence ResCon;
    @Given("x-api-key is already acquired.")
    public void x_api_key_is_already_acquired() {
        //x_api_key ="8adf71fc-c27b-40ef-8662-19ab891129e3";
        x_api_key ="4fbdc7a5-4747-44ef-813a-3c6c017fb722";
    }

    @When("Tester makes favourites request")
    public void tester_makes_request() {
        actor = Actor.named("Tester the automation tester")
                .whoCan(CallAnApi.at(favouiresAPI.invoke_my_webservice()));
       actor.attemptsTo(Get.resource("favourites").with(request ->
                request.header("x-api-key", x_api_key)));
    }
    @And("Tester should see information about dog")
    public void tester_should_see_information_about_dog() {
        actor.should(
                seeThatResponse("all the favVotes should be returned",
                        response -> {
                            response.statusCode(200);
                        }
));

        favImages = SerenityRest.lastResponse()
                .jsonPath()
                .getList("", FavouritesField.class);

    }

    @Then("Tester cast {} vote")
    public void testerCastOneVote(String arg0) {
        String bodys=("{\"image_id\": \"%s\",\"sub_id\": \"my-user-1234\",\"value\": 1\n}");
        bodys=String.format(bodys,arg0); //: 1\n
        String finalBodys = bodys;

        actor.attemptsTo(Post.to("votes").with(req->req.header("Content-Type", "application/json").header("x-api-key",x_api_key)
            .body(finalBodys)
    ));

    actor.should(
                seeThatResponse("The vote should have been successfully cast",
                        response -> response.statusCode(200))
        );
    }

    @Then("The tester favorites the dog they {} for")
    public void theTesterFavoritesTheDogTheyFor(String arg0) {
        String bodys=("{\"image_id\": \"%s\",\"sub_id\": \"my-user-1234\"}");
        bodys=String.format(bodys,arg0);
        String finalBodys = bodys;
        actor.attemptsTo(Post.to("favourites").with(req->req.header("Content-Type", "application/json").header("x-api-key",x_api_key)
                .body(finalBodys)
        ));
        actor.should(
                seeThatResponse("To favourites should have been successfully adding vote cast",
                        response -> response.statusCode(200))
        );

    }

    @Then("Tester should see favorites image of dogs {}")
    public void testerShouldSeeOfDogsfavImage(String arg0) {
        //Before being added to favorites
        System.out.println("!--Favorite Dogs Image Urls--!");
        favImages.forEach((i)-> System.out.println(i.image.url));
        //Favori Image Size if equals value pass
        int value=favImages.size()+1; //FavVote Controls
        assertThat(favImages).hasSize(value-1);

        actor.attemptsTo(Get.resource("favourites").with(request ->
                request.header("x-api-key", x_api_key)));
        actor.should(
                seeThatResponse("all the expected favImageId should be returned",
                        response -> response.body("image_id", hasItems(arg0)))
        );
    }


    @Then("Tester remove favorites image of dogs")
    public void testerRemoveFavoritesImageOfDogs() {

        favImages = SerenityRest.lastResponse()
                .jsonPath()
                .getList("", FavouritesField.class);
        for (int i=favImages.size()-1, j=0; j<1; j++,i--){
            String veri=favImages.get(i).id;
            actor.attemptsTo(Delete.from("favourites/{favourite_id}").with(req->req.header("Content-Type", "application/json").header("x-api-key",x_api_key)
                    .pathParams("favourite_id",veri)
            ));

            actor.should(
                    seeThatResponse("Last favourites vote has been successfully removed",
                            response -> response.statusCode(200))
            );
        }
    }
}
