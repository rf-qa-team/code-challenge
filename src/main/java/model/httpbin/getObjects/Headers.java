package model.httpbin.getObjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Headers {

    @JsonProperty("accept")
    private String accept;
    @JsonProperty("acceptEncoding")
    private String acceptEncoding;
    @JsonProperty("acceptLanguage")
    private String acceptLanguage;
    @JsonProperty("dnt")
    private String dnt;
    @JsonProperty("host")
    private String host;
    @JsonProperty("secChUa")
    private String secChUa;
    @JsonProperty("secChUaMobile")
    private String secChUaMobile;
    @JsonProperty("secChUaPlatform")
    private String secChUaPlatform;
    @JsonProperty("secFetchDest")
    private String secFetchDest;
    @JsonProperty("secFetchMode")
    private String secFetchMode;
    @JsonProperty("secFetchSite")
    private String secFetchSite;
    @JsonProperty("secFetchUser")
    private String secFetchUser;
    @JsonProperty("upgradeInsecureRequests")
    private String upgradeInsecureRequests;
    @JsonProperty("userAgent")
    private String userAgent;
    @JsonProperty("xAmznTraceId")
    private String xAmznTraceId;
    
}
