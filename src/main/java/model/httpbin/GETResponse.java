package model.httpbin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import model.httpbin.getObjects.Headers;

import java.util.List;

@Data
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GETResponse {
    @JsonProperty("args")
    private JsonNode args;
    @JsonProperty("headers")
    private JsonNode headers;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("url")
    private String url;

    public GETResponse() {
    }

    public GETResponse(JsonNode args, JsonNode headers, String origin, String url) {
        this.args = args;
        this.headers = headers;
        this.origin = origin;
        this.url = url;
    }
}
