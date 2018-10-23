import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class PutPetType {

    @Test
    public void updatePetType(){
        RestAssured.baseURI = "http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath = "/pettypes/{petTypeId}";
        given().
                contentType(ContentType.JSON).
                pathParam("petTypeId", 141).
                body("{\"name\": \"TestUpdated\"}").
                when().
                put("{petTypeId}").
                then().
                statusCode(HttpStatus.SC_NO_CONTENT);

    }


}
