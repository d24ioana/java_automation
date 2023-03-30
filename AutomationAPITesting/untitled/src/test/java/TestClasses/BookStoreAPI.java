package TestClasses;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class BookStoreAPI {
    private String username = RandomStringUtils.randomAlphanumeric(5);
    public String CreateUserPostMethodAndGetTheUserId(){
        //Create a Request pointing to the Service Endpoint:
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        //Create a JSON request which contains all the fields:
        JSONObject requestParams = new JSONObject();
        //pot sa-i dau sa dea un nume random la user de fiecare data, ca sa nu am
        //probleme in a rula de doua ori request-ul (la a doua rulare a metodei/request-ului,
        //nu mi se mai da userID si mi se spune ca userul exista deja:
        requestParams.put("userName", username);
        requestParams.put("password", "Diesel5*");

        //Add JSON body in the request and send the Request:
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        //Get the Response: !pay attention at the method used (get, post, pu, delete)
        Response response = request.post("/Account/v1/User");
        String jsonString = response.getBody().asString();
        System.out.println("Response body: " + response.body().asPrettyString());

        //Validate the Response:
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);

        //save userID intro variabila:
        String userId = JsonPath.from(jsonString).get("userID");
        System.out.println("User id is: " + userId);
        return userId;
    }

    public String CreateTokenPostMethodAndGetTheUserToken() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", username);
        requestParams.put("password", "Diesel5*");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        Response response = request.post("/Account/v1/GenerateToken");
        String jsonString = response.getBody().asString();
        System.out.println("Response body: " + response.body().asPrettyString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        //save user token intro variabila:
        String userToken = JsonPath.from(jsonString).get("token");
        System.out.println("User token is: " + userToken);
        return userToken;
    }

    public void GetAuthorizedPostMethod() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", username);
        requestParams.put("password", "Diesel5*");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        Response response = request.post("/Account/v1/Authorized");
        String jsonString = response.getBody().asString();
        System.out.println("Response body: " + response.body().asPrettyString());

        String authorizedStatus = jsonString;
        Assert.assertEquals(authorizedStatus, "true");
    }

    public String AddABookToAUserPostMethodAndReturnThatBookIsbn(String userToken, String userId, String bookIsbn) {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        String payload = "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"" + bookIsbn + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        //adaugam headerul de Authorization prin Bearer token:
        request.header("Authorization", "Bearer " + userToken)
                .header("Content-Type", "application/json");

        Response response = request.body(payload).post("/BookStore/v1/Books");
        String jsonString = response.getBody().asString();
        System.out.println("Response body: " + response.body().asPrettyString());

        //save book isbn intro variabila:
        String addedBookIsbn = JsonPath.from(jsonString).get("books[0].isbn");
        System.out.println("Added book isbn is : " + addedBookIsbn);
        return addedBookIsbn;
    }

    public void GetUserAndCountBooks(String userToken, String userId, int expectedCount) {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        //adaugam headerul de Authorization prin Bearer token:
        request.header("Authorization", "Bearer " + userToken)
                .header("Content-Type", "application/json");

        Response response = request.get("/Account/v1/User/" + userId);
        String jsonString = response.getBody().asString();
        System.out.println("Response body: " + response.body().asPrettyString());

        int numberOfUserBooks = JsonPath.from(jsonString).getList("books").size();
        System.out.println("User has: " + numberOfUserBooks + " books from the bookstore ");

        Assert.assertEquals(numberOfUserBooks, expectedCount);
    }

    public void DeleteUser(String userToken, String userId) {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + userToken)
                .header("Content-Type", "application/json");

        Response response = request.delete("/Account/v1/User/" + userId);
        String jsonString = response.getBody().asString();

        //Validare status code 204 no content:
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 204);
    }
}
