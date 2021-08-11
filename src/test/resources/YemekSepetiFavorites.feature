Feature:Yemek Sepeti Favorites Cases

  Scenario: TC_YemekSepetiFavorites_001_User successfully adds favorite the restaurant
    When User searchs restaurant in search textbox
    And User clicks on listed restaurant
    And User clicks Favorilere Ekle
    Then Favorilerden Çıkar displayed
    And Favorite restaurant is displayed in the Favorilerim tab

  Scenario: TC_YemekSepetiFavorites_002_User successfully removes favorite restaurant
    When User clicks on Favorilerim tab
    And User checks on favorite restaurant
    And User clicks Sil button
    Then Favorite restaurant is removed