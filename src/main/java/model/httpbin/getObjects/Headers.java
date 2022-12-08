package model.httpbin.getObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Headers {

    @JsonProperty("Content-Type")
    public String contentType;
    @JsonProperty("Accept")
    private String accept;
    @JsonProperty("Accept-Encoding")
    private String acceptEncoding;
    @JsonProperty("Accept-Language")
    private String acceptLanguage;
    @JsonProperty("dnt")
    private String dnt;
    @JsonProperty("Host")
    private String host;
    @JsonProperty("Sec-Ch-Ua")
    private String secChUa;
    @JsonProperty("Sec-Ch-Ua-Mobile")
    private String secChUaMobile;
    @JsonProperty("Sec-Ch-Ua-Platform")
    private String secChUaPlatform;
    @JsonProperty("Sec-Fetch-Dest")
    private String secFetchDest;
    @JsonProperty("Sec-Fetch-Mode")
    private String secFetchMode;
    @JsonProperty("Sec-Fetch-Site")
    private String secFetchSite;
    @JsonProperty("secFetchUser")
    private String secFetchUser;
    @JsonProperty("upgradeInsecureRequests")
    private String upgradeInsecureRequests;
    @JsonProperty("User-Agent")
    private String userAgent;
    @JsonProperty("X-Amzn-Trace-Id")
    private String xAmznTraceId;
}