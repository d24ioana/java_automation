package TestClasses;

import org.testng.annotations.Test;

import java.util.List;

public class BookStoreAPITests {

    @Test
    public void TestBookstoreAPIFlow(){
        BookStoreAPI bookStoreAPI = new BookStoreAPI();

        String userId = bookStoreAPI.CreateUserPostMethodAndGetTheUserId();
        String userToken = bookStoreAPI.CreateTokenPostMethodAndGetTheUserToken();

        bookStoreAPI.GetAuthorizedPostMethod();

        //See newly created user before start doing stuff
        bookStoreAPI.GetUserAndCountBooks(userToken, userId, 0);

        //doing the stuff
        List<String> bookIsbnsList = List.of("9781449325862", "9781449331818", "9781449337711", "9781449365035", "9781491904244",
                "9781491950296", "9781593275846", "9781593277574");

        bookStoreAPI.AddABookToAUserPostMethodAndReturnThatBookIsbn(userToken, userId, bookIsbnsList.get(0));
        bookStoreAPI.AddABookToAUserPostMethodAndReturnThatBookIsbn(userToken, userId, bookIsbnsList.get(2));
        bookStoreAPI.AddABookToAUserPostMethodAndReturnThatBookIsbn(userToken, userId, bookIsbnsList.get(4));

        //See user details again
        bookStoreAPI.GetUserAndCountBooks(userToken, userId, 3);

        bookStoreAPI.DeleteUser(userToken, userId);
    }
}
