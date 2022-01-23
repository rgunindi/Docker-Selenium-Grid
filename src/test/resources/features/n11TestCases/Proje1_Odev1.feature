@first_homework
Feature: In the first one, the number of comments made about the selected store is checked.
  Scenario Outline: The number of comments made about the selected store is checked.
    Given I launch <desired_browser> browser and <env> environment <Docker_Selenium_Grid>
    When  Go to "https://www.n11.com"
    And   Mağazalar|Mağazaları Gör from the header is selected
    When  Click on Tüm Mağazalar button
    And   Tüm Mağazalar from A to Z are printed in an csv file
    Then  The second store starting with the letter S is reads from the created file (csv) and the page of this store is taken
    And   Go to the took store page
    Then  It is checked how many comments are made about the selected Store

    Examples:
    |desired_browser|   |env | |Docker_Selenium_Grid|
    |     Firefox   |   |test|      |true|


#    |     Chrome    |   |test|      |false|
#    |     Edge      |   |test|     |false|
                     # |qa-staging-prod|
