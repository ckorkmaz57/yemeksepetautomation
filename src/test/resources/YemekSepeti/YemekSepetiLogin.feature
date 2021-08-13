#noinspection NonAsciiCharacters
Feature: YemekSepeti Login Case

  Background:
    Given User navigate to "https://www.yemeksepeti.com/istanbul" page

  Scenario Outline: TC_YemekSepetiLogin_001_User should be successfully login, when enters correct username and password
    When User enters <username> and <password>
    And User clicks "ÜYE GİRİŞİ" button
    Then "TEST USER" successfully logs in

    Examples:
      | username                  | password      |
      | yemeksepetitest@gmail.com | 10203057Test* |


  Scenario Outline: TC_YemekSepetiLogin_002_User should not be login, when enters invalid username or password
    When User enters <username> and <password>
    And User clicks "ÜYE GİRİŞİ" button
    Then <error> message is displayed

    Examples:
      | username                  | password        | error                                                                          |
      | yemeksepetitest@gmail.com | invalidpassword | Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz. |
      | invalidusername           | 10203057Test*   | Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz. |
      | invalidusername           | invalidpassword | Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz. |

  Scenario Outline: TC_YemekSepetiLogin_003_User should not be login, when enters blank username and password
    When User enters <username> and <password>
    And User clicks "ÜYE GİRİŞİ" button
    Then <warn> message is displayed

    Examples:
      | username | password | warn                                                                                   |
      | ""       | ""       | Lütfen kullanıcı adınızı/e-postanızı giriniz.,Şifre alanı için Lütfen şifrenizi girin. |

  Scenario Outline: TC_YemekSepetiLogin_004_User should not be login, when enters blank username or password
    When User enters <username> and <password>
    And User clicks "ÜYE GİRİŞİ" button
    Then <warn> message is displayed

    Examples:
      | username | password | warn                                          |
      | ""       | password | Lütfen kullanıcı adınızı/e-postanızı giriniz. |
      | username | ""       | Şifre alanı için "Lütfen şifrenizi girin      |

    #Test failed should be inspected
  Scenario: TC_YemekSepetiLogin_005_User should not be login, when enters space character in username/e-mail textbox
    When User enters e-mail and password
    And User clicks "ÜYE GİRİŞİ" button
    Then Error message is displayed