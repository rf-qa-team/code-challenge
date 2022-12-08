package model.httpbin.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import model.httpbin.get.GETResponse;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class POSTDelayResponse extends GETResponse {
    private String data;
    private Map<String, String> files;
    private Map<String, String> form;
}
