import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ApiTesting {



  //1) Execute a GET request that lists all posts resources
  @Test
   public void GetList(){

    given()
            .get("https://jsonplaceholder.typicode.com/posts")
            .then()
            .statusCode(200)
            .log().all();
}


//2) Execute a GET request that returns a single posts resource with id = 11
@Test
  public void GetSingleList(){

  given()
          .get("https://jsonplaceholder.typicode.com/posts/11")
          .then()
          .statusCode(200)
          .log().all();
  }

//3) Execute a POST request to create a new posts resource
  @Test
  public void PostRequest(){

    JSONObject request = new JSONObject();
    request.put("title", "foo" );
    request.put("body" , "bar" );
    request.put("userId", 1  );

    System.out.println(request);
    System.out.println(request.toJSONString());

given().
        body(request.toJSONString()).
        when().
        post("https://jsonplaceholder.typicode.com/posts").
        then().
        statusCode(201).
        log().all();

  }

//4) Execute a DELETE request that removes the posts resource with id = 1
  @Test
public void DeleteRequest(){
    given().
            when().
            delete("https://jsonplaceholder.typicode.com/posts/1").
            then().
            statusCode(200).
            log().all();

}

  //5) Bonus Question: Add assertions for the expected status codes i.e. 200 OK
  @Test
  public void assertions(){

  given()
          .get("https://jsonplaceholder.typicode.com/posts")
          .then()
          .assertThat()
          .statusCode(200)
          .log().all();


}
}
