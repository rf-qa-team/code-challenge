Feature: [API] HttpBin API Calls

  Scenario: Validate the GET endpoint is working appropriately
    Given a request to GET HttpBin data is requested
    # Add steps here to validate the GET data coming back is correct
    Then verify the GET HttpBin response args are ok
    And verify the GET HttpBin response headers are ok
    And verify the GET HttpBin response origin is ok
    And verify the GET HttpBin response url is ok

  # Add a test to validate the post delay endpoint for HttpBin https://httpbin.org/#/Dynamic_data/post_delay__delay_
  # - Should include a validation that a way of X seconds, results in the appropriate time delay
  Scenario Outline: Validate the POST endpoint is working appropriately
    Given a POST request to delay <seconds> is sent
    Then verify the delay response delay of <seconds> is accurate
    And verify the delay response data is okay
    Examples:
      | seconds |
      | 0       |
      | 5       |
      | 9       |