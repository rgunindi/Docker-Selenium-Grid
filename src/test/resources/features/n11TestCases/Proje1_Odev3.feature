Feature: In the third one, the ones with free shipping are listed according to the comment order of the searched product.



  @third_homework
  Scenario Outline: The ones with free shipping are listed according to the comment order of the searched product
    Given I launch <desired_browser> Browser and <env> Environment
    When  Go To "https://www.n11.com"
    Then  The word "telefon" is searched
    And   The second brand is selected from the filters on the product listing (result) screen
    Then  Incoming results are sorted by the number of comments
    Then  Free shipping products are does list


    Examples:
      |desired_browser|   |env |
     |     Edge      |   |test|
#      |     Chrome    |   |test|
#      |     Firefox   |   |test|
                     # |qa-staging-prod|
