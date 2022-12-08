package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    private static final ThreadLocal<RequestSpecification> reqSpec = new ThreadLocal<>();
    private RequestSpecBuilder builder;

    protected void buildRequestSpec() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        builder = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setUrlEncodingEnabled(true)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON);
        reqSpec.set(builder.build());
    }

    public RequestSpecification generateReqSpecWithoutToken(String baseUri) {
        buildRequestSpec();
        return builder.setBaseUri(baseUri).build();
    }

    protected RequestSpecification reqSpec() {
        return reqSpec.get();
    }
}
