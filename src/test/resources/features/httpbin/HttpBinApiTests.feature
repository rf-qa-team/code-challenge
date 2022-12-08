Feature: [API] HttpBin API Calls

  Scenario: Validate the GET endpoint is working appropriately
    # Add steps here to validate the GET data coming back is correct

    Given a request to GET HttpBin data is requested
    Then checking that the GET response for args part is correct
    And checking that the GET response for headers part is correct
    And checking that the GET response for origin part is correct
    And checking that the GET response for url part is correct

  Scenario: Validate the POST endpoint is working appropriately
    # Add a test to validate the post delay endpoint for HttpBin https://httpbin.org/#/Dynamic_data/post_delay__delay_
  # - Should include a validation that a way of X seconds, results in the appropriate time delay

    Given POST request with a delay of <5> seconds was sent
    When receive daley time
    Then request delay time in <5> second is correct