Feature: [API] HttpBin API Calls

  Scenario Outline: Validate the GET endpoint is working appropriately
    Given a request to GET HttpBin data is requested
    Then response status code is 200
    And GetResponse [args] are empty
    And GetResponse [url] is equal to "https://<host>/get"
    And GetResponse [origin] is IP address
    And GetResponse -> Headers [Accept] is "application/json, application/javascript, text/javascript, text/json"
    And GetResponse -> Headers [Accept-Encoding] is "gzip,deflate"
    And GetResponse -> Headers [Content-Type] is "application/json"
    And GetResponse -> Headers [User-Agent] is not empty
    And GetResponse -> Headers [X-Amzn-Trace-Id] is not empty
    And GetResponse -> Headers [Host] is "<host>"

    Examples:
      | host        |
      | httpbin.org |


  Scenario Outline: Validate the POST delay endpoint is working appropriately
    Given a request to POST delay HttpBin data with <delay> is requested
    Then response status code is 200
    Then response has delay time <actualDelay> seconds
    And POSTDelayResponse [args] are empty
    And POSTDelayResponse [data] is empty
    And POSTDelayResponse [files] is empty
    And POSTDelayResponse [form] is empty
    And POSTDelayResponse [url] is equal to "https://httpbin.org/delay/<delay>"
    And POSTDelayResponse [origin] is IP address
    And POSTDelayResponse -> Headers [Accept] is "application/json, application/javascript, text/javascript, text/json"
    And POSTDelayResponse -> Headers [Accept-Encoding] is "gzip,deflate"
    And POSTDelayResponse -> Headers [Content-Type] is "application/json"
    And POSTDelayResponse -> Headers [User-Agent] is not empty
    And POSTDelayResponse -> Headers [X-Amzn-Trace-Id] is not empty
    And POSTDelayResponse -> Headers [Host] is "httpbin.org"

    Examples:
      | delay | actualDelay |
      | -10   | 0           |
      | 0     | 0           |
      | 1     | 1           |
      | 10    | 10          |
      | 20    | 10          |
