package model.httpbin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class POSTResponse {
    @JsonProperty("args")
    private JsonNode args;
    @JsonProperty("data")
    private String data;
    @JsonProperty("files")
    private JsonNode files;
    @JsonProperty("form")
    private JsonNode form;
    @JsonProperty("headers")
    private JsonNode headers;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("url")
    private String url;

    public POSTResponse() {
    }

    public POSTResponse(JsonNode args, String data, JsonNode files, JsonNode form, JsonNode headers, String origin, String url) {
        this.args = args;
        this.data = data;
        this.files = files;
        this.form = form;
        this.headers = headers;
        this.origin = origin;
        this.url = url;
    }
}
