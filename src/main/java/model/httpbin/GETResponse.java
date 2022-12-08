package model.httpbin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import model.httpbin.getObjects.Headers;

import java.util.LinkedHashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GETResponse {

    @JsonProperty("args")
    private LinkedHashMap args;
    @JsonProperty("headers")
    private Headers headers;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("url")
    private String url;
}