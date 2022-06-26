Feature: Verify Search Job Functionality on uk.indeed.com

  Background: User has already on the Indeed Web Site
    Given user is on uk.indeed.com search page

  Scenario: User Searches Job on Indeed Web Site
    When user types SDET in the job title search box
    And user types London in the location search box
    And user clicks search button
    Then user sees SDET jobs in London on the result

 Scenario Template: User Searches Job on Indeed Web Site
    When user types <Job Title> in the job title search box
    And user types <Job Location> in the location search box
    Then user sees results of <Job Title> in <Job Title>
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

    Examples:
      | Job Location |
      | London |
      | Birmingham |
      | Glasgow |
      | Liverpool |
      | Bristol |
      | Manchester |
      | Sheffield |
      | Leeds |
