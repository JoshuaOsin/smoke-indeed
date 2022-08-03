Feature: Verify Search Job Functionality on uk.indeed.com

  Background: User has already on the Indeed Web Site
    Given user is on uk.indeed.com search page

  @regression
  Scenario: User Searches Job on Indeed Web Site
    Given user is on uk.indeed.com search page
    When user types SDET in the job title search box
    And user types London in the location search box
    And user clicks search button
    Then user sees the result


  @smoke
  Scenario Template: User Searches Job in London on Indeed Web Site
    When user types "<Job Title>" in the job title search box
    And user types London in the location search box
    And user clicks search button
    Then user sees the result
#    And user types <Job Location> in the location search box
#    Then user sees results of <Job Title> in <Job Title>
    Examples:
      | Job Title                 |
      | SDET                      |
      | QA Analyst                |
      | Software Tester           |
      | Automation Tester         |
      | QA Tester                 |
      | Software Test Engineer    |
      | QA Automation Engineer    |
      | QA Engineer               |
      | Automation Test Engineer  |
      | Test Automation Engineer  |
      | Software Engineer in Test |

  @
  Scenario Template: User Searches Job SDET in job locationson Indeed Web Site
    When user types SDET in the job title search box
    And user types "<Job Location>" in the location search box
    And user clicks search button
    Then user sees the result
#
#    Then user sees results of <Job Title> in <Job Title>
    Examples:
      | Job Location |
      | London       |
      | Birmingham   |
      | Glasgow      |
      | Liverpool    |
      | Bristol      |
      | Manchester   |
      | Sheffield    |
      | Leeds        |


  Scenario Template: User Searches Job in London on Indeed Web Site
    When user types "<Job Title>" in the job title search box
    And user types <Job Locations> in the location search box
    And user clicks search button
    Then user sees the result

    Examples:
      | Job Title                 | Job Locations                                                           |
      | SDET                      | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | QA Analyst                | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | Software Tester           | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | Automation Tester         | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | QA Tester                 | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | Software Test Engineer    | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | QA Automation Engineer    | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | QA Engineer               | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | Automation Test Engineer  | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | Test Automation Engineer  | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |
      | Software Engineer in Test | London,Birmingham,Glasgow,Liverpool,Bristol,Manchester,Sheffield,Leeds |

  @db
  Scenario: User Searches Job SDET in job locations from database Indeed Web Site
    When user types SDET in the job title search box
    And user types location from database in the location search box
    And user clicks search button
    Then user sees the result