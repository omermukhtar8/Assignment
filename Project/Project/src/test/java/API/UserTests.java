package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserTests {

    public String BASE_URI = "";


    @BeforeClass
    public void readProperties() throws IOException {
        Properties prop= new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//config.properties");

        prop.load(fis);
        BASE_URI=prop.getProperty("baseURI");
    }

    @Test
    public void GetRequestToGetUsersData()
    {
        int expectedStatusCode = 200;
        String expectedFirstName = "Michael";

        RestAssured.baseURI = BASE_URI;
        Response R = RestAssured
                .given()
                .basePath("users")
                .queryParam("page","2")
                .contentType(ContentType.JSON)
                .get();

        //Deserialization to my object User
        UserList users = R.body().as(UserList.class);

        //soft assertion
        SoftAssert sa = new SoftAssert();

        sa.assertEquals(R.getStatusCode(),expectedStatusCode);
        sa.assertEquals(users.getData().get(0).getFirstName(),expectedFirstName);

        sa.assertAll();

    }

    @Test
    public void PostRequestToCreateUserData()
    {
        int expectedStatusCode = 201;
        String name = "morpheus";
        String job = "leader";

        CreateUser bodyData = new CreateUser();
        bodyData.setName(name);
        bodyData.setJob(job);

        RestAssured.baseURI = BASE_URI;
        Response R = RestAssured
                .given()
                .basePath("users")
                .contentType(ContentType.JSON)
                .body(bodyData)
                .post();


        CreateUser responseBody = R.body().as(CreateUser.class);


        //soft assertion
        SoftAssert sa = new SoftAssert();

        sa.assertEquals(R.getStatusCode(),expectedStatusCode);
        sa.assertEquals(responseBody.getName(),name);
        sa.assertEquals(responseBody.getJob(),job);

        sa.assertAll();

    }
}
