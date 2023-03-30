package TestClasses;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreAPITests {

    //We run CreateTokenPostMethod once to get the user token for authorization
    //private static String userID = "";
    //private static String userToken = "";

    @Test
    public void TestBookstoreAPIFlow(){
        BookStoreAPI bookStoreAPI = new BookStoreAPI();

        String userId = bookStoreAPI.CreateUserPostMethodAndGetTheUserId();
        String userToken = bookStoreAPI.CreateTokenPostMethodAndGetTheUserToken();

        bookStoreAPI.GetAuthorizedPostMethod();

        //See newly created user before start doing stuff
        bookStoreAPI.GetUserAndCountBooks(userToken, userId, 0);

        //doing the stuff
        String bookIsbn = "9781491904244";
        bookStoreAPI.AddABookToAUserPostMethodAndReturnThatBookIsbn(userToken, userId, bookIsbn);

        //See user details again
        bookStoreAPI.GetUserAndCountBooks(userToken, userId, 1);

        //bookStoreAPI.DeleteUser(userToken, userId);
    }
}
