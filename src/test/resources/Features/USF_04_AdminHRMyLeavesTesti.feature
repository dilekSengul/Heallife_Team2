@fus04 @fus
Feature: Admin kullanici olarak admin panelinde izinlerimi "My Leaves" sayfasinda yonetebilmek istiyorum.

  Background:
    Given Admin kullanici giris bilgileri ile sisteme login olur
    And Staff Directory Sayfasina gider

  Scenario: [TC_01 > FUS_04] Staff Directory sayfasindan My Leaves sayfasina erisilebilmesi
    When Kullanici Leaves butonuna tiklar
    Then Kullanici My Leaves sayfasina erisir

  Scenario: [TC_02 > FUS_04] My Leaves Sayfasi icinde Arama ve Siralama Yapilabilmesi
    When Kullanici Leaves butonuna tiklar
    And Kullanici My Leaves sayfasina erisir
    When Kullanici arama butonunda ilgili izin icin arama yapar
    Then Kullanici izin bilgisine erisir
