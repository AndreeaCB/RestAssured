import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class GetPetType {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath = "/pettypes";
    }
    @Test
    public void getAllTypes_assertions(){

        given().
                when().//log().all().
                get().
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllTypes(){

        given().
                when().//log().all().
                get().
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                body("id[0]", equalTo(101)).
                body("name[0]", equalTo("Camel")).
                body("id", hasItems(101,112,7));
    }

}
