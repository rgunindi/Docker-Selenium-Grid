@second_homework
Feature: In the second time, the products added to the cart are tried to be purchased with the wrong credit card.

  Scenario Outline: The products added to the cart are tried to be purchased with the wrong credit card
    Given I launch <desired_browser> Browser and <env> environment <Docker_Selenium_Grid>
    When  Go to  "https://www.n11.com"
    Then  The word "ayfon" is searched in the search engine and it is seen that the searched word is corrected and the results come accordingly
    Then  From the results, the first and last product on the first page and the 5th product on the 3rd page are added to the cart
    And   Go to bucket
    Then  The cheapest product in the cart becomes 3
    And   Proceeds to the payment step as a guest user
    Then  Attempt to purchase products with incorrect credit card information

    Examples:
      |desired_browser|   |env | |Docker_Selenium_Grid|
      |     Chrome    |   |test|      |  false   |
#    |     Firefox    |   |test|        |true|
#    |     Edge      |   |test|         |true|
#                                   |qa-staging-prod|
