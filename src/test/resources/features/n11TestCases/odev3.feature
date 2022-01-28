@third_homework
Feature: In the third one, the ones with free shipping are listed according to the comment order of the searched product.
  Scenario Outline: The ones with free shipping are listed according to the comment order of the searched product
    Given I launch <desired_browser> Browser and <env> Environment <Docker_Selenium_Grid>
    When  Go To "https://www.n11.com"
    Then  The word "telefon" is searched
    And   The second brand is selected from the filters on the product listing (result) screen
    Then  Incoming results are sorted by the number of comments
    Then  Free shipping products are does list

    Examples:
      |desired_browser|   |env | |Docker_Selenium_Grid|
      |     Edge    |   |test|      |  false   |
#      |     Chrome    |   |test|     |false|
#      |     Firefox   |   |test|     |false|
                     # |qa-staging-prod|
