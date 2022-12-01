package model.httpbin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private List<Object> args;
    @JsonProperty("headers")
    private Headers headers;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("url")
    private String url;

}
