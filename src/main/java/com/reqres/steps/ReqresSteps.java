package com.reqres.steps;

import com.reqres.constants.EndPoints;
import com.reqres.model.ReqresPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReqresSteps {
    @Step
    public ValidatableResponse getAllReqresList(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PRODUCTS)
                .then().log().all().statusCode(200);
    }
    @Step("Creating reqres with name:{0} and job : {1}")
    public ValidatableResponse craeteReqres(String name, String job){
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setName(name);
        reqresPojo.setJob(job);
        return SerenityRest.given().log().all()
                .auth().preemptive()
                .basic("token","cea28846c268f54d01fa8cbae21f3eeec1353288c0fe2c45d1ee0cbaa0d2d9d3")
                .contentType("application/json")
                .body(reqresPojo)
                .when()
                .post(EndPoints.POSTPRODUCTS).then();
    }
    @Step("get product with id: {0}")
    public ValidatableResponse getReqresById(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_SINGLE_ID).then();
//                .statusCode(200)
//                .extract().path("");
    }
    @Step("creating login")
    public ValidatableResponse crateLogin(String email,String password){
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setEmail(email);
        reqresPojo.setPassword(password);
        return SerenityRest.given().log().all()
                .contentType("application/json")
                .body(reqresPojo)
                .when()
                .post(EndPoints.LOG_IN).then();
    }
    @Step("delete user")
    public ValidatableResponse deleteById(){
        return SerenityRest.given().log().all()
                .when()
                .delete(EndPoints.DELETE).then();
    }
}
