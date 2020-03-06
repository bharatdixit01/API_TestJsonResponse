import dataProviders.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class tmSandBoxAPITest {

    private ConfigFileReader configFileReader;

    /**
     * Validating key values in API response.
     */
    @Test(description= "To check api response from a url")
    public void carbonCredits() {

        // Specify base URI
        configFileReader= new ConfigFileReader();
        RestAssured.baseURI = configFileReader.getbaseURI().trim();

        // Request object
        RequestSpecification httpsRequest = RestAssured.given();

        // Response object
        Response response = httpsRequest.request(Method.GET,
                "Details.json?catalogue=false");

        // print response in console window
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        // Carbon Credit verification
        String name = response.jsonPath().get("Name");

        // Verify Name value
        Assert.assertEquals(name, "Carbon credits");
        System.out.println("'Name' tag Expected value: Carbon credits.      Actual value: " + name);


        // Carbon Credit verification
        boolean canRelist = response.jsonPath().get("CanRelist");

        // Verify Name value
        Assert.assertEquals(canRelist, true);
        System.out.println("'canRelist' tag Expected Value: true   Actual Value: "
                + canRelist);

        int i = ((ArrayList<String>) (response.getBody().jsonPath().get("Promotions.Name")))
                .indexOf("Gallery");
        String desc = response.getBody().jsonPath().get("Promotions[" + i + "]."
                + "Description").toString();

        Assert.assertTrue(desc.contains("2x larger image"));
        System.out.println("Description of Promotions of element Name "
                + "Gallery is : '" + desc
                + "', " + "contains searched string: '2x larger image'");

        //assertThat(desc,"2x larger image");
    }
}
