package com.reqres.Test;

import com.reqres.steps.ReqresSteps;
import com.reqres.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ReqresTest extends TestBase {
static   String name = "nid";
static   String job = "tester";
static String id;
static String email = "eve.holt@reqres.in";
static String password = "cityslicka";

  @Steps
    ReqresSteps reqresSteps;
  @Test
    public void test001(){
     ValidatableResponse response=  reqresSteps.getAllReqresList().log().all().statusCode(200);
  }
  @Test
  public void test002(){
    ValidatableResponse response = reqresSteps.craeteReqres(name,job).log().all().statusCode(201);
    response.log().all().statusCode(201);
    id = response.extract().path("id");
    System.out.println(id);
  }
  @Test
  public void test003(){
//    HashMap<String,?> reqMap = (HashMap<String, ?>) reqresSteps.getReqresById(id);
//    Assert.assertThat(reqMap,hasValue(name));
reqresSteps.getReqresById().log().all().statusCode(200);
  }
@Test
  public void test004(){
    reqresSteps.crateLogin(email,password).log().all().statusCode(200);

}
@Test
  public void test005(){
    reqresSteps.deleteById().log().all().statusCode(204);

}
}
