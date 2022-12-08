package model.httpbin.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Headers {

    @JsonProperty("Accept")
    private String accept;
    @JsonProperty("Accept-Encoding")
    private String acceptEncoding;
    @JsonProperty("Content-Type")
    private String contentType;
    @JsonProperty("Content-Length")
    private String contentLength;
    @JsonProperty("Host")
    private String host;
    @JsonProperty("User-Agent")
    private String userAgent;
    @JsonProperty("X-Amzn-Trace-Id")
    private String xAmznTraceId;
    @JsonProperty("Accept-Language")
    private String acceptLanguage;
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
    @JsonProperty("X-Shared-Secret")
    private String xSharedSecret;
}
