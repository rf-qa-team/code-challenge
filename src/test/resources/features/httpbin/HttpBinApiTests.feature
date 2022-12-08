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


  # Add a test to validate the post delay endpoint for HttpBin https://httpbin.org/#/Dynamic_data/post_delay__delay_
  # - Should include a validation that a way of X seconds, results in the appropriate time delay