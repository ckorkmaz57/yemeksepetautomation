# encoding: utf-8
Feature:Yemek Sepeti Favorites Cases

  Background:
    Given User navigate to "https://www.yemeksepeti.com/istanbul" page
    And User enters yemeksepetitest@gmail.com and 10203057Test*
    And User clicks "ÜYE GİRİŞİ" button
    And "TEST USER" successfully logs in

  Scenario: TC_YemekSepetiFavorites_001_User successfully adds favorite the restaurant
    When User select district
    And User searches "Burger King" in search textbox
    And User clicks on listed restaurant
    And User clicks "Kapat" in banabi notification
    And User clicks Favorilere Ekle
    Then "Favorilerden Çıkar" displayed


  Scenario: TC_YemekSepetiFavorites_002_User successfully removes favorite restaurant
    When User clicks on "Favorilerim" menu
    And User clicks "Kapat" in banabi notification
    And User checks on favorite restaurant
    And User clicks "SİL" button in favorites menu
    Then "Henüz favori restoranınız bulunmamaktadır." text should be displayed